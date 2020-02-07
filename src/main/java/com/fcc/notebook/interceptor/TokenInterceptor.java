package com.fcc.notebook.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.fcc.notebook.utils.JWTUtil;
import com.fcc.notebook.utils.Message;

public class TokenInterceptor implements HandlerInterceptor{

    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception arg3)
            throws Exception {
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView model) throws Exception {
    }
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
    	response.setCharacterEncoding("utf-8");
    	String token = request.getHeader("accessToken");
    	System.out.println(token);
    	//token不存在
    	if (null != token) {
    		//验证token是否正确
    		boolean result = JWTUtil.verify(token);
    		if (result) {
    			return true;
    		}
    	}
    	Message msg = Message.createErr("认证失败");
    	response.getWriter().write(JSONObject.toJSONString(msg));
    	return false;
    }

}
