package com.lcw.exerciseback.domain.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/23 17:13
 */
@Data
public class TestsQuery {
    /**
     * 测试ID
     */
    private int testsID;

    /**
     * 测试名
     */
    private String testsName;

    /**
     * 测试类型
     */
    private String testTypesName;

    /**
     * 测试难度
     */
    private String testLevelsName;

    /**
     * 测试难度
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 创建时间
     */
    private int testsMaxTime;

    /**
     * 教师
     */
    private String teacherName;
}
