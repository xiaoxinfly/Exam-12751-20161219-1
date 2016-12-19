<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影列表</title>
<link rel="stylesheet" type="text/css" href="css/mycss.css" />
<script type="text/javascript" src="javascript/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		var page = ${pageUtil.getPage()};
		var maxpage = ${pageUtil.getAllpage()};
		if(page==1){
			$('#head_page,#up_page').attr("href","javascript:return false")
			$('#head_page,#up_page').css({"opacity":" 0.2"});
		}
		if(page==maxpage){
			$('#down_page,#footer_page').attr("href","javascript:return false")
			$('#down_page,#footer_page').css({"opacity":" 0.2"});
		}
		
		$('#select_num').change(function(){
			var num = $('#select_num').val();
			$.ajax({
				type:'post',
				url:'film.action',
				data:{'num':num,'code':5}
			}); 
		});
	});
</script>
</head>
<body>
	<div id="film_list">
	<a href="film.action?code=1&edit=1">添加</a>
		<ul id="list_ul">
			<li class="list_head">film_id</li>
			<li class="list_head">title</li>
			<li class="list_head">description</li>
			<li class="list_head">language</li>
			<li class="list_head">operation</li>

			<c:forEach items="${filmList}" var="item">
				<li class="list_body">${item.filmId}</li>
				<li class="list_body">${item.title}</li>
				<li class="list_body">${item.description}</li>
				<li class="list_body">${item.languageName}</li>
				<li class="list_body"><a id="update_film"
					href="film.action?code=3&edit=1&flim_id=${item.filmId}">编辑</a> <a id="delete_film"
					href="film.action?code=2&flim_id=${item.filmId}">删除</a></li>
			</c:forEach>
		</ul>

		<ul id="page_ul">
			<li>一次显示 <select id="select_num">
			<option selected="selected">${pageUtil.getSum()}</option>
			<option value="10"> 10 </option>
					<option value="15">15</option>
					<option value="20">20</option></select> 条
			</li>
			<li>&nbsp;总共${pageUtil.getAllpage()}页 ${pageUtil.getCount()}条记录</li>
			<li class="page_li"> &nbsp;<a id="head_page" href="film.action?code=4&page=1">首页</a></li>
			<li class="page_li"> &nbsp;<a id="up_page" href="film.action?code=4&page=${pageUtil.getPage()-1}">上一页</a></li>
			<li class="page_li"> &nbsp;第${pageUtil.getPage()}页&nbsp;</li>
			<li class="page_li"><a id="down_page" href="film.action?code=4&page=${pageUtil.getPage()+1}"> 下一页</a></li>
			<li class="page_li"> &nbsp;<a id="footer_page" href="film.action?code=4&page=${pageUtil.getAllpage()}">尾页</a></li>
		</ul>
	</div>
</body>
</html>