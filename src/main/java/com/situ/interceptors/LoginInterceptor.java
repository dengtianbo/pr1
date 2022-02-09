package com.situ.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.situ.model.Admin;
/**
 * 管理员登入拦截器
 * @author 浅墨~~
 * @date  2021年12月24日
 */
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * 在到达Controller之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session=request.getSession();
		Admin user = (Admin)session.getAttribute("@@admin_login");
		if(user==null) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
			// return false表示请求至此为止。请求中断。
			return false;
			
			//return true;
		}else {
			// return true表示继续交给下一个拦截器，如果拦截器没有了，交给controller
			return true;
		}
	}

	
}
