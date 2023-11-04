package com.cong.coj.judge.codesandbox;

import com.cong.coj.judge.codesandbox.mode.ExecuteCodeRequest;
import com.cong.coj.judge.codesandbox.mode.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * 代码沙箱增强代理
 *
 * @author 86188
 * @date 2023/09/01
 */
@Slf4j
public class CodeSandBoxProxy implements CodeSandbox {

    private final CodeSandbox codeSandbox;

    public CodeSandBoxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代码沙箱请求信息{}", executeCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        log.info("代码沙箱输出信息{}", executeCodeResponse.toString());
        return executeCodeResponse;
    }
}
