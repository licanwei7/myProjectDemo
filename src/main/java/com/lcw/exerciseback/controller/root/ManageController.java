package com.lcw.exerciseback.controller.root;

import com.lcw.exerciseback.api.PageVo;
import com.lcw.exerciseback.api.ResultDto;
import com.lcw.exerciseback.domain.entity.StudentEntity;
import com.lcw.exerciseback.domain.entity.TeacherEntity;
import com.lcw.exerciseback.domain.query.ShowPartChoiceQuestionQuery;
import com.lcw.exerciseback.mapper.root.ManageMapper;
import com.lcw.exerciseback.service.root.ManageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/22 15:16
 */
@CrossOrigin
@RestController
@RequestMapping("/root/manage")
public class ManageController {
    @Autowired
    private ManageService manageService;
    @Autowired
    private ManageMapper manageMapper;

    //展示全部学生
    @RequestMapping("/showAllStu")
    public ResultDto showAllStu(){
        return ResultDto.success("查询成功！",manageService.queryAllStu());
    }
    //展示全部教师
    @RequestMapping("/showAllTea")
    public ResultDto showAllTea(){
        return ResultDto.success("查询成功！",manageService.queryAllTea());
    }
    //验证账号密码正确性
    @RequestMapping("/verAdmin")
    public ResultDto verAdmin(@Param("systemID")String systemID, @Param("systemPwd")String systemPwd){
        boolean isVerAdmin = manageService.verAdmin(systemID,systemPwd);
        if(isVerAdmin){
            return ResultDto.success("验证通过！",1);
        }else {
            return ResultDto.fail("验证失败！",0);
        }

    }
    //根据学生账号或者学生姓名模糊查询
    @RequestMapping("/showStuByInfo")
    public ResultDto showStuByInfo(@Param("info")String info){
        return ResultDto.success("查询成功！",manageService.queryStuByInfo(info));
    }
    //根据教师姓名进行查询学生信息
    @RequestMapping("/showStuByTea")
    public ResultDto showStuByTea(@Param("teaName")String teaName){
        return ResultDto.success("查询成功！",manageService.queryStuByTea(teaName));
    }
    //添加学生账号
    @RequestMapping("/addStu")
    public ResultDto addStu(@Param("stuName")String stuName,
                                  @Param("account")String account,
                                  @Param("passWord")String passWord,
                                  @Param("sex")String sex,
                                  @Param("email")String email,
                                  @Param("chooseTea")String chooseTea){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentName(stuName);
        studentEntity.setStudentID(account);
        studentEntity.setStudentPwd(passWord);
        studentEntity.setStudentSex(sex);
        studentEntity.setStudentEmail(email);
        studentEntity.setTeacherID(chooseTea);
        System.out.println(studentEntity);
        if (manageMapper.addStu(studentEntity)>0){
            return ResultDto.success("添加成功！",1);
        }else {
            return ResultDto.fail("添加失败！",0);
        }
    }
    //根据学生ID删除学生
    @RequestMapping("/deleteStu")
    public ResultDto deleteStu(@Param("studentID")String studentID){
        System.out.println(studentID);
        return ResultDto.success("删除成功！",manageService.deleteStu(studentID));
    }
    //根据ID进行学生信息查询
    @RequestMapping("/showStuByID")
    public ResultDto showStuByID(@Param("studentID")String studentID){
        return ResultDto.success("查询成功！",manageMapper.queryStuByID(studentID));
    }
    //根据ID进行学生信息修改
    @RequestMapping("/updateStu")
    public ResultDto updateStu(@Param("stuName")String stuName,
                               @Param("account")String account,
                               @Param("passWord")String passWord,
                               @Param("sex")String sex,
                               @Param("email")String email,
                               @Param("chooseTea")String chooseTea){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentName(stuName);
        studentEntity.setStudentPwd(passWord);
        studentEntity.setStudentSex(sex);
        studentEntity.setStudentEmail(email);
        studentEntity.setTeacherID(chooseTea);
        studentEntity.setStudentID(account);
        return ResultDto.success("更改成功！",manageMapper.updateStu(studentEntity));
    }


    //根据教师名字或者账号关键字模糊查询教师
    @RequestMapping("/showTeaByInfo")
    public ResultDto showTeaByInfo(@Param("info")String info){
        return ResultDto.success("查询成功！",manageMapper.queryTeaByInfo(info));
    }
    //新建教师
    @RequestMapping("/addTea")
    public ResultDto addTea(@Param("teacherName")String teacherName,
                            @Param("teacherID")String teacherID,
                            @Param("teacherPwd")String teacherPwd,
                            @Param("teacherSex")String teacherSex,
                            @Param("teacherEmail")String teacherEmail,
                            @Param("mangeClass")String mangeClass ){
        TeacherEntity entity = new TeacherEntity();
        entity.setTeacherName(teacherName);
        entity.setTeacherID(teacherID);
        entity.setTeacherPwd(teacherPwd);
        entity.setTeacherSex(teacherSex);
        entity.setTeacherEmail(teacherEmail);
        entity.setMangeClass(mangeClass);
        System.out.println(entity);
        return ResultDto.success("新增成功！",manageMapper.addTea(entity));
    }

    //根据教师ID查看指定教师信息
    @RequestMapping("/showTeaByID")
    public ResultDto showTeaByID(@Param("teacherID")String teacherID){
        System.out.println(teacherID);
        return ResultDto.success("查询成功！",manageMapper.queryTeaByID(teacherID));
    }

    //根据教师ID更改教师信息
    @RequestMapping("/updateTea")
    public ResultDto updateTea(@Param("teacherName")String teacherName,
                               @Param("teacherID")String teacherID,
                               @Param("teacherPwd")String teacherPwd,
                               @Param("teacherSex")String teacherSex,
                               @Param("teacherEmail")String teacherEmail,
                               @Param("mangeClass")String mangeClass ){
        TeacherEntity entity = new TeacherEntity();
        entity.setTeacherName(teacherName);
        entity.setTeacherID(teacherID);
        entity.setTeacherPwd(teacherPwd);
        entity.setTeacherSex(teacherSex);
        entity.setTeacherEmail(teacherEmail);
        entity.setMangeClass(mangeClass);
        System.out.println(entity);
        return ResultDto.success("修改成功！",manageMapper.updateTea(entity));
    }

    //根据教师ID删除指定教师
    @RequestMapping("/deleteTea")
    public ResultDto deleteTea(@Param("teacherID")String teacherID){
        return ResultDto.success("删除成功！！",manageMapper.deleteTeaByID(teacherID));
    }
}
