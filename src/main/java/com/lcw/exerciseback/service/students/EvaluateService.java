package com.lcw.exerciseback.service.students;

import com.lcw.exerciseback.domain.query.EvaluateQuery;
import com.lcw.exerciseback.domain.query.TestQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/2/19 18:09
 */
public interface EvaluateService {
    //根据学生ID查询该学生是否有测试未完成
    Boolean queryTestCompleteByStudentID(@Param("studentID")String studentID);
    //根据学生ID查询该学生所有未完成测试的部分信息
    List<EvaluateQuery> queryAllTestByStudentID(@Param("studentID")String studentID);
    //根据学生点击测试ID查询该测试所包含内容集合
    TestQuery queryThisTestsContent(Integer testID);
    //将学生 测试结果存入数据库 以及 自动匹配分数 以及 测试状态 改变
    boolean submitStuTest(@Param("studentID")String studentID,
                          @Param("testID")Integer testID,
                          @Param("radioAnswers")String radioAnswers);

}
