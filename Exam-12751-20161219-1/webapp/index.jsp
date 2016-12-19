<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电脑租赁系统</title>
</head>
<body>
	<c:if test="${!empty customer}">
		<c:out value="欢迎${customer.firstName}登录"></c:out>
	</c:if>
	<c:if test="${empty customer}">
		<a href="login.jsp">登录</a>
	</c:if>
	<hr />
	<a href="film.action?code=4&page=1&num=10">查看电影</a>
</body>
</html>