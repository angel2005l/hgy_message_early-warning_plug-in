<%@ include file="../../view/base/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>产品信息管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="<%=basePath%>theme/default/layer.css" />

<link href="<%=basePath%>css/lib/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>css/compiled/tables.css" type="text/css" media="screen" />
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
						<h4>产品信息管理</h4>
					</div>
				</div>
				<div class="row-fluid filter-block">
				<form id="searchForm"
						action="<%=basePath%>productManage?method=product_sel" method="post">
					<div class="pull-right">
						<input type="text" class="search" name="product_name" placeholder="请输入产品名称关键字"/>
						<input type="hidden" id="pageNum" name="pageNum" value="${data.data.totalPage }">
							<input type="hidden" id="page" name = "page" value="${data.data.page==0 ? 1: data.data.page}" /> <a
								class="btn-flat success new-product" onclick="searchBtn('q')">查询</a> <a
							class="btn-flat success new-product" onclick="addProduct()">添加产品</a>
					</div>
					</form>
				</div>

				<div class="row-fluid">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="span1">序号</th>
								<th class="span2"><span class="line"></span>产品名称</th>
								<th class="span2"><span class="line"></span>产品型号</th>
								<th class="span2"><span class="line"></span>产品原价</th>
								<th class="span2"><span class="line"></span>产品售价</th>
								<th class="span1"><span class="line"></span>排序</th>
								<th class="span1"><span class="line"></span>状态</th>
								<th class="span2"><span class="line"></span>新增时间</th>
								<th class="span2"><span class="line"></span>操作</th>
							</tr>
						</thead>
						<tbody>
							<!-- row -->
							<c:forEach items="${data.data.list }" var="b" varStatus="s">
								<tr>
									<td>${s.count }</td>
									<td>${b.product_name }</td>
									<td>${b.item_no }</td>
									<td><fmt:formatNumber value="${b.original_price }"
											type="currency" pattern="￥.00"></fmt:formatNumber></td>
									<td><fmt:formatNumber value="${b.price }" type="currency"
											pattern="￥.00"></fmt:formatNumber></td>
									<td>${b.sort }</td>
									<td><span
										<c:choose>
										<c:when test="${b.status==0 }">class="label label-important" </c:when>
										<c:when test="${b.status==2 }">class="label label-warning"</c:when>
										<c:otherwise>class="label label-success"</c:otherwise>
									</c:choose>><tag:enum
												className="CommonEnum">${b.status }</tag:enum></span></td>
									<td><fmt:formatDate value="${b.add_time }"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td><c:if test="${b.status!=0 }">
											<ul class="actions">
												<li><a onclick="edit(${b.id })">编辑</a></li>
												<li class="last"><a onclick="del(${b.id })">删除</a></li>
											</ul>
										</c:if></td>
								</tr>
							</c:forEach>
							<!-- row -->
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
		function addProduct() {
			var index = layer.open({
				type : 2,
				title : '添加产品信息',
				area : [ '400px', '500px' ],
				shadeClose : false, //点击遮罩关闭
				content : 'view/product/addLayer.jsp'
			});
			layer.full(index);
		}
		function edit(id){
			var index =layer.open({
				type:2,
				title:'修改产品信息',
				area : [ '400px', '500px' ],
				shadeClose : false, //点击遮罩关闭
				content: '<%=basePath %>productManage?method=product_sel_id&id='+id
			})
			layer.full(index);
		}
		function del(id){
			$.ajax({
				url:'<%=basePath%>productManage?method=product_del',
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
		
		function searchBtn(msg){
			var page = $("#page");
			var pageNum = $("#pageNum").val();
			switch (msg) {
			case "q":
				page.val(1);
				break;
			case "back":
				if(page.val()>1){
					page.val(page.val()-1);
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