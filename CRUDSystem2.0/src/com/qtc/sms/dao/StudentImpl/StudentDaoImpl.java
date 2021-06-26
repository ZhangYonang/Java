package com.qtc.sms.dao.StudentImpl;

import com.qtc.sms.dao.StudentLoginDoa;
import com.qtc.sms.util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentLoginDoa {

    @Override
    public int StudentLoginDao(String StudentName, String StudentPassword) {
        String sql = "select * from students where StudentName = ? and StudentPassword = ?;";
        Object[] params = {
                StudentName,StudentPassword
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
