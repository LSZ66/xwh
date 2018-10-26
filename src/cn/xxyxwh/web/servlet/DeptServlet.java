package cn.xxyxwh.web.servlet;

import cn.xxyxwh.service.DeptService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeptServlet" ,urlPatterns = "/dept")
public class DeptServlet extends HttpServlet {

    private DeptService service = new DeptService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write(new Gson().toJson(service.showAllApplyingDepts()));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("error/404.html").forward(request, response);
    }
}
