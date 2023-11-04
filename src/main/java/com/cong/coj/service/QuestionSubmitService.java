package com.cong.coj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cong.coj.model.dto.question.QuestionQueryRequest;
import com.cong.coj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.cong.coj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.cong.coj.model.entity.Question;
import com.cong.coj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cong.coj.model.entity.User;
import com.cong.coj.model.vo.QuestionSubmitVO;
import com.cong.coj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 86188
* @description 针对表【question_submit(question)】的数据库操作Service
* @createDate 2023-08-13 11:56:56
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest 问题提交添加请求
     * @param loginUser                登录用户
     * @return long
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);



    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);



    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

}
