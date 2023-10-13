package com.lcw.exerciseback.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @Author Licanwei
 * @Description:论坛文章实体类
 * @Date 2022/2/20 15:31
 */
@Data
public class ForumEntity {
    /**
     *论坛文章ID
     */
    private int forumID;

    /**
     *论坛文章题名
     */
    private String forumName;

    /**
     *论坛文章内容
     */
    private String forumContent;

    /**
     *论坛文章配图
     */
    private String forumFigureCaptions;

    /**
     *论坛文章附带图片
     */
    private String forumPicture;

    /**
     *论坛文章点赞数
     */
    private int forumLikeNumber;

    /**
     *论坛文章阅读数
     */
    private int forumReadNumber;

    /**
     *论坛文章发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime forumTime;

    /**
     * 教师名
     */
    private String teacherName;
}
