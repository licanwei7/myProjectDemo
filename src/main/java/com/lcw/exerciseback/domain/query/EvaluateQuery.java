package com.lcw.exerciseback.domain.query;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/2/22 13:48
 */
@Data
public class EvaluateQuery {
    /**
     * 测试ID
     */
    private int testsID;

    /**
     *教师名
     */
    private String teacherName;

    /**
     *测试名
     */
    private String testsName;

    /**
     *测试类型名
     */
    private String testTypesName;

    /**
     *测试限制时间
     */
    private int testsMaxTime;

    /**
     *测试封面图片
     */
    private String testsCover;
}
