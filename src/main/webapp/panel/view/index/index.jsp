<%@ include file="../base/base.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>panel/">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta charset="utf-8" />
<title>主页数据面板呈现</title>
<style>
body {
	margin: 0 auto;
	padding: 0 auto;
}

#left_div {
	height: 100vh;
	float: left;
}

#right_div {
	height: 100vh;
	float: left;
	/*盒模型*/
	display: -webkit-box;
	display: -moz-box;
	display: box;
	/*横向or纵向*/
	-webkit-box-orient: vertical;
	/*属性值：[horizontal]横向/[vertical]纵向*/
	-moz-box-orient: vertical;
	box-orient: vertical;
}

.table_div {
	height: 50%;
}

.pie_div {
	height: 50%;
}
</style>
</head>

<body>

	<div id="left_div">
		<div id="tab1" class="table_div"></div>
		<div id="tab2" class="table_div"></div>
	</div>
	<div id="right_div">
		<div id="pie1" class="pie_div"></div>
		<div id="pie2" class="pie_div"></div>
	</div>
</body>

<script type="text/javascript" src="indexAssets/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="indexAssets/js/echarts.min.js"></script>

<script type="text/javascript">
	var width = $(window).width();
	$("#left_div").css("width", width * 0.6);
	$("#right_div").css("width", width - width * 0.6 -10);
	window.onresize = function() {
		window.location.reload();
	}
</script>

<script>
	var pie1Chart = echarts.init(document.getElementById('pie1'));
	pie1option = {
		title : {
			text : '机台生产状态',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		series : [ {
			name : '机台状态',
			type : 'pie',
			radius : '55%',
			center : [ '50%', '50%' ],
			type : 'pie',
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	pie1Chart.setOption(pie1option, true);
	getEquRunType();
	setInterval(function() {
		getEquRunType();
	},  30*60* 1000);
	function getEquRunType() {
		$.ajax({
			url : 'panelManage',
			type : 'post',
			data : {
				'method' : 'warn_equ_produce_type_sel'
			},
			dataType : 'json',
			success : function(result) {
				pie1Chart.setOption({
					series : [ {
						data : result
					} ]
				});
			},
			error : function() {
				//alert("服务器连接异常");
			}
		});
	}

</script>

<script type="text/javascript">
var pie2Chart = echarts.init(document.getElementById('pie2'));
pie2option = {
	title : {
		text : '每周预警类型 top5',
		x : 'center'
	},
	tooltip : {
		trigger : 'item',
		formatter : "{a} <br/>{b} : {c} ({d}%)"
	},
	series : [ {
		name : '每周预警类型 top5',
		type : 'pie',
		radius : '55%',
		center : [ '50%', '50%' ],
		itemStyle : {
			emphasis : {
				shadowBlur : 10,
				shadowOffsetX : 0,
				shadowColor : 'rgba(0, 0, 0, 0.5)'
			}
		}
	} ]
};

pie2Chart.setOption(pie2option, true);
getWarnTypeTop5();
function getWarnTypeTop5() {
	$.ajax({
		url : 'panelManage',
		type : 'post',
		data : {
			'method' : 'warn_week_top5_sel'
		},
		dataType : 'json',
		success : function(result) {
			pie2Chart.setOption({
				series : [ {
					data : result
				} ]
			});
		},
		error : function() {
			//alert("服务器连接异常");
		}
	});
}
</script>
<script type="text/javascript">
var tab1chart = echarts.init(document.getElementById('tab1'));
// 指定图表的配置项和数据
var option = {
	title : {
		text : '机台信息OEE汇总'
	},
	tooltip : {
		trigger : 'axis',
		axisPointer : {
			type : 'shadow'
		}
	},
	xAxis : {
		type : 'category',
	},
	yAxis : {
		axisLabel : {
			show : true,
			interval : 'auto',
			formatter : '{value} %'
		},
		show : true,
	},
	series : [ {
		type : 'bar',
		label : {
			normal : {
				show : true,
				position : 'top',
				formatter : '{@[1]}%'
			}
		},
		barCategoryGap : '30%',
		itemStyle : {
			normal : {
				color : function(parmas) {
					var colorList = [ 'rgb(255,0,0)', 'rgb(0,128,0)',
							'rgb(255,165,0)' ];
					var data = parmas.data[1]
					if (data > 95) {
						return 'rgb(0,128,0)';
					} else if (data >= 80) {
						return 'rgb(255,165,0)';
					} else {
						return 'rgb(255,0,0)';
					}
				}
			}
		}
	} ]
};
// 使用刚指定的配置项和数据显示图表。
tab1chart.setOption(option);
getOEEInfos();
setInterval(function() {
	console.log("zhixngOEE");
	getOEEInfos();
},  5*60* 1000);

function getOEEInfos() {
	$.ajax({
		url : 'panelManage',
		type : 'post',
		data : {
			'method' : 'oee_panel_sel'
		},
		dataType : 'json',
		success : function(result) {
			tab1chart.setOption({
				dataset : {
					source : result
				}
			});
		},
		error : function() {
			//alert("服务器连接异常");
		}
	});
}
</script>
<script type="text/javascript">

var tab2chart = echarts.init(document.getElementById('tab2'));

// 指定图表的配置项和数据
var tab2option = {
	title : {
		text : '近七天内每日预警次数'
	},
	tooltip : {
		trigger : 'axis',			
		axisPointer : {
			type : 'shadow'
		},
		formatter:'{c}次'
	},
	xAxis : {
		type : 'category',
	},
	yAxis : {
		axisLabel : {
			show : true,
			interval : 'auto',
			formatter : '{value}'
		},
		show : true,
	},
	series : [ {
		type : 'bar',
		label : {
			normal : {
				show : true,
				position : 'top',
				formatter : '{@[1]}次'
			}
		}
	} ]
};

// 使用刚指定的配置项和数据显示图表。
tab2chart.setOption(tab2option);
getWarnNum();
function getWarnNum() {
	$.ajax({
		url : 'panelManage',
		type : 'post',
		data : {
			'method' : 'warn_7day_sel'
		},
		dataType : 'json',
		success : function(result) {
			console.log(result);
			tab2chart.setOption({
				dataset : {
					source : result
				}
			});
		},
		error : function() {
			//alert("服务器连接异常");
		}
	});
}

</script>
</html>