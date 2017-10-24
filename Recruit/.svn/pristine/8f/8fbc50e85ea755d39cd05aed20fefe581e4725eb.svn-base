/**
 * 董再兴 LoginSessionInterceptor.java 2013年7月13日
 */
package com.ttgis.recruit.interceptors;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/** 
* @ClassName LoginSessionInterceptor 
* @Description 后台过滤 
* @author cxh 
* @date 2016年9月5日 上午8:55:55 
*  
*/
public class LoginSessionInterceptor extends HandlerInterceptorAdapter
{

	/*
	 * @see
	 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{

		request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");

	if (request.getSession().getAttribute("loginSession") == null) {
	    PrintWriter out = response.getWriter();
	    StringBuilder builder = new StringBuilder();
	    builder.append("<script type=\"text/javascript\">window.top.location.href=/login</script>");
	    out.print(builder.toString());
	    out.close();
	    return false;
	} else {
	    return super.preHandle(request, response, handler);
	}
    }

}
