package com.lcw.exerciseback.controller.teachers;

import com.lcw.exerciseback.api.ResultDto;
import com.lcw.exerciseback.mapper.students.AdminMapper;
import com.lcw.exerciseback.mapper.teachers.AdminTeaMapper;
import com.lcw.exerciseback.service.students.AdminService;
import com.lcw.exerciseback.service.teachers.AdminTeaService;
import com.lcw.exerciseback.utils.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @Author Licanwei
 * @Description: 管理控制层  用于学生和教师的登陆  登出
 * @Date 2022/4/8 14:15
 */
@RestController
@CrossOrigin
@RequestMapping("/teachers/admin")
public class AdminTeaController {
    @Autowired
    private AdminTeaService adminTeaService;
    @Autowired
    private AdminTeaMapper adminTeaMapper;

    //验证学生账号密码正确性
    @RequestMapping("/verifyTea")
    public ResultDto verifyTea(@Param("teacherID")String teacherID,
                               @Param("teacherPwd")String teacherPwd){

        //非空处理
        if (teacherID==""||teacherPwd==""||teacherID==null||teacherPwd==null){
            return ResultDto.fail("请在规定位置填写账号信息",2);
        }

        if (adminTeaService.verifyTea(teacherID,teacherPwd)){
            return ResultDto.success("信息验证通过！",1);
        }else {
            return ResultDto.fail("账号或密码错误，请重新输入！",2);
        }
    }

    @RequestMapping("/showAdminHp")
    public void showAdminHp(@Param("teacherID") String teacherID,HttpServletResponse response) {
        System.out.println("前端传递过来的学生ID是："+teacherID);
        //根据用户ID查询该用户头像
        String hp = adminTeaMapper.queryTeadentHeadP(teacherID);
        if(hp==null||"".equals(hp)){
            System.out.println("教师头像没查到，直接返回即可");
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
}
