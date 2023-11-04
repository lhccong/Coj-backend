package com.cong.coj.judge.codesandbox;

import com.cong.coj.judge.codesandbox.impl.ExampleCodeSandBox;
import com.cong.coj.judge.codesandbox.impl.RemoteCodeSandBox;
import com.cong.coj.judge.codesandbox.impl.ThirdPartyCodeSandBox;

/**
 * 代码沙箱工厂（根据字符串参数生成代码沙箱实例）
 * @author 86188
 * @date 2023/09/01
 */
public class CodeSandBoxFactory {

    public static CodeSandbox newInstance(String type){
        switch (type){
            case "remote":
                return new RemoteCodeSandBox();
            case "thirdParty":
                return new ThirdPartyCodeSandBox();
            default:
                return new ExampleCodeSandBox();

        }
    }
}
