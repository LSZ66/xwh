package cn.xxyxwh.web.filter;

import cn.xxyxwh.service.AdminService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter", urlPatterns = "/admin/*")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        AdminService service = new AdminService();
        String username = (String) request.getSession().getAttribute("username");
        if (username != null)
            chain.doFilter(req, resp);
        else
            response.sendRedirect(request.getContextPath() + "/error/401.html");
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
