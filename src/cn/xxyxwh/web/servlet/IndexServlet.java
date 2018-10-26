package cn.xxyxwh.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HI");
        String header = request.getHeader("user-agent");
        if(header.contains("Android") || header.contains("iPhone"))
            request.getRequestDispatcher("mobile.jsp").forward(request, response);
        else
            request.getRequestDispatcher("desktop.html").forward(request, response);
    }
}
