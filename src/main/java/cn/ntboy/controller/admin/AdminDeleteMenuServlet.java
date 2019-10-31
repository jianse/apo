package cn.ntboy.controller.admin;

import cn.ntboy.service.MenuService;
import cn.ntboy.util.ServiceFactory;
import cn.ntboy.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "AdminDeleteMenuServlet",urlPatterns = "/admin/menus_delete.jsp")
public class AdminDeleteMenuServlet extends HttpServlet {

    private MenuService menuService = ServiceFactory.getInstance().getService(MenuService.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        log.debug("{}",id);
        if (StringUtils.isInteger(id)) {
            menuService.deleteById(Integer.valueOf(id));
        }
        response.sendRedirect(request.getContextPath()+"/admin/menus.jsp");
    }
}
