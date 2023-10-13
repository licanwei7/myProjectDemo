package com.lcw.exerciseback.service.students.impl;

import com.github.pagehelper.PageHelper;
import com.lcw.exerciseback.api.PageVo;
import com.lcw.exerciseback.domain.dpo.QueryQuestionsByTandD;
import com.lcw.exerciseback.domain.entity.QuestionsDifficultyEntity;
import com.lcw.exerciseback.domain.entity.QuestionsTypesEntity;
import com.lcw.exerciseback.domain.query.ShowPartChoiceQuestionQuery;
import com.lcw.exerciseback.domain.query.TopicItemQuery;
import com.lcw.exerciseback.mapper.students.BrushQuestionMapper;
import com.lcw.exerciseback.service.students.BrushQuestionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/2/19 18:12
 */
@Service
public class BrushQuestionServiceImpl implements BrushQuestionService {
    @Autowired
    private BrushQuestionMapper brushQuestionMapper;

    @Override
    public List<ShowPartChoiceQuestionQuery> queryPartChoiceQuestionPage(PageVo pageVo){//pageNum：当前页 pageSize：当前页展示数目
        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
        List<ShowPartChoiceQuestionQuery> list=brushQuestionMapper.queryPartChoiceQuestion();
        return list;
    }

    @Override
    public List<QuestionsTypesEntity> queryAllQuestionsTypes() {
        List<QuestionsTypesEntity> list=brushQuestionMapper.queryAllQuestionsTypes();
        return list;
    }

    @Override
    public List<QuestionsDifficultyEntity> queryAllQuestionsDifficulty() {
        List<QuestionsDifficultyEntity> list=brushQuestionMapper.queryAllQuestionsDifficulty();
        return list;
    }

    @Override
    public List<ShowPartChoiceQuestionQuery> queryPartChoiceQuestionByquestionsTypesOrDifficultyID(QueryQuestionsByTandD queryQuestionsByTandD,
                                                                                                   PageVo pageVo) {
        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());

        List<ShowPartChoiceQuestionQuery> list=brushQuestionMapper.queryPartChoiceQuestionByquestionsTypesOrDifficultyID(queryQuestionsByTandD);
        return list;
    }

    @Override
    public List<ShowPartChoiceQuestionQuery> queryPartChoiceQuestionByKeyWordPage(@Param("keyWord") String keyWord, PageVo pageVo) {
        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
        List<ShowPartChoiceQuestionQuery> list=brushQuestionMapper.queryPartChoiceQuestionByKeyWord(keyWord);
        return list;
    }

    @Override
    public List<TopicItemQuery> queryThisTopic(Integer topicID) {
        return brushQuestionMapper.queryThisTopic(topicID);
    }
}
