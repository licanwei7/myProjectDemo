package com.lcw.exerciseback.service.teachers;

import com.lcw.exerciseback.domain.query.TopicsQuery;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/21 22:35
 */
public interface TopicsService {
    //查询全部单选题
    List<TopicsQuery> showAllTopics();
    //根据类型ID查询特定题目
    List<TopicsQuery> queryTopicsByTypeID(Integer typesID);
    //根据题目关键字进行模糊查询题库
    List<TopicsQuery> queryTopicsByKeyWord(String keyWord);
}
