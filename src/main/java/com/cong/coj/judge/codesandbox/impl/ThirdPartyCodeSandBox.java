package com.cong.coj.judge.codesandbox.impl;

import com.cong.coj.judge.codesandbox.CodeSandbox;
import com.cong.coj.judge.codesandbox.mode.ExecuteCodeRequest;
import com.cong.coj.judge.codesandbox.mode.ExecuteCodeResponse;

/**
 * 第三方代码沙箱（调用网上现成的代码沙箱）
 * @author 86188
 * @date 2023/09/01
 */
public class ThirdPartyCodeSandBox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");

        return null;
    }
}
