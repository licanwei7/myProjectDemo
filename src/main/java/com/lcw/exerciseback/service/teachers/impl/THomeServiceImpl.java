package com.lcw.exerciseback.service.teachers.impl;

import com.lcw.exerciseback.domain.dto.GradesSituation;
import com.lcw.exerciseback.domain.dto.TestSituation;
import com.lcw.exerciseback.domain.query.TopicsQuery;
import com.lcw.exerciseback.mapper.teachers.THomeMapper;
import com.lcw.exerciseback.service.teachers.THomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/21 22:33
 */
@Service
public class THomeServiceImpl implements THomeService {
    @Autowired
    private THomeMapper tHomeMapper;


    @Override
    public Map<String, List> queryHomeInfo(String teacherID) {
        Map<String,List> map = new HashMap<>();

        //拿到该教师发布近两次的测试信息
        List<Integer> list = tHomeMapper.queryTwoTests(teacherID);
        //拿到前一次测试 学生测试完成情况
        List<TestSituation> lastSituation = tHomeMapper.queryTestSituation(list.get(1));
        //拿到当前次数的 学生测试完成情况
        List<TestSituation> currentSituation = tHomeMapper.queryTestSituation(list.get(0));
        //拿到前一次测试 各个成绩分布人数情况
        List<GradesSituation> lastEachPhaseNum = tHomeMapper.queryEachPhaseNum(list.get(1));
        //拿到前一次测试 各个成绩分布人数情况
        List<GradesSituation> currentEachPhaseNum = tHomeMapper.queryEachPhaseNum(list.get(0));
        map.put("lastSituation",lastSituation);
        map.put("currentSituation",currentSituation);
        map.put("lastEachPhaseNum",lastEachPhaseNum);
        map.put("currentEachPhaseNum",currentEachPhaseNum);

        return map;
    }
}
