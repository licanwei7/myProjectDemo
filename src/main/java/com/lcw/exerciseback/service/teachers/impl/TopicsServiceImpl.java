package com.lcw.exerciseback.service.teachers.impl;

import com.lcw.exerciseback.domain.query.TopicsQuery;
import com.lcw.exerciseback.mapper.teachers.TopicsMapper;
import com.lcw.exerciseback.service.teachers.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/21 22:35
 */
@Service
public class TopicsServiceImpl implements TopicsService {
    @Autowired
    private TopicsMapper topicsMapper;

    @Override
    public List<TopicsQuery> showAllTopics() {
        return topicsMapper.showAllTopics();
    }

    @Override
    public List<TopicsQuery> queryTopicsByTypeID(Integer typesID) {
        return topicsMapper.queryTopicsByTypeID(typesID);
    }

    @Override
    public List<TopicsQuery> queryTopicsByKeyWord(String keyWord) {
        return topicsMapper.queryTopicsByKeyWord(keyWord);
    }
}
