package com.lcw.exerciseback.service.students.impl;

import com.lcw.exerciseback.domain.query.MessageQuery;
import com.lcw.exerciseback.mapper.students.MessageMapper;
import com.lcw.exerciseback.service.students.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/2/19 18:16
 */

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<MessageQuery> queryAllMessage(String studentID) {
        List<MessageQuery> list=messageMapper.queryAllMessage(studentID);
        return list;
    }
}
