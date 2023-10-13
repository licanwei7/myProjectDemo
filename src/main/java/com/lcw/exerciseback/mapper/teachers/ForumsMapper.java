package com.lcw.exerciseback.mapper.teachers;

import com.lcw.exerciseback.domain.entity.ForumEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/21 22:39
 */
@Mapper
public interface ForumsMapper {
    //根据教师ID查询所发布的全部论坛(时间倒叙-默认)
    List<ForumEntity> queryAllForums(String teacherID);
    //根据教师ID查询所发布的全部论坛(点赞数量倒叙)
    List<ForumEntity> queryAllForumsByLike(String teacherID);
    //根据教师ID查询所发布的全部论坛(浏览次数倒叙)
    List<ForumEntity> queryAllForumsByRead(String teacherID);
    //根据教师ID查询所发布的全部论坛(时间正序)
    List<ForumEntity> queryAllForumsByTime(String teacherID);
    //根据教师ID 和 论坛名关键字 查询所有符合条件的论坛
    List<ForumEntity> queryAllForumsByKeyWord(@Param("teacherID")String teacherID, @Param("keyWord")String keyWord);
}
