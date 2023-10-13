 package com.lcw.exerciseback.controller.students;

import com.lcw.exerciseback.api.ResultDto;
import com.lcw.exerciseback.domain.query.EvaluateQuery;
import com.lcw.exerciseback.service.students.EvaluateService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

 /**
 * @Author Licanwei
 * @Description:评测界面-控制层
 * @Date 2022/2/19 15:19
 */
@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/students/evaluate")
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;

    //通过学生ID查询该学生是否有测试全部完成
    @RequestMapping("/isCompleteAllTestByStudentID")
    public ResultDto isCompleteAllTestByStudentID(@Param("studentID")String studentID){
        if (studentID==null || studentID==""){
          return ResultDto.fail("查询失败，您ID参数未传！");
        }
        Boolean iscomplete=evaluateService.queryTestCompleteByStudentID(studentID);
        return ResultDto.success("查询成功！",iscomplete);
    }
    //通过学生ID展示所有该学生未完成的测试信息
    @RequestMapping("/showAllTestByStudent")
    public ResultDto showAllTestByStudent(@Param("studentID")String studentID){
        if (studentID==null || studentID==""){
            return ResultDto.fail("查询失败，您ID参数未传！");
        }
        List<EvaluateQuery> allTestInformations=evaluateService.queryAllTestByStudentID(studentID);
        return ResultDto.success("查询成功！",allTestInformations);
    }
    //根据测试ID查询本次测试的内容（主单选题）
    @RequestMapping("/showThisTest")
    public ResultDto showThisTest(@Param("testID")Integer testID){
        if (testID==null || testID==0){
            return ResultDto.fail("查询失败，您ID参数未传！");
        }
        return ResultDto.success("查询成功！",evaluateService.queryThisTestsContent(testID));
    }
    //接收前端提交的学生测试情况（学生ID、测试ID、所填写答案list）
    @RequestMapping("/submitStuTestAnswer")
    public ResultDto submitStuTestAnswer(@Param("studentID")String studentID,
                                      @Param("testID")Integer testID,
                                      @Param("radioAnswers")String[] radioAnswers){
        if (evaluateService.submitStuTest(studentID,testID,radioAnswers[0])){
            return ResultDto.success("提交成功");
        }else {
            return ResultDto.fail("异常错误，提交失败！");
        }

    }
}
