<%@ include file="../base/base.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">

	<head>
		<meta charset="utf-8">
		<base href="<%=basePath %>panel/">
		<title>七分厂预警一级人员签到</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">

		<!-- CSS -->

		<link rel="stylesheet" href="dutyAssets/css/reset.css">
		<link rel="stylesheet" href="dutyAssets/css/supersized.css">
		<link rel="stylesheet" href="dutyAssets/css/style.css">

	</head>

	<body>

		<div class="page-container">
			<h1>七分厂预警一级人员签到</h1>
				<form action="">
				<select id="user_info">
					<option value="" duty_status="N">请选择员工信息</option>
				</select>
				</form>
				<button id="on_duty" type="button" onclick="sumbitBtn('Y')">上班 签到</button>
				<button id="off_duty" type="button" onclick="sumbitBtn('N')">下班 签到</button>
		</div>

		<!-- Javascript -->
		<script src="dutyAssets/js/jquery-1.8.2.min.js"></script>
		<script src="dutyAssets/js/supersized.3.2.7.min.js"></script>
		<script src="dutyAssets/js/supersized-init.js"></script>
		<script src="dutyAssets/js/scripts.js"></script>
		<script>
		$(function(){
			$("#on_duty").show();
			$("#off_duty").hide();
			var userSelectObj = $("#user_info");
			$.ajax({
				url:'../warn/userManage?method=user_first_level_KV',
				type:'post',
				dataType:'json',
				async:false,
				success:function(result){
					userSelectObj.empty();
					userSelectObj.append($("<option />").text("请选择员工信息").attr("duty_status",'N').attr("value","").attr("selected","selected"));
					if(result.code ==0){
						$(result.data).each(function(){
							userSelectObj.append($("<option />").text(this.text).attr("duty_status",this.isWork).attr("value",this.code));
						})
					}else{
						alert(result.msg);
					}
				},
				error:function(){
					alert("服务未响应")
				}
			})
			
			changeBtn();
		});
		
		function changeBtn() {
			var userSelectObj = $("#user_info");
			var onDuty = $("#on_duty");
			var offDuty = $("#off_duty");
			userSelectObj.on('change',function(){
				var dutyStatus = $("#user_info").find("option:selected").attr("duty_status");
				if(dutyStatus=='Y'){
					onDuty.hide();
					offDuty.show();
				}else{
					onDuty.show();
					offDuty.hide();
				}
			})
		}
		
		</script>
		<script type="text/javascript">
			function sumbitBtn(isWork){
				var userId = $("#user_info").val();
				if(userId=='' ){
					alert("请选择员工信息")
					return ;
				}
				$.ajax({
					url:'../warn/userManage?method=sign_in_work',
					data:{'id':userId,'workType':isWork},
					dataType:'json',
					success:function(result){
						alert(result.msg);
						window.location.reload();
					},
					error:function(){
						alert("服务未响应")
					}
				})
			}
		</script>
	</body>

</html>