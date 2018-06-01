<%@ include file="../../view/base/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>预警类别弹窗</title>
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
					<input type="hidden" id="ruleCodeStr" value="${data.ruleCode }" />
					<form id="tableForm">
						<input type="hidden" name="id" value="${data.id }" />
						<div class="field-box">
							<label>*事件编码:</label> <input class="span5 inline-input"
								type="text" name="eventCode" value="${data.eventCode }" readonly />
						</div>
						<div class="field-box">
							<label>*事件名称:</label> <input class="span5 inline-input"
								type="text" name="eventName" value="${data.eventName }" readonly />
						</div>
						<div class="field-box">
							<label>*预警规则编码</label>
							<div class="ui-select">
								<select id="ruleCode" name="ruleCode">
									<option value="" selected="selected">请选择预警规则编码</option>
								</select>
							</div>
						</div>
						<div id="alert" class="alert alert-info">
							<i class="icon-exclamation-sign"></i>请认真填写预警类别,*为必填字段
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
		var selectObj =$("#ruleCode");
		$.ajax({
			url:'prManage?method=pr_sel_kv',
			type:'post',
			dataType:'json',
			async:false,
			success:function(result){
					selectObj.empty();
					selectObj.append($("<option />").text("请选择预警规则编码").attr("value","").attr("selected","selected"));
				if(result.code ==0){
					$(result.data).each(function(){
						selectObj.append($("<option />").text(this.text).attr("value",this.code));
					})
				}else{
					alert(result.msg);
				}
			},
			error:function(){
				alert("服务未响应")
			}
		})
		$("#ruleCode option").each(function(){
			if(this.value == $("#ruleCodeStr").val()){
				$(this).attr("selected", "selected");
				return;
			}
		})
		
	});
		var index = parent.layer.getFrameIndex(window.name);
		$("#sumbit_form").on("click",function(){
			if(check()){
				$("#tableForm").ajaxSubmit({
					url:'warningManage?method=warning_upt_rule_code',
					type:'post',
					dataType:'json',
					success:function(result){
						alert(result.msg);
						if(result.code == 0){
							parent.location.href='warningManage?method=warning_sel';
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
			var eventCode = $("input[name='eventCode']").val();
			var eventName = $("input[name='eventName']").val();
			var ruleCode = $("#ruleCode").val();
			var msg = ""
			var isSuccess = true;
			if(eventCode==""){
				msg="请填写事件编码。";
				isSuccess =false;
			}else if(eventName==""){
				msg="请填写事件名称。";
				isSuccess =false;
			}else if(ruleCode==""){
				msg="请选择预警规则编码。";
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