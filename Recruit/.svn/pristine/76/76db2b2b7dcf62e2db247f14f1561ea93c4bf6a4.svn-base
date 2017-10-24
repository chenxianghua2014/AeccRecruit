var pageSize = 10;
var dataCount = 0;
function pageselectCallback(page_index, jq) {
	page_index += 1;
	var strHtml = "";
	var currentPageSize = (dataCount < page_index * pageSize ? dataCount
			- (page_index * pageSize - 10) : pageSize);
	$("#count").html(dataCount);
	if (dataCount == 0)
		$("#start").html(0);
	else
		$("#start").html(page_index * 10 - 9);
	$("#end").html(currentPageSize + page_index * 10 - 10);
	$
			.ajax({
				type : 'POST',
				url : "LoadPositionData",
				data : {
					pageNum : page_index,
					pageSize : pageSize,
					currentPageSize : currentPageSize,
					positionZsdw : $("#zpdw").val(),
					positionZpzy : $("#zpzy").val(),
					positionType : $("#zwlb").val(),
					positionAddress : $("#gzdd").val(),
					positionXlyq : $("#xlyq").val(),
					positionAddtime : $("#dt").val(),
					positionStatus : '正在进行',
					isuniposition : $("#isuniposition").val()
				},
				dataType : "json",
				success : function(result) {
					for (var i = 0; i <= result.model.list.length - 1; i++) {
						strHtml += "<tr>";
						strHtml += "<td>" + result.model.list[i].positionName
								+ "</td>";
						strHtml += "<td>" + result.model.list[i].positionType
								+ "</td>";
						strHtml += "<td>" + result.model.list[i].positionXlyq
								+ "</td>";
						strHtml += "<td>" + result.model.list[i].positionZpzy
								+ "</td>";
						strHtml += "<td>" + result.model.list[i].positionXqrs
								+ "</td>";
						strHtml += "<td>"
								+ (result.model.list[i].positionZpfl == null ? ""
										: result.model.list[i].positionZpfl)
								+ "</td>";
						strHtml += "<td>" + result.model.list[i].positionZsdw
								+ "</td>";
						strHtml += "<td>"
								+ result.model.list[i].positionWorkaddress
								+ "</td>";
						strHtml += "<td>"
								+ new Date(result.model.list[i].positionAddtime)
										.Format("yyyy-MM-dd") + "</td>";
						strHtml += "<td>" + result.model.list[i].positionStatus
								+ "</td>";
						if (result.model.list[i].positionStatus == "已结束") {
							strHtml += "<td><a href=\"javascript:void(0);\" onclick=\"ShowDetails('"
									+ result.model.list[i].positionId
									+ "');\">查看</a>&nbsp;&nbsp;";
							if (!result.model.isLogin) {
								strHtml += "<span>申请</span>";
								strHtml += "&nbsp;&nbsp;<a href=\"javascript:void(0);\" onclick=\"ShowLogin();\">收藏</a></td>";
							} else {
								strHtml += "<span>申请</span>";
								strHtml += "&nbsp;&nbsp;<a href=\"javascript:void(0);\" onclick=\"DoCollection('"
										+ result.model.list[i].positionId
										+ "');\">收藏</a></td>";
							}
							strHtml += "</tr>";
						} else {
							strHtml += "<td><a href=\"javascript:void(0);\" onclick=\"ShowDetails('"
									+ result.model.list[i].positionId
									+ "');\">查看</a>&nbsp;&nbsp;";
							if (!result.model.isLogin) {
								strHtml += "<a href=\"javascript:void(0);\" onclick=\"ShowLogin();\">申请</a>";
								strHtml += "&nbsp;&nbsp;<a href=\"javascript:void(0);\" onclick=\"ShowLogin();\">收藏</a></td>";
							} else {
								strHtml += "<a href=\"javascript:void(0);\" onclick=\"ApplyPosition('"
										+ result.model.list[i].positionId
										+ "');\">申请</a>";
								strHtml += "&nbsp;&nbsp;<a href=\"javascript:void(0);\" onclick=\"DoCollection('"
										+ result.model.list[i].positionId
										+ "');\">收藏</a></td>";
							}
							strHtml += "</tr>";
						}
					}
					$("#tbList").html(strHtml);
				}
			});
	return false;
}

Date.prototype.Format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}

function getOptionsFromForm() {
	var opt = {
		callback : pageselectCallback
	};
	opt.prev_text = "上一页";
	opt.next_text = "下一页";
	return opt;
}

function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

/* 进入优才时的提醒窗口 */
var promptUni = function() {
	var strHtml = "<div class='editBlock'><table>"
			+ "<tr>" 
			+"<td class = 'ycIntro'>“优才计划”是集团公司重点针对“五个新一代”、“四项基础性支撑技术”、“一个新业态”等领域，" +
					"面向国内著名高校中科技创新能力强、综合素质高的优秀博士、硕士研究生进行直接选拔，并在毕业生到岗后给予一系列培养正常，" +
					"整合集团公司有关资源，全力关注和培养优秀人才，促使其早成才、早发展、早贡献，形成和造就一批集团公司优秀青年科技后备人才群体的人才专项计划。" +
					/*" “优才职位”面向的主要目标院校、目标对象、目标专业分别为: " +*/
					"</td>" 
			+"</tr>"
			/*+"<tr>"
			+"<td class = 'ycIntro'>1、 C9高校：清华大学、北京大学、上海交通大学、复旦大学、浙江大学、南京大学、中国科学技术大学、哈尔滨工业大学、西安交通大学。</td>" 
			+"</tr>"
			+"<tr>"
			+"<td class = 'ycIntro'>2、 3所著名高校：北京航空航天大学、北京理工大学、西北工业大学。</td>" 
			+"</tr>"
			+"<tr>"
			+"<td class = 'ycIntro'>3、 参加”航天科工杯”大学生科技竞赛获奖团队中科技创新能力强的博士、硕士研究生。</td>" 
			+"</tr>"
			+"<tr>"
			+"<td class = 'ycIntro'>4、 符合“五个新一代”、“四项基础性支撑技术”、“一个新业态”的相关专业。</td>" 
			+"</tr>" */
			+ "</table></div>";
	$.jBox.open(strHtml, '优才计划模块温馨提示', 450, 580, {
		buttons : {
			'关闭' : true
		}
	});
};
function get_cookie(Name) {
	var search = Name + "="
	var returnvalue = "";
	if (document.cookie.length > 0) {
		offset = document.cookie.indexOf(search)
		if (offset != -1) {
			// 如果指定的cookie已经存在
			offset += search.length
			// 长度指定到cookie值的位置
			end = document.cookie.indexOf(";", offset);
			// 判断是否还包括其他cookie值
			if (end == -1)
				// 如果不包括
				end = document.cookie.length;
			// 获取cookie的长度
			returnvalue = unescape(document.cookie.substring(offset, end))
			// 获取cookie的值
		}
	}
	return returnvalue;
}
function loadpopup() {
	if (get_cookie("popped") == "") {
		// 判断是否已经弹出过窗口
		promptUni();
		// 如果没有则弹出窗口
		document.cookie = "popped=yes"
		// 设置cookie值
	}
}

$(document).ready(
		function() {
			$("#zpdw").val(
					unescape(getQueryString("zpdw")) == "null" ? ""
							: unescape(getQueryString("zpdw")));
			$("#zpzy").val(
					unescape(getQueryString("zpzy")) == "null" ? ""
							: unescape(getQueryString("zpzy")));
			$("#zwlb").find(
					"option[value='" + unescape(getQueryString("zwlb")) + "']")
					.attr("selected", true);
			$("#gzdd").find(
					"option[value='" + unescape(getQueryString("gzdd")) + "']")
					.attr("selected", true);
			$("#xlyq").find(
					"option[value='" + unescape(getQueryString("xlyq")) + "']")
					.attr("selected", true);
			$("#dt").find(
					"option[value='" + unescape(getQueryString("dt")) + "']")
					.attr("selected", true);

			loadData();
		});

function loadData() {
	$.ajax({
		type : 'POST',
		url : "LoadPositionDataCount",
		data : {
			positionZsdw : $("#zpdw").val(),
			positionZpzy : $("#zpzy").val(),
			positionType : $("#zwlb").val(),
			positionAddress : $("#gzdd").val(),
			positionXlyq : $("#xlyq").val(),
			positionAddtime : $("#dt").val(),
			positionStatus : '正在进行',
			isuniposition : $("#isuniposition").val()
		},
		dataType : "json",
		success : function(count) {
			dataCount = count;
			var optInit = getOptionsFromForm();
			$("#Pagination").pagination(dataCount, optInit);
			$("#setoptions").click(function() {
				var opt = getOptionsFromForm();
				$("#Pagination").pagination(dataCount, opt);
			});
		}
	});
}

function ShowLogin() {
	$.jBox.open("iframe:LoginFrm", "用户登录", 280, 200, {
		buttons : {}
	});
}

function ShowDetails(id) {
	window.location.href = "PositionDetails?id=" + id;
}

function ApplyPosition(id) {
	window.location.href = "ApplyPosition?id=" + id + "&page=SearchPosition";
}

function DoCollection(id) {
	window.location.href = "DoCollection?id=" + id;
}
