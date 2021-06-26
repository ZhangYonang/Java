package com.qtc.sms.service.studentImpl;
import com.qtc.sms.service.StudentService;
import com.qtc.sms.service.TeacherService;
import com.qtc.sms.service.teacherImpl.TeacherServiceImpl;
import com.qtc.sms.view.studentview.LoginViewStudent;

public class StudentServiceImpl implements StudentService {
    TeacherService service = new TeacherServiceImpl();

    //查询学生信息
    @Override
    public void ShowStudent(String StudentName) {
        service.FindStudent(StudentName);
    }

    //修改学生信息
    public void UpdateStudent(String UpdateStudentName, String UpdateStudentPassword, String StudentName) {
        int Check = service.UpdateStudent(UpdateStudentName, UpdateStudentPassword, StudentName);
        if (Check == 1) {
            System.out.println("请重新登录......");
            LoginViewStudent loginViewStudent = new LoginViewStudent();
            loginViewStudent.StudentLoginMenu();
        } else {

        }
    }
}
