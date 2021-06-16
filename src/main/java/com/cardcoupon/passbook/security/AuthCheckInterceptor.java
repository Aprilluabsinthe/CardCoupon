package com.cardcoupon.passbook.security;

import com.cardcoupon.passbook.constant.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The interceptor for all HTTP requests
 */
@Component
public class AuthCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = HttpServletRequest.getHeader(Constants.TOKEN_STRING);
        // the token is empty
        if (StringUtils.isEmpty(token)){
            throw new Exception("Can not find " + Constants.TOKEN_STRING + "in  Header!");
        }
        // the token is not the authorized one
        if(!token.equals(Constants.TOKEN)){
            throw new Exception("The token in header is " + Constants.TOKEN + ", invalid");
        }
        AccessContext.setToken(token);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AccessContext.clearAccessKey();
    }
}
