package com.lcw.exerciseback.domain.dpo;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description:根据（学生ID、测试类型ID）查询学生所有成绩
 * @Date 2022/2/22 16:50
 */
@Data
public class QueryGradesBySandT {
    /**
     * 学生ID
     */
    private String studentID;

    /**
     * 测试类型ID
     */
    private Integer testTypesID;
}
