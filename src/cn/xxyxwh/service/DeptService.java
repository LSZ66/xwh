package cn.xxyxwh.service;

import cn.xxyxwh.dao.DeptDAO;
import cn.xxyxwh.model.Dept;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptService {

    private DeptDAO dao = new DeptDAO();

    public List<Dept> showAllApplyingDepts() {
        try {
            return dao.showAllApplyingDepts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> getDeptsNameById(String[] id) {
        ArrayList<String> depts = new ArrayList<>();
        try {
            for (String x : id)
                depts.add(dao.getDTO(x).getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return depts;
    }
}
