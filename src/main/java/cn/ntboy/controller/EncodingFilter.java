package cn.ntboy.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "EncodingFilter",urlPatterns = "/*",initParams = @WebInitParam(name="encoding",value = "utf-8"))
public class EncodingFilter implements Filter {

    private String encoding = "utf-8";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
        log.info("use encoding = \"{}\" process request and response.", encoding);
    }

}
