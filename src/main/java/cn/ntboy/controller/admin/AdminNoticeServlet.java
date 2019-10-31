package cn.ntboy.controller.admin;

import cn.ntboy.model.Notice;
import cn.ntboy.service.NoticeService;
import cn.ntboy.service.ServiceResultState;
import cn.ntboy.util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminNoticeServlet",urlPatterns = "/admin/notice.jsp")
public class AdminNoticeServlet extends HttpServlet {

    private NoticeService noticeService = ServiceFactory.getInstance().getService(NoticeService.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceResultState<List<Notice>> allNotice = noticeService.getAllNotice();
        request.setAttribute("notices",allNotice.getPayload());
        request.getRequestDispatcher("/WEB-INF/admin/notice.jsp").forward(request,response);
    }
}
