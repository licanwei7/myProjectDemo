package com.lcw.exerciseback.domain.query;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description: 题目查询类信息
 * @Date 2022/4/25 10:30
 */
@Data
public class TopicItemQuery {
    /**
     * 题目ID
     */
    private Integer topicId;

    /**
     * 题目类型
     */
    private String topicType;

    /**
     * 题目难度
     */
    private String topicLevel;

    /**
     * 题目名
     */
    private String topicName;

    /**
     * 题目选项A
     */
    private String optionA;

    /**
     * 题目选项B
     */
    private String optionB;

    /**
     * 题目选项C
     */
    private String optionC;

    /**
     * 题目选项D
     */
    private String optionD;

    /**
     * 正确选项
     */
    private String rightAnswer;

    /**
     * 解析
     */
    private String analysis;
}
