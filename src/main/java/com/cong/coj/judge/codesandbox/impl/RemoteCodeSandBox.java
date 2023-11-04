package com.cong.coj.judge.codesandbox.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.cong.coj.common.ErrorCode;
import com.cong.coj.exception.BusinessException;
import com.cong.coj.judge.codesandbox.CodeSandbox;
import com.cong.coj.judge.codesandbox.mode.ExecuteCodeRequest;
import com.cong.coj.judge.codesandbox.mode.ExecuteCodeResponse;

/**
 * 远程代码沙箱（调用远程接口）
 * @author 86188
 * @date 2023/09/01
 */
public class RemoteCodeSandBox implements CodeSandbox {
    /**
     * 定义鉴权请求头和密钥
     */
    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "secretKey";
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        String url = "http://localhost:8090/executeCode";
        String jsonStr = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .body(jsonStr)
                .header(AUTH_REQUEST_HEADER,AUTH_REQUEST_SECRET)
                .execute()
                .body();
        if (StrUtil.isEmpty(responseStr)){
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR,"executeCode remoteSandbox error,message = "+responseStr);
        }
        return JSONUtil.toBean(responseStr,ExecuteCodeResponse.class);
    }
}
