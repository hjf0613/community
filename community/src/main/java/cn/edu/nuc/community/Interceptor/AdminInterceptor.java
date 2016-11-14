package cn.edu.nuc.community.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.edu.nuc.community.entity.Admin;
/**
 * 因为controller路径没有写对 所以并没有用上
 * @author 韩晋峰
 *
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		  
          
        Admin admin =  (Admin)request.getSession().getAttribute("admin");   
        if(admin == null){  
            request.getRequestDispatcher("/WEB-INF/views/admin/adminlogin.jsp").forward(request, response);  
            return false;  
        }else  
            return true;  
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
