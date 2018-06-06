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
<title>模具保养日志管理</title>
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
						<h4>模具保养日志管理</h4>
					</div>
				</div>
				<div class="row-fluid filter-block">
					<form id="searchForm" action="mouldManage?method=mould_log_sel" method="post">
						<div class="pull-right">
							<input type="text" class="search" name="mould_log_code"
								placeholder="请输入模具日志编号关键字" /> <input type="hidden" id="pageNum"
								name="pageNum" value="${data.totalPage }"> <input
								type="hidden" id="page" name="page"
								value="${data.page==0 ? 1: data.page}" /> <a
								class="btn-flat success new-product" onclick="searchBtn('q')">查询</a>
						</div>
					</form>
				</div>

				<div class="row-fluid">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="span1">序号</th>
								<th class="span1"><span class="line"></span>模具日志编号</th>
								<th class="span2"><span class="line"></span>模具日志名称</th>
								<th class="span1"><span class="line"></span>模具编号</th>
								<th class="span3"><span class="line"></span>保养内容</th>
								<th class="span1"><span class="line"></span>计划保养模次数</th>
								<th class="span1"><span class="line"></span>实际保养模次数</th>
								<th class="span1"><span class="line"></span>记录状态</th>
								<th class="span1"><span class="line"></span>创建时间</th>
								<th class="span1"><span class="line"></span>操作</th>
							</tr>
						</thead>
						<tbody>
							<!-- row -->
							<c:forEach items="${data.list }" var="b" varStatus="s">
								<tr>
									<td>${s.count }</td>
									<td>${b.mouldLogCode }</td>
									<td>${b.mouldLogName }</td>
									<td>${b.mouldId }</td>
									<td>${b.mouldLogContext }</td>
									<td>${b.mouldPlanTimes }/次</td>
									<td>${b.mouldRealTimes }/次</td>
									<td><tag:enum className="MouldLogEnum">${b.mouldLogStatus }</tag:enum></td>					
									<td><fmt:formatDate value="${b.mouldLogCreateTime }"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td><ul class="actions">
										<c:if test="${b.mouldLogStatus eq '1' }">
											<li><a onclick="edit(${b.id })">完成保养</a></li>
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
	
			
			function edit(id){
				var index = layer.open({
					type:2,
					title:'确认模具保养记录',
					area : [ '600px', '544px' ],
					shadeClose : false, //点击遮罩关闭
					content: 'mouldManage?method=mould_log_sel_id&id='+id
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