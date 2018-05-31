<%@ include file="../../view/base/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>推送规则弹窗</title>
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
							<label>*规则编码:</label> <input class="span5 inline-input"
								type="text" name="ruleCode" placeholder="请输入规则编码..." />
						</div>
						<div class="field-box">
							<label>*规则名称:</label> <input class="span5 inline-input"
								type="text" name="ruleName" placeholder="请输入规则名称..." />
						</div>
						<div class="field-box" >
							<label>*第一级推送时间</label> <input class="span5 inline-input"
								type="text" name="ruleFirstTime" placeholder="请输入第一级推送时间..." />
						</div>
						<div class="field-box" >
							<label>*第二级推送时间</label> <input class="span5 inline-input"
								type="text" name="ruleSecondTime" placeholder="请输入第二级推送时间..." />
						</div>
						<div class="field-box" >
							<label>*第三级推送时间</label> <input class="span5 inline-input"
								type="text" name="ruleThirdTime" placeholder="请输入第三级推送时间..." />
						</div>
						<div class="field-box" >
							<label>*第四级推送时间</label> <input class="span5 inline-input"
								type="text" name="ruleFourthTime" placeholder="请输入第四级推送时间..." />
						</div>
						<div id="alert" class="alert alert-info">
							<i class="icon-exclamation-sign"></i>请认真填写推送规则,*为必填字段
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
					url:'prManage?method=pr_ins',
					type:'post',
					dataType:'json',
					success:function(result){
						alert(result.msg);
						if(result.code == 0){
							parent.location.href='prManage?method=pr_sel';
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
			var ruleCode = $("input[name='ruleCode']").val();
			var ruleName = $("input[name='ruleName']").val();
			var ruleFirstTime = $("input[name='ruleFirstTime']").val();
			var ruleSecondTime = $("input[name='ruleSecondTime']").val();
			var ruleThirdTime = $("input[name='ruleThirdTime']").val();
			var ruleFourthTime = $("input[name='ruleFourthTime']").val();
			var msg = ""
			var isSuccess = true;
			if(ruleCode==''){
				msg="请填写规则编码。";
				isSuccess =false;
			}else if(ruleName==''){
				msg="请填写规则名称。";
				isSuccess =false;
			}else if(ruleFirstTime==''){
				msg="请填写第一级推送时间。";
				isSuccess =false;
			}else if(ruleSecondTime==''){
				msg="请填写规则名称。";
				isSuccess =false;
			}else if(ruleThirdTime==''){
				msg="请填写第三级推送时间。";
				isSuccess =false;
			}else if(ruleFourthTime==''){
				msg="请填写第四级推送时间。";
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