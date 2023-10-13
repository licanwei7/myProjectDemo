package com.lcw.exerciseback.service.teachers.impl;

import com.lcw.exerciseback.domain.dpo.TeaAndStu;
import com.lcw.exerciseback.domain.dpo.UpdateStuGrade;
import com.lcw.exerciseback.domain.query.GradesQuery;
import com.lcw.exerciseback.domain.query.TeaTestNamesQuery;
import com.lcw.exerciseback.domain.query.TestQuery;
import com.lcw.exerciseback.mapper.students.EvaluateMapper;
import com.lcw.exerciseback.mapper.teachers.ReprintMapper;
import com.lcw.exerciseback.service.teachers.ReprintService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/21 22:34
 */
@Service
public class ReprintServiceImpl implements ReprintService {
    @Autowired
    private ReprintMapper reprintMapper;
    @Autowired
    private EvaluateMapper evaluateMapper;

    @Override
    public List<GradesQuery> queryAllStuGrades(String teacherID) {
        return reprintMapper.queryAllStuGrades(teacherID);
    }

    @Override
    public List<TeaTestNamesQuery> queryAllTestsName(String teacherID) {
        return reprintMapper.queryAllTestsName(teacherID);
    }

    @Override
    public List<GradesQuery> queryAllStuGradesByTestID(Integer testID,String teacherID) {
        return reprintMapper.queryAllStuGradesByTestID(testID,teacherID);
    }

    @Override
    public List<GradesQuery> queryAllStuGradesByStu(String keyWord, String teacherID) {
        return reprintMapper.queryAllStuGradesByStu(keyWord,teacherID);
    }

    @Override
    public Map<String, List> queryRecodeByID(String studentID, Integer testID) {
        Map<String,List> map = new HashMap<>();
        TeaAndStu teaAndStu = new TeaAndStu();
        teaAndStu.setStudentID(studentID);
        teaAndStu.setTestID(testID);
        //查询标准根据测试Id查询标准答案
        List<String> rightAnswers = evaluateMapper.queryAnswers(testID);
        //查询学生答案
        List<String> stuAnswers = new ArrayList<>();
        String stu_Answers = reprintMapper.queryAnswer(teaAndStu);
        String[] stu_Answers1 = stu_Answers.replace('[',' ').replace(']',' ').replaceAll(" ","").split(",");
        for (String item:stu_Answers1){
            stuAnswers.add(item);
        }
        map.put("rightAnswers",rightAnswers);
        map.put("stuAnswers",stuAnswers);

        return map;
    }

    @Override
    public boolean updateStuGrade(String studentID, Integer testID, Integer totalScore) {
        //更改分数
        UpdateStuGrade updateStuGrade = new UpdateStuGrade();
        updateStuGrade.setTestsID(testID);
        updateStuGrade.setTotalScore(totalScore);
        updateStuGrade.setStudentID(studentID);
        updateStuGrade.setResidueHeavyBatchNumber(reprintMapper.queryHBNumber(updateStuGrade)-1);
        reprintMapper.updateStuGrades(updateStuGrade);

        return true;
    }
}
