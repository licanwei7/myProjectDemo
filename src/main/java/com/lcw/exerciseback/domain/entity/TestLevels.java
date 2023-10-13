package com.lcw.exerciseback.domain.entity;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description: 测试难度实体类
 * @Date 2022/4/25 15:35
 */
@Data
public class TestLevels {
    /**
     * 测试难度ID
     */
    private Integer testLevelsID;

    /**
     * 难度名
     */
    private String testLevelsName;
}
