package com.qtc.sms.service.teacherImpl;

import com.qtc.sms.dao.TeacherDao;
import com.qtc.sms.dao.teacherimpl.TeacherImpl;
import com.qtc.sms.service.TeacherService;
import com.qtc.sms.view.studentview.LoginViewStudent;
import com.qtc.sms.view.teacherview.LoginViewTeacher;
import com.qtc.sms.view.teacherview.TeacherView;
import com.qtc.sms.vo.Students;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherServiceImpl implements TeacherService {
    TeacherDao studentDao = new TeacherImpl();
    LoginViewTeacher loginViewTeacher = new LoginViewTeacher();
    //添加学生
    public void CheckAddStudent(Students student){
        int check = studentDao.AddStudent(student);
        if (check>0){
            System.out.println("添加成功...");
        }else {
            System.out.println("添加失败...");
            }
        }
//输出查询内容
    @Override
    public int FindStudent(String StudentName) {
        ResultSet rs = studentDao.FindStudents(StudentName);
        if (rs == null) {
            System.out.println("没有此学生...");
        } else {
            try {
                while (rs.next()) {
                    int Id = rs.getInt("StudentId");
                    String Name = rs.getNString("StudentName");
                    String Password = rs.getNString("StudentPassword");
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
//删除学生信息
    @Override
    public void DateStudent(String StudentName) {
        int check = studentDao.DateStudent(StudentName);
        if(check>0){
            System.out.println("删除成功...");
        }else {
            System.out.println("删除失败或者没有此联系人...");
        }
    }
//修改学生
    @Override
    public int UpdateStudent(String UpdateStudentName,String UpdateStudentPassword,String StudentName) {
        int check = studentDao.UpdateStudent(UpdateStudentName,UpdateStudentPassword,StudentName);
        if(check!=0){
            System.out.println("修改成功...");
            return 1;
        }else {
            System.out.println("修改失败...");
            return 0;
        }
    }
//检查老师信息是否修改成功
    @Override
    public void CheckUpdateTeacher(int Check) {
        if(Check>0){
            System.out.println("修改成功请重新登录......");
            loginViewTeacher.TeacherLongMenu();
        }else {
            System.out.println("修改失败......");
        }
    }
}
