package com.lcw.exerciseback.controller.teachers;

import com.lcw.exerciseback.api.ResultDto;
import com.lcw.exerciseback.domain.entity.ChoiceQuestionsEntity;
import com.lcw.exerciseback.mapper.teachers.TopicsMapper;
import com.lcw.exerciseback.service.teachers.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Licanwei
 * @Description: 教师题库控制层
 * @Date 2022/4/21 22:28
 */
@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/teachers/topics")
public class TopicsController {
    @Autowired
    private TopicsService topicsService;
    @Autowired
    private TopicsMapper topicsMapper;

    //展示所有题库题目（按ID倒叙）
    @RequestMapping("/showAllTopics")
    public ResultDto showAllTopics(){
        return ResultDto.success("获取成功！", topicsService.showAllTopics());
    }
    //根据题目类型展示指定部分题库题目（按ID倒叙）
    @RequestMapping("/showTopicsByTypeID")
    public ResultDto showTopicsByTypeID(Integer typeID){
        return ResultDto.success("获取成功！", topicsService.queryTopicsByTypeID(typeID));
    }
    //根据题目关键字进行模糊查询
    @RequestMapping("/showTopicsByKeyWord")
    public ResultDto showTopicsByKeyWord(String keyWord){
        return ResultDto.success("获取成功！",topicsService.queryTopicsByKeyWord(keyWord));
    }
    //新增题目
    @RequestMapping("/addTopic")
    public ResultDto addTopic(ChoiceQuestionsEntity topic){
        int isOK = topicsMapper.addTopic(topic);
        if (isOK>=1){
            return ResultDto.success("新增成功！");
        }else {
            return ResultDto.fail("新增失败");
        }
    }
    //根据题目ID拿到题目内容
    @RequestMapping("/showThisTopic")
    public ResultDto showThisTopic(Integer choiceQuestionsID){
        return ResultDto.success("访问成功！",topicsMapper.queryTopicByID(choiceQuestionsID));
    }
    //根据题目ID更新题目
    @RequestMapping("/updateThisTopic")
    public ResultDto updateThisTopic(ChoiceQuestionsEntity topic){
        return ResultDto.success("更新成功！",topicsMapper.updateThisTopic(topic));
    }
    //根据题目ID删除题目
    @RequestMapping("/deleteThisTopic")
    public ResultDto deleteThisTopic(Integer choiceQuestionsID){
        return ResultDto.success("删除成功！",topicsMapper.deleteThisTopic(choiceQuestionsID));
    }
}
