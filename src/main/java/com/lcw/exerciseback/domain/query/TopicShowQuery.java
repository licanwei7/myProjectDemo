package com.lcw.exerciseback.domain.query;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/5/1 18:18
 */
@Data
public class TopicShowQuery {
    /**
     * 单选题ID
     */
    Integer choiceQuestionsID;

    /**
     * 单选题名字
     */
    String choiceQuestionName;
}
