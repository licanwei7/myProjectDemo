package com.lcw.exerciseback.mapper.teachers;

import com.lcw.exerciseback.domain.dto.GradesSituation;
import com.lcw.exerciseback.domain.dto.TestSituation;
import com.lcw.exerciseback.domain.query.TopicsQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/21 22:39
 */
@Mapper
public interface THomeMapper {
    //查询近两次该教师发布测试信息
    List<Integer> queryTwoTests(String teacherID);
    //查询该测试的完成情况
    List<TestSituation> queryTestSituation(Integer testID);
    //根据测试查询各个分数阶段人数
    List<GradesSituation> queryEachPhaseNum(int testID);
}
