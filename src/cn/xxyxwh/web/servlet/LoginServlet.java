package cn.xxyxwh.web.servlet;

import cn.xxyxwh.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        AdminService service = new AdminService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (service.login(username, password)) {
            request.getSession().setAttribute("username", username);
            response.sendRedirect(request.getContextPath() + "/admin/index.jsp");
        } else
            response.getWriter().println("<script language='javascript'>alert('登录失败，请检查用户名和密码');" +
                    "window.location.href='login.html';</script>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("error/404.html").forward(request, response);
    }
}
