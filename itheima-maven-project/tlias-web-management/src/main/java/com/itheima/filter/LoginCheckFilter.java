package com.itheima.filter;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;//強轉
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //1.獲得請求url
        String url = req.getRequestURL().toString();
        log.info("請求的url:{}", url);
        //2.判斷url有沒有login,如有就放行
        if (url.contains("login")) {
            log.info("登入操作,放行");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //3.獲得請求頭token
        String jwt = req.getHeader("token");
        //4.判斷令牌存在,不存在返回登入失敗
        if (!StringUtils.hasLength(jwt)) {
            log.info("請求頭token為空,返回未登錄信息");
            Result error = Result.error("NOT_LOGIN");
            //手動轉換 對象轉成JSON --->阿里巴巴fastJSON
            String noLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(noLogin);
            return;
        }
        //5.token存在,解析令牌,如有錯誤返回登錄失敗
        try {
            JwtUtils.parseJWT(jwt);//不報錯就是解析成功
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失敗");
            Result error = Result.error("NOT_LOGIN");
            //手動轉換 對象JSON --->阿里巴巴fastJSON
            String noLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(noLogin);
            return;
        }
        //6.放行
        log.info("令牌合法,放行");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
