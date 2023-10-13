package com.lcw.exerciseback.domain.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lcw.exerciseback.domain.entity.ChoiceQuestionsEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Licanwei
 * @Description: 测试试卷所包含内容
 * @Date 2022/4/25 23:37
 */
@Data
public class TestQuery {
    /**
     *测试ID
     */
    private Integer testID;

    /**
     *教师姓名
     */
    private String teacherName;

    /**
     *测试名
     */
    private String testName;

    /**
     *测试类型
     */
    private String testTypesName;

    /**
     *测试难度
     */
    private String testLevelsName;

    /**
     *测试规定完成最大时间限（单位是分钟）
     */
    private Integer testsMaxTime;

    /**
     *创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     *单选题集合
     */
    private List<ChoiceQuestionsEntity> radios;



}
