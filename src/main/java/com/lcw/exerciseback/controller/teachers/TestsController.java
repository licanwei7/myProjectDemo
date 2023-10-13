package com.lcw.exerciseback.controller.teachers;

import com.lcw.exerciseback.api.ResultDto;
import com.lcw.exerciseback.domain.dpo.TestAdd;
import com.lcw.exerciseback.mapper.teachers.TestsMapper;
import com.lcw.exerciseback.service.teachers.TestsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Licanwei
 * @Description: 教师测试控制层
 * @Date 2022/4/21 22:28
 */
@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/teachers/tests")
public class TestsController {
    @Autowired
    private TestsService testsService;
    @Autowired
    private TestsMapper testsMapper;

    //展示该教师所发布的所有测试
    @RequestMapping("/showAllTests")
    public ResultDto showAllTests(String teacherID){
        return ResultDto.success("访问成功！",testsService.queryAllTests(teacherID));
    }

    //展示该教师所发布所有测试的测试类型
    @RequestMapping("/showAllTestsType")
    public ResultDto showAllTestsType(String teacherID){
        return ResultDto.success("访问成功！",testsService.queryAllTypes(teacherID));
    }

    //展示该教师所发布所有测试的测试类型
    @RequestMapping("/showAllTestsLevel")
    public ResultDto showAllTestsLevel(String teacherID){
        return ResultDto.success("访问成功！",testsService.queryAllLevels(teacherID));
    }

    //根据测试类型ID展示该教师发布的所有测试
    @RequestMapping("/showAllTestsByTypeID")
    public ResultDto showAllTestsByTestID(@Param("teacherID")String teacherID,@Param("typeID")Integer typeID){
        return ResultDto.success("访问成功！",testsService.queryAllTestsByTestTypeID(teacherID,typeID));
    }

    //根据测试名关键字展示该教师所发布的所有测试
    @RequestMapping("/showAllTestsByKeyWord")
    public ResultDto showAllTestsByKeyWord(@Param("teacherID")String teacherID,@Param("keyWord")String keyWord){
        return ResultDto.success("访问成功！",testsService.queryAllTestsByKeyWord(teacherID,keyWord));
    }
    //查询所有单选题的ID和名字
    @RequestMapping("/showAllTopic")
    public ResultDto showAllTopic(){
        return ResultDto.success("访问成功！",testsMapper.queryAllTopic());
    }
    //添加测试
    @RequestMapping("/addTest")
    public ResultDto addTest(@Param("topics")String topics,
                             @Param("testName")String testName,
                             @Param("testName")Integer testLevel,
                             @Param("testName")Integer testType,
                             @Param("testName")Integer maxTime,
                             @Param("teacherID")String teacherID){
        //弄成正常集合
        List<Integer> arrayList = new ArrayList<>();
        String[] array = topics.split("&");
        for (int i=0;i<array.length;i++){
            char a = array[i].toString().charAt(2);
            arrayList.add(a-48);
        }
        return ResultDto.success("访问成功！",testsService.addTest(arrayList,testName,testLevel,testType,maxTime,teacherID));
    }
}
