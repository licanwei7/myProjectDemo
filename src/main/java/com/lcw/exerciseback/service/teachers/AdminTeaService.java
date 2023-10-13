package com.lcw.exerciseback.service.teachers;

import org.apache.ibatis.annotations.Param;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/29 17:17
 */
public interface AdminTeaService {
    //验证前后端教师账号密码是否正确
    boolean verifyTea(@Param("teacherID")String teacherID, @Param("teacherPwd")String teacherPwd);
}
