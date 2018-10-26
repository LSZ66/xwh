package cn.xxyxwh.service;

import cn.xxyxwh.dao.ApplyDAO;
import cn.xxyxwh.model.Apply;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ApplyService {

    private ApplyDAO dao = new ApplyDAO();

    private String getDayWeek(String src) {
        try {
            String[] weeks = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(src);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            return weeks[c.get(Calendar.DAY_OF_WEEK) - 1];
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Apply apply) {
        try {
            dao.add(apply);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Apply toPageMsg(Apply apply) {
        String[] id = apply.getDepts().split(",");
        DeptService service = new DeptService();
        ArrayList<String> deptName = service.getDeptsNameById(id);
        apply.setDepts(StringUtils.join(deptName, ","));
        String exec = apply.getExec();
        String[] apart = exec.split(" ");
        apply.setExec(apart[0] + " " + getDayWeek(apart[0]) + " " + apart[1].substring(0,5));
        return apply;
    }

    public List<Apply> showAllApply() {
        List<Apply> applyList;
        try {
            applyList = dao.showAllApply();
            for (int i = 0; i < applyList.size(); i++)
                applyList.set(i, toPageMsg(applyList.get(i)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return applyList;
    }

    public List<Apply> showWeekTask() {
        List<Apply> applyList;
        try {
            applyList = dao.weekTask();
            for (int i = 0; i < applyList.size(); i++)
                applyList.set(i, toPageMsg(applyList.get(i)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return applyList;
    }

    public long showTotalUnReply() {
        try {
            return dao.showTotalUnReply();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Apply getApplyById(int id) {
        try {
            return toPageMsg(dao.getDTO(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveReply(int id, String audit, String reply, int status) {
        try {
            dao.update(id, audit, reply, status);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
