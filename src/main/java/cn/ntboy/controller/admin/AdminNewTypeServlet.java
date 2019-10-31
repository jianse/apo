package cn.ntboy.controller.admin;

import cn.ntboy.model.Types;
import cn.ntboy.service.TypeService;
import cn.ntboy.util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminNewTypeServlet",urlPatterns = "/admin/type_add.jsp")
public class AdminNewTypeServlet extends HttpServlet {
    TypeService typeService = ServiceFactory.getInstance().getService(TypeService.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name!=null &&!name.isEmpty()){
            Types types = new Types();
            types.setName(name);
            typeService.newType(types);
        }
        response.sendRedirect(request.getContextPath()+"/admin/type.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/admin/type_add.jsp").forward(request,response);
    }
}
