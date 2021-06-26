package com.qtc.sms.dao.teacherimpl;

import com.qtc.sms.dao.TeacherLoginDao;
import com.qtc.sms.util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDaoImpl implements TeacherLoginDao {
//老师登录实现
    @Override
    public int CheckTeacherLoginInfo(String TeacherName, String TeacherPassword) {
        String sql = "select * from teachers where TeacherName = ? and TeacherPassword = ?;";
        Object[] params = {
                TeacherName,TeacherPassword
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
