package com.lcw.exerciseback.service.students;


import com.lcw.exerciseback.domain.entity.ForumEntity;
import com.lcw.exerciseback.domain.entity.ForumTypesEntity;
import com.lcw.exerciseback.domain.query.ForumsTopQuery;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/1/11 23:10
 */
public interface SHomeService {
    //查询全部论坛文章（按照时间倒序）
    List<ForumEntity> queryAllForums();
    //查询论坛排行榜（按阅读量倒序）
    List<ForumsTopQuery> queryForumsTop();
    //查询所有论坛文章类型（按照类型ID升序）
    List<ForumTypesEntity> queryAllForumTypes();

    //上传图片TesT接口
    Boolean upPhoto(File file) throws FileNotFoundException;
}
