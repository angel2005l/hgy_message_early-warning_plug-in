<%@ include file="../../view/base/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>调度任务弹窗</title>
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
						<div class="field-box">
							<label>*任务编码:</label> <input class="span5 inline-input"
								type="text" name="taskCode" placeholder="请输入任务编码..." />
						</div>
						<div class="field-box">
							<label>*任务名称:</label> <input class="span5 inline-input"
								type="text" name="taskName" placeholder="请输入任务名称..." />
						</div>
						<div class="field-box">
							<label>*任务类型</label>
							<div class="ui-select">
								<select id="taskType" name="taskType">
									<option value="" selected="selected">请选择任务类型</option>
									<option value="data">数据</option>
									<option value="work">业务</option>
								</select>
							</div>
						</div>
						<div class="field-box">
							<label>*任务执行类型</label>
							<div class="ui-select">
								<select id="taskRunType" name="taskRunType">
									<option value="" selected="selected">请选择任务执行类型</option>
									<option value="once" >每日一次</option>
									<option value="cont">每日循环</option>
								</select>
							</div>
						</div>
						<div class="field-box" id = "taskTime">
							<label>*任务执行时间间隔（单位：秒）</label> <input class="span5 inline-input"
								type="text" name="taskTime" placeholder="请输入任务执行时间间隔..." />
						</div>
						<div class="field-box" id = "taskTiming">
							<label>*任务执行时间点</label> <input class="span5 inline-input"
								type="text" name="taskTiming" placeholder="请输入任务执行时间点..." />
						</div>
						<div class="field-box">
							<label>*任务状态:</label> <label style="width: 20%;"><input
								type="radio" name="status" value="Y" checked="checked" />启用</label>
							<label style="width: 20%; float: left;"><input
								type="radio" name="status" value="N" />未启用</label>
						</div>
						<div id="alert" class="alert alert-info">
							<i class="icon-exclamation-sign"></i>请认真填写任务信息,*为必填字段
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
			changeTime();
		});
		var index = parent.layer.getFrameIndex(window.name);
		$("#sumbit_form").on("click",function(){
			if(check()){
				$("#tableForm").ajaxSubmit({
					url:'taskManage?method=task_ins',
					type:'post',
					dataType:'json',
					success:function(result){
						alert(result.msg);
						if(result.code == 0){
							parent.location.href='taskManage?method=task_sel';
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
		
		$("#taskRunType").on("change",function(){
			changeTime();
		});
		
		function changeTime(){
			var taskRunTyprStr = $("#taskRunType").val();
			var timeDiv = $("#taskTime");
			var timingDiv = $("#taskTiming");
			if(taskRunTyprStr =='once'){
				timingDiv.css("display","block");
				timeDiv.css("display","none");
			}else if(taskRunTyprStr == 'cont'){
				timingDiv.css("display","none");
				timeDiv.css("display","block");
			}else{
				timingDiv.css("display","none");
				timeDiv.css("display","none");
			}
		}
		
		function check(){
			var taskCode = $("input[name='taskCode']").val();
			var taskName = $("input[name='taskName']").val();
			var taskType = $("#taskType").val();
			var taskRunType = $("#taskRunType").val();
			var taskTime = $("input[name='taskTime']").val();
			var taskTiming = $("input[name='taskTiming']").val();
			var isChecked = $("input[name='status']").is(":checked");
			var msg = ""
			var isSuccess = true;
			if(taskCode==""){
				msg="请填写任务编码。";
				isSuccess =false;
			}else if(taskName==""){
				msg="请填写任务名称。";
				isSuccess =false;
			}else if(taskType==""){
				msg="请选择任务类型。";
				isSuccess =false;
			}else if(taskRunType==""){
				msg="请选择任务执行类型。";
				isSuccess =false;
			}else if(taskRunType=="once" && taskTiming==''){
				msg="请填写任务执行时间点。";
				isSuccess =false;
			}else if(taskRunType=="cont" && taskTime==''){
				msg="请填写任务执行时间间隔。";
				isSuccess =false;
			}else if(!isChecked){
				msg="请选择任务状态。";
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