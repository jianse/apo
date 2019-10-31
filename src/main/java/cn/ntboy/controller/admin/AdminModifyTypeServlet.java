package cn.ntboy.controller.admin;

import cn.ntboy.model.Types;
import cn.ntboy.service.ServiceResultState;
import cn.ntboy.service.TypeService;
import cn.ntboy.util.ServiceFactory;
import cn.ntboy.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Slf4j
@WebServlet(name = "AdminModifyTypeServlet",urlPatterns = "/admin/type_update.jsp")
public class AdminModifyTypeServlet extends HttpServlet {

    private TypeService typeService = ServiceFactory.getInstance().getService(TypeService.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Types types = new Types();
        try {
            BeanUtils.populate(types,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("parse parameterMap failed",e);
//            e.printStackTrace();
        }
        typeService.updateById(types.getId(),types);
        response.sendRedirect(request.getContextPath()+"/admin/type.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (StringUtils.isInteger(id)) {
            ServiceResultState<Types> typeById = typeService.getTypeById(Integer.parseInt(id));
            request.setAttribute("type",typeById.getPayload());
            request.getRequestDispatcher("/WEB-INF/admin/type_update.jsp").forward(request,response);
        }else {
            response.sendRedirect(request.getContextPath()+"/admin/type.jsp");
        }
    }
}
