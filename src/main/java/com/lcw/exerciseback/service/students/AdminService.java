package com.lcw.exerciseback.service.students;

import org.apache.ibatis.annotations.Param;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/8 14:35
 */
public interface AdminService {
    //验证前后端学生账号密码是否正确
    boolean verifyStu(@Param("studentID")String studentID,@Param("studentPwd")String studentPwd);
}
