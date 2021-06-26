package com.qtc.sms.view.administratorsview;

import com.qtc.sms.input.CMUtility;
import com.qtc.sms.service.AdministratorLoginService;
import com.qtc.sms.service.administrator.AdministratorLoginServiceImpl;

//管理员登录界面
public class LoginViewAdministratorsView {
    AdministratorLoginService administratorLoginService = new AdministratorLoginServiceImpl();
    public void AdministratorLoginMenu(){
        System.out.println("----------管理员请登录----------");
        System.out.print("请输入管理员用户名:>");
        String AdministratorName = CMUtility.readString(20);
        System.out.print("\t请输入管理员密码:>");
        String AdministratorPassword = CMUtility.readString(20);
        administratorLoginService.CheckAdministratorLogin(AdministratorName,AdministratorPassword);
    }
}
