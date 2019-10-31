package cn.ntboy.controller.admin;

import cn.ntboy.service.TypeService;
import cn.ntboy.util.ServiceFactory;
import cn.ntboy.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminDeleteTypeServlet",urlPatterns = "/admin/type_delete.jsp")
public class AdminDeleteTypeServlet extends HttpServlet {

    TypeService typeService = ServiceFactory.getInstance().getService(TypeService.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (StringUtils.isInteger(id)) {
            typeService.deleteById(Integer.parseInt(id));
        }
        response.sendRedirect(request.getContextPath()+"/admin/type.jsp");
    }
}
