package com.lcw.exerciseback.domain.entity;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description:老师实体类
 * @Date 2022/2/19 15:14
 */
@Data
public class TeacherEntity {
    /**
     *教师ID
     */
    private String teacherID;

    /**
     *教师密码
     */
    private String teacherPwd;

    /**
     *教师姓名
     */
    private String teacherName;

    private String teacherSex;

    private String teacherEmail;

    private String mangeClass;
}
