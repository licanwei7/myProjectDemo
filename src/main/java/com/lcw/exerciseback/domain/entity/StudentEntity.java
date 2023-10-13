package com.lcw.exerciseback.domain.entity;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description: 学生实体类
 * @Date 2022/2/19 14:57
 */
@Data
public class StudentEntity {
    /**
     *学生ID
     */
    private String studentID;

    /**
     *学生密码
     */
    private String studentPwd;

    /**
     *学生姓名
     */
    private String studentName;

    /**
     *性别0：女  1：男
     */
    private String studentSex;

    /**
     *QQ邮箱
     */
    private String studentEmail;

    /**
     *昵称
     */
    private String studentNickName;

    /**
     *头像
     */
    private String studentHeadPortrait;

    /**
     *教师ID
     */
    private String teacherID;
}
