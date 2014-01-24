package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PrivilegeInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		
		//获取当前请求的action名字
		String uri = request.getRequestURI();
		int indexOfSlash = uri.lastIndexOf("/");
		uri = uri.substring(indexOfSlash+1);
		
		//简单放行
		return true;
	}
}
