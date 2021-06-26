package com.qtc.sms.service.administrator;

import com.qtc.sms.dao.AdministratorLoginDao;
import com.qtc.sms.dao.administrator.AdministratorDaoImpl;
import com.qtc.sms.service.AdministratorLoginService;
import com.qtc.sms.service.AdministratorService;
import com.qtc.sms.view.administratorsview.AdministratorView;
import com.qtc.sms.view.administratorsview.LoginViewAdministratorsView;

public class AdministratorLoginServiceImpl implements AdministratorLoginService {
    AdministratorView administratorService = new AdministratorView();
    AdministratorLoginDao administratorLoginDao = new AdministratorDaoImpl();

    //管理员登录结果
    @Override
    public void CheckAdministratorLogin(String AdministratorName, String AdministratorPassword) {
        int Check = administratorLoginDao.CheckAdministratorLogin(AdministratorName,AdministratorPassword);
        if(Check == 1){
            System.out.println("登录成功......");
            administratorService.AdministratorMenu(AdministratorName);
        }else {
            System.out.println("登录失败......");
            LoginViewAdministratorsView loginViewAdministratorsView = new LoginViewAdministratorsView();
            loginViewAdministratorsView.AdministratorLoginMenu();
        }
    }
}
