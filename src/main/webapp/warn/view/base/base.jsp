<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="tag" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath %>warn/">
<!-- bootstrap -->
<link href="css/bootstrap/bootstrap.css" rel="stylesheet" />
<link href="css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
<link href="css/bootstrap/bootstrap-overrides.css"	type="text/css" rel="stylesheet" />

<!-- global styles -->
<link rel="stylesheet" type="text/css" href="css/layout.css" />
<link rel="stylesheet" type="text/css" href="css/elements.css" />
<link rel="stylesheet" type="text/css" href="css/icons.css" />

<!-- libraries -->
<link href="css/lib/font-awesome.css" type="text/css" rel="stylesheet" />

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/theme.js"></script>

<script type="text/javascript" src="js/layer.js"></script>
</head>
<body>
</body>
</html>