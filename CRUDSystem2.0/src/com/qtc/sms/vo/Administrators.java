package com.qtc.sms.vo;

public class Administrators {
    private String AdministratorsName;
    private String AdministratorsPassword;
    private int AdministratorsId;

    public Administrators() {
    }

    public Administrators(String administratorsName, String administratorsPassword, int administratorsId) {
        AdministratorsName = administratorsName;
        AdministratorsPassword = administratorsPassword;
        AdministratorsId = administratorsId;
    }

    public String getAdministratorsName() {
        return AdministratorsName;
    }

    public void setAdministratorsName(String administratorsName) {
        AdministratorsName = administratorsName;
    }

    public String getAdministratorsPassword() {
        return AdministratorsPassword;
    }

    public void setAdministratorsPassword(String administratorsPassword) {
        AdministratorsPassword = administratorsPassword;
    }

    public int getAdministratorsId() {
        return AdministratorsId;
    }

    public void setAdministratorsId(int administratorsId) {
        AdministratorsId = administratorsId;
    }
}
