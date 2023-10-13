package com.lcw.exerciseback.mapper.students;

import com.lcw.exerciseback.domain.entity.ChoiceQuestionsEntity;
import com.lcw.exerciseback.domain.entity.GradesEntity;
import com.lcw.exerciseback.domain.entity.MessageEntity;
import com.lcw.exerciseback.domain.query.EvaluateQuery;
import com.lcw.exerciseback.domain.query.TestQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/2/19 18:08
 */
@Mapper
public interface EvaluateMapper {
    //根据学生ID查询该学生存在哪些测试未完成
    List<Integer> queryTestCompleteByStudentID(@Param("studentID")String studentID);
    //根据学生ID查询该学生所有未完成测试的部分信息
    List<EvaluateQuery> queryAllTestByStudentID(@Param("studentID")String studentID);
    //1.根据测试ID查询该测试所包含内容，目前只涉及到单选
    TestQuery queryThisTest(Integer testID);
    //2.根据测试ID查询该测试所包含内容，目前只涉及到单选
    List<ChoiceQuestionsEntity> queryThisTestRadio(Integer testID);
    //将test_iscompele这个表中的该学生的该测试改成已经完成
    int updateTestComplete(@Param("studentID")String studentID,@Param("testID")Integer testID);
    //将学生测试答案记录存入test_record表中
    int addTestRecords(@Param("studentID")String studentID,@Param("testID")Integer testID,@Param("radioAnswers")String radioAnswers);
    //根据测试ID查询正确答案集合
    List<String> queryAnswers(@Param("testID")Integer testID);
    //在成绩表中添加一条该学生的成绩信息
    int addStuGrade(GradesEntity stuGrade);
    //添加一条Message消息
    int addStuMessage(MessageEntity messageEntity);
    //根据学生ID查询教师ID
    String queryTeaByStu(String studentID);
}
