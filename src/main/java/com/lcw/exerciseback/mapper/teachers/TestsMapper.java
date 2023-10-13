package com.lcw.exerciseback.mapper.teachers;

import com.lcw.exerciseback.domain.dpo.TeaAndStu;
import com.lcw.exerciseback.domain.dpo.TestAdd;
import com.lcw.exerciseback.domain.dpo.TestAndRadio;
import com.lcw.exerciseback.domain.entity.TestLevels;
import com.lcw.exerciseback.domain.entity.TestTypes;
import com.lcw.exerciseback.domain.query.TestsQuery;
import com.lcw.exerciseback.domain.query.TopicShowQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/21 22:39
 */
@Mapper
public interface TestsMapper {
    //查看该教师所发布的所有测试
    List<TestsQuery> queryAllTests(String teacherID);
    //展示该教师所发布所有测试的测试类型
    List<TestTypes> queryAllTypes(String teacherID);
    //展示该教师所发布所有测试的测试难度
    List<TestLevels> queryAllLevels(String teacherID);
    //根据测试类型ID展示该教师发布的所有测试
    List<TestsQuery> queryAllTestsByTestTypeID(@Param("teacherID")String teacherID, @Param("typeID")Integer typeID);
    //根据题目关键字进行模糊查询
    List<TestsQuery> queryAllTestsByKeyWord(@Param("teacherID")String teacherID, @Param("keyWord")String keyWord);
    //查询所有单选题的ID和名字
    List<TopicShowQuery> queryAllTopic();
    //添加测试入测试表
    int addTest(TestAdd testAdd);
    //查询所有的学生
    List<String> queryAllStu(@Param("teacherID")String teacherID);
    //查询最新测试ID
    Integer queryTestID();
    //添加进入测试完成表
    int addTestComplete(TeaAndStu teaAndStu);
    //插入测试单选对应表
    int addTestRadio(TestAndRadio testAndRadio);
}
