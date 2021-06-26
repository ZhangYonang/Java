package com.qtc.sms.dao;
import com.qtc.sms.vo.Students;

import java.sql.ResultSet;

public interface TeacherDao {
   public int AddStudent(Students student);
   public ResultSet FindStudents(String StudentsName);
   public int DateStudent(String StudentsName);
   public int UpdateStudent(String UpdateStudentName,String UpdateStudentPassword,String StudentName);
}
