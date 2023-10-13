package com.lcw.exerciseback.domain.dpo;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description: 学生ID和测试ID
 * @Date 2022/4/27 15:22
 */
@Data
public class EvaluateOperation {
    /**
     * 学生ID
     */
    private String studentID;

    /**
     * 测试ID
     */
    private Integer testID;

    /**
     * 单选题集合字符串形式
     */
    private String radioAnswers;
}
