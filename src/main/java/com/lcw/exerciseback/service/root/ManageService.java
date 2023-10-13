package com.lcw.exerciseback.service.root;

import com.lcw.exerciseback.domain.query.MangeStuQuery;
import com.lcw.exerciseback.domain.query.MangeTeaQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/22 15:21
 */
public interface ManageService {
    //展示全部学生
    List<MangeStuQuery> queryAllStu();
    //展示全部教师
    List<MangeTeaQuery> queryAllTea();
    //验证密码正确性
    boolean verAdmin(@Param("systemID")String systemID,@Param("systemPwd")String systemPwd);
    //根据学生账号或者学生姓名查询
    List<MangeStuQuery> queryStuByInfo(@Param("info")String info);
    //根据教师姓名拆线呢学生
    List<MangeStuQuery> queryStuByTea(@Param("teaName")String teaName);
    //删除学生
    boolean deleteStu(@Param("studentID")String studentID);
}
