package cn.xxyxwh.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

public class DBUtil {

    private static DataSource dataSource = new ComboPooledDataSource();

    private static QueryRunner queryRunner = new QueryRunner(dataSource);

    public static QueryRunner getQueryRunner() {
        return queryRunner;
    }
}
