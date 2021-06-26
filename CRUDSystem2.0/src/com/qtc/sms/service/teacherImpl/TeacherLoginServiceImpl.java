package com.qtc.sms.service.teacherImpl;

import com.qtc.sms.dao.TeacherLoginDao;
import com.qtc.sms.dao.teacherimpl.TeacherDaoImpl;
import com.qtc.sms.service.TeacherLoginService;
import com.qtc.sms.view.teacherview.LoginViewTeacher;
import com.qtc.sms.view.teacherview.TeacherView;

//老师登录结果
public class TeacherLoginServiceImpl implements TeacherLoginService {
    TeacherLoginDao teacherLoginDao = new TeacherDaoImpl();
    TeacherView TeacherView = new TeacherView();
    @Override
    public void checkTeacherLogin(String TeacherName, String TeacherPassword) {
        int check = teacherLoginDao.CheckTeacherLoginInfo(TeacherName,TeacherPassword);
        if(check == 1){
            System.out.println("登录成功......");
            TeacherView.TeacherMenu(TeacherName);
        }else {
            System.out.println("登录失败请重新登录......");
            LoginViewTeacher loginViewTeacher = new LoginViewTeacher();
            loginViewTeacher.TeacherLongMenu();
        }
    }
}
