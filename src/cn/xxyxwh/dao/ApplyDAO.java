package cn.xxyxwh.dao;

import cn.xxyxwh.model.Apply;
import cn.xxyxwh.model.Dept;
import cn.xxyxwh.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplyDAO {

    private QueryRunner runner = DBUtil.getQueryRunner();

    public Apply getDTO(int id) throws SQLException {
        return runner.query("SELECT * FROM t_apply WHERE id = ?", new BeanHandler<>(Apply.class), id);
    }

    public ArrayList<Dept> getDeptsByApplyId(int id) throws SQLException {
        DeptDAO deptDAO = new DeptDAO();
        String[] depts = getDTO(id).getDepts().split(",");
        ArrayList<Dept> deptList = new ArrayList<>();
        for (String x : depts)
            deptList.add(deptDAO.getDTO(x));
        return deptList;
    }

    public void add(Apply apply) throws SQLException {
        runner.update("INSERT INTO t_apply(name, unit, contact, depts, exec, place, description) VALUE (?,?,?,?,?,?,?)",
                apply.getName(), apply.getUnit(), apply.getContact(), apply.getDepts(), apply.getExec(), apply.getPlace(), apply.getDescription());
    }

    public void update(int id, String audit, String reply, int status) throws SQLException {
        runner.update("UPDATE t_apply SET audit = ?, reply = ?, status = ? WHERE id = ?", audit, reply, status, id);
    }

    public List<Apply> showAllApply() throws SQLException {
        return runner.query("SELECT * FROM t_apply", new BeanListHandler<>(Apply.class));
    }

    public long showTotalUnReply() throws SQLException {
        return runner.query("SELECT COUNT(*) FROM t_apply WHERE status = 0", new ScalarHandler<Long>());
    }

    public List<Apply> weekTask() throws SQLException {
        return runner.query("SELECT * FROM `t_apply` WHERE YEARWEEK( exec ,1) = YEARWEEK( now( ),1 ) AND status = 1 ORDER BY exec",
                new BeanListHandler<>(Apply.class));
    }
}
