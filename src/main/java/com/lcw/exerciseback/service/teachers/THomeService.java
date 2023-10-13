package com.lcw.exerciseback.service.teachers;

import com.lcw.exerciseback.domain.query.TopicsQuery;

import java.util.List;
import java.util.Map;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/21 22:33
 */
public interface THomeService {
    //根据教师ID查询教师首页展示信息
    Map<String, List> queryHomeInfo(String teacherID);
}
