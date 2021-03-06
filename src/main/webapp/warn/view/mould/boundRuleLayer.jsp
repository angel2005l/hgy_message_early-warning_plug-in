<%@ include file="../../view/base/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>模具信息弹窗</title>
<base href="<%=basePath%>warn/">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- this page specific styles -->
<link rel="stylesheet" href="css/compiled/personal-info.css"
	type="text/css" media="screen" />
		<link rel="stylesheet" type="text/css" href="css/datetime/bootstrap-datetimepicker.min.css" />
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
	<input type="hidden" value="${data.mouldRuleCode }" id ="mouldRuleCodeStr" />
	<input type="hidden" value="${data.pushRuleCode }" id ="pushRuleCodeStr" />
	<div class="content wide-content">
		<div class="container-fluid">
			<div class="settings-wrapper" id="pad-wrapper">
				<!-- avatar column -->
				<div class="span1 avatar-box"></div>
				<!-- edit form column -->
				<div class="span7 personal-info">
					<form id="tableForm">
						<input type="hidden" name="id"  value="${data.id }">
						<div class="field-box">
							<label>*模具保养规则</label>
							<div class="ui-select">
								<select id="mouldRuleCode" name="mouldRuleCode">
									<option value="" selected="selected">请选择模具保养规则</option>
								</select>
							</div>
						</div>
						<div class="field-box">
							<label>*模具推送规则</label>
							<div class="ui-select">
								<select id="pushRuleCode" name="pushRuleCode">
									<option value="" selected="selected">请选择模具推送规则</option>
								</select>
							</div>
						</div>
						<div id="alert" class="alert alert-info">
							<i class="icon-exclamation-sign"></i>请认真填写模具相关规则,*为必填字段
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
	$(function(){
		var mouldRuleSelectObj =$("#mouldRuleCode");
		var pushRuleSelectObj  = $("#pushRuleCode");
		$.ajax({
			url:'mouldManage?method=mould_rule_sel_kv',
			type:'post',
			dataType:'json',
			async:false,
			success:function(result){
				mouldRuleSelectObj.empty();
					mouldRuleSelectObj.append($("<option />").text("请选择模具保养规则").attr("value","").attr("selected","selected"));
				if(result.code ==0){
					$(result.data).each(function(){
						mouldRuleSelectObj.append($("<option />").text(this.text).attr("value",this.code));
					})
				}else{
					alert(result.msg);
				}
			},
			error:function(){
				alert("服务未响应")
			}
		})
		$("#mouldRuleCode option").each(function(){
			if(this.value == $("#mouldRuleCodeStr").val()){
				$(this).attr("selected", "selected");
				return;
			}
		})
		$.ajax({
			url:'prManage?method=pr_sel_kv',
			type:'post',
			dataType:'json',
			async:false,
			success:function(result){
				pushRuleSelectObj.empty();
				pushRuleSelectObj.append($("<option />").text("请选择模具推送规则").attr("value","").attr("selected","selected"));
				if(result.code ==0){
					$(result.data).each(function(){
						pushRuleSelectObj.append($("<option />").text(this.text).attr("value",this.code));
					})
				}else{
					alert(result.msg);
				}
			},
			error:function(){
				alert("服务未响应")
			}
		})
		$("#pushRuleCode option").each(function(){
			if(this.value == $("#pushRuleCodeStr").val()){
				$(this).attr("selected", "selected");
				return;
			}
		})
	});
		var index = parent.layer.getFrameIndex(window.name);
		$("#sumbit_form").on("click",function(){
			if(check()){
				$("#tableForm").ajaxSubmit({
					url:'mouldManage?method=mould_upt_push_rule_code',
					type:'post',
					dataType:'json',
					success:function(result){
						alert(result.msg);
						if(result.code == 0){
							parent.location.href='mouldManage?method=mould_sel';
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
			var mouldRuleCode = $("#mouldRuleCode").val();
			var pushRuleCode = $("#pushRuleCode").val();
			var msg = ""
			var isSuccess = true;
			if(mouldRuleCode==""){
				msg="请选择模具保养规则。";
				isSuccess =false;
			}else if(pushRuleCode==""){
				msg="请选择模具推送规则。";
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