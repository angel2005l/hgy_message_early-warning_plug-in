<%@ include file="../../view/base/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>模具保养日志弹窗</title>
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
						<input type="hidden" name="id" value="${data.id }" />
						<div class="field-box">
							<label>*保养模具编码:</label> <input class="span5 inline-input"
								type="text" name="mouldId" value="${data.mouldId }" readonly />
						</div>
						<div class="field-box">
							<label>*记录编码:</label> <input class="span5 inline-input"
								type="text" name="mouldLogCode" value="${data.mouldLogCode }"  readonly />
						</div>
						<div class="field-box">
							<label>*记录名称:</label> <input class="span5 inline-input"
								type="text" name="mouldLogName" value="${data.mouldLogName }" readonly />
						</div>
						<div class="field-box">
							<label>保养内容</label>
							<textarea class="span5" name="mouldLogContext" rows="4" placeholder="请填写保养内容..."></textarea>
						</div>
						<div id="alert" class="alert alert-info">
							<i class="icon-exclamation-sign"></i>请认真填写保养记录,*为必填字段。
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
					url:'mouldManage?method=mould_log_upt',
					type:'post',
					dataType:'json',
					success:function(result){
						alert(result.msg);
						if(result.code == 0){
							parent.location.href='mouldManage?method=mould_log_sel';
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
		
		/* function check(){
			var ruleCode = $("input[name='moludRuleCode']").val();
			var ruleName = $("input[name='moludRuleName']").val();
			var ruleFirstTime = $("input[name='mouldRuleTimes']").val();
			var msg = ""
			var isSuccess = true;
			if(ruleCode==''){
				msg="页面异常,请重新打开页面。";
				isSuccess =false;
			}else if(ruleName==''){
				msg="请填写规则名称。";
				isSuccess =false;
			}else if(ruleFirstTime==''){
				msg="请填写模具保养间隔。";
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
		}		 */
	</script>
</body>

</html>