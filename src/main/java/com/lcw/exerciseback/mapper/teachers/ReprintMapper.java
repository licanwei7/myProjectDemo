package com.lcw.exerciseback.mapper.teachers;

import com.lcw.exerciseback.domain.dpo.TeaAndStu;
import com.lcw.exerciseback.domain.dpo.UpdateStuGrade;
import com.lcw.exerciseback.domain.query.GradesQuery;
import com.lcw.exerciseback.domain.query.TeaTestNamesQuery;
import com.lcw.exerciseback.domain.query.TestQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/21 22:39
 */
@Mapper
public interface ReprintMapper {
    //查看该教师所有学生的成绩情况
    List<GradesQuery> queryAllStuGrades(String teacherID);
    //展示该教师所发布的全部测试名
    List<TeaTestNamesQuery> queryAllTestsName(String teacherID);
    //根据测试ID查询所有符合条件的测试成绩
    List<GradesQuery> queryAllStuGradesByTestID(@Param("testID")Integer testID,@Param("teacherID")String teacherID);
    //根据学生名字关键字查询所有符合条件的测试成绩
    List<GradesQuery> queryAllStuGradesByStu(@Param("keyWord")String keyWord,@Param("teacherID")String teacherID);
    String queryAnswer(TeaAndStu teaAndStu);
    int updateStuGrades(UpdateStuGrade updateStuGrade);
    int queryHBNumber(UpdateStuGrade updateStuGrade);
}
