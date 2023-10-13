package com.lcw.exerciseback.mapper.root;

import com.lcw.exerciseback.domain.entity.StudentEntity;
import com.lcw.exerciseback.domain.entity.TeacherEntity;
import com.lcw.exerciseback.domain.query.MangeStuQuery;
import com.lcw.exerciseback.domain.query.MangeTeaQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/22 15:21
 */
@Mapper
public interface ManageMapper {
    //1.管理学生
    //展示全部学生
    List<MangeStuQuery> queryAllStu();
    //更改指定ID学生信息
    MangeStuQuery queryStuByID(@Param("studentID")String studentID);
    int updateStu(StudentEntity studentEntity);
    //删除指定ID学生信息
    int deleteStu(@Param("studentID")String studentID);
    //新增学生
    int addStu(StudentEntity studentEntity);


    //2.管理教师
    List<MangeTeaQuery> queryTeaByInfo(@Param("info")String info);
    //展示全部教师
    List<MangeTeaQuery> queryAllTea();
    //更改指定ID教师信息
    MangeTeaQuery queryTeaByID(@Param("teacherID")String teacherID);
    int updateTea(TeacherEntity teacherEntity);
    //删除指定ID教师信息
    int deleteTeaByID(@Param("teacherID")String teacherID);

    //新增教师
    int addTea(TeacherEntity teacher);


    List<String> queryAdmin(@Param("systemID")String systemID, @Param("systemPwd")String systemPwd);
    //根据学生账号或者学生姓名查询
    List<MangeStuQuery> queryStuByInfo(@Param("info")String info);
    //根据教师姓名拆线呢学生
    List<MangeStuQuery> queryStuByTea(@Param("teaName")String teaName);
}
