<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<c:if test="${!empty login_info}">
		<c:out value="${login_info}"></c:out>
	</c:if>
	<form action="customer.action" method="post">
		请输入用户名：<input type="text" name="name" /><br /> 
		<input type="hidden" name="code" value="1" />
		<input type="submit" value="登录" />
	</form>
</body>
</html>