package cn.ntboy.controller.admin;

import cn.ntboy.model.Types;
import cn.ntboy.service.ServiceResultState;
import cn.ntboy.service.TypeService;
import cn.ntboy.util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminTypesServlet",urlPatterns = "/admin/type.jsp")
public class AdminTypesServlet extends HttpServlet {

    private TypeService typeService = ServiceFactory.getInstance().getService(TypeService.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceResultState<List<Types>> allTypes = typeService.getAllTypes();
        request.setAttribute("types",allTypes.getPayload());
        request.getRequestDispatcher("/WEB-INF/admin/type.jsp").forward(request,response);
    }
}
