<%@ include file="../../view/base/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>产品图片弹窗</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- this page specific styles -->
<link rel="stylesheet"
	href="css/compiled/personal-info.css" type="text/css"
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
	<!-- main container .wide-content is used for this layout without sidebar :)  -->
	<div class="content wide-content">
		<div class="container-fluid">
			<div class="settings-wrapper" id="pad-wrapper">
				<!-- avatar column -->
				<div class="span1 avatar-box"></div>
				<!-- edit form column -->
				<div class="span7 personal-info">
					<form id="tableForm" enctype="multipart/form-data">
						<div class="field-box">
							<label>图片标题:</label> <input class="span5 inline-input"
								name="title" type="text" placeholder="请输入图片标题..." />
						</div>
						<div class="field-box">
							<label>序号:</label> <input class="span5 inline-input" type="text"
								name="sort" placeholder="请输入序号..." />
						</div>
						<div class="field-box">
							<label>图片文件:</label> <input type="file" id="upLoad" name="img" />
						</div>
						<div class="field-box">
							<label>所属产品</label>
							<div class="ui-select">
								<select id="pid" name="pid">
									<option value="" selected="selected">未绑定</option>
								</select>
							</div>
						</div>
						<div class="field-box">
							<label>图片类型</label>
							<div class="ui-select">
								<select name="img_type">
									<option value="1" selected="selected">产品图片</option>
									<option value="2">产品详情图片</option>
								</select>
							</div>
						</div>
						<div class="field-box" style="height: 37px;">
							<label>是否主图:</label> <label style="width: 20%;"><input
								type="radio" name="is_main" value="1" />是</label> <label
								style="width: 20%; float: left;"><input type="radio"
								name="is_main" value="0" checked="checked" />否</label>
						</div>
						<div class="field-box" style="height: 37px;">
							<label>状态:</label> <label style="width: 20%;"><input
								type="radio" name="status" value="1" checked="checked" />正常</label> <label
								style="width: 20%; float: left;"><input type="radio"
								name="status" value="2" />锁定</label>
						</div>
						<div class="alert alert-info">
							<i class="icon-exclamation-sign"></i>请认真填写产品图片信息
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
	<script src="js/jquery.form.js"></script>
	<script>
	$(function(){
		var selectObj =$("#pid");
		$.ajax({
			url:'productManage?method=product_id_productName',
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
		})
	});
	
		var index = parent.layer.getFrameIndex(window.name);
		$("#sumbit_form").on("click",function(){
			var fileUrl =$("#upLoad").val();
			 if(checkExcel(fileUrl)){
				$("#tableForm").ajaxSubmit({
				url:'productManage?method=product_img_ins',
				type:'post',
				dataType : "json",
				success:function(result){
					alert(result.msg);
					if(result.code == 0){
						parent.location.href='productManage?method=product_img_sel';
						parent.layer.close(index);
					} else {
						return;
						}
					},
					error : function() {
						alert("服务未响应");
						}
					});
				}
			 });
		$("#close_win").on("click", function() {
			parent.layer.close(index);
		})
		function checkExcel() {
			var fileUrl =$("#upLoad").val();
			if (fileUrl.indexOf(" ") >= 0) {
				alert("文件名不能有空格");
				return false;
			}
			var re = /(\\+)/g;
			var filename = fileUrl.replace(re, "#");
			var one = filename.split("#");
			var two = one[one.length - 1];
			var three = two.split(".");
			var last = three[three.length - 1];
			var tp = "jpge,png";
			var rs = tp.indexOf(last);
			if (rs >= 0) {
				return true;
			} else {
				alert("当前只支持文件扩展名为jpge/png的图片文件！");
				return false;
			}
		}
	</script>
</body>

</html>