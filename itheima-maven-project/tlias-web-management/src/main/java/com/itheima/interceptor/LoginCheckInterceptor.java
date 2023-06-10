package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component//交給IOC容器管理
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override//目標運行前運行
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        System.out.println("preHandle運行了");

        //1.獲得請求url
        String url = req.getRequestURL().toString();
        log.info("請求的url:{}", url);
        //2.判斷url有沒有login,如有就放行
        if (url.contains("login")) {
            log.info("登入操作,放行");
            return true;
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
            return false;
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
            return false;
        }
        //6.放行
        log.info("令牌合法,放行");
        return true;

    }

    @Override//目標運行後運行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle運行了了");
    }

    @Override//視圖渲染後運行,最後運行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion運行了了了");
    }
}
