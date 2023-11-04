package com.cong.coj.judge.codesandbox.mode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author 86188
 * @date 2023/09/01
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExecuteCodeRequest {

    /**
     *输入用例
     */
    private List<String> inputList;

    /**
     *代码
     */
    private String code;
    private String language;
}
