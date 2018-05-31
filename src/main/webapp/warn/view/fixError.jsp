<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/warn/";
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>网站正在升级维护中...</title>
<style>
.error_content {
	margin: 30px auto;
	margin-bottom:0;
	width: 900px;
	height: 500px;
	border: 1px solid #cccccc;
}

.error_left {
	margin: 120px 0 0 50px;
	width: 330px;
	height: 345px;
	background: url("<%=basePath%>img/bgs/fixImg.png") no-repeat;
	background-size: 100%;
	float: left;
}

.error_right {
	width: 450px;
	height: 400px;
	float: left;
}

.error_detail {
	margin: 240px 0 0 120px;
	width: 400px;
	height: auto;
}

.error_detail .error_p_title {
	font-size: 28px;
	color: #eb8531;
}

.error_detail .error_p_con {
	font-size: 14px;
	margin-top: 10px;
	line-height: 20px;
}

.sp_con {
	margin-left: 128px;
	color: #1A4EC0;
	margin-top: 35px;
	position: absolute;
	font-size: 18px;
}

.btn_error {
	margin: 80px 0 0 160px;
}

.btn_error a {
	padding: 5px;
	border: 1px solid #CCCCCC;
}

.btn_back1 {
	background: dodgerblue;
	color: #ffffff;
}

.btn_back2 {
	margin-left: 25px;
	background: #CCCCCC;
}

.btn {
	width: 40px;
	height: 38px;
	cursor: pointer;
	color: #FF813B;
	float: right;
	margin-top: 1px;
	border-left: solid 1px #FF813B;
	font-size: 20px;
	background: no-repeat;
}
</style>
</head>

<body>
	<div class="error_content">
		<div class="error_left">
			<span class="sp_con">赶紧修，大家等着呢。</span>
		</div>
		<div class="error_right">
			<div class="error_detail">
				<p class="error_p_title">哎呀~ 主页正在设计中!</p>
				<p class="error_p_con">别急，工程师正在紧急处理，马上就好。</p>
			</div>
		</div>
	</div>

</body>

</html>