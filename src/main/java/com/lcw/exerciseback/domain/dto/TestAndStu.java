package com.lcw.exerciseback.domain.dto;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description: 学生ID和测试ID  为了更改数据库的isHB属性
 * @Date 2022/4/25 14:53
 */
@Data
public class TestAndStu {
    /**
     * 学生ID
     */
    private String studentID;

    /**
     * 测试ID
     */
    private String testID;

    /**
     * rhb次数
     */
    private Integer rhbNum;
}
