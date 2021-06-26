package com.qtc.sms.dao.teacherimpl;

import com.qtc.sms.dao.TeacherDao;
import com.qtc.sms.util.JdbcUtil;
import com.qtc.sms.vo.Students;

import java.sql.ResultSet;

public class TeacherImpl implements TeacherDao {
    //添加学生信息
    public int AddStudent(Students student) {
        String sql = "insert into students(StudentName,StudentPassword) values(?,?);";
        Object[] params = {
                student.getStudentsName(),
                student.getStudentsPassword()
        };
        int check = JdbcUtil.executeUpdate(sql, params);
        return check;
    }
    //查询学生信息
    @Override
    public ResultSet FindStudents(String StudentsName) {
        String sql = "select * from students where StudentName = ?;";
        Object[] params = {
                StudentsName
        };
        ResultSet rs = JdbcUtil.executeQuery(sql,params);
        return rs;
    }
    //删除学生信息
    @Override
    public int DateStudent(String StudentsName) {
        String sql = "delete from students where StudentName= ?;";
        Object[] params = {
                StudentsName
        };
        int check = JdbcUtil.executeUpdate(sql,params);
        return check;
    }
    //修改学生信息
    @Override
    public int UpdateStudent(String UpdateStudentName, String UpdateStudentPassword, String StudentName) {
        String sql = "UPDATE students SET StudentName = ?,StudentPassword = ? WHERE StudentName = ?;";
        Object[] params = {
                UpdateStudentName,UpdateStudentPassword,StudentName
        };
        int check = JdbcUtil.executeUpdate(sql,params);
        return check;
    }
}





