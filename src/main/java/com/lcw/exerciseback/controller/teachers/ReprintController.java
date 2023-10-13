package com.lcw.exerciseback.controller.teachers;

import com.lcw.exerciseback.api.ResultDto;
import com.lcw.exerciseback.domain.query.GradesQuery;
import com.lcw.exerciseback.service.teachers.ReprintService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Licanwei
 * @Description: 教师重批控制层
 * @Date 2022/4/21 22:28
 */
@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/teachers/reprint")
public class ReprintController {
    @Autowired
    private ReprintService reprintService;

    @RequestMapping("/showAllStuGrades")
    public ResultDto showAllStuGrades(String teacherID){
        return ResultDto.success("访问成功！",reprintService.queryAllStuGrades(teacherID));
    }

    //展示该教师所发布的所有测试名称
    @RequestMapping("/showAllTestsName")
    public ResultDto showAllTestsName(String teacherID){
        return ResultDto.success("访问成功！",reprintService.queryAllTestsName(teacherID));
    }
    //根据测试ID查询所有符合条件的测试成绩
    @RequestMapping("/showAllStuGradesByTestID")
    public ResultDto showAllStuGradesByTestID(@Param("testID")Integer testID,@Param("teacherID")String teacherID){
        System.out.println(teacherID+":"+testID);
        return ResultDto.success("访问成功！",reprintService.queryAllStuGradesByTestID(testID,teacherID));
    }
    //根据学生名字关键字查询所有符合条件的测试成绩
    @RequestMapping("/showAllStuGradesByStu")
    public ResultDto showAllStuGradesByStu(@Param("keyWord")String keyWord,@Param("teacherID")String teacherID){
        return ResultDto.success("访问成功！",reprintService.queryAllStuGradesByStu(keyWord,teacherID));
    }
    //根据学生ID和测试ID查找测试答案和学生答题答案
    @RequestMapping("/queryRecodeByID")
    public ResultDto queryRecodeByID(@Param("studentID")String studentID,@Param("testID")Integer testID){
        return ResultDto.success("访问成功！",reprintService.queryRecodeByID(studentID,testID));
    }
    //更改学生分数
    @RequestMapping("/updateStuGrade")
    public ResultDto updateStuGrade(@Param("studentID")String studentID,@Param("testID")Integer testID,@Param("totalScore")Integer totalScore){
        return ResultDto.success("更改成功！",reprintService.updateStuGrade(studentID,testID,totalScore));
    }
}
