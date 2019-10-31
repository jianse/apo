package cn.ntboy.controller.admin;

import cn.ntboy.model.Menus;
import cn.ntboy.model.Types;
import cn.ntboy.service.MenuService;
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
import java.util.List;
import java.util.Map;

@Slf4j
@WebServlet(name = "AdminModifyMenuServlet",urlPatterns = "/admin/menus_update.jsp")
public class AdminModifyMenuServlet extends HttpServlet {

    private MenuService menuService = ServiceFactory.getInstance().getService(MenuService.class);

    private TypeService typeService = ServiceFactory.getInstance().getService(TypeService.class);

    /**
     * doPost 提交修改数据
     * @param request 请求
     * @param response 响应
     * @throws ServletException any
     * @throws IOException any
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        log.debug("param {}",parameterMap);
        Menus menu = new Menus();
        try {
            BeanUtils.populate(menu,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("populate error",e);
        }
        log.debug("populated bean : {}",menu);
        menuService.updateMenuById(menu.getId(),menu);
        response.sendRedirect(request.getContextPath()+"/admin/menus.jsp");
    }

    /**
     * doGet 获取表单
     * @param request 请求
     * @param response 响应
     * @throws ServletException any
     * @throws IOException any
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(StringUtils.isInteger(id)){
            ServiceResultState<Menus> result = menuService.getById(Integer.parseInt(id));
            if (result.getStateCode()==200) {
                request.setAttribute("item",result.getPayload());
                ServiceResultState<List<Types>> allTypes = typeService.getAllTypes();
                request.setAttribute("types",allTypes.getPayload());
                request.getRequestDispatcher("/WEB-INF/admin/menus_update.jsp").forward(request,response);
                return;
            }
        }
        response.sendRedirect(request.getContextPath()+"/admin/menus.jsp");
    }
}
