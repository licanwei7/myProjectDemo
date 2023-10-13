package com.lcw.exerciseback.controller.students;

import com.lcw.exerciseback.api.ResultDto;
import com.lcw.exerciseback.domain.query.MessageQuery;
import com.lcw.exerciseback.service.students.MessageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:消息界面-控制层
 * @Date 2022/2/19 15:21
 */
@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/students/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    //根据（学生ID）展示该学生所有消息（时间倒序）
    @RequestMapping("/showMessageByStudentID")
    public ResultDto showMessageByStudentID(@Param("studentID")String studentID){
        if (studentID==null || studentID==""){
            return ResultDto.fail("查询失败，缺少学生ID");
        }
        List<MessageQuery> allMessages= messageService.queryAllMessage(studentID);
        return ResultDto.success("查询成功！",allMessages);
    }
}
