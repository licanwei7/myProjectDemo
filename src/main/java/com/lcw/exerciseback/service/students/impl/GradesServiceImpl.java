package com.lcw.exerciseback.service.students.impl;

import com.github.pagehelper.PageHelper;
import com.lcw.exerciseback.api.PageVo;
import com.lcw.exerciseback.domain.dpo.QueryGradesBySandK;
import com.lcw.exerciseback.domain.dpo.QueryGradesBySandT;
import com.lcw.exerciseback.domain.dto.TestAndStu;
import com.lcw.exerciseback.domain.entity.TestTypes;
import com.lcw.exerciseback.domain.query.GradesQuery;
import com.lcw.exerciseback.mapper.students.GradesMapper;
import com.lcw.exerciseback.service.students.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/2/19 18:15
 */
@Service
public class GradesServiceImpl implements GradesService {
    @Autowired
    private GradesMapper gradesMapper;

    @Override
    public List<GradesQuery> queryAllGradesByStudentIDPage(String studentID, PageVo pageVo) {
        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
        List<GradesQuery> list=gradesMapper.queryAllGradesByStudentID(studentID);
        return list;
    }

    @Override
    public List<GradesQuery> queryAllGradesBySIDandTIDPage(QueryGradesBySandT queryGradesBySandT, PageVo pageVo) {
        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
        List<GradesQuery> list=gradesMapper.queryAllGradesBySIDandTID(queryGradesBySandT);
        return list;
    }

    @Override
    public List<GradesQuery> queryAllGradesByKeyWordPage(QueryGradesBySandK queryGradesBySandK,PageVo pageVo) {
        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
        List<GradesQuery> list=gradesMapper.queryAllGradesByKeyWord(queryGradesBySandK);
        return list;
    }

    @Override
    public boolean transHB(TestAndStu testAndStu) {
        //先查询该测试 该学生有没有申请次数
        int rhbNum = gradesMapper.queryRhbNum(testAndStu);
        if (rhbNum<1){
            return false;
        }

        int isOK = gradesMapper.transHB(testAndStu);
        if (isOK>=1){
            //将rhbNum减一
            TestAndStu testAndStu1 = new TestAndStu();
            testAndStu1.setTestID(testAndStu.getTestID());
            testAndStu1.setStudentID(testAndStu.getStudentID());
            testAndStu1.setRhbNum(rhbNum-1);
            gradesMapper.updateRhbNum(testAndStu1);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<TestTypes> queryAllTestsTypes() {
        return gradesMapper.queryAllTestsTypes();
    }
}
