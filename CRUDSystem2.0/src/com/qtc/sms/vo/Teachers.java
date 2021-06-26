package com.qtc.sms.vo;

public class Teachers {
    private String TeachersName;
    private int TeachersId;
    private String TeachersPassword;

    public Teachers() {
    }

    public Teachers(String teachersName, int teachersId, String teachersPassword) {
        TeachersName = teachersName;
        TeachersId = teachersId;
        TeachersPassword = teachersPassword;
    }

    public String getTeachersName() {
        return TeachersName;
    }

    public void setTeachersName(String teachersName) {
        TeachersName = teachersName;
    }

    public int getTeachersId() {
        return TeachersId;
    }

    public void setTeachersId(int teachersId) {
        TeachersId = teachersId;
    }

    public String getTeachersPassword() {
        return TeachersPassword;
    }

    public void setTeachersPassword(String teachersPassword) {
        TeachersPassword = teachersPassword;
    }
}
