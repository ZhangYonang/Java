package com.qtc.sms.vo;

public class Students {
    private String StudentsName;
    private int StudentsId;
    private String StudentsPassword;

    public Students() {

    }

    public Students(String studentsName, int studentsId, String studentsPassword) {
        StudentsName = studentsName;
        StudentsId = studentsId;
        StudentsPassword = studentsPassword;
    }

    public String getStudentsName() {
        return StudentsName;
    }

    public void setStudentsName(String studentsName) {
        StudentsName = studentsName;
    }

    public int getStudentsId() {
        return StudentsId;
    }

    public void setStudentsId(int studentsId) {
        StudentsId = studentsId;
    }

    public String getStudentsPassword() {
        return StudentsPassword;
    }

    public void setStudentsPassword(String studentsPassword) {
        StudentsPassword = studentsPassword;
    }
}
