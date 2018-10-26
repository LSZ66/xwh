package cn.xxyxwh.dao;

import cn.xxyxwh.model.Member;
import cn.xxyxwh.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class MemberDAO {

    private QueryRunner runner = DBUtil.getQueryRunner();

    public Member getDTO(int id) throws SQLException {
        return runner.query("SELECT * FROM t_member WHERE id = ?", new BeanHandler<>(Member.class), id);
    }

    public void add(String name, int dept, String position, String clazz, String phone, String qq, String weChat) throws SQLException {
        runner.update("INSERT INTO t_member(name, dept, position, clazz, phone, qq, wechat) " +
                "VALUE (?,?,?,?,?,?)", name, dept, position, clazz, phone, qq, weChat);
    }

    public void update(int id, String name, int dept, String position, String clazz, String phone, String qq, String weChat) throws SQLException {
        runner.update("UPDATE t_member " +
                "SET name = ?, dept = ?, position = ?, clazz = ?, phone = ?, qq = ?, wechat =? WHERE id = ?",
                name, dept, position, clazz, phone, qq, weChat, id);
    }

    public void delete(int id) throws SQLException {
        runner.update("DELETE FROM t_member WHERE id = ?",id);
    }

    public void deleteAllMember() throws SQLException {
        runner.update("TRUNCATE t_member");
    }

    public List<Member> selectByDept(int deptId) throws SQLException {
        return runner.query("SELECT * FROM t_member WHERE dept = ?", new BeanListHandler<>(Member.class), deptId);
    }
}
