<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
	<h1>你好，这是你在 Spring MVC 世界中创建的首页</h1> 
	<h2>测试1</h2>
	测试名称 ： get方法传递参数到后台，再返回前台展示,return show
	测试路径： http://localhost:8085/springmvc/parameterController/param?userName=123
	<h2>测试2</h2>
	测试名称 ： get方法传递参数到后台，再返回前台展示,return ModelAndView
	测试路径： http://localhost:8085/springmvc/parameterController/mav?userName=123
	<h2>测试3</h2>
	测试名称 ： get 实体转json，再返回前台展示,return usermodel
	测试路径： http://localhost:8085/springmvc/parameterController/usermodel

</body>
</html>