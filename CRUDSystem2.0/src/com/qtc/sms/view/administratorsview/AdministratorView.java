package com.qtc.sms.view.administratorsview;

import com.qtc.sms.input.CMUtility;
import com.qtc.sms.service.AdministratorService;
import com.qtc.sms.service.TeacherService;
import com.qtc.sms.service.administrator.AdministratorServiceImpl;
import com.qtc.sms.service.teacherImpl.TeacherServiceImpl;
import com.qtc.sms.vo.Administrators;
import com.qtc.sms.vo.Students;
import com.qtc.sms.vo.Teachers;

public class AdministratorView {
    Teachers teacher = new Teachers();
    Students student = new Students();
    Administrators administrators = new Administrators();
    private int Check;
    private String TeacherName;
    AdministratorService administratorService = new AdministratorServiceImpl();
    TeacherService teacherService = new TeacherServiceImpl();
    public void AdministratorMenu(String AdministratorName) {
        int key = 1;
        do {
            System.out.println("----------欢迎使用管理员系统----------");
            System.out.println("******1.添加老师*****2.修改老师******");
            System.out.println("******3.删除老师*****4.查询老师******");
            System.out.println("******5.添加学生*****6.修改学生******");
            System.out.println("******7.删除学生*****8.查询学生******");
            System.out.println("*9.显示当前管理员*10.修改当前管理员信息*");
            System.out.println("*************0.退出登录*************");
            System.out.println("------------------------------------");
            System.out.print("请选择:>");
            key = CMUtility.readInt();
            switch (key) {
                case 1:
                    AddTeacher();
                    break;
                case 2:
                    UpdateTeacher();
                    break;
                case 3:
                    DateTeacher();
                    break;
                case 4:
                    ShowTeacher();
                    break;
                case 5:
                    AddStudent();
                    break;
                case 6:
                    UpdateStudent();
                    break;
                case 7:
                    DateStudent();
                    break;
                case 8:
                    ShowStudent();
                    break;
                case 9:
                    ShowAdministrator(AdministratorName);
                    break;
                case 10:
                    UpdateAdministrator(AdministratorName);
                default:
                    System.out.println("输入错误请重新输入......");
                    break;
            }
        } while (key != 0);
    }

    //添加老师
    private void AddTeacher() {
        System.out.print("请输入老师用户名:>");
        teacher.setTeachersName(CMUtility.readString(20));
        System.out.print("请输入老师密码:>");
        teacher.setTeachersPassword(CMUtility.readString(20));
        administratorService.AddTeacher(teacher);
    }

    //修改老师
    private void UpdateTeacher() {
        System.out.print("请输入要修改的老师姓名");
        TeacherName = CMUtility.readString(20);
        Check = administratorService.ShowTeacher(TeacherName);
        if (Check == 1) {
            System.out.print("用户名修改为:>");
            teacher.setTeachersName(CMUtility.readString(20));
            System.out.print("密码修改为:>");
            teacher.setTeachersPassword(CMUtility.readString(20));
            administratorService.UpdateTeacher(TeacherName, teacher);
        }
    }
        //删除老师
        private void DateTeacher() {
        System.out.print("请输入需要删除的老师姓名:>");
        teacher.setTeachersName(CMUtility.readString(20));
        administratorService.DateTeacher(teacher);
        }
        //查询老师
        private void ShowTeacher () {
            System.out.print("请输入要查找的老师的用户名:>");
            TeacherName = CMUtility.readString(20);
            administratorService.ShowTeacher(TeacherName);
        }
        //添加学生
        private void AddStudent () {
            System.out.print("请输入添加的学生用户名:>");
            student.setStudentsName(CMUtility.readString(20));
            System.out.print("请输入添加的学生密码:>");
            student.setStudentsPassword(CMUtility.readString(20));
            teacherService.CheckAddStudent(student);
        }
        //修改学生
        private void UpdateStudent() {
        System.out.print("输入需要修改学生的用户名:>");
        String UpdateStudentName = CMUtility.readString(20);
        System.out.print("学生用户名修改为:>");
        student.setStudentsName(CMUtility.readString(20));
        System.out.print("学生密码修改为:>");
        student.setStudentsPassword(CMUtility.readString(20));
        teacherService.UpdateStudent(student.getStudentsName(),student.getStudentsPassword(),UpdateStudentName);
        }
        //删除学生
        private void DateStudent() {
        System.out.print("请输入需要删除的学生用户名:>");
        String DateStudentName = CMUtility.readString(20);
        teacherService.DateStudent(DateStudentName);
        }
        //查询学生
        private void ShowStudent(){
        System.out.print("请输入查询学生的用户名:>");
        String StudentName = CMUtility.readString(20);
        teacherService.FindStudent(StudentName);
        }
        //查看当前管理员
        private void ShowAdministrator (String AdministratorName) {
        administratorService.ShowAdministrator(AdministratorName);
        }
        //修改当前管理员
        private void UpdateAdministrator (String AdministratorName) {
        System.out.print("用户名修改为");
        administrators.setAdministratorsName(CMUtility.readString(20));
        System.out.print("密码修改为:>");
        administrators.setAdministratorsPassword(CMUtility.readString(20));
        administratorService.UpdateAdministrator(AdministratorName,administrators);
        }
}
