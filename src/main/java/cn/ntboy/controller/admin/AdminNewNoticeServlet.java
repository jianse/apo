package cn.ntboy.controller.admin;

import cn.ntboy.model.Notice;
import cn.ntboy.service.NoticeService;
import cn.ntboy.util.ServiceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "AdminNewNoticeServlet",urlPatterns = "/admin/notice_add.jsp")
public class AdminNewNoticeServlet extends HttpServlet {

    private NoticeService noticeService = ServiceFactory.getInstance().getService(NoticeService.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Notice notice = new Notice();
        try {
            BeanUtils.populate(notice,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        noticeService.newNotice(notice);
        response.sendRedirect("/admin/notice.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/admin/notice_add.jsp").forward(request,response);
    }
}
