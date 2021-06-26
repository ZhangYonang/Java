package com.qtc.sms.service.administrator;

import com.qtc.sms.dao.AdministratorDao;
import com.qtc.sms.dao.administrator.AdministratorImpl;
import com.qtc.sms.service.AdministratorService;
import com.qtc.sms.view.administratorsview.LoginViewAdministratorsView;
import com.qtc.sms.vo.Administrators;
import com.qtc.sms.vo.Teachers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministratorServiceImpl implements AdministratorService {
    int Check;
    AdministratorDao administratorDao = new AdministratorImpl();
    //添加老师结果
    @Override
    public void AddTeacher(Teachers teacher) {
        int Check = administratorDao.AddTeacher(teacher);
        if(Check > 0){
            System.out.println("添加成功......");
        }else {
            System.out.println("添加失败");
        }
    }
    //输出老师信息
    @Override
    public int ShowTeacher(String TeacherName) {
        ResultSet rs = administratorDao.ShowTeacher(TeacherName);
        if (rs == null) {
            System.out.println("没有此老师...");
        } else {
            try {
                while (rs.next()) {
                    int Id = rs.getInt("TeacherId");
                    String Name = rs.getNString("TeacherName");
                    String Password = rs.getNString("TeacherPassword");
                    System.out.println("ID:" + Id + "\n姓名:" + Name + "\n密码:" + Password);
                    return 1;
                }
            } catch (SQLException Err) {
                System.out.println(Err);
                return 0;
            }
        }
        return 0;
    }
    //修改老师信息并返回结果
    @Override
    public int UpdateTeacher(String TeacherName,Teachers teacher) {
        Check = administratorDao.UpdateTeacher(TeacherName,teacher);
        if(Check!=0){
            System.out.println("修改成功...");
            return 1;
        }else {
            System.out.println("修改失败...");
            return 0;
        }
    }
    //删除老师信息
    @Override
    public void DateTeacher(Teachers teacher) {
        Check = administratorDao.DateTeacher(teacher);
        if (Check>0){
            System.out.println("删除成功......");
        }else {
            System.out.println("删除失败......");
        }
    }
    //查询管理员信息
    @Override
    public void ShowAdministrator(String AdministratorName) {
        ResultSet rs = administratorDao.ShowAdministrator(AdministratorName);
        if (rs == null) {
            System.out.println("没有此学生...");
        } else {
            try {
                while (rs.next()) {
                    int Id = rs.getInt("AdministratorId");
                    String Name = rs.getNString("AdministratorName");
                    String Password = rs.getNString("AdministratorPassword");
                    System.out.println("ID:" + Id + "\n姓名:" + Name + "\n密码:" + Password);
                }
            } catch (SQLException Err) {
                System.out.println(Err);
            }
        }
    }
    //修改管理员信息
    @Override
    public void UpdateAdministrator(String AdministratorName, Administrators administrator) {
        Check = administratorDao.UpdateAdministrator(AdministratorName,administrator);
        if(Check>0){
            System.out.println("修改成功请重新登录......");
            LoginViewAdministratorsView loginViewAdministratorsView = new LoginViewAdministratorsView();
            loginViewAdministratorsView.AdministratorLoginMenu();
        }
    }

}
