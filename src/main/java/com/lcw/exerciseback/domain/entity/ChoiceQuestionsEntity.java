package com.lcw.exerciseback.domain.entity;

import lombok.Data;

@Data
public class ChoiceQuestionsEntity {

  /**
   *题目ID
   */
  private int choiceQuestionsID;

  /**
   *类型ID
   */
  private int questionsTypesID;

  /**
   *难度ID
   */
  private int questionsDifficultyID;

  /**
   *问题
   */
    private String choiceQuestionName;

  /**
   *选项A
   */
  private String choiceQuestionA;

  /**
   *选项B
   */
  private String choiceQuestionB;

  /**
   *选项C
   */
  private String choiceQuestionC;

  /**
   *选项D
   */
  private String choiceQuestionD;

  /**
   *正确选项
   */
  private String choiceQuestionRightAnswer;

  /**
   *解析
   */
  private String choiceQuestionAnalysis;
}
