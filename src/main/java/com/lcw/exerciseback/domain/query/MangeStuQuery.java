package com.lcw.exerciseback.domain.query;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/22 15:49
 */
@Data
public class MangeStuQuery {
    /**
     * 学生ID
     */
    private String studentID;

    /**
     * 学生账号密码
     */
    private String studentPwd;

    /**
     * 学生名字
     */
    private String studentName;

    /**
     * 昵称
     */
    private String studentNickName;

    /**
     * 学生性别（0：女  1：男）
     */
    private String studentSex;

    /**
     * 邮箱
     */
    private String studentEmail;

    /**
     * 头像
     */
    private String studentHeadPortrait;

    /**
     * 教师名称
     */
    private String teacherName;

    //
    private String teacherID;
}
