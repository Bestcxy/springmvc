<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/home.js"></script>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<h1>你好，这是你在 Spring MVC 世界中创建的首页</h1> 
	<h2>测试1</h2>
	测试名称 ： get方法传递参数到后台，再返回前台展示,return show
	测试路径： <a href="http://localhost:8085/springmvc/parameterController/param?userName=123" target="_blank">http://localhost:8085/springmvc/parameterController/param?userName=123</a>
	<h2>测试2</h2>
	测试名称 ： get方法传递参数到后台，再返回前台展示,return ModelAndView
	测试路径：  <a href="http://localhost:8085/springmvc/parameterController/mav?userName=123" target="_blank">http://localhost:8085/springmvc/parameterController/mav?userName=123</a>
	<h2>测试3</h2>
	测试名称 ： get 实体转json，再返回前台展示,return usermodel
	测试路径： <a href="http://localhost:8085/springmvc/parameterController/usermodel" target="_blank">http://localhost:8085/springmvc/parameterController/usermodel</a>
	<h2>测试3</h2>
	测试名称：ajax测试
	测试描述：在文本框中输入任意内容，鼠标离开后显示提示信息，当输入“123”时,提示数据尚不存在，其他字符提示数据已存在<br>
	<br>
	输入信息并移开鼠标：<input class="checkUserName" id="userName" name="userName" type="text">
	<span class="col_msgspan"></span>
	<h2>测试获取header</h2>
	测试名称：get方式请求后台，获取header
	请求描述：后台获取header的值
	测试路径:<a href="http://localhost:8085/springmvc/header/get/auto_token" target="_blank">http://localhost:8085/springmvc/header/get/auto_token</a>
	<h2>form表单提交测试</h2>
	<form action="<%=basePath%>parameterController/model" method="post">
		<input name="userName" id="userName">
		<input type="submit" value="提交">
	</form>

</body>
</html>