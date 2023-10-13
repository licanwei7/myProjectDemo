package com.lcw.exerciseback.mapper.students;

import com.lcw.exerciseback.domain.entity.MessageEntity;
import com.lcw.exerciseback.domain.query.MessageQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/2/19 18:07
 */
@Mapper
public interface MessageMapper {
    //根据（学生ID）查询所有的该学生消息（时间倒序）
    List<MessageQuery> queryAllMessage(String studentID);
}
