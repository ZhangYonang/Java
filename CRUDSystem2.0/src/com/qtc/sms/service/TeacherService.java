package com.qtc.sms.service;

import com.qtc.sms.vo.Students;

public interface TeacherService {
    public void CheckAddStudent(Students students);
    public int FindStudent(String StudentName);
    public void DateStudent(String StudentName);
    public int UpdateStudent(String UpdateStudentName,String UpdateStudentPassword,String StudentName);
    public void CheckUpdateTeacher(int Check);
}
