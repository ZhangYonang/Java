package com.qtc.sms.main;

import com.qtc.sms.input.CMUtility;
import com.qtc.sms.view.administratorsview.LoginViewAdministratorsView;
import com.qtc.sms.view.studentview.LoginViewStudent;
import com.qtc.sms.view.teacherview.LoginViewTeacher;

//主菜单
public class MainMenu {
    public void Menu() {
        int key = 1;
        LoginViewTeacher loginViewTeacher = new LoginViewTeacher();
        LoginViewStudent loginViewStudent = new LoginViewStudent();
        LoginViewAdministratorsView loginViewAdministratorsView = new LoginViewAdministratorsView();
        do {
            System.out.println("----------欢迎使用----------");
            System.out.println("-------请选择你的身份--------");
            System.out.println("*****1.老师*****2.学生******");
            System.out.println("*****3.管理员***0.退出系统***");
            System.out.println("---------------------------");
            System.out.print("请选择:>");
            key = CMUtility.readInt();
            switch (key){
                case 1:
                    loginViewTeacher.TeacherLongMenu();
                    break;
                case 2:
                    loginViewStudent.StudentLoginMenu();
                    break;
                case 3:
                    loginViewAdministratorsView.AdministratorLoginMenu();
                    break;
                case 0:
                    System.out.println("感谢使用...");
                    break;
                default:
                    System.out.println("输入错误请重新输入......");
                    break;
            }
        } while (key != 0);
    }
}
