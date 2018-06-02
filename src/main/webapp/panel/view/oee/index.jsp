<%@ include file="../base/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>panel/">
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0">
<title></title>
<link rel="stylesheet" href="OEEAssets/css/bootstrap.min.css" />
<link rel="stylesheet" href="OEEAssets/css/roll.css" />
</head>
<body>
	<div class="row">
		<div class="col-6">
			<div id="cahrt"></div>
		</div>
		<div class="roll col-6">

			<h3 class="h3">当天预警信息</h3>
			<div class="roll-wrap roll_col" id="warn_infos">
				<ul id="warn_infos_ul" class="roll_list"
					style="position: absolute; left: 0; top: 0;">
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="OEEAssets/js/echarts.common.min.js"></script>
	<script type="text/javascript" src="OEEAssets/js/rollSlide.js"></script>
	<script type="application/javascript">
			$(".roll").height($(window).height());
			$("#cahrt").height($(window).height()*0.98);
			var rollDiv = $("#warn_infos");
			var rollObj = rollDiv.rollNoInterval();
			var oeeChart = echarts.init(document.getElementById("cahrt"));
			var option = {
				title: {
					text: '机台信息OEE汇总'
				},
				tooltip: {
					trigger: 'axis',
					axisPointer: {
						type: 'shadow'
					}
				},
				xAxis: {
					axisLabel: {
						show: true,
						interval: 'auto',
						formatter: '{value} %'
					},
					show: true,
				},
				yAxis: {
					type: 'category',
				},
				series: [{
					name: 'OEE',
					type: 'bar',
					label: {
						normal: {
							show: true,
							position: 'right',
							formatter: '{c}%'
						}
					},
					barCategoryGap:'30%',
					itemStyle: {
						normal: {
							color: function(parmas) {
								var colorList = ['rgb(255,0,0)', 'rgb(0,128,0)', 'rgb(255,165,0)'];
								var data = parmas.data[1] 
								if(data > 95) {
									return 'rgb(0,128,0)';
								} else if(data >= 80) {
									return 'rgb(255,165,0)';
								} else {
									return 'rgb(255,0,0)';
								}
							}
						}
					}
				}]
			};
			oeeChart.setOption(option);
			getOEEInfos();
			getWarnInfos();
			
		function getOEEInfos(){
			$.ajax({
				url:'panelManage',
				type:'post',
				data:{
					'method':'oee_panel_sel'
					},
					dataType : 'json',
				success:function(result){
						oeeChart.setOption({
							dataset: {
								source: result
							}
						});
				},
				error:function(){
					//alert("服务器连接异常");
				}
			});
		}
			function getWarnInfos(){
				$.ajax({
					async : true,
					url:'panelManage',
					type:'post',
					data:{
						'method':'warn_day_sel'
					},
					dataType : 'json',
					success:function(result){
						//var rollObj = $("#warn_infos").rollNoInterval();
						if(result.code ==0){
							rollObj.init();
							var obj = rollDiv.find("#warn_infos_ul");
							obj.empty();
							var datas = result.data;
							var htmlStr = "";
						 for (var i = 0; i < datas.length; i++) {
								var warnObj = datas[i];
								htmlStr +="<li class ='warn_info_li'><hr>【预警标题】:"+warnObj.title+"</br>【预警信息】:"+warnObj.message+"</li>" 
							} 
							/* for(var i = 0;i<3;i++){
								htmlStr +="<li class='warn_info_li'>【预警标题】:设备编号("+i+"#)模具报修预警提醒<br>【预警信息】:模具(M031-0148)故障，请及时维修。报修人:张成兵设备编号:10#班别:白班产线:第一产线<hr></li>" 
							} */
							obj.append(htmlStr);
							rollObj.top();
						}
					},
					error:function(){
						
					}
				});
			}

			setInterval(function() {
				getOEEInfos();
			},  5*60* 1000);
	
			setInterval(function() {
				getWarnInfos();
			},  10*60* 1000);
	
	
	
	</script>
	<script type="text/javascript" src="OEEAssets/js/bootstrap.min.js"></script>
</body>

</html>