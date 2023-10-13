package com.lcw.exerciseback.domain.query;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description: 测试类型ID和教师ID和关键字
 * @Date 2022/4/29 12:07
 */
@Data
public class TypeAndTeaQuery {
    /**
     *教师ID
     */
    private String teacherID;
    /**
     *测试类型ID
     */
    private Integer typeID;
    /**
     * 测试名关键字
     */
    private String keyWord;
}
