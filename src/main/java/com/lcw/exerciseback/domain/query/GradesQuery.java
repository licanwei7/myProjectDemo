package com.lcw.exerciseback.domain.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class GradesQuery {

  /**
   * 学生ID
   */
  private String studentID;

  /**
   * 学生ID
   */
  private String studentName;

  /**
   *测试ID
   */
  private Integer testsID;

  /**
   *测试名
   */
  private String testsName;

  /**
   * 测试类型名
   */
  private String testTypesName;

  /**
   * 测试难度名
   */
  private String testLevelsName;

  /**
   *选择题分数
   */
  private Integer choiceQuestionScore;

  /**
   *主观题分数、（经过老师批改才有分）
   */
  private Integer subjectiveTopicScore;

  /**
   *成绩总分数
   */
  private Integer totalScore;

  /**
   *考试完毕时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime examEndTime;

  /**
   *剩余申请重批次数（默认最多2次）
   */
  private Integer ResidueHeavyBatchNumber;

  /**
   *是否正在进行重批（1：是/0：否）
   */
  private Integer isHeavyBatching;

  /**
   *批改人（即教师姓名）
   */
  private String teacherName;
}
