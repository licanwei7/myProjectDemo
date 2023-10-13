package com.lcw.exerciseback.service.students;

import com.lcw.exerciseback.api.PageVo;
import com.lcw.exerciseback.domain.dpo.QueryGradesBySandK;
import com.lcw.exerciseback.domain.dpo.QueryGradesBySandT;
import com.lcw.exerciseback.domain.dto.TestAndStu;
import com.lcw.exerciseback.domain.entity.GradesEntity;
import com.lcw.exerciseback.domain.entity.TestTypes;
import com.lcw.exerciseback.domain.query.GradesQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/2/19 18:09
 */
public interface GradesService {
    //根据学生ID查询该学生所有成绩（分页）（按时间倒序）
    List<GradesQuery> queryAllGradesByStudentIDPage(@Param("studentID")String studentID,
                                                    PageVo pageVo);
    //根据（学生ID、测试类型ID）进行查询成绩库（分页）（时间倒序）
    List<GradesQuery> queryAllGradesBySIDandTIDPage(QueryGradesBySandT queryGradesBySandT,
                                                 PageVo pageVo);
    //根据（学生ID、测试名关键字）进行模糊查询（时间倒序）
    List<GradesQuery> queryAllGradesByKeyWordPage(QueryGradesBySandK queryGradesBySandK,
                                                   PageVo pageVo);
    //根据学生ID和测试ID将isHeavyBatching属性从0->1
    boolean transHB(TestAndStu testAndStu);
    //查询所有测试类型
    List<TestTypes> queryAllTestsTypes();
}
