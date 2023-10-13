package com.lcw.exerciseback.service.students;

import com.lcw.exerciseback.domain.entity.MessageEntity;
import com.lcw.exerciseback.domain.query.MessageQuery;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/2/19 18:10
 */
public interface MessageService {
    //根据（学生ID）查询所有的该学生消息（时间倒序）
    List<MessageQuery> queryAllMessage(String studentID);
}
