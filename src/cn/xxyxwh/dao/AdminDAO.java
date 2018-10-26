package cn.xxyxwh.dao;

import cn.xxyxwh.model.Admin;
import cn.xxyxwh.utils.DBUtil;
import cn.xxyxwh.utils.MD5SaltUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AdminDAO {

    private QueryRunner runner = DBUtil.getQueryRunner();

    public Admin getDTO(int id) throws SQLException {
        return runner.query("SELECT * FROM t_admin WHERE id = ?", new BeanHandler<>(Admin.class), id);
    }

    private Admin getDTO(String username) throws SQLException {
        return runner.query("SELECT * FROM t_admin WHERE username = ?", new BeanHandler<>(Admin.class), username);
    }

    public boolean checkUsername(String username) throws SQLException {
        Admin query = getDTO(username);
        if (query != null)
            return true;
        else
            return false;
    }

    public boolean query(String username, String password) throws SQLException {
        Admin admin = getDTO(username);
        if (admin == null)
            return false;
        return MD5SaltUtil.validPassword(password, admin.getPassword());
    }

    public boolean add(Admin admin) throws SQLException {
        if (checkUsername(admin.getUsername()))
            return false;
        String encryptedPwd = MD5SaltUtil.getEncryptedPwd(admin.getPassword());
        runner.update("INSERT INTO t_admin(username, password) VALUE (?,?)",
                admin.getUsername(), encryptedPwd);
        return true;
    }
}
