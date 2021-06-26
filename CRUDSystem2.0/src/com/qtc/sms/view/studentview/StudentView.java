package com.qtc.sms.view.studentview;

import com.qtc.sms.input.CMUtility;
import com.qtc.sms.service.StudentService;
import com.qtc.sms.service.studentImpl.StudentServiceImpl;

//学生菜单
public class StudentView {
    private int key = 1;
    StudentService studentService = new StudentServiceImpl();
    public void StudentMenu(String StudentName){
        do {
            System.out.println("------------欢迎使用学生系统------------");
            System.out.println("****1.查询个人信息****2.修改个人信息****");
            System.out.println("****************0.退出****************");
            System.out.println("---------------------------------------");
            System.out.print("请选择:>");
            key = CMUtility.readInt();
            switch (key){
                case 1:
                    ShowStudent(StudentName);
                    break;
                case 2:
                    UpdateStudent(StudentName);
                    break;
                case 0:
                    System.out.println("返回至身份选择......");
                    break;
                default:
                    System.out.println("输入错误请重新输入......");
                    break;
            }
        }while (key != 0);

    }
    //输出学生信息
    public void ShowStudent(String StudentName){
        studentService.ShowStudent(StudentName);
    }
    //修改个人信息
    public void UpdateStudent(String StudentName){
        System.out.print("名字修改为:>");
        String UpdateStudentName = CMUtility.readString(20);
        System.out.print("密码修改为:>");
        String UpdateStudentPassword = CMUtility.readString(20);
        studentService.UpdateStudent(UpdateStudentName,UpdateStudentPassword,StudentName);
    }
}
