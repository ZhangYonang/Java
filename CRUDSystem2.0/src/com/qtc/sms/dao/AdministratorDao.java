package com.qtc.sms.dao;

import com.qtc.sms.vo.Administrators;
import com.qtc.sms.vo.Teachers;

import java.sql.ResultSet;

public interface AdministratorDao {
    public int AddTeacher(Teachers teacher);
    public ResultSet ShowTeacher(String TeacherName);
    public int UpdateTeacher(String TeacherName,Teachers teacher);
    public int DateTeacher(Teachers teachers);
    public ResultSet ShowAdministrator(String AdministratorName);
    public int UpdateAdministrator(String AdministratorName, Administrators administrator);
}
