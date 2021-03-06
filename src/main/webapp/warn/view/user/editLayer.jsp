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
					<form id="tableForm">
						<input name="id" type="hidden" value="${data.data.id }">
						<div class="field-box">
						<label>员工工号:</label> <input class="span5 inline-input"
								type="text" name="userCode" value="${data.data.userCode }" readonly />
						</div>
						<div class="field-box">
							<label>员工姓名:</label> <input class="span5 inline-input"
								type="text" name="userName" value="${data.data.userName }" readonly />
						</div>
						<div class="field-box">
							<label>*员工微信识别码:</label> <input class="span5 inline-input"
								type="text" name="userToken" value="${data.data.userToken }"  placeholder="请输入员工微信识别码..." />
						</div>
						<div class="field-box">
							<label>员工邮箱:</label> <input class="span5 inline-input"
								type="text" name="userEmail" value="${data.data.userEmail }" placeholder="请输入员工邮箱..." />
						</div>
						<div class="field-box">
							<label>员工手机号码:</label> <input class="span5 inline-input"
								type="text" name="userPhone" value="${data.data.userPhone }" placeholder="请输入员工手机号码..." />
						</div>
						<div class="field-box">
							<label>*通知层级</label>
							<div class="ui-select">
								<select name="userLevel">
									<option value="">请选择通知层级</option>
									<option value="1" <c:if test="${data.data.userLevel ==1 }">selected="selected"</c:if> >第一通知级</option>
									<option value="2" <c:if test="${data.data.userLevel ==2 }">selected="selected"</c:if>>第二通知级</option>
									<option value="3" <c:if test="${data.data.userLevel ==3 }">selected="selected"</c:if>>第三通知级</option>
									<option value="4" <c:if test="${data.data.userLevel ==4 }">selected="selected"</c:if>>第四通知级</option>
								</select>
							</div>
						</div>
						<div class="field-box">
							<label>*员工状态:</label> <label style="width: 20%;"><input
								type="radio" name="userStatus" value="1" <c:if test="${data.data.userStatus ==1 }">checked="checked"</c:if> />正常</label>
							<label style="width: 20%; float: left;"><input
								type="radio" name="userStatus" value="2" <c:if test="${data.data.userStatus ==2 }">checked="checked"</c:if>/>其他</label>
						</div>
						<div id="alert" class="alert alert-info">
							<i class="icon-exclamation-sign"></i>请认真填写员工信息,*为必填字段
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
			if(check()){
				$("#tableForm").ajaxSubmit({
					url:'userManage?method=user_upt',
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
		
		function check(){
			var userCode = $("input[name='userCode']").val();
			var userName = $("input[name='userName']").val();
			var userToken = $("input[name='userToken']").val();
			var userLevel = $("input[name='userLevel']").val();
			var isChecked = $("input[name='userStatus']").is(":checked");
			var msg = ""
			var isSuccess = true;
			if(userToken==""){
				msg="请填写员工微信识别码。";
				isSuccess =false;
			}else if(userLevel==""){
				msg="请选择通知层级。";
				isSuccess =false;
			}else if(!isChecked){
				msg="请选择员工状态。";
				isSuccess =false;
			}
			
			if(isSuccess){
				return true;
			}else{
				changeAlert(msg);
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