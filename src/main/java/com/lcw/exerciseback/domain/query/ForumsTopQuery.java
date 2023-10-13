package com.lcw.exerciseback.domain.query;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description:论坛排行榜-查询类
 * @Date 2022/2/20 17:03
 */
@Data
public class ForumsTopQuery {
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
     *论坛文章阅读数
     */
    private int forumReadNumber;
}
