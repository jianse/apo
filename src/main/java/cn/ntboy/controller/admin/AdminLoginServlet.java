package cn.ntboy.controller.admin;

import cn.ntboy.model.Admin;
import cn.ntboy.service.AdminService;
import cn.ntboy.service.ServiceResultState;
import cn.ntboy.util.ServiceFactory;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@WebServlet(name = "AdminLoginServlet",urlPatterns = "/admin/login")
public class AdminLoginServlet extends HttpServlet {

    private AdminService adminService = ServiceFactory.getInstance().getService(AdminService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        String pwd = req.getParameter("pwd");
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPwd(pwd);
        ServiceResultState login = adminService.login(admin);
        if(login.getStateCode()==200){
            HttpSession session = req.getSession();
            session.setAttribute("adminSession",login.getPayload());
            resp.sendRedirect(req.getContextPath()+"/admin/main.jsp");
            return;
        }
        req.setAttribute("status","failed");
        req.getRequestDispatcher(req.getContextPath()+"/admin/index.jsp").forward(req,resp);
    }
}
