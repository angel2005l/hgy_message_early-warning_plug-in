<%@ include file="../../view/base/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>新闻图片弹窗</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- this page specific styles -->
<link rel="stylesheet"
	href="<%=basePath%>css/compiled/personal-info.css" type="text/css"
	media="screen" />

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
	<input type="hidden" id="aidCode" value="${data.data.aid }">
	<!-- main container .wide-content is used for this layout without sidebar :)  -->
	<div class="content wide-content">
		<div class="container-fluid">
			<div class="settings-wrapper" id="pad-wrapper">
				<!-- avatar column -->
				<div class="span1 avatar-box"></div>
				<!-- edit form column -->
				<div class="span7 personal-info">
					<form id="tableForm" enctype="multipart/form-data">
						<input type="hidden" name="id" value="${data.data.id }">
						<div class="field-box">
							<label>图片标题:</label> <input class="span5 inline-input"
								name="title" type="text" placeholder="请输入图片标题..."
								value="${data.data.title }" />
						</div>
						<div class="field-box" style="max-width:600px;max-height:300px;">
								<label>图片详情</label>
                                <img src="<%=imgRootUrl %>${data.data.url }" />
                            </div>
						<div class="field-box">
							<label>所属文章</label>
							<div class="ui-select">
								<select id="aid" name="aid">
									<option value="" selected="selected">未绑定</option>
								</select>
							</div>
						</div>
						<div class="field-box">
							<label>状态:</label> <label style="width: 20%;"><input
								type="radio" name="status" value="1"
								<c:if test="${data.data.status ==1 }">checked="checked" </c:if> />正常</label>
							<label style="width: 20%; float: left;"><input
								type="radio" name="status" value="2"
								<c:if test="${data.data.status ==2 }">checked="checked"</c:if> />锁定</label>
						</div>
						<div class="alert alert-info">
							<i class="icon-exclamation-sign"></i>请认真填写新闻图片信息
						</div>
						<div class="field-box actions">
							<input id="sumbit_form" type="button" class="btn-flat primary"
								value="保存" /> <input id="close_win" type="button"
								class="btn-flat danger" value="取消" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- end main container -->

	<!-- scripts -->
	<script src="<%=basePath%>js/jquery.form.js"></script>
	<script>
	$(function(){
		var selectObj =$("#aid");
		$.ajax({
			url:'<%=basePath%>newsManage?method=news_sel_id_name',
			type:'post',
			dataType:'json',
			async:false,
			success:function(result){
					selectObj.empty();
					selectObj.append($("<option />").text("未绑定").attr("value","").attr("selected","selected"));
				if(result.code ==0){
					$(result.data).each(function(){
						selectObj.append($("<option />").text(this.value).attr("value",this.code));
					})
				}else{
					alert(result.msg);
				}
			},
			error:function(){
				alert("服务未响应")
			}
		});
		
		$("#aid option").each(function(){
			if(this.value == $("#aidCode").val()){
				 $(this).attr("selected","selected");
				return;
			}
		})
	});
	
	
		var index = parent.layer.getFrameIndex(window.name);
		$("#sumbit_form").on("click",function(){
			$("#tableForm").ajaxSubmit({
				url:'<%=basePath%>newsManage?method=news_img_upt',
				type:'post',
				dataType : "json",
				success:function(result){
					alert(result.msg);
					if(result.code == 0){
						parent.location.href='<%=basePath%>newsManage?method=news_img_sel';
						parent.layer.close(index);
						} else {
							return;
							}
					},
					error : function() {
						alert("服务未响应");
						}
					});
			});
		$("#close_win").on("click", function() {
			parent.layer.close(index);
		})
	</script>
</body>

</html>