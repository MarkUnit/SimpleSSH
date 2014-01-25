package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import exception.UserTestException;

public class PrivilegeInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		
		//获取当前请求的action名字
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		StringBuffer requestURL = request.getRequestURL();
		String servletPath = request.getServletPath();
		
		if ("/user/load".equals(servletPath)) {
			throw new UserTestException();
		}
		
		//简单放行
		return true;
	}
}
