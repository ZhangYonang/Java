package com.qtc.sms.view.studentview;
import com.qtc.sms.input.CMUtility;
import com.qtc.sms.service.StudentLoginService;
import com.qtc.sms.service.studentImpl.StudentLoginServiceImpl;

public class LoginViewStudent {
    private String StudentName;
    private String StudentPassword;
    StudentLoginService studentLoginService = new StudentLoginServiceImpl();

    public void StudentLoginMenu(){
        System.out.println("-----------学生请登录------------");
        System.out.print("请输入用户名:>");
        StudentName = CMUtility.readString(20);
        System.out.print("请输入密码:>");
        StudentPassword = CMUtility.readString(20);
        studentLoginService.CheckStudentLogin(StudentName,StudentPassword);
    }
}
