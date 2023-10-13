package com.lcw.exerciseback.controller.students;

import com.lcw.exerciseback.api.PageVo;
import com.lcw.exerciseback.api.ResultDto;
import com.lcw.exerciseback.domain.dpo.QueryQuestionsByTandD;
import com.lcw.exerciseback.domain.entity.QuestionsDifficultyEntity;
import com.lcw.exerciseback.domain.entity.QuestionsTypesEntity;
import com.lcw.exerciseback.domain.query.ShowPartChoiceQuestionQuery;
import com.lcw.exerciseback.domain.query.TopicItemQuery;
import com.lcw.exerciseback.service.students.BrushQuestionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Licanwei
 * @Description:刷题界面-控制层
 * @Date 2022/2/19 15:18
 */
@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/students/brush")
public class BrushQuestionController {

    @Autowired
    private BrushQuestionService brushQuestionService;

    //展示选题题部分信息（分页）（按ID升序）
    @RequestMapping("/showPartChoiceQuestionsPage")
    public ResultDto showPartChoiceQuestionsPage(PageVo pageVo){
        List<ShowPartChoiceQuestionQuery> partChoiceQuestions=brushQuestionService.queryPartChoiceQuestionPage(pageVo);
        return ResultDto.success("查询成功！",partChoiceQuestions);
    }
    //展示所有题目类型（按ID升序）
    @RequestMapping("/showAllQuestionsTypes")
    public ResultDto showAllQuestionsTypes(){
        List<QuestionsTypesEntity> questionsTypes=brushQuestionService.queryAllQuestionsTypes();
        return ResultDto.success("查询成功！",questionsTypes);
    }
    //展示所有题目难度（按ID升序）
    @RequestMapping("/showAllQuestionsDifficulty")
    public ResultDto showAllQuestionsDifficulty(){
        List<QuestionsDifficultyEntity> questionsDifficulty=brushQuestionService.queryAllQuestionsDifficulty();
        return ResultDto.success("查询成功！",questionsDifficulty);
    }
    //根据（题目类型ID或者题目难度ID）展示选题题部分信息（分页）（按ID升序）
    @RequestMapping("/showPartChoiceQuestionsPageByquestionsTypesOrDifficultyID")
    public ResultDto showPartChoiceQuestionsPageByquestionsTypesOrDifficultyID(QueryQuestionsByTandD queryQuestionsByTandD,
                                                                               PageVo pageVo){
        List<ShowPartChoiceQuestionQuery> partChoiceQuestions=brushQuestionService.queryPartChoiceQuestionByquestionsTypesOrDifficultyID(queryQuestionsByTandD,pageVo);
        return ResultDto.success("查询成功！",partChoiceQuestions);
    }
    //根据题目名字关键字搜索展示题库（分页）（按ID升序）
    @RequestMapping("/showPartChoiceQuestionsPageByKeyWord")
    public ResultDto showPartChoiceQuestionsPageByKeyWord(@Param("keyWord")String keyWord,
                                                          PageVo pageVo){
        List<ShowPartChoiceQuestionQuery> partChoiceQuestions=brushQuestionService.queryPartChoiceQuestionByKeyWordPage(keyWord,pageVo);
        return ResultDto.success("查询成功！",partChoiceQuestions);
    }

    //根据题目ID查询该题目所有信息
    @RequestMapping("/showThisTopic")
    public ResultDto showThisTopic(Integer topicID){
        System.out.println(topicID);
        List<TopicItemQuery> list =brushQuestionService.queryThisTopic(topicID);
        return ResultDto.success("请求成功！",list);
    }


    //展示图片测试
    @RequestMapping("/viewImg")
    public void viewUserImg(@Param("pathname") String pathname,HttpServletResponse response) {
        System.out.println(pathname);
        //根据用户Id查询用户信息
        //User user = userService.viewImg(userId, response);
        try {
            //根据用户的图片路径，创建文件
            //File file = new File(user.getImgUrl());
            String path=pathname.replace("\\","\\\\");
            System.out.println(path);

            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
            long size = file.length();
            byte[] temp = new byte[(int) size];
            fileInputStream.read(temp, 0, (int) size);
            fileInputStream.close();
            byte[] data = temp;
            response.setContentType("image/png");
            OutputStream os = response.getOutputStream();
            os.write(data);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
