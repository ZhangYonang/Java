package com.qtc.sms.view.teacherview;

import com.qtc.sms.input.CMUtility;
import com.qtc.sms.service.TeacherLoginService;
import com.qtc.sms.service.teacherImpl.TeacherLoginServiceImpl;

public class LoginViewTeacher {
    private String TeacherName;
    private String TeacherPassword;
    TeacherLoginServiceImpl teacherLoginService = new TeacherLoginServiceImpl();

    public void TeacherLongMenu(){
        System.out.println("-----------老师请登录------------");
        System.out.print("请输入用户名:>");
        TeacherName = CMUtility.readString(20);
        System.out.print("请输入密码:>");
        TeacherPassword = CMUtility.readString(20);
        teacherLoginService.checkTeacherLogin(TeacherName,TeacherPassword);
    }
}
