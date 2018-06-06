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
<title>预警类别管理</title>
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
						<h4>预警类别管理</h4>
					</div>
				</div>
				<div class="row-fluid filter-block">
					<form id="searchForm" action="warningManage?method=warning_sel"
						method="post">
						<div class="pull-right">
							<input type="text" class="search" name="event_name"
								placeholder="请输入预警类别名称关键字" /> <input type="hidden" id="pageNum"
								name="pageNum" value="${data.totalPage }"> <input
								type="hidden" id="page" name="page"
								value="${data.page==0 ? 1: data.page}" /> <a
								class="btn-flat success new-product" onclick="searchBtn('q')">查询</a>
							<a class="btn-flat success new-product" onclick="addWarnType()">添加预警类别</a>
							<a class="btn-flat success new-product"
								onclick="batchBoundRule()">快速绑定推送规则</a> <a
								class="btn-flat success new-product" onclick="synchro()">同步预警类别</a>
						</div>
					</form>
				</div>

				<div class="row-fluid">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="span2">序号</th>
								<th class="span2"><span class="line"></span>事件编号</th>
								<th class="span2"><span class="line"></span>事件编码</th>
								<th class="span2"><span class="line"></span>事件名称</th>
								<th class="span2"><span class="line"></span>预警规则编码</th>
								<th class="span1"><span class="line"></span>事件状态</th>
								<th class="span2"><span class="line"></span>操作</th>
							</tr>
						</thead>
						<tbody>
							<!-- row -->
							<c:forEach items="${data.list }" var="b" varStatus="s">
								<tr>
									<td>${s.count }</td>
									<td>${b.eventId }</td>
									<td>${b.eventCode }</td>
									<td>${b.eventName }</td>
									<td>${b.ruleCode }</td>
									<td><span
										<c:choose>
										<c:when test="${b.eventStatus !=1 }">class="label label-warning"</c:when>
										<c:otherwise>class="label label-success"</c:otherwise>
									</c:choose>><tag:enum
												className="EventStatusEnum">${b.eventStatus }</tag:enum></span></td>
									<td><ul class="actions">
											<li><a onclick="edit(${b.id })">绑定推送规则</a></li>
											<c:if test="${b.eventStatus ==1 }">
												<li class="last"><a onclick="disable(${b.id })">不启用</a></li>
											</c:if>
											<c:if test="${b.eventStatus ==2 }">
												<li class="last"><a onclick="enabled(${b.id })">启用</a></li>
											</c:if>
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
	
			function addWarnType() {
				var index = layer.open({
					type: 2,
					title:'添加预警类别',
					area: ['600px', '500px'],
					shadeClose: false, //点击遮罩关闭
					content: 'view/warning/addLayer.jsp'
//					content:'grids.html'
				});
			}
			
		function edit(id){
			layer.open({
				type:2,
				title:'绑定预警类别',
				area : [ '600px', '417px' ],
				shadeClose : true, //点击遮罩关闭
				content: 'warningManage?method=warning_sel_id&id='+id
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
			
			function disable(id) {
				$.ajax({
					url:'warningManage?method=warning_upt_event_status',
					type:'post',
					dataType:'json',
					data:{"id":id,"eventStatus":"2"},
					success:function(result){
						alert(result.msg)
						location.reload();
					},
					error:function(){
						alert("服务未响应");
					}
				});
			}
			function enabled(id) {
				$.ajax({
					url:'warningManage?method=warning_upt_event_status',
					type:'post',
					dataType:'json',
					data:{"id":id,"eventStatus":"1"},
					success:function(result){
						alert(result.msg)
						location.reload();
					},
					error:function(){
						alert("服务未响应");
					}
				});
			}
			
			function batchBoundRule(){
				layer.open({
					type:2,
					title:'批量绑定预警类别',
					area : [ '600px', '340px' ],
					shadeClose : true, //点击遮罩关闭
					content: 'view/warning/batchLayer.jsp'
				});
			}
			
			function synchro(){
				$.ajax({
					url:'warningManage?method=warning_synchrodata',
					type:'post',
					dataType:'json',
					success:function(result){
						alert(result.msg)
						location.reload();
					},
					error:function(){
						alert("服务未响应");
					}
				})
			}
			
		</script>
</body>
</html>