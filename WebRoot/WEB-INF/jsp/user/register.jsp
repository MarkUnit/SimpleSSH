<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="resources/scripts/jquery-1.9.1.js"></script>
</head>

<body>
	<form method="post" action="user/register">
		<img title="这是个图片" src="resources/images/logo.jpg" /><br>
		<table>
			<tr>
				<td align="center"
					style="background:url(resources/images/logo.jpg) no-repeat"
					width="200" height="60"><br>
			</tr>
		</table>
		用户名：<input type="text" name="username" id="username"><br>
		密码：<input type="password" name="psw" id="psw"><br> 确认密码：<input
			type="password" name="psw2" id="psw2"><br> <input
			type="submit" value="提交">
	</form>
</body>
</html>
