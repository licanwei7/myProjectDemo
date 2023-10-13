package com.lcw.exerciseback.controller.students;

import com.lcw.exerciseback.api.PageVo;
import com.lcw.exerciseback.api.ResultDto;
import com.lcw.exerciseback.domain.dpo.QueryGradesBySandK;
import com.lcw.exerciseback.domain.dpo.QueryGradesBySandT;
import com.lcw.exerciseback.domain.dto.TestAndStu;
import com.lcw.exerciseback.domain.query.GradesQuery;
import com.lcw.exerciseback.service.students.GradesService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:成绩界面-控制层
 * @Date 2022/2/19 15:20
 */
@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/students/grades")
public class GradesController {
    @Autowired
    private GradesService gradesService;

    //根据学生ID展示该学生的所有成绩（分页）（时间倒序）
    @RequestMapping("/showAllGradesByStudentID")
    public ResultDto showAllGradesByStudentID(@Param("studentID")String studentID,
                                              PageVo pageVo){
        if (studentID==null || studentID==""){
            return ResultDto.fail("查询失败，您ID参数未传！");
        }
        List<GradesQuery> allGrades=gradesService.queryAllGradesByStudentIDPage(studentID,pageVo);
        return ResultDto.success("查询成功！",allGrades);
    }
    //根据（学生ID、测试类型ID）展示所有成绩库（分页）（时间倒序）
    @RequestMapping("/showAllGradesBySIDandTID")
    public ResultDto showAllGradesBySIDandTID(QueryGradesBySandT queryGradesBySandT,
                                              PageVo pageVo){
        if (queryGradesBySandT.getStudentID()==null || queryGradesBySandT.getStudentID()==""){
            return ResultDto.fail("查询失败，您ID参数未传！");
        }
       List<GradesQuery> allGrades=gradesService.queryAllGradesBySIDandTIDPage(queryGradesBySandT,pageVo);
       return ResultDto.success("查询成功！",allGrades);
    }
    //根据（学生ID、测试名的关键字）展示所有成绩库（分页）（时间倒序）
    @RequestMapping("/showAllGradesBySIDandKey")
    public ResultDto showAllGradesBySIDandKey(QueryGradesBySandK queryGradesBySandK,PageVo pageVo){
        if (queryGradesBySandK.getStudentID()==null || queryGradesBySandK.getStudentID()==""){
            return ResultDto.fail("查询失败，您ID参数未传！");
        }
        List<GradesQuery> allGrades=gradesService.queryAllGradesByKeyWordPage(queryGradesBySandK,pageVo);
        return ResultDto.success("查询成功！",allGrades);
    }
    //根据学生ID和测试ID将isHeavyBatching属性从0->1
    @RequestMapping("/transHB")
    public ResultDto transHB(TestAndStu testAndStu){
        System.out.println(testAndStu.getStudentID()+testAndStu.getTestID());
        if (gradesService.transHB(testAndStu)){
           return ResultDto.success("成功申请！");
        }
        else {
            return ResultDto.fail("您的申请次数已经用完！");
        }
    }
    //展示所有测试类型
    @RequestMapping("/showAllTestsTypes")
    public ResultDto showAllTestsTypes(){
        return ResultDto.success("访问成功",gradesService.queryAllTestsTypes());
    }
}
