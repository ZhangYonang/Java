package com.qtc.sms.service.studentImpl;

import com.qtc.sms.dao.StudentImpl.StudentDaoImpl;
import com.qtc.sms.dao.StudentLoginDoa;
import com.qtc.sms.service.StudentLoginService;
import com.qtc.sms.view.studentview.LoginViewStudent;
import com.qtc.sms.view.studentview.StudentView;

public class StudentLoginServiceImpl implements StudentLoginService {
    StudentLoginDoa studentLoginDoa = new StudentDaoImpl();
    StudentView studentView = new StudentView();

    @Override
    public void CheckStudentLogin(String StudentName, String StudentPassword) {
        int check = studentLoginDoa.StudentLoginDao(StudentName,StudentPassword);
        if(check == 1){
            System.out.println("登录成功...");
            studentView.StudentMenu(StudentName);
        }else {
            System.out.println("登录失败...");
            LoginViewStudent loginViewStudent = new LoginViewStudent();
            loginViewStudent.StudentLoginMenu();
        }
    }
}
