package com.qtc.sms.service;

import com.qtc.sms.vo.Administrators;
import com.qtc.sms.vo.Teachers;

public interface AdministratorService {
    public void AddTeacher(Teachers teacher);
    public int ShowTeacher(String TeacherName);
    public int UpdateTeacher(String TeacherName, Teachers teacher);
    public void DateTeacher(Teachers teacher);
    public void ShowAdministrator(String Administrator);
    public void UpdateAdministrator(String AdministratorName,Administrators administrator);
}