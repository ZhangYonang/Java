package com.qtc.sms.dao.administrator;

import com.qtc.sms.dao.AdministratorLoginDao;
import com.qtc.sms.service.AdministratorLoginService;
import com.qtc.sms.util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
//管理员登录实现
public class AdministratorDaoImpl implements AdministratorLoginDao {
    @Override
    public int CheckAdministratorLogin(String AdministratorName, String AdministratorPassword) {
        String sql = "select * from administrators where AdministratorName = ? and AdministratorPassword = ?;";
        Object[] params = {
                AdministratorName,AdministratorPassword
        };
        ResultSet rs = JdbcUtil.executeQuery(sql, params);
        try {
            if (rs.next()) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException Err) {
            Err.printStackTrace();
            return 0;
        }
    }
}

