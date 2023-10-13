package com.lcw.exerciseback.domain.dpo;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description:根据（题目类型ID和题目难度ID）查询题目
 * @Date 2022/2/21 12:15
 */
@Data
public class QueryQuestionsByTandD {
    /**
     *题目难度ID
     */
    private int questionsDifficultyID;

    /**
     *题目类型ID
     */
    private int questionsTypesID;
}
