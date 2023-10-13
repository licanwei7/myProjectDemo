package com.lcw.exerciseback.controller.teachers;

import com.lcw.exerciseback.api.ResultDto;
import com.lcw.exerciseback.service.teachers.ForumsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Licanwei
 * @Description: 教师论坛控制层
 * @Date 2022/4/21 22:28
 */
@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/teachers/forums")
public class ForumsController {
    @Autowired
    private ForumsService forumsService;

    //根据教师ID查询所发布的全部论坛(时间倒叙-默认)
    @RequestMapping("/showAllForums")
    public ResultDto showAllForums(String teacherID){
        if (teacherID==null || teacherID==""){
            return ResultDto.fail("查询失败，您ID参数未传！");
        }
        return ResultDto.success("访问成功！",forumsService.queryAllForums(teacherID));
    }
    //根据教师ID查询所发布的全部论坛(点赞数量倒叙)
    @RequestMapping("/showAllForumsByLike")
    public ResultDto showAllForumsByLike(String teacherID){
        if (teacherID==null || teacherID==""){
            return ResultDto.fail("查询失败，您ID参数未传！");
        }
        return ResultDto.success("访问成功！",forumsService.queryAllForumsByLike(teacherID));
    }
    //根据教师ID查询所发布的全部论坛(浏览次数倒叙)
    @RequestMapping("/showAllForumsByRead")
    public ResultDto showAllForumsByRead(String teacherID){
        if (teacherID==null || teacherID==""){
            return ResultDto.fail("查询失败，您ID参数未传！");
        }
        return ResultDto.success("访问成功！",forumsService.queryAllForumsByRead(teacherID));
    }
    //根据教师ID查询所发布的全部论坛(时间正序)
    @RequestMapping("/showAllForumsByTime")
    public ResultDto showAllForumsByTime(String teacherID){
        if (teacherID==null || teacherID==""){
            return ResultDto.fail("查询失败，您ID参数未传！");
        }
        return ResultDto.success("访问成功！",forumsService.queryAllForumsByTime(teacherID));
    }
    //根据教师ID 和 论坛名关键字 查询所有符合条件的论坛
    @RequestMapping("/showAllForumsByKeyWord")
    public ResultDto showAllForumsByKeyWord(@Param("teacherID")String teacherID,@Param("keyWord")String keyWord){
        if (teacherID==null || teacherID==""){
            return ResultDto.fail("查询失败，您ID参数未传！");
        }
        return ResultDto.success("访问成功！",forumsService.queryAllForumsByKeyWord(teacherID,keyWord));
    }
}
