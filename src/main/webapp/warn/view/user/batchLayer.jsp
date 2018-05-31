<%@ include file="../../view/base/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>员工信息弹窗</title>
<base href="<%=basePath%>warn/">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- this page specific styles -->
<link rel="stylesheet" href="css/compiled/personal-info.css"
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
					<form id="tableForm" enctype="multipart/form-data">
						<div class="field-box">
							<label>员工信息文件:</label> <input type="file" id="upLoad" name="file" />
						</div>
						<div class="field-box">
							<a href="#">没有模板?</a>
						</div>
						<div id="alert" class="alert alert-info">
							<i class="icon-exclamation-sign"></i>目前只支持Excel文件必须为2007及以上版本,空行请用*代替。
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
	<script type="text/javascript" src="js/jquery.form.js"></script>
	<script>
		var index = parent.layer.getFrameIndex(window.name);
		$("#sumbit_form").on("click",function(){
			if(checkExcel()){
				$("#tableForm").ajaxSubmit({
					url:'userManage?method=user_batch_add',
					type:'post',
					dataType:'json',
					success:function(result){
						alert(result.msg);
						if(result.code == 0){
							parent.location.href='userManage?method=user_sel';
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
		});
		
		function checkExcel() {
			var fileUrl =$("#upLoad").val();
			if (fileUrl.indexOf(" ") >= 0) {
				changeAlert("文件名不能有空格");
				return false;
			}
			var re = /(\\+)/g;
			var filename = fileUrl.replace(re, "#");
			var one = filename.split("#");
			var two = one[one.length - 1];
			var three = two.split(".");
			var last = three[three.length - 1];
			var tp = "xlsx";
			var rs = tp.indexOf(last);
			if (rs >= 0) {
				return true;
			} else {
				changeAlert("当前只支持文件扩展名为.xlsx的Excel2007及以上文件！");
				return false;
			}
		}
		
		function changeAlert(msg){
			var alertDiv = $("#alert");
			alertDiv.removeClass("alert-info");
			alertDiv.addClass("alert-error");
			alertDiv.empty();
			alertDiv.prepend("<i class='icon-remove-sign'></i>"+msg);
		}		
	</script>
</body>

</html>