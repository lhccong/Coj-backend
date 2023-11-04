package com.cong.coj.judge;

import cn.hutool.json.JSONUtil;
import com.cong.coj.common.ErrorCode;
import com.cong.coj.exception.BusinessException;
import com.cong.coj.judge.codesandbox.CodeSandBoxFactory;
import com.cong.coj.judge.codesandbox.CodeSandBoxProxy;
import com.cong.coj.judge.codesandbox.CodeSandbox;
import com.cong.coj.judge.codesandbox.mode.ExecuteCodeRequest;
import com.cong.coj.judge.codesandbox.mode.ExecuteCodeResponse;
import com.cong.coj.judge.strategy.JudgeContext;
import com.cong.coj.model.dto.question.JudgeCase;
import com.cong.coj.judge.codesandbox.mode.JudgeInfo;
import com.cong.coj.model.entity.Question;
import com.cong.coj.model.entity.QuestionSubmit;
import com.cong.coj.model.enums.QuestionSubmitStatusEnum;
import com.cong.coj.service.QuestionService;
import com.cong.coj.service.QuestionSubmitService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 判题服务
 * @author 86188
 * @date 2023/09/02
 */
@Service
public class JudgeServiceImpl implements JudgeService {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;
    @Resource
    private JudgeManager judgeManager;

    @Value("${codesandbox.type:example}")
    String type;
    @Override
    public QuestionSubmit doJudge(long questionSubmitId) {
        //1)传入题目的提交1d,获取到对应的题目、提交信息（包含代码、编程语言等）
        QuestionSubmit questionSubmit = questionSubmitService.getById(questionSubmitId);

        if (questionSubmit ==null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR," 提交信息不存在");
        }

        Question question = questionService.getById(questionSubmit.getQuestionId());

        if (question ==null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR," 题目不存在");
        }
        //2)如果题目提交状态不为等待中，就不用重复执行
        if (!QuestionSubmitStatusEnum.WAITING.getValue().equals(questionSubmit.getStatus())){
            throw new BusinessException(ErrorCode.OPERATION_ERROR,"题目已在判题中");
        }
        //3)更改判题（题目提交）的状态为“判题中”，防止重复执行
        QuestionSubmit questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmitId);
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());
        boolean result = questionSubmitService.updateById(questionSubmitUpdate);
        if (!result){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"题目状态更新错误");
        }
        //4)调用沙箱，获取到执行结果
        CodeSandbox codeSandbox = CodeSandBoxFactory.newInstance(type);
        codeSandbox = new CodeSandBoxProxy(codeSandbox);
        String judgeCaseStr = question.getJudgeCase();
        List<JudgeCase> judgeCasesList = JSONUtil.toList(judgeCaseStr, JudgeCase.class);
        String language = questionSubmit.getLanguage();
        String code = questionSubmit.getCode();
        List<String> inputList = judgeCasesList.stream().map(JudgeCase::getInput).collect(Collectors.toList());


        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        List<String> outputList = executeCodeResponse.getOutputList();
        //5)根据沙箱的执行结果，设置题目的判题状态和信息
        JudgeContext judgeContext = new JudgeContext();
        judgeContext.setJudgeInfo(executeCodeResponse.getJudgeInfo());
        judgeContext.setInputList(inputList);
        judgeContext.setOutputList(outputList);
        judgeContext.setJudgeCaseList(judgeCasesList);
        judgeContext.setQuestion(question);
        judgeContext.setQuestionSubmit(questionSubmit);

        JudgeInfo judgeInfo = judgeManager.doJudge(judgeContext);

        //6)修改数据库中的判题结果
        questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmitId);
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        questionSubmitUpdate.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        result = questionSubmitService.updateById(questionSubmitUpdate);
        if (!result){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"题目状态更新错误");
        }
         questionSubmit = questionSubmitService.getById(questionSubmitId);
        return questionSubmit;
    }
}
