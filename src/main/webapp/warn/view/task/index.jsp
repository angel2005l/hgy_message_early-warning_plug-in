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
<title>调度任务管理</title>
<base href="<%=basePath%>warn/">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

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
						<h4>调度任务管理</h4>
					</div>
				</div>
				<div class="row-fluid filter-block">
					<form id="searchForm" action="taskManage?method=task_sel"
						method="post">
						<div class="pull-right">
							<input type="text" class="search" name="task_name"
								placeholder="请输入调度任务名称关键字" /> <input type="hidden" id="pageNum"
								name="pageNum" value="${data.totalPage }"> <input
								type="hidden" id="page" name="page"
								value="${data.page==0 ? 1: data.page}" /> <a
								class="btn-flat success new-product" onclick="searchBtn('q')">查询</a>
							<a class="btn-flat success new-product" onclick="addTask()">添加调度任务</a>
						</div>
					</form>
				</div>

				<div class="row-fluid">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="span1">序号</th>
								<th class="span2"><span class="line"></span>任务编码</th>
								<th class="span2"><span class="line"></span>任务名称</th>
								<th class="span1"><span class="line"></span>任务类型</th>
								<th class="span2"><span class="line"></span>任务执行类型</th>
								<th class="span2"><span class="line"></span>最后一次执行时间</th>
								<th class="span2"><span class="line"></span>状态</th>
								<th class="span2"><span class="line"></span>操作</th>
							</tr>
						</thead>
						<tbody>
							<!-- row -->
							<c:forEach items="${data.list }" var="b" varStatus="s">
								<tr>
									<td>${s.count }</td>
									<td>${b.taskCode }</td>
									<td>${b.taskName }</td>
									<td><tag:enum className="TaskEnum">${b.taskType }</tag:enum></td>
									<td><tag:enum className="TaskEnum">${b.taskRunType }</tag:enum></td>
									<td><fmt:formatDate value="${b.taskLastExecuteTime }"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>

									<td><span
										<c:choose>
										<c:when test="${b.status eq 'N' }">class="label label-warning"</c:when>
										<c:otherwise>class="label label-success"</c:otherwise>
									</c:choose>><tag:enum
												className="TaskEnum">${b.status }</tag:enum></span></td>
									<td><ul class="actions">
											<li><a onclick="edit(${b.id })">编辑</a></li>
											<li class="last"><a onclick="del(${b.id })">删除</a></li>
										</ul></td>
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
		})
	
			function addTask() {
				var index = layer.open({
					type: 2,
					title:'添加调度任务',
					area: ['600px', '555px'],
					shadeClose: false, //点击遮罩关闭
					content: 'view/task/addLayer.jsp'
//					content:'grids.html'
				});
			}
			
			function edit(id){
				var index = layer.open({
					type:2,
					title:'修改调度任务',
					area : [ '600px', '555px' ],
					shadeClose : false, //点击遮罩关闭
					content: 'taskManage?method=task_sel_id&id='+id
				});
			}
			function del(id){
				$.ajax({
					url:'taskManage?method=task_del',
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