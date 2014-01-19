<%@page import="service.impl.UserServiceImpl"%>
<%@page import="org.apache.catalina.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="service.UserService" %>
<%@ page import="service.impl.UserServiceImpl" %>
<%@ page import="po.WebUser" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	
	
	String username = request.getParameter("username");
	String psw = request.getParameter("psw");
	String psw2 = request.getParameter("psw2");

	WebUser user = new WebUser();
	user.setUsername(username);
	user.setPsw(psw);
	
	UserService userManager = new UserServiceImpl();
	boolean exists = userManager.exists(user);

	if(exists) {
		response.sendRedirect("registerFail.jsp");
		return;
	} else {
		userManager.add(user);
	}

	response.sendRedirect("registerSuccess.jsp");
%>
