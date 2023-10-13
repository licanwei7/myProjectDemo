package com.lcw.exerciseback.domain.query;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description:刷题界面-展示选择题的部分信息
 * @Date 2022/2/20 18:27
 */
@Data
public class ShowPartChoiceQuestionQuery {
    /**
     *选择题ID
     */
    private int choiceQuestionsID;

    /**
     *选择题题目
     */
    private String choiceQuestionName;

    /**
     *选择题类型
     */
    private String questionsTypesName;

    /**
     *选择题难度
     */
    private String questionsDifficultyName;
}
