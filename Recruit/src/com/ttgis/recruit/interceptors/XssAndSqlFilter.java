/**   
* @Title XssAndSqlFilter.java 
* @Package com.ttgis.recruit.interceptors 
* @Description TODO 
* @author hua
* @date 2016年8月31日 下午7:43:49 
* @version V1.0   
*/
package com.ttgis.recruit.interceptors;

import java.io.IOException;  

import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  

import com.ttgis.recruit.utility.io.FileUtil;
/** 
* @ClassName XssAndSqlFilter 
* @Description TODO 
* @author cxh 
* @date 2016年8月31日 下午7:43:49 
*  
*/
public class XssAndSqlFilter implements Filter{
    
    @Override  
    public void destroy() {  
        // TODO Auto-generated method stub  
  
    }  
  
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  
	HttpServletRequest httpServletRequest = (HttpServletRequest) request;
	String urlPath = httpServletRequest.getServletPath();
	if (urlPath.indexOf("uppics") != -1 && urlPath.indexOf(".") != -1) {
	   String  fileType = urlPath.substring(urlPath.lastIndexOf(".") + 1, urlPath.length()).toLowerCase();
	    if (!FileUtil.readProAndCheckInWhiteList("whiteList.properties", "wl.filter", fileType)) {
		System.out.println("访问文件不符合要求！");
		httpServletRequest.getRequestDispatcher(httpServletRequest.getContextPath()+"/index.jsp").forward(request, response);
		return;
	    }
	}
	
        XssAndSqlHttpServletRequestWrapper xssRequest = new XssAndSqlHttpServletRequestWrapper((HttpServletRequest) request);  
        chain.doFilter(xssRequest, response);  
    }  
  
    @Override  
    public void init(FilterConfig arg0) throws ServletException {  
        // TODO Auto-generated method stub  
  
    }  
}
