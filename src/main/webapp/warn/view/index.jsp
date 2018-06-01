<%@ include file="../view/base/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Object obj = session.getAttribute("isLogin");
	if (null == obj || !Boolean.parseBoolean(obj.toString())) {
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>新海集团_MES预警通知辅助系统</title>
<base href="<%=basePath%>warn/">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- libraries -->
<link href="css/lib/jquery-ui-1.10.2.custom.css" rel="stylesheet"
	type="text/css" />

<!-- this page specific styles -->
<link rel="stylesheet" href="css/compiled/index.css" type="text/css"
	media="screen" />
</head>

<body>

	<!-- navbar -->
	<div class="navbar navbar-inverse">
		<div class="navbar-inner">
			<a class="brand" href="javascript:void(0)"><i class="icon-fire"></i>&nbsp;&nbsp;&nbsp;<img
				src="img/logo_simple.png" /></a>
			<ul class="nav pull-right">
				<li class="dropdown"><a href="#"
					class="dropdown-toggle hidden-phone" data-toggle="dropdown">
						账户信息 <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">Personal info</a></li>
						<li><a href="#">Account settings</a></li>
						<li><a href="#">Billing</a></li>
						<li><a href="#">Export your data</a></li>
						<li><a href="#">Send feedback</a></li>
					</ul></li>
				<li class="settings hidden-phone"><a
					href="userManage?method=logout" role="button"> <i
						class="icon-share-alt"></i>
				</a></li>
			</ul>
		</div>
	</div>
	<!-- end navbar -->

	<!--左侧导航栏-->
	<!-- sidebar -->
	<div id="sidebar-nav">
		<ul id="dashboard-menu">
			<li class="left-nav-li active">
				<div class="pointer">
					<div class="arrow"></div>
					<div class="arrow_border"></div>
				</div> <a href="view/index.jsp"> <i class="icon-fire"></i> <span>主页</span>
			</a>
			</li>
			<li class="left-nav-li"><a class="dropdown-toggle"> <i
					class="icon-comment"></i> <span>预警管理</span>
			</a>
				<ul class="submenu">
					<li><a class="func" href="warningManage?method=warning_sel"
						target="mainFrame">预警类别</a></li>
					<!-- <li>
							<a class="func" href="newsManage?method=news_type_sel" target="mainFrame">模具类别</a>
						</li> -->
				</ul></li>
			<li class="left-nav-li"><a class="dropdown-toggle" href="#">
					<i class="icon-cog"></i> <span>员工管理</span>
			</a>
				<ul class="submenu">
					<li><a class="func" href="userManage?method=user_sel"
						target="mainFrame">员工信息</a></li>
				</ul></li>
			<li class="left-nav-li"><a class="dropdown-toggle" href="#">
					<i class="icon-cog"></i> <span>系统管理</span>
			</a>
				<ul class="submenu">
					<li><a class="func" href="taskManage?method=task_sel"
						target="mainFrame">调度任务</a></li>
					<li><a class="func" href="prManage?method=pr_sel"
						target="mainFrame">推送规则</a></li>
				</ul></li>
		</ul>
	</div>
	<!-- end sidebar -->

	<!-- main container -->
	<div class="content">
		<div class="frame-div">
			<iframe class="frame" id="mainFrame" name="mainFrame"
				src="view/fixError.jsp"></iframe>
		</div>
	</div>

	<!-- scripts -->
	<script src="js/jquery-ui-1.10.2.custom.min.js"></script>
	<!-- knob -->
	<script src="js/jquery.knob.js"></script>
	<!-- flot charts -->
	<script src="js/jquery.flot.js"></script>
	<script src="js/jquery.flot.stack.js"></script>
	<script src="js/jquery.flot.resize.js"></script>

	<script type="text/javascript">
		var height = jQuery(window).height();
		var width = jQuery(window).width();
		$("body").attr("height", height + "px;").attr("width", width + "px;");

		$("#mainFrame").attr("height", height - 60 + "px;");
		$(".left-nav-li")
				.click(
						function() {
							$(".active").removeClass("active");
							$(".pointer").remove();
							$(".submenu").css("display", "none");
							$(this).children(".submenu")
									.css("display", "block");
							$(this).addClass("active");
							$(this)
									.prepend(
											"<div class='pointer'><div class='arrow'></div><div class='arrow_border'></div></div>");
						})
	</script>

</body>

</html>
