package com.lcw.exerciseback.service.students.impl;

import com.lcw.exerciseback.domain.entity.ForumEntity;
import com.lcw.exerciseback.domain.entity.ForumTypesEntity;
import com.lcw.exerciseback.domain.query.ForumsTopQuery;
import com.lcw.exerciseback.mapper.students.SHomeMapper;
import com.lcw.exerciseback.service.students.SHomeService;
import com.lcw.exerciseback.utils.PhotoUpAndDownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/1/11 23:11
 */

@Service
public class SHomeServiceImpl implements SHomeService {
    @Autowired
    private SHomeMapper SHomeMapper;

    @Override
    public List<ForumEntity> queryAllForums() {
        List<ForumEntity> forums= SHomeMapper.queryAllForums();
        return forums;
    }

    @Override
    public List<ForumsTopQuery> queryForumsTop() {
        List<ForumsTopQuery> forumsTop= SHomeMapper.queryForumsTop();
        return forumsTop;
    }

    @Override
    public List<ForumTypesEntity> queryAllForumTypes() {
        List<ForumTypesEntity> forumTypes= SHomeMapper.queryAllForumTypes();
        return forumTypes;
    }

    @Override
    public Boolean upPhoto(File file) throws FileNotFoundException {
       InputStream in = PhotoUpAndDownUtils.upPhoto(file);
        if (SHomeMapper.addPhoto(in)>=1){
            return true;
        }//图片上传成功！
        return false;//失败
    }
}
