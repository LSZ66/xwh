package cn.xxyxwh.web.servlet;

import cn.xxyxwh.model.Apply;
import cn.xxyxwh.service.ApplyService;
import cn.xxyxwh.utils.MailUtil;
import cn.xxyxwh.utils.MyBeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ApplyServlet", urlPatterns = "/apply")
public class ApplyServlet extends HttpServlet {
    private ApplyService service = new ApplyService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("add")) {
            if (add(request))
                response.getWriter().println("<script language='javascript'>alert('您已成功提交申请！');" +
                        "window.location.href='/index';</script>");
            else
                response.getWriter().println("<script language='javascript'>alert('您有信息未填写, 请返回检查！');" +
                        "window.location.href='/index';</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean add(HttpServletRequest request) {
        Apply apply = MyBeanUtil.createBeanByRequest(Apply.class, request);
        try {
            service.add(apply);
            new MailUtil("lsz0929@live.cn", apply).start();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
