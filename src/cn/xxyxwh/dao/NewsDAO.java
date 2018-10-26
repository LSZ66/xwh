package cn.xxyxwh.dao;

import cn.xxyxwh.model.News;
import cn.xxyxwh.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class NewsDAO {

    private QueryRunner runner = DBUtil.getQueryRunner();

    public void add(String title, String author, String photographer, String time, String text) throws SQLException {
        runner.update("INSERT INTO t_news(title, author, photographer, text) VALUE (?,?,?,?)"
                , title, author, photographer, text);
    }

    public void delete(int id) throws SQLException {
        runner.update("DELETE FROM t_news WHERE id = ?", id);
    }

    public void update(int id, String title, String author, String photographer, String time, String text) throws SQLException {
        runner.update("UPDATE t_news SET title = ?, author = ?, photographer = ?, time = ?, text = ? WHERE id = ?",
                title, author, photographer, time, text, id);
    }

    public List<News> showAllNews() throws SQLException {
        return runner.query("SELECT * FROM t_news", new BeanListHandler<>(News.class));
    }

    public News getDTO(int id) throws SQLException {
        return runner.query("SELECT * FROM t_news WHERE id = ?", new BeanHandler<>(News.class), id);
    }
}
