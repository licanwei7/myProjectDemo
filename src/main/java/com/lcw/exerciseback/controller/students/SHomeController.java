package com.lcw.exerciseback.controller.students;

import com.lcw.exerciseback.api.ResultDto;
import com.lcw.exerciseback.domain.entity.ForumEntity;
import com.lcw.exerciseback.domain.entity.ForumTypesEntity;
import com.lcw.exerciseback.domain.query.ForumsTopQuery;
import com.lcw.exerciseback.service.students.SHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:首页界面-控制层
 * @Date 2022/1/11 23:09
 */
@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/students/home")
public class SHomeController {
    @Autowired
    private SHomeService SHomeService;

    //展示所有论坛文章（从发布时间近到远排序）
    @RequestMapping("/showAllForums")
    public ResultDto showAllForums(){
        List<ForumEntity> forums= SHomeService.queryAllForums();
        return ResultDto.success("查询成功！",forums);
    }

    //展示论坛文章排行榜（从阅读量大到小排序）
    @RequestMapping("/showForumsTop")
    public ResultDto showForumsTop(){
        List<ForumsTopQuery> forumsTop= SHomeService.queryForumsTop();
        return ResultDto.success("查询成功！",forumsTop);
    }

    //展示所有文章类型
    @RequestMapping("/showAllForumTypes")
    public ResultDto showAllForumTypes(){
        List<ForumTypesEntity> forumTypes= SHomeService.queryAllForumTypes();
        return ResultDto.success("查询成功！",forumTypes);
    }
}
