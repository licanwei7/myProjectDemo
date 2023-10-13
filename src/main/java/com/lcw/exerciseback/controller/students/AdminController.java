package com.lcw.exerciseback.controller.students;

import com.lcw.exerciseback.api.ResultDto;
import com.lcw.exerciseback.domain.entity.StudentEntity;
import com.lcw.exerciseback.mapper.students.AdminMapper;
import com.lcw.exerciseback.service.students.AdminService;
import com.lcw.exerciseback.utils.EmailUtils;
import com.lcw.exerciseback.utils.FileUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.Random;

/**
 * @Author Licanwei
 * @Description: 管理控制层  用于学生和教师的登陆  登出
 * @Date 2022/4/8 14:15
 */
@RestController
@CrossOrigin
@RequestMapping("/students/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminMapper adminMapper;

    //验证学生账号密码正确性
    @RequestMapping("/verifyStu")
    public ResultDto verifyStu(@Param("studentID")String studentID,
                               @Param("studentPwd")String studentPwd){

        //非空处理
        if (studentID==""||studentPwd==""||studentID==null||studentPwd==null){
            return ResultDto.fail("请在规定位置填写账号信息",2);
        }

        if (adminService.verifyStu(studentID,studentPwd)){
            return ResultDto.success("信息验证通过！",1);
        }else {
            return ResultDto.fail("账号或密码错误，请重新输入！",2);
        }
    }

    //拿到用户头像
    @RequestMapping("/showAdminHp")
    public void viewUserImg(@Param("studentID") String studentID,HttpServletResponse response) {
        System.out.println("前端传递过来的学生ID是："+studentID);
        //根据用户ID查询该用户头像
        String hp = adminMapper.queryStudentHeadP(studentID);
        System.out.println(hp);
        if(hp==null||"".equals(hp)){
            System.out.println("学生头像没查到，直接返回即可");
            return;
        }
        try {
            File file = new File(hp.replace("\\","\\\\"));

            //判断路径文件是否存在
            if (!file.exists()){
                System.out.println("该路径不存在文件图片");
                return;
            }
            FileUtils.transFile_Flow(file,response);//封装的工具类，将文件转成流
        } catch (Exception e) {
            System.out.println("相关图片未能找到");
            e.printStackTrace();

        }
    }

    //根据邮箱获取验证码
    @RequestMapping("/sendVerCode")
    public ResultDto sendVerCode(@Param("stuEmail") String stuEmail) {
        StringBuffer sbCode = new StringBuffer();
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int txt = r.nextInt(10);
            String str = String.valueOf(txt);
            sbCode.append(str);
        }
        //拼接邮件内容
        String msg = "验证码为：" + sbCode.toString() + ",30分钟内有效";
        boolean flag = EmailUtils.sendMail(stuEmail, msg);
        if (flag) {
            return ResultDto.success("发送成功！","1000");
        } else {
            return ResultDto.fail("发送失败！",0);
        }
    }

    //查询账号、邮箱是否可用
    @RequestMapping("/verIDisExist")
    public ResultDto verIDisExist(@Param("studentID")String studentID) {
        int len1 = adminMapper.verIDisExist(studentID).size();
        if (len1<1){
            return ResultDto.success("账号可用!",1);
        }else {
            return ResultDto.success("账号不可用!",0);
        }
    }


    //用户注册信息
    @RequestMapping("/registerStu")
    public ResultDto registerStu(@Param("studentID")String studentID,
                                 @Param("studentPwd")String studentPwd,
                                 @Param("studentEmail")String studentEmail,
                                 @Param("studentSex") String studentSex,
                                 @Param("studentName")String studentName,
                                 @Param("teacherID") String teacherID) {
        StudentEntity stu = new StudentEntity();
        stu.setStudentID(studentID);
        stu.setStudentPwd(studentPwd);
        stu.setStudentName(studentName);
        stu.setStudentEmail(studentEmail);
        stu.setTeacherID(teacherID);
        stu.setStudentSex(studentSex);
        System.out.println(stu);

        if (adminMapper.addStuAdmin(stu)>=1){
            return ResultDto.success("注册成功",1);
        }else {
            return ResultDto.fail("注册失败",0);
        }
    }

    //查询所有教师
    @RequestMapping("/showAllTea")
    public ResultDto showAllTea() {
        return ResultDto.success("获取成功！",adminMapper.queryAllTea());
    }
}
