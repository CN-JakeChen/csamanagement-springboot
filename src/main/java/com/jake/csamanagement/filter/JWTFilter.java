package com.jake.csamanagement.filter;

import com.jake.csamanagement.util.JWTToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTFilter extends BasicHttpAuthenticationFilter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 如果带有 token，则对 token 进行检查，否则拒绝通过
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws UnauthorizedException {
//        System.out.println("到达filter");
        //判断请求的请求头是否带上 "Token"
        if (((HttpServletRequest) request).getHeader("Token") != null) {
            //如果存在，则进入 executeLogin 方法执行登入，检查 token 是否正确
            try {
                executeLogin(request, response);
                return true;
            } catch (Exception e) {
                //token 错误
//                System.out.println("token错误区");
                if (e.getMessage().equals("token过期！"))
                {
                    responseError(response,1);
                }else
                {
                    responseError(response,2);
                }
                return false;
            }
        }
        System.out.println("请求头不存在");
        responseError(response,3);
        return false;
    }


    /**
     * 执行登陆操作
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("Token");
        JWTToken jwtToken = new JWTToken(token);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(jwtToken);
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }


    /**
     * 将非法请求跳转到 /unauthorized/**
     */
    private void responseError(ServletResponse response,int messageType) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//            System.out.println("到达重定向区域");
            if(messageType==1)
            {
                httpServletResponse.sendRedirect("/api/login/expired");
            }
            else if(messageType==2)
            {
                httpServletResponse.sendRedirect("/api/login/error");
            }
            else if(messageType==3)
            {
                httpServletResponse.sendRedirect("/api/login/notlogin");
            }

        } catch (IOException e) {
//            System.out.println("io异常区");
            logger.error(e.getMessage());
        }
    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}
