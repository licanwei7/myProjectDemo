package com.lcw.exerciseback.domain.query;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/22 16:13
 */
@Data
public class MangeTeaQuery {
    /**
     * 教师ID
     */
    private String teacherID;

    /**
     * 教师账号密码
     */
    private String teacherPwd;

    /**
     * 教师名字
     */
    private String teacherName;

    /**
     * 教师性别
     */
    private String teacherSex;

    /**
     * 教师邮箱
     */
    private String teacherEmail;

    /**
     * 教师头像
     */
    private String teacherHeadPortrait;

    /**
     * 教师所管理的班级
     */
    private String mangeClass;
}
