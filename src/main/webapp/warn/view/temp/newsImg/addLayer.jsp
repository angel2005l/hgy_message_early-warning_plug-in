<%@ include file="../../view/base/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>新闻图片弹窗</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- this page specific styles -->
<link rel="stylesheet"
	href="<%=basePath%>css/compiled/personal-info.css" type="text/css"
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
							<label>图片标题:</label> <input class="span5 inline-input" name="title"
								type="text" placeholder="请输入图片标题..." />
						</div>
						<div class="field-box">
							<label>图片文件:</label> <input type="file" id="upLoad" name="img"  />
						</div>
						<div class="field-box">
							<label>所属文章</label>
							<div class="ui-select">
								<select id="aid" name="aid">
									<option value="" selected="selected">未绑定</option>
								</select>
							</div>
						</div>
						<div class="field-box">
							<label>状态:</label> <label style="width: 20%;"><input
								type="radio" name="status" value="1" checked="checked" />正常</label> <label
								style="width: 20%; float: left;"><input type="radio"
								name="status" value="2" />锁定</label>
						</div>
						<div class="alert alert-info">
							<i class="icon-exclamation-sign"></i>请认真填写新闻图片信息
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
	<script src="<%=basePath%>js/jquery.form.js"></script>
	<script>
	$(function(){
		var selectObj =$("#aid");
		$.ajax({
			url:'<%=basePath %>newsManage?method=news_sel_id_name',
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
						url:'<%=basePath %>newsManage?method=news_img_ins',
						type:'post',
						dataType : "json",
						success:function(result){
							alert(result.msg);
							if(result.code == 0){
								parent.location.href='<%=basePath %>newsManage?method=news_img_sel';
								parent.layer.close(index);
							}else{
								return ;
							}
						},
						error:function(){
							alert("服务未响应");
						}
					}); 
			 }
		})
		
		function checkExcel(fileUrl) {
    //检查是否有空格，不允许文件名中存在空格
    if (fileUrl.indexOf(" ") >= 0) {
        alert("文件名不能有空格");
        return false;
    }
    // 为了避免转义反斜杠出问题，这里将对其进行转换
    var re = /(\\+)/g;
    var filename = fileUrl.replace(re, "#");
    // 对路径字符串进行剪切截取
    var one = filename.split("#");
    // 获取数组中最后一个，即文件名
    var two = one[one.length - 1];
    // 再对文件名进行截取，以取得后缀名
    var three = two.split(".");
    // 获取截取的最后一个字符串，即为后缀名
    var last = three[three.length - 1];
    // 添加需要判断的后缀名类型
    var tp = "jpge,png";
    // 返回符合条件的后缀名在字符串中的位置
    var rs = tp.indexOf(last);
    // 如果返回的结果大于或等于0，说明包含允许上传的文件类型
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