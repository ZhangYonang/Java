package com.qtc.sms.dao.administrator;

import com.qtc.sms.dao.AdministratorDao;
import com.qtc.sms.util.JdbcUtil;
import com.qtc.sms.vo.Administrators;
import com.qtc.sms.vo.Teachers;

import java.sql.ResultSet;

public class AdministratorImpl implements AdministratorDao {
    //添加老师并返回添加结果
    @Override
    public int AddTeacher(Teachers teacher) {
        String sql = "insert into teachers (TeacherName,TeacherPassword) values(?,?)";
        Object[] params = {
                teacher.getTeachersName(),
                teacher.getTeachersPassword()
        };
        int check = JdbcUtil.executeUpdate(sql, params);
        return check;
    }
    //查找老师返回指针
    @Override
    public ResultSet ShowTeacher(String TeacherName) {
        String sql = "select * from teachers where TeacherName = ?;";
        Object[] params = {
                TeacherName
        };
        ResultSet rs = JdbcUtil.executeQuery(sql,params);
        return rs;
    }
    //修改老师并返回结果
    @Override
    public int UpdateTeacher(String TeacherName,Teachers teacher) {
        String sql = "UPDATE teachers SET TeacherName = ?,TeacherPassword = ? WHERE TeacherName = ?;";
        Object[] params = {
                teacher.getTeachersName(),teacher.getTeachersPassword(),TeacherName
        };
        int check = JdbcUtil.executeUpdate(sql,params);
        return check;
    }
    //删除老师
    @Override
    public int DateTeacher(Teachers teachers) {
        String sql = "delete from teachers where TeacherName= ?;";
        Object[] params = {
                teachers.getTeachersName()
        };
        int check = JdbcUtil.executeUpdate(sql,params);
        return check;
    }
    //查询管理员信息
    @Override
    public ResultSet ShowAdministrator(String AdministratorName) {
        String sql = "select * from AdministratorS where AdministratorName = ?;";
        Object[] params = {
                AdministratorName
        };
        ResultSet rs = JdbcUtil.executeQuery(sql,params);
        return rs;
    }
    //修改管理员信息
    @Override
    public int UpdateAdministrator(String AdministratorName, Administrators administrator) {
        String sql = "UPDATE Administrators SET AdministratorName = ?,AdministratorPassword = ? WHERE AdministratorName = ?;";
        Object[] params = {
                administrator.getAdministratorsName(),administrator.getAdministratorsPassword(),AdministratorName
        };
        int check = JdbcUtil.executeUpdate(sql,params);
        return check;
    }
}
