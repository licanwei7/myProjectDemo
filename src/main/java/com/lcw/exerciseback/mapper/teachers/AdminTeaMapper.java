package com.lcw.exerciseback.mapper.teachers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/29 17:22
 */
@Mapper
public interface AdminTeaMapper {
    //根据教师ID查询教师密码
    String queryTeaPwdBySID(String teacherID);

    //根据教师ID查询头像
    String queryTeadentHeadP(@Param("teacherID") String teacherID);
}
