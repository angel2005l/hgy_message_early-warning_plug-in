<%@ include file="../../view/base/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Object obj = session.getAttribute("isLogin");
	if (null == obj || !Boolean.parseBoolean(obj.toString())) {
		 response.getWriter().write("<script>window.parent.location='"+basePath+"/warn/view/login.jsp'</script>");
	}
%>
<!DOCTYPE html>
<html style="margin-top: 30px">
<head>
<title>员工信息管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<base href="<%=basePath%>warn/">
<link rel="stylesheet" href="theme/default/layer.css" />
<link rel="stylesheet" href="css/compiled/tables.css" type="text/css"
	media="screen" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<div class="container-fluid">
		<div id="pad-wrapper">
			<!-- products table-->
			<!-- the script for the toggle all checkboxes from header is located in js/theme.js -->
			<div class="table-wrapper products-table section">
				<div class="row-fluid head">
					<div class="span12">
						<h4>员工信息管理</h4>
					</div>
				</div>
				<div class="row-fluid filter-block">
					<form id="searchForm" action="userManage?method=user_sel"
						method="post">
						<div class="pull-right">
							<input type="text" class="search" name="user_name"
								placeholder="请输入员工姓名关键字" /> <input type="hidden" id="pageNum"
								name="pageNum" value="${data.totalPage }"> <input
								type="hidden" id="page" name="page"
								value="${data.page==0 ? 1: data.page}" /> <a
								class="btn-flat success new-product" onclick="searchBtn('q')">查询</a>
							<a class="btn-flat success new-product" onclick="addUser()">添加员工信息</a>
							<a class="btn-flat success new-product" onclick="batchUser()">批量添加员工信息</a>
						</div>
					</form>
				</div>

				<div class="row-fluid">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="span1">序号</th>
								<th class="span1"><span class="line"></span>员工工号</th>
								<th class="span1"><span class="line"></span>员工姓名</th>
								<th class="span1"><span class="line"></span>员工微信识别码</th>
								<th class="span1"><span class="line"></span>员工邮箱</th>
								<th class="span1"><span class="line"></span>员工号码</th>
								<th class="span1"><span class="line"></span>员工通知层级</th>
								<th class="span1"><span class="line"></span>员工状态</th>
								<th class="span1"><span class="line"></span>操作</th>
							</tr>
						</thead>
						<tbody>
							<!-- row -->
							<c:forEach items="${data.list }" var="b" varStatus="s">
								<tr>
									<td>${s.count }</td>
									<td>${b.userCode }</td>
									<td>${b.userName }</td>
									<td>${b.userToken }</td>
									<td>${b.userEmail }</td>
									<td>${b.userPhone }</td>
									<td><tag:enum className="LevelTypeEnum">${b.userLevel }</tag:enum>
									</td>
									<td><span
										<c:choose>
										<c:when test="${b.userStatus!=1 }">class="label label-warning"</c:when>
										<c:otherwise>class="label label-success"</c:otherwise>
									</c:choose>><tag:enum
												className="CommonEnum">${b.userStatus }</tag:enum></span></td>
									<td>
										<ul class="actions">
											<li><a onclick="edit(${b.id })">编辑</a></li>
											<li class="last"><a onclick="del(${b.id })">删除</a></li>
										</ul>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="pagination pull-right">
					<ul id="pagingBtn">
					</ul>
				</div>
			</div>
			<!-- end products table -->
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			var pageNum = $("#pageNum").val();
			var pagingBth = $("#pagingBtn");
			pagingBth.empty();
			var htmlStr = "<li><a onclick=searchBtn('back')>&#8249;</a></li>";
			  for(var index=0 ;index < (pageNum ==0? 1: pageNum);index++){
				htmlStr += "<li><a onclick=searchBtn('"+(index+1)+"')>"+(index+1)+"</a></li>";
			}  
			htmlStr += "<li><a onclick=searchBtn('next')>&#8250;</a></li>";
			pagingBth.append(htmlStr);
		});
		
		function batchUser(){
			layer.open({
				type: 2,
				title:'批量添加员工信息',
				area: ['600px', '299px'],
				shadeClose: false, //点击遮罩关闭
				content: 'view/user/batchLayer.jsp'
//				content:'grids.html'
			})
		}
	
			function addUser() {
				layer.open({
					type: 2,
					title:'添加员工信息',
					area: ['600px', '550px'],
					shadeClose: false, //点击遮罩关闭
					content: 'view/user/addLayer.jsp'
//					content:'grids.html'
				});
			}
			
			function edit(id){
				layer.open({
					type:2,
					title:'修改员工信息',
					area : [ '600px', '550px' ],
					shadeClose : true, //点击遮罩关闭
					content: 'userManage?method=user_sel_id&id='+id
				});
			}
			function del(id){
				$.ajax({
					url:'userManage?method=user_del',
					type:'post',
					dataType:'json',
					data:{"id":id},
					success:function(result){
						alert(result.msg)
						location.reload();
					},
					error:function(){
						alert("服务未响应");
					}
				});
			}
			function searchBtn(msg){
				var page = $("#page");
				var pageNum = $("#pageNum").val();
				switch (msg) {
				case "q":
					page.val(1);
					break;
				case "back":
					if(page.val()>1){
						page.val(page.val()-1)
					}				
					break;
				case"next":
					if(page.val() < pageNum){
						page.val((page.val()-0+1));
					}
					break;
				default:
					page.val(parseInt(msg));
					break;
				}
				$("#searchForm").submit();
			}
		</script>
</body>
</html>