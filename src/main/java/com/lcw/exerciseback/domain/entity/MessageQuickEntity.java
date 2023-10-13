package com.lcw.exerciseback.domain.entity;

import lombok.Data;

@Data
public class MessageQuickEntity {

  /**
   * 快捷消息ID
   */
  private int messageQuickId;

  /**
   *快捷消息头
   */
  private String messageQuickHead;

  /**
   *快捷消息内容
   */
  private String messageQuickContent;

}
