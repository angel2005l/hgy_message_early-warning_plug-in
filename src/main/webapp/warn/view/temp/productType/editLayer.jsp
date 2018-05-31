<%@ include file="../../view/base/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>产品分类弹窗</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />



<!-- this page specific styles -->
<link rel="stylesheet" href="<%=basePath %>css/compiled/personal-info.css"
	type="text/css" media="screen" />

<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
html {
	height: auto;
}
</style>
</head>
<body>
	<!-- main container .wide-content is used for this layout without sidebar :)  -->
	<div class="content wide-content">
		<div class="container-fluid">
			<div class="settings-wrapper" id="pad-wrapper">
				<!-- avatar column -->
				<div class="span1 avatar-box"></div>
				<!-- edit form column -->
				<div class="span7 personal-info">
					<form id="tableForm">
						<input type="hidden" name="id" value="${data.data.id }">
						<div class="field-box">
							<label>产品分类:</label> <input class="span5 inline-input" name ="type_name"
								type="text" placeholder="请输入产品分类..." value="${data.data.type_name }"/>
						</div>
						<!--<div class="field-box">
								<label>产品分类小图标:</label>
								<input class="span5 inline-input"  type="text" placeholder="" />
							</div>-->
						<div class="field-box">
							<label>序号:</label> <input class="span5 inline-input" type="text" name="sort"
								placeholder="请输入序号..." value="${data.data.sort }" />
						</div>
						<div class="field-box">
							<label>所属产品分类</label>
							<div class="ui-select">
								<select id="fid" name="fid">
									<option value="0">主级产品分类</option>
									<c:forEach items="${select.data }" var="b" >
										<option value="${b.code }" <c:if test="${b.code == data.data.id }"> selected="selected"</c:if> >${b.value }</option>
									</c:forEach>
									<option value="CGYL-001">常规医疗用品</option>
									<option value="ZNYL-001">智能化医疗用品</option>
								</select>
							</div>
						</div>
						<div class="field-box">
							<label>状态:</label> <label style="width: 20%;"><input
								type="radio" name="status" value="1" <c:if test="${data.data.status==1 }">checked="checked"</c:if> />正常</label> <label
								style="width: 20%; float: left;"><input type="radio"
								name="status" value="2" <c:if test="${data.data.status==2 }">checked="checked"</c:if> />锁定</label>
						</div>
						<div class="alert alert-info">
							<i class="icon-exclamation-sign"></i>请认真填写产品分类信息
						</div>
						<div class="field-box actions">
							<input id="sumbit_form" type="button" class="btn-flat primary" value="保存" /> <input
								id="close_win" type="button" class="btn-flat danger" value="取消" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- end main container -->

	<!-- scripts -->
	<script src="<%=basePath %>js/jquery.form.js"></script>
	
		<script>
		var index = parent.layer.getFrameIndex(window.name);
		$("#sumbit_form").on("click",function(){
			$("#tableForm").ajaxSubmit({
				url:'<%=basePath %>productManage?method=product_type_upt',
				type:'post',
				dataType : "json",
				success:function(result){
					alert(result.msg);
					if(result.code == 0){
						parent.location.href='<%=basePath %>productManage?method=product_type_sel';
						parent.layer.close(index);
					}else{
						return ;
					}
				},
				error:function(){
					alert("服务未响应");
				}
			});
		})
		$("#close_win").on("click", function() {
			parent.layer.close(index);
		})
	</script>
</body>

</html>