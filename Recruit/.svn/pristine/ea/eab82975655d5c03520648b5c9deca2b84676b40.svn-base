/**   
* @Title FileShellInterceptor.java 
* @Package com.ttgis.recruit.interceptors 
* @Description TODO 
* @author hua
* @date 2016年9月2日 下午6:03:11 
* @version V1.0   
*/
package com.ttgis.recruit.interceptors;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.ttgis.recruit.controller.UserController;
import com.ttgis.recruit.utility.io.FileUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/** 
* @ClassName FileShellInterceptor 
* @Description TODO 
* @author cxh 
* @date 2016年9月2日 下午6:03:11 
*  
*/
public class FileShellInterceptor extends HandlerInterceptorAdapter{  
    
    static Logger log = Logger.getLogger(FileShellInterceptor.class);
    @Override  
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {  
        HttpServletRequest req=(HttpServletRequest)request;  
        MultipartResolver res=new org.springframework.web.multipart.commons.CommonsMultipartResolver();  
        if(res.isMultipart(req)){  
//          System.out.println("我是文件上传请求");  
            MultipartHttpServletRequest  multipartRequest=(MultipartHttpServletRequest) req;  
            Map<String, MultipartFile> files= multipartRequest.getFileMap();  
            Iterator<String> iterator = files.keySet().iterator();  
            while (iterator.hasNext()) {  
                String formKey = (String) iterator.next();  
//              System.out.println("表单key:"+formKey);  
                MultipartFile multipartFile = multipartRequest.getFile(formKey);
                String originFileName = multipartFile.getOriginalFilename();
                
        	String fileType = originFileName.substring(originFileName.lastIndexOf(".") + 1, originFileName.length()).toLowerCase();

                if(checkFile(fileType)){  
                    return true;  
                }else{
                    System.out.println("格式不符合要求！！！");
        	    /*PrintWriter out = response.getWriter();
        	    StringBuilder builder = new StringBuilder();
        	    builder.append("<script type=\"text/javascript\">window.top.location.href='/Recruit/MyRecruit';</script>");
        	    out.print(builder.toString());
        	    out.close();*/
        	    return false;
                }
               /*if (!ValidateUtils.isEmpty(multipartFile.getOriginalFilename())) {  
                    String filename = FileUtils.getDateFileName(multipartFile.getOriginalFilename());  
//                  System.out.println("我是文件"+multipartFile.getOriginalFilename());  
                    if(checkFile(filename)){  
                        return true;  
                    }else{  
                        request.getSession().removeAttribute(Global.SESSION_ADMIN_USERNAME);  
                        HttpUtils.setActionMessage(request, "尊敬的管理员，您的登录信息已经过期，请重新登录！",ACTION_MSG_TYPE.ERROR ,true);  
                        String redirectURL=request.getContextPath()+"/admin/login.jspx";  
                        //解决登录页面 显示在frame中的问题。  
                        HttpUtils.write2Client(response, "<html><head><script>top.location.href='"+redirectURL+"'</script></head></html>");  
                        return false;  
                    }  
                }  */
            }  
            return true;  
        }else{  
            return true;  
        }  
    }  
    private  boolean checkFile(String fileName){  
        boolean flag=false;  
        String suffixList="xls,xlsx,jpg,gif,png,ico,bmp,jpeg";  
        //获取文件后缀  
        String suffix=fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());  
          
        if(suffixList.contains(suffix.trim().toLowerCase())){  
            flag=true;  
        }  
        return flag;  
    }  
}  
