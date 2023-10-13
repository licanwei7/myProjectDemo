package com.lcw.exerciseback.service.root.Impl;

import com.lcw.exerciseback.domain.query.MangeStuQuery;
import com.lcw.exerciseback.domain.query.MangeTeaQuery;
import com.lcw.exerciseback.mapper.root.ManageMapper;
import com.lcw.exerciseback.service.root.ManageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/4/22 15:22
 */
@Service
public class ManageServiceImpl implements ManageService {
    @Autowired
    private ManageMapper manageMapper;

    @Override
    public List<MangeStuQuery> queryAllStu() {
        return manageMapper.queryAllStu();
    }

    @Override
    public List<MangeTeaQuery> queryAllTea() {
        return manageMapper.queryAllTea();
    }

    @Override
    public boolean verAdmin(String systemID, String systemPwd) {
       //根据账号密码查询数据库是否存在该条数据
        if (manageMapper.queryAdmin(systemID,systemPwd).size()>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<MangeStuQuery> queryStuByInfo(@Param("info")String info) {
        return manageMapper.queryStuByInfo(info);
    }

    @Override
    public List<MangeStuQuery> queryStuByTea(String teaName) {
        return manageMapper.queryStuByTea(teaName);
    }

    @Override
    public boolean deleteStu(String studentID) {
       if (manageMapper.deleteStu(studentID)>0){
           return true;
       }else {
           return false;
       }
    }
}
