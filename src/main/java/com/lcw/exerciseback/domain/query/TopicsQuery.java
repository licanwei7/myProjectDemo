package com.lcw.exerciseback.domain.query;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description: 题库页面展示查询类
 * @Date 2022/4/21 22:53
 */
@Data
public class TopicsQuery {
    /**
     *题目ID
     */
    private int topicID;

    /**
     *题目名
     */
    private String topicName;

     /**
     *题目类型
     */
    private String topicType;

     /**
     *题目难度
     */
    private String topicLevel;

     /**
     *选项A
     */
    private String optionA;

     /**
     *选项B
     */
    private String optionB;

     /**
     *选项C
     */
    private String optionC;

     /**
     *选项D
     */
    private String optionD;

    /**
     *正确选项
     */
    private String rightOption;

    /**
     *解析
     */
    private String analysis;
}
