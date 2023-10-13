package com.lcw.exerciseback.domain.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageEntity {

  /**
   *消息ID
   */
  private int messageID;

  /**
   *学生ID
   */
  private String studentID;

  /**
   *测试ID
   */
  private int testsID;

  /**
   *教师ID
   */
  private String teacherID;

  /**
   * 快捷消息ID
   */
  private int messageQuickId;

  /**
   *消息发布时间
   */
  private LocalDateTime messageReleaseTime;

  /**
   *是否被查看（0：未被查看   1：已被查看）
   */
  private int isCheck;

  /**
   * 快捷消息
   */
  private MessageQuickEntity messageQuickEntity;
}
