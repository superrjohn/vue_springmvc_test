package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")//當前攔截器攔截所有請求
public class DemoFilter implements Filter {

    @Override//默認方法,初始化方法,只調用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化方法");
    }

    @Override //攔截到請求後調用,可多次調用
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("攔截到請求前");
        //放行,進入Controller方法
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("攔截到請求後");
    }

    @Override//默認方法,銷毀方法,只調用一次
    public void destroy() {
        System.out.println("銷毀方法");
    }
}
