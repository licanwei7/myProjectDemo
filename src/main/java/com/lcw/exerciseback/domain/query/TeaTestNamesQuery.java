package com.lcw.exerciseback.domain.query;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/28 23:57
 */
@Data
public class TeaTestNamesQuery {
    /**
     *测试ID
     */
    private Integer testID;
    /**
     *测试名
     */
    private String testName;
}
