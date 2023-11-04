package com.cong.coj.judge.codesandbox;

import com.cong.coj.judge.codesandbox.impl.ExampleCodeSandBox;
import com.cong.coj.judge.codesandbox.mode.ExecuteCodeRequest;
import com.cong.coj.judge.codesandbox.mode.ExecuteCodeResponse;
import com.cong.coj.model.enums.QuestionSubmitLanguageEnum;
import com.cong.coj.model.enums.QuestionSubmitStatusEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CodeSandboxTest {
    @Value("${codesandbox.type:example}")
    String type;
    @Test
    void executeCode() {
        CodeSandbox codeSandbox = CodeSandBoxFactory.newInstance(type);
        String code = "int main {}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = new ArrayList<>();
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }
    @Test
    void executeCodeByProxy() {
        CodeSandbox codeSandbox = CodeSandBoxFactory.newInstance(type);
        codeSandbox = new CodeSandBoxProxy(codeSandbox);
        String code = "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        Integer arg1 = Integer.valueOf(args[0]);\n" +
                "        Integer arg2 = Integer.valueOf(args[1]);\n" +
                "        System.out.println(\"结果:\"+ (arg2+arg1));\n" +
                "    }\n" +
                "}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2","3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }
}