package cn.ntboy.controller.admin;

import cn.ntboy.util.AntPathMatcher;
import cn.ntboy.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
@WebFilter(filterName = "AdminLoginFilter",urlPatterns = "/admin/*",initParams = {
        @WebInitParam(name = "adminSessionKey",value = "adminSession"),
        @WebInitParam(name = "loginPage",value = "/admin/index.jsp"),
        @WebInitParam(name = "excludes",value = "/admin/images/*;/admin/js/*;/admin/login",description = "放行的路径,支持通配符,多个路径以分号(;)分隔,用作css,js等静态资源的路径")
})
public class AdminLoginFilter implements Filter {

    private String adminSessionKey = "";
    private String loginPage = "";
    private String excludes = "";
    private String[] excludesPattern = null;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // visit login page, pass
        if(loginPage.equals(request.getServletPath())){
            log.debug("login page, pass");
            chain.doFilter(req,resp);
            return;
        }

        // exclude path, pass
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        if(antPathMatcher.matchOne(excludesPattern,request.getServletPath())){
            log.debug("exclude path , pass : {}",request.getServletPath());
            chain.doFilter(req, resp);
            return;
        }

        // verify session
        Object adminSession = request.getSession().getAttribute(adminSessionKey);
        if (adminSession != null) {
            // already login, pass
            log.debug("already login, pass : {}",request.getServletPath());
            chain.doFilter(req,resp);
            return;
        }

        // others, rejected and redirect to login page
        log.debug("rejected : {}",request.getServletPath());
        response.sendRedirect(request.getContextPath()+loginPage);
    }

    public void init(FilterConfig config) throws ServletException {
        adminSessionKey = config.getInitParameter("adminSessionKey");
//        System.out.println(adminSessionKey);
        loginPage = config.getInitParameter("loginPage");
        excludes = config.getInitParameter("excludes");
        excludesPattern = excludes.split(";");
//        excludesPattern = StringUtils.split(excludes, ";");
//        System.out.println(Arrays.toString(excludesPattern));

    }

}
