package com.lcw.exerciseback.service.students.impl;

import com.lcw.exerciseback.domain.entity.ChoiceQuestionsEntity;
import com.lcw.exerciseback.domain.entity.GradesEntity;
import com.lcw.exerciseback.domain.entity.MessageEntity;
import com.lcw.exerciseback.domain.query.EvaluateQuery;
import com.lcw.exerciseback.domain.query.TestQuery;
import com.lcw.exerciseback.mapper.students.EvaluateMapper;
import com.lcw.exerciseback.service.students.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/2/19 18:13
 */
@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    private EvaluateMapper evaluateMapper;

    @Override
    public Boolean queryTestCompleteByStudentID(String studentID) {
        List<Integer> list=evaluateMapper.queryTestCompleteByStudentID(studentID);
        if (list.isEmpty()){
            return true;//返回true 集合为空，表示该同学已经完成所有测试！
        }else {
            return false;//返回false表示该同学还有测试未能及时完成...
        }

    }

    @Override
    public List<EvaluateQuery> queryAllTestByStudentID(String studentID) {
        List<EvaluateQuery> list=evaluateMapper.queryAllTestByStudentID(studentID);
        return list;
    }

    @Override
    public TestQuery queryThisTestsContent(Integer testID) {
        //获取主体测试
        TestQuery test = evaluateMapper.queryThisTest(testID);
        List<ChoiceQuestionsEntity> radios = evaluateMapper.queryThisTestRadio(testID);
        test.setRadios(radios);
        return test;
    }

    @Override
    public boolean submitStuTest(String studentID, Integer testID, String radioAnswers) {
        float score = 0;//分数
        float fullScore = 0;//满分
        GradesEntity stuGrade = new GradesEntity();
        MessageEntity stuMessage = new MessageEntity();
        String teacherID = evaluateMapper.queryTeaByStu(studentID);

        //把格式转成正常的集合
        List<Character> list = new ArrayList();
        for (int i =0;i<radioAnswers.length();i++){
            char item = radioAnswers.charAt(i);
            if (item=='A'||item=='B'||item=='C'||item=='D'||item=='a'||item=='b'||item=='c'||item=='d'){
                list.add(item);
            }
        }
        fullScore = list.size()*10;
        //将test_isComplete这个表中的该学生的该测试改成已经完成
        int isComplete = evaluateMapper.updateTestComplete(studentID,testID);
        if (isComplete<1){
            System.out.println("更改test_isComplete表状态异常！");
            return false;
        }
        //将学生测试答案记录存入test_record表中
        Integer isAddRecord = evaluateMapper.addTestRecords(studentID,testID,list.toString());
        if (isAddRecord<1){
            System.out.println("添加学生测试答案记录时出现异常！");
            return false;
        }
        //根据测试ID查询正确答案集合
        List<String> rightAnswers = evaluateMapper.queryAnswers(testID);
        //在成绩表中添加一条该学生的成绩信息
            //先比对答案正确率
            System.out.println("用户作答的："+list.toString());
            System.out.println("正确答案是："+rightAnswers.toString());
            System.out.println(rightAnswers.size());
            System.out.println(list.size());
        System.out.println(10<rightAnswers.size());
        System.out.println(10<rightAnswers.size()-1);
            for (int i=0;i<rightAnswers.size();i++){
                if (Character.toString(list.get(i)).equals(rightAnswers.get(i))){
                    score = score+10;
                }
            }
        stuGrade.setStudentID(studentID);
        stuGrade.setTestsID(testID);
        stuGrade.setChoiceQuestionScore(Math.round(100*(score/fullScore)));
        stuGrade.setSubjectiveTopicScore(0);
        stuGrade.setTotalScore(Math.round(100*(score/fullScore)));
        stuGrade.setExamEndTime(null);
        stuGrade.setResidueHeavyBatchNumber(2);
        stuGrade.setIsHeavyBatching(0);
        stuGrade.setTeacherID(teacherID);

        int isAddStuGrade = evaluateMapper.addStuGrade(stuGrade);
        if (isAddStuGrade<1){
            System.out.println("添加学生测试成绩时出现异常");
            return false;
        }
        //根据测试结果添加一条消息
        stuMessage.setStudentID(studentID);
        stuMessage.setTestsID(testID);
        stuMessage.setTeacherID(teacherID);
        stuMessage.setMessageQuickId(1);
        stuMessage.setIsCheck(0);
        int isAddStuMessage = evaluateMapper.addStuMessage(stuMessage);
        if (isAddStuMessage<1){
            System.out.println("添加学生消息时出现异常");
            return false;
        }
        return true;
    }
}
