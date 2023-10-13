package com.lcw.exerciseback.domain.query;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/29 11:36
 */
@Data
public class TestAndTeaQuery {
    /**
     *测试ID
     */
    private Integer testID;
    /**
     *教师ID
     */
    private String teacherID;
}
