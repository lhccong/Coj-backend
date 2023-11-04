package com.cong.coj.model.vo;

import cn.hutool.json.JSONUtil;
import com.cong.coj.judge.codesandbox.mode.JudgeInfo;
import com.cong.coj.model.entity.QuestionSubmit;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目提交封装类
 *
 * @author 86188
 * @TableName question
 * @date 2023/08/13
 */
@Data
public class QuestionSubmitVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 题目 id
     */
    private Long questionId;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 判题状态 0-待判题、1-判题中、2-成功、3-失败
     */
    private Integer status;

    /**
     * 编程语言
     */
    private String language;

    /**
     * 用户代码
     */
    private String code;

    /**
     * 判题信息（json对象）
     */
    private JudgeInfo judgeInfo;
    /**
     * 用户信息
     */
    private UserVO userVO;

    /**
     * 对应题目信息
     */
    private QuestionVO questionVO;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    /**
     * 包装类转对象
     *
     * @param questionSubmitVO
     * @return
     */
    public static QuestionSubmit voToObj(QuestionSubmitVO questionSubmitVO) {
        if (questionSubmitVO == null) {
            return null;
        }
        QuestionSubmit questionSubmit = new QuestionSubmit();
        BeanUtils.copyProperties(questionSubmitVO, questionSubmit);
        JudgeInfo judgeInfoObj = questionSubmitVO.getJudgeInfo();
        if (judgeInfoObj != null) {
            questionSubmit.setJudgeInfo(JSONUtil.toJsonStr(judgeInfoObj));
        }

        return questionSubmit;
    }

    /**
     * 对象转包装类
     *
     * @param questionSubmit
     * @return
     */
    public static QuestionSubmitVO objToVo(QuestionSubmit questionSubmit) {
        if (questionSubmit == null) {
            return null;
        }
        QuestionSubmitVO questionVO = new QuestionSubmitVO();
        BeanUtils.copyProperties(questionSubmit, questionVO);
        String judgeInfoStr = questionSubmit.getJudgeInfo();
        questionVO.setJudgeInfo(JSONUtil.toBean(judgeInfoStr, JudgeInfo.class));
        return questionVO;
    }
}