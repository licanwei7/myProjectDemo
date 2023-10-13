package com.lcw.exerciseback.mapper.students;

import com.lcw.exerciseback.domain.entity.ForumEntity;
import com.lcw.exerciseback.domain.entity.ForumTypesEntity;
import com.lcw.exerciseback.domain.entity.StudentEntity;
import com.lcw.exerciseback.domain.query.ForumsTopQuery;
import org.apache.ibatis.annotations.Mapper;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/1/11 23:10
 */
@Mapper
public interface SHomeMapper {
    //查询全部论坛文章（按时间倒序）
    List<ForumEntity> queryAllForums();
    //查询论坛排行榜（按阅读量倒序）(取前十位)
    List<ForumsTopQuery> queryForumsTop();
    //查询所有的论坛文章类型（按ID升序）
    List<ForumTypesEntity> queryAllForumTypes();

    //测试的（上传图片）
    int addPhoto(InputStream photo);
    int addString(String str);
}
