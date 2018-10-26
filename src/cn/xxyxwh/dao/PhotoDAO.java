package cn.xxyxwh.dao;

import cn.xxyxwh.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class PhotoDAO {

    private QueryRunner runner = DBUtil.getQueryRunner();

    public void add(String name, String path, String brief) throws SQLException {
        runner.update("INSERT INTO t_photo(name, path, brief) VALUE (?,?,?)", name, path, brief);
    }

    public void update(int id, String name, String path, String brief) throws SQLException {
        runner.update("UPDATE t_photo SET name = ?, path = ?, brief = ? WHERE id = ?", name, path, brief, id);
    }

    public void delete(int id) throws SQLException {
        runner.update("DELETE FROM t_photo WHERE id = ?", id);
    }


}
