package com.lcw.exerciseback.service.students.impl;

import com.lcw.exerciseback.mapper.students.AdminMapper;
import com.lcw.exerciseback.service.students.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/8 14:35
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean verifyStu(@Param("studentID") String studentID, @Param("studentPwd") String studentPwd) {

        String pwd =adminMapper.queryStuPwdBySID(studentID);

        if (pwd==""||pwd==null){
            return false;
        }

        if (pwd.equals(studentPwd)){
            return true;
        }else {
            return false; //根据学生账号拿到的密码 1.未空 或者 2.与前端获取不同（均不给予通过）
        }

    }
}
