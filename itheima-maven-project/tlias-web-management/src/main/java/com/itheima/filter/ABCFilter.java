package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class ABCFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("ABC攔截到請求前");
        //放行,進入Controller方法
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("ABC攔截到請求後");
    }
}
