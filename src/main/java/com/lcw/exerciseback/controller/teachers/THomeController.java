package com.lcw.exerciseback.controller.teachers;

import com.lcw.exerciseback.api.ResultDto;
import com.lcw.exerciseback.service.teachers.THomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Licanwei
 * @Description: 教师主页控制层
 * @Date 2022/4/21 22:28
 */
@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/teachers/home")
public class THomeController {
    @Autowired
    private THomeService tHomeService;

    @RequestMapping("/showPageInfo")
    public ResultDto showPageInfo(String teacherID){
        return ResultDto.success("获取成功！", tHomeService.queryHomeInfo(teacherID));
    }
}
