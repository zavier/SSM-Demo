<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<button id="add">添加</button>
	<button id="delete">删除</button>
	<button id="search">查找所有</button>
	
	<table id="userListTable" border="1px">
		
	</table>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/index.js"></script>
</body>
</html>