package com.lcw.exerciseback.domain.entity;

import lombok.Data;

@Data
public class QuestionsDifficultyEntity {

  /**
   *题目难度ID
   */
  private int questionsDifficultyID;

  /**
   *题目难度名
   */
  private String questionsDifficultyName;
}
