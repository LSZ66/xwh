package cn.xxyxwh.web.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

@WebServlet(name = "UploadServlet", urlPatterns = "/admin/upload")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = upload(request);
        System.out.println(new Date() + " : " + getIp(request) + " : " + fileName);
        response.sendRedirect(request.getContextPath() + "/admin/member.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/error/404.jsp");
    }

    private String upload(HttpServletRequest request) {
        String fileName = "";
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setRepository(new File(request.getContextPath() + "/tmp/xwh"));
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            List<FileItem> fileItemList = upload.parseRequest(request);
            for (FileItem fileItem : fileItemList) {
                fileName = fileItem.getName();
                InputStream is = fileItem.getInputStream();
                String uploadPath = getServletContext().getRealPath("/WEB-INF");
                OutputStream os = new FileOutputStream(uploadPath + "contact.html");
                IOUtils.copy(is, os);
                fileItem.delete();
                is.close();
                os.close();
            }
            return fileName;
        } catch (FileUploadException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
