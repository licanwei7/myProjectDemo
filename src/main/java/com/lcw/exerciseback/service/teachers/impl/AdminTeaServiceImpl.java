package com.lcw.exerciseback.service.teachers.impl;

import com.lcw.exerciseback.mapper.teachers.AdminTeaMapper;
import com.lcw.exerciseback.service.students.AdminService;
import com.lcw.exerciseback.service.teachers.AdminTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/29 17:20
 */
@Service
public class AdminTeaServiceImpl implements AdminTeaService {
    @Autowired
    private AdminTeaMapper adminTeaMapper;

    @Override
    public boolean verifyTea(String teacherID, String teacherPwd) {
        String pwd =adminTeaMapper.queryTeaPwdBySID(teacherID);

        if (pwd==""||pwd==null){
            return false;
        }

        if (pwd.equals(teacherPwd)){
            return true;
        }else {
            return false; //根据教师账号拿到的密码 1.未空 或者 2.与前端获取不同（均不给予通过）
        }

    }
}
