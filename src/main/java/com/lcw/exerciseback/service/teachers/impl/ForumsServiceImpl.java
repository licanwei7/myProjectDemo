package com.lcw.exerciseback.service.teachers.impl;

import com.lcw.exerciseback.domain.entity.ForumEntity;
import com.lcw.exerciseback.mapper.teachers.ForumsMapper;
import com.lcw.exerciseback.service.teachers.ForumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/21 22:34
 */
@Service
public class ForumsServiceImpl implements ForumsService {
    @Autowired
    private ForumsMapper forumsMapper;

    @Override
    public List<ForumEntity> queryAllForums(String teacherID) {
        return forumsMapper.queryAllForums(teacherID);
    }

    @Override
    public List<ForumEntity> queryAllForumsByLike(String teacherID) {
        return forumsMapper.queryAllForumsByLike(teacherID);
    }

    @Override
    public List<ForumEntity> queryAllForumsByRead(String teacherID) {
        return forumsMapper.queryAllForumsByRead(teacherID);
    }

    @Override
    public List<ForumEntity> queryAllForumsByTime(String teacherID) {
        return forumsMapper.queryAllForumsByTime(teacherID);
    }

    @Override
    public List<ForumEntity> queryAllForumsByKeyWord(String teacherID, String keyWord) {
        return forumsMapper.queryAllForumsByKeyWord(teacherID,keyWord);
    }
}
