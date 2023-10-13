package com.lcw.exerciseback.mapper.students;

import com.lcw.exerciseback.domain.dpo.QueryGradesBySandK;
import com.lcw.exerciseback.domain.dpo.QueryGradesBySandT;
import com.lcw.exerciseback.domain.dto.TestAndStu;
import com.lcw.exerciseback.domain.entity.GradesEntity;
import com.lcw.exerciseback.domain.entity.TestTypes;
import com.lcw.exerciseback.domain.query.GradesQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/2/19 18:08
 */
@Mapper
public interface GradesMapper {
    //根据学生ID查询该学生所有成绩（时间倒序）
    List<GradesQuery> queryAllGradesByStudentID(@Param("studentID")String studentID);
    //根据（学生ID、测试类型ID）进行查询成绩库（时间倒序）
    List<GradesQuery> queryAllGradesBySIDandTID(QueryGradesBySandT queryGradesBySandT);
    //根据（学生ID、测试名关键字）进行模糊查询（时间倒序）
    List<GradesQuery> queryAllGradesByKeyWord(QueryGradesBySandK queryGradesBySandK);
    //根据学生ID和测试ID将isHeavyBatching属性从0->1
    int transHB(TestAndStu testAndStu);
    //查询所有测试类型
    List<TestTypes> queryAllTestsTypes();
    //先查询该测试 该学生有没有申请次数
    int queryRhbNum(TestAndStu testAndStu);
    //更改rhb次数
    int updateRhbNum(TestAndStu testAndStu);
}
