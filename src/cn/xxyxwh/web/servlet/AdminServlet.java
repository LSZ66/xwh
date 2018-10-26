package cn.xxyxwh.web.servlet;

import cn.xxyxwh.model.Apply;
import cn.xxyxwh.service.ApplyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin/s")
public class AdminServlet extends HttpServlet {

    private ApplyService service = new ApplyService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("save")) {
            saveReply(request);
            response.sendRedirect(request.getContextPath() + "/admin/apply.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("logout")) {
            logout(request);
            response.sendRedirect(request.getContextPath() + "/");
        } else if (action.equalsIgnoreCase("reply")) {
            getDetail(request);
            response.sendRedirect(request.getContextPath() + "/admin/reply.jsp");
        } else
            response.sendRedirect(request.getContextPath() + "/error/404.jsp");
    }

    private void logout(HttpServletRequest request) {
        request.getSession().removeAttribute("username");
    }

    private void getDetail(HttpServletRequest request) {
        String applyID = request.getParameter("applyID");
        Apply apply = service.getApplyById(Integer.parseInt(applyID));
        request.getSession().setAttribute("apply", apply);
    }

    private void saveReply(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        int status = Integer.parseInt(request.getParameter("status"));
        String audit = request.getParameter("audit");
        String reply = request.getParameter("reply");
        service.saveReply(id, audit, reply, status);
    }
}
