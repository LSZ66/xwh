package cn.xxyxwh.service;

import cn.xxyxwh.dao.AdminDAO;

import java.sql.SQLException;

public class AdminService {

    private AdminDAO dao = new AdminDAO();

    public boolean checkAdmin(String username) {
        try {
            return dao.checkUsername(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean login(String username, String password) {
        try {
            return dao.query(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
