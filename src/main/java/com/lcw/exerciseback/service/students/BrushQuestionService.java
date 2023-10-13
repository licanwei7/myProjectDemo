package com.lcw.exerciseback.service.students;

import com.lcw.exerciseback.api.PageVo;
import com.lcw.exerciseback.domain.dpo.QueryQuestionsByTandD;
import com.lcw.exerciseback.domain.entity.QuestionsDifficultyEntity;
import com.lcw.exerciseback.domain.entity.QuestionsTypesEntity;
import com.lcw.exerciseback.domain.query.ShowPartChoiceQuestionQuery;
import com.lcw.exerciseback.domain.query.TopicItemQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/2/19 18:10
 */
public interface BrushQuestionService {
    //查询所有选择题部分展示信息(分页)（按ID升序）
    List<ShowPartChoiceQuestionQuery> queryPartChoiceQuestionPage(PageVo pageVo);
    //查询所有题目类型（按ID升序）
    List<QuestionsTypesEntity> queryAllQuestionsTypes();
    //查询所有题目难度（按ID升序）
    List<QuestionsDifficultyEntity> queryAllQuestionsDifficulty();
    //根据（题目类型ID或者题目难度ID）查询所有对应题目部分信息（按照ID升序）
    List<ShowPartChoiceQuestionQuery> queryPartChoiceQuestionByquestionsTypesOrDifficultyID(QueryQuestionsByTandD queryQuestionsByTandD,
                                                                                            PageVo pageVo);
    //根据题目名字关键字对题库进行模糊查询（分页）（按ID升序）
    List<ShowPartChoiceQuestionQuery> queryPartChoiceQuestionByKeyWordPage(@Param("keyWord")String keyWord,
                                                                           PageVo pageVo);
    //根据题目ID查询该题目所有信息
    List<TopicItemQuery> queryThisTopic(Integer topicID);
}
