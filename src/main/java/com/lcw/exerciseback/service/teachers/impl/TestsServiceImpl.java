package com.lcw.exerciseback.service.teachers.impl;

import com.lcw.exerciseback.domain.dpo.TeaAndStu;
import com.lcw.exerciseback.domain.dpo.TestAdd;
import com.lcw.exerciseback.domain.dpo.TestAndRadio;
import com.lcw.exerciseback.domain.entity.TestLevels;
import com.lcw.exerciseback.domain.entity.TestTypes;
import com.lcw.exerciseback.domain.query.TestsQuery;
import com.lcw.exerciseback.mapper.teachers.TestsMapper;
import com.lcw.exerciseback.service.teachers.TestsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/21 22:35
 */
@Service
public class TestsServiceImpl implements TestsService {
    @Autowired
    private TestsMapper testsMapper;

    @Override
    public List<TestsQuery> queryAllTests(String teacherID) {
        return testsMapper.queryAllTests(teacherID);
    }

    @Override
    public List<TestTypes> queryAllTypes(String teacherID) {
        return testsMapper.queryAllTypes(teacherID);
    }

    @Override
    public List<TestLevels> queryAllLevels(String teacherID) {
        return testsMapper.queryAllLevels(teacherID);
    }

    @Override
    public List<TestsQuery> queryAllTestsByTestTypeID(String teacherID, Integer typeID) {
        return testsMapper.queryAllTestsByTestTypeID(teacherID,typeID);
    }

    @Override
    public List<TestsQuery> queryAllTestsByKeyWord(String teacherID, String keyWord) {
        return testsMapper.queryAllTestsByKeyWord(teacherID,keyWord);
    }

    @Override
    public boolean addTest(List<Integer> topics, String testName, Integer testLevel, Integer testType, Integer maxTime,String teacherID) {
        //首先将测试加入进去测试表
        TestAndRadio testAndRadio = new TestAndRadio();
        TeaAndStu teaAndStu = new TeaAndStu();
        TestAdd test = new TestAdd();
        test.setTestName(testName);
        test.setTestLevel(testLevel);
        test.setTestType(testType);
        test.setMaxTime(maxTime);
        test.setTeacherID(teacherID);
        int addTestOk =testsMapper.addTest(test);
        if (addTestOk<1){
            System.out.println("添加测试表步骤出现问题");
            return false;
        }
        //根据测试添加时间排序，拿到第一个（也就是刚刚添加的）
        Integer testID = testsMapper.queryTestID();
        //查询该教师所管理的所有学生
        List<String> allStu = new ArrayList<>();
        allStu = testsMapper.queryAllStu(teacherID);
        //根据这些学生依此插入未完成测试表
        for(String item:allStu){
            teaAndStu.setStudentID(item);
            teaAndStu.setTestID(testID);
            testsMapper.addTestComplete(teaAndStu);
        }
        //建立选择题和测试的对应关系
        for (Integer item:topics){
            testAndRadio.setTestID(testID);
            testAndRadio.setRadioID(item);
            testsMapper.addTestRadio(testAndRadio);
        }
        return true;
    }
}
