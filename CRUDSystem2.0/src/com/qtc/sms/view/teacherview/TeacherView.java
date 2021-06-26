package com.qtc.sms.view.teacherview;

import com.qtc.sms.input.CMUtility;
import com.qtc.sms.service.AdministratorService;
import com.qtc.sms.service.TeacherService;
import com.qtc.sms.service.administrator.AdministratorServiceImpl;
import com.qtc.sms.service.teacherImpl.TeacherServiceImpl;
import com.qtc.sms.vo.Students;
import com.qtc.sms.vo.Teachers;

//老师菜单
public class TeacherView {
    private Students student = new Students();
    private Teachers teachers = new Teachers();
    private int key = 1;
    private AdministratorService administratorService = new AdministratorServiceImpl();
    public void TeacherMenu(String TeacherName){
        do {
            System.out.println("----------欢迎使用教师系统------------");
            System.out.println("*****1.添加学生****2.修改学生信息*****");
            System.out.println("*****3.删除学生****4.查找学生信息*****");
            System.out.println("***5.查看当前老师*6.修改当前老师信息***");
            System.out.println("***************0.退出****************");
            System.out.println("-------------------------------------");
            System.out.print("请选择:>");
            key = CMUtility.readInt();
            switch (key){
                case 1:
                    AddStudent();//添加S
                    break;
                case 2:
                    UpdateStudent();//修改S
                    break;
                case 3:
                    DateStudent();//删除S
                    break;
                case 4:
                    FindStudent();//查找S
                    break;
                case 5:
                    ShowTeacher(TeacherName);
                    break;
                case 6:
                    UpdateTeacher(TeacherName);
                case 0:
                    System.out.println("返回至身份选择...");
                    key = 0;
                    break;
            }
        }while (key!=0);
    }
    private void AddStudent(){
        TeacherService studentService = new TeacherServiceImpl();
        System.out.println("——————————————添加学生——————————————");
        System.out.print("请输入学生姓名:>");
        student.setStudentsName(CMUtility.readString(20));
        System.out.print("请输入学生密码:>");
        student.setStudentsPassword(CMUtility.readString(20));
        studentService.CheckAddStudent(student);
    }

    private void UpdateStudent(){
        TeacherService studentService = new TeacherServiceImpl();
        System.out.println("——————————————修改学生信息——————————————");
        System.out.print("请输入需要修改学生的名字:>");
        student.setStudentsName(CMUtility.readString(10));
        int check = studentService.FindStudent(student.getStudentsName());
        if(check!=0){
            System.out.print("姓名修改为:>");
            String UpdateName = CMUtility.readString(20);
            System.out.print("密码修改为:>");
            String UpdatePassword = CMUtility.readString(20);
            studentService.UpdateStudent(UpdateName,UpdatePassword,student.getStudentsName());
        }
    }

    private void DateStudent(){
        TeacherService studentService = new TeacherServiceImpl();
        System.out.println("——————————————删除学生——————————————");
        System.out.print("请输入需要删除学生的名字:>");
        student.setStudentsName(CMUtility.readString(10));
        studentService.DateStudent(student.getStudentsName());
    }

    private void FindStudent(){
        TeacherService studentService = new TeacherServiceImpl();
        System.out.println("——————————————查找学生——————————————");
        System.out.print("请输入需要查找的学生姓名:>");
        student.setStudentsName(CMUtility.readString(10));
        int Check = studentService.FindStudent(student.getStudentsName());
    }
    private void ShowTeacher(String TeacherName){
        System.out.println("——————————————个人信息——————————————");
        administratorService.ShowTeacher(TeacherName);
    }
    private void UpdateTeacher(String TeacherName){
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        System.out.println("——————————————个人信息修改——————————————");
        System.out.print("用户名修改为:>");
        teachers.setTeachersName(CMUtility.readString(20));
        System.out.print("密码修改为:>");
        teachers.setTeachersPassword(CMUtility.readString(20));
        int Check = administratorService.UpdateTeacher(TeacherName,teachers);
        teacherService.CheckUpdateTeacher(Check);
    }
}
