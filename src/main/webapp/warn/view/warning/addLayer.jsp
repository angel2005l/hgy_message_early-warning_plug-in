<%@ include file="../../view/base/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>新闻信息弹窗</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- this page specific styles -->
<link rel="stylesheet" href="<%=basePath %>css/compiled/personal-info.css"
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
							<label>新闻标题:</label> <input class="span5 inline-input"
								type="text" name="title" placeholder="请输入新闻标题..." />
						</div>
						<div class="field-box">
							<label>主要内容（摘要）</label>
							<textarea class="span5" name="main_content" rows="2"></textarea>
						</div>
						<div class="field-box">
							<label>新闻内容</label>
							<textarea class="span5" name="content" rows="2"></textarea>
						</div>
						<div class="field-box">
							<label>所属分类</label>
							<div class="ui-select">
								<select id="tid" name="tid">
									<option value="" selected="selected">请选择新闻分类</option>
								</select>
							</div>
						</div>
						<div class="field-box">
							<label>新闻类型</label>
							<div class="ui-select">
								<select id="type" name="type">
									<option value="1" selected="selected">内部新闻</option>
									<option value="2">外部新闻</option>
								</select>
							</div>
						</div>
						<div class="field-box" id="http_url_input">
							<label>引用外部链接:</label> <input class="span5 inline-input" id="httpurl"
								type="text" name="httpurl" placeholder="请输入引用外部链接..." />
						</div>
						<div class="field-box">
							<label>状态:</label> <label style="width: 20%;"><input
								type="radio" name="status" value="1" checked="checked" />正常</label> <label
								style="width: 20%; float: left;"><input type="radio"
								name="status" value="2" />锁定</label>
						</div>
						<div class="alert alert-info">
							<i class="icon-exclamation-sign"></i>请认真填写新闻信息
						</div>
						<div class="field-box actions">
							<input id="sumbit_form" type="button" class="btn-flat primary" value="保存" /> <input
								id="close_win" type="button" class="btn-flat danger" value="取消" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- end main container -->

	<!-- scripts -->
	<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
	<script>
		$(function(){
			var selectObj =$("#tid");
			$.ajax({
				url:'<%=basePath%>newsManage?method=news_type_sel_id_typeName&id',
				type:'post',
				dataType:'json',
				async:false,
				success:function(result){
						selectObj.empty();
						selectObj.append($("<option />").text("请选择新闻分类").attr("value","").attr("selected","selected"));
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
			typeChange();
		});
		function typeChange(){
			if($("#type").val()==1){
				$("#http_url_input").css("display","none");
				$("#httpurl").val("");
			}else{
				$("#http_url_input").css("display","block");
			}
			
		}
		
		$("#type").on("change",function(){
			typeChange();
		})
	
		var index = parent.layer.getFrameIndex(window.name);
		$("#sumbit_form").on("click",function(){
			$("#tableForm").ajaxSubmit({
				url:'<%=basePath%>newsManage?method=news_ins',
				type:'post',
				dataType:'json',
				success:function(result){
					alert(result.msg);
					if(result.code == 0){
						parent.location.href='<%=basePath%>newsManage?method=news_sel';
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