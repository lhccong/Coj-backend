package com.cong.coj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cong.coj.annotation.AuthCheck;
import com.cong.coj.common.BaseResponse;
import com.cong.coj.common.ErrorCode;
import com.cong.coj.common.ResultUtils;
import com.cong.coj.constant.UserConstant;
import com.cong.coj.exception.BusinessException;

import com.cong.coj.model.dto.question.QuestionQueryRequest;
import com.cong.coj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.cong.coj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.cong.coj.model.entity.Question;
import com.cong.coj.model.entity.QuestionSubmit;
import com.cong.coj.model.entity.User;
import com.cong.coj.model.vo.QuestionSubmitVO;
import com.cong.coj.service.QuestionSubmitService;
import com.cong.coj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 * @author <a href="https://github.com/licong">程序员聪</a>
 * @from <a href="https://cong.icu">编程导航知识星球</a>
 */
@RestController
//@RequestMapping("/question_submit")
@Slf4j
@Deprecated
public class QuestionSubmitController {

//    @Resource
//    private QuestionSubmitService questionSubmitService;
//
//    @Resource
//    private UserService userService;
//
//    /**
//     * 提交题目
//     *
//     * @param questionSubmitAddRequest
//     * @param request
//     * @return resultNum 提交记录id
//     */
//    @PostMapping("/")
//    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
//                                               HttpServletRequest request) {
//        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        // 登录才能提交题目
//        final User loginUser = userService.getLoginUser(request);
//        long result = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
//        return ResultUtils.success(result);
//    }
//
//    /**
//     * 分页获取题目提交列表（除了管理员外，普通用户只能看到非答案、提交代码等公开信息）
//     *
//     * @param questionQueryRequest 问题查询请求
//     * @param request              请求
//     * @return {@link BaseResponse}<{@link Page}<{@link Question}>>
//     */
//    @PostMapping("/list/page")
//    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionQueryRequest,
//                                                                         HttpServletRequest request) {
//        Long current = questionQueryRequest.getCurrent();
//        long size = questionQueryRequest.getPageSize();
//        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
//                questionSubmitService.getQueryWrapper(questionQueryRequest));
//        User loginUser = userService.getLoginUser(request);
//        //脱敏信息
//        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage,loginUser));
//
//    }
}
