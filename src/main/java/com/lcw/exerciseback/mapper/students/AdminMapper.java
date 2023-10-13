package com.lcw.exerciseback.mapper.students;

import com.lcw.exerciseback.domain.entity.StudentEntity;
import com.lcw.exerciseback.domain.entity.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/8 14:40
 */
@Mapper
public interface AdminMapper {

    //根据学生ID查询学生密码
    String queryStuPwdBySID(String studentID);

    //根据学生ID查询头像
    String queryStudentHeadP(@Param("studentID") String studentID);

    //根据学生信息进行注册
    int addStuAdmin(StudentEntity studentEntity);

    //查询学生ID是否存在
    List<String> verIDisExist(String studentID);

    //查询邮箱是否可以用
    List<String> verEmailIsExist(String stuEmail);

    //展示所有教师
    List<TeacherEntity> queryAllTea();
}
