package cn.ntboy.controller.admin;

import cn.ntboy.model.Menus;
import cn.ntboy.model.vo.PageVO;
import cn.ntboy.service.MenuService;
import cn.ntboy.service.ServiceResultState;
import cn.ntboy.util.ServiceFactory;
import cn.ntboy.util.StringUtils;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "AdminMenusServlet",urlPatterns = "/admin/menus.jsp")
public class AdminMenusServlet extends HttpServlet {

    private MenuService menuService = ServiceFactory.getInstance().getService(MenuService.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNum = request.getParameter("pageNum");
        int pageNumI = StringUtils.isInteger(pageNum)?Integer.parseInt(pageNum):1;
        String pageSize = request.getParameter("pageSize");
        int pageSizeI = StringUtils.isInteger(pageSize)?Integer.parseInt(pageSize):10;
        PageVO page = new PageVO();
        page.setPageNum(pageNumI);
        page.setPageSize(pageSizeI);

        ServiceResultState<PageVO<Menus>> allMenus = menuService.getAllMenus(page);
        PageVO<Menus> menusData = allMenus.getPayload();
        request.setAttribute("menusData", menusData);
        request.getRequestDispatcher("/WEB-INF/admin/menus.jsp").forward(request,response);
    }
}
