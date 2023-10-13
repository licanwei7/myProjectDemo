package com.lcw.exerciseback.mapper.teachers;

import com.lcw.exerciseback.domain.entity.ChoiceQuestionsEntity;
import com.lcw.exerciseback.domain.query.TopicsQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/21 22:39
 */
@Mapper
public interface TopicsMapper {
    //  <!--展示所有题库题目（按ID倒叙）-->
    List<TopicsQuery> showAllTopics();
    //根据类型ID查询特定题目
    List<TopicsQuery> queryTopicsByTypeID(Integer typesID);
    //根据题目关键字进行模糊查询题库
    List<TopicsQuery> queryTopicsByKeyWord(String keyWord);
    //新建题目
    int addTopic(ChoiceQuestionsEntity topic);
    //根据题目ID拿到题目内容
    ChoiceQuestionsEntity queryTopicByID(Integer choiceQuestionsID);
    //根据题目ID更新题目
    int updateThisTopic(ChoiceQuestionsEntity topic);
    //根据Id删除题目
    int deleteThisTopic(Integer choiceQuestionsID);
}
