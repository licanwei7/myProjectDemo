package com.lcw.exerciseback.service.teachers;

import com.lcw.exerciseback.domain.entity.TestLevels;
import com.lcw.exerciseback.domain.entity.TestTypes;
import com.lcw.exerciseback.domain.query.TestsQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/21 22:35
 */
public interface TestsService {
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
    //添加测试
    boolean addTest(@Param("topics")List<Integer> topics,
                    @Param("testName")String testName,
                    @Param("testName")Integer testLevel,
                    @Param("testName")Integer testType,
                    @Param("testName")Integer maxTime,
                    @Param("teacherID")String  teacherID);
}
