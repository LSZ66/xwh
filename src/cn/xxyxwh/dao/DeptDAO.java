package cn.xxyxwh.dao;

import cn.xxyxwh.model.Dept;
import cn.xxyxwh.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class DeptDAO {

    private QueryRunner runner = DBUtil.getQueryRunner();

    private boolean checkDept(String name) throws SQLException {
        Dept query = runner.query("SELECT * FROM t_dept WHERE name = ?", new BeanHandler<>(Dept.class), name);
        if (query != null)
            return true;
        else
            return false;
    }

    public Dept getDTO(String id) throws SQLException {
        return runner.query("SELECT * FROM t_dept WHERE id = ?", new BeanHandler<>(Dept.class), id);
    }

    public boolean add(Dept dept) throws SQLException {
        if (checkDept(dept.getName()))
            return false;
        runner.update("INSERT INTO t_dept(name, color, brief, applying) VALUE (?,?,?,?)",
                dept.getName(), dept.getColor(), dept.getBrief(), dept.isApplying());
        return true;
    }

    public void update(int id, String name, String color, String brief, boolean applying) throws SQLException {
        runner.update("UPDATE t_dept SET name = ?, color = ?, brief = ?, applying = ? WHERE id = ?", name, color, brief, applying, id);
    }

    public List<Dept> showAllDepts() throws SQLException {
        return runner.query("SELECT * FROM t_dept", new BeanListHandler<Dept>(Dept.class));
    }

    public List<Dept> showAllApplyingDepts() throws SQLException {
        return runner.query("SELECT * FROM t_dept WHERE applying = 1", new BeanListHandler<Dept>(Dept.class));
    }
}
