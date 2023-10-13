package com.lcw.exerciseback.domain.query;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageQuery {

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
  private String teacherName;

  /**
   * 快捷消息头
   */
  private String messageQuickHead;

  /**
   * 快捷消息内容
   */
  private String messageQuickContent;

  /**
   *消息发布时间
   */
  private String messageReleaseTime;

  /**
   *是否被查看（0：未被查看   1：已被查看）
   */
  private int isCheck;

}
