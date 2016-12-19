<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改电影</title>
</head>
<body>

	<form action="film.action" method="post">
		<input type="hidden" name="code" value="3" /> <input type="hidden"
			name="edit" value="2" /> <input type="hidden" name="flim_id"
			value="${editFilm.filmId}" /> <input type="text" name="title"
			value="${editFilm.title}" /> <br /> <input type="text"
			name="description" value="${editFilm.description}" /> <br /> <select
			name="language_id">
			<c:forEach items="${languageList}" var="item">
				<option value="${item.languageId}">${item.name}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="提交" />
	</form>

</body>
</html>