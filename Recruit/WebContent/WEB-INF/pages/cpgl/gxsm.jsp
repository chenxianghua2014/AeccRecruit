<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>共享声明</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/cpgl/cpstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resources/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="resources/jquery/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript"
	src="resources/jBox/jquery.jBox-2.3.min.js"></script>
<script type="text/javascript" src="resources/jBox/jquery.jBox-zh-CN.js"></script>
<link type="text/css" rel="stylesheet"
	href="resources/jBox/Skins/Blue/jbox.css" />
<script type="text/javascript" src="js/KeyDown.js"></script>
<script type="text/javascript">
	function querySj() {
		$.jBox.tip("正在生成试卷，请耐心等待一会！", 'loading');
		setTimeout(function() {
			$.ajax({
				type : "POST",
				url : "checkKscjEng",
				data : {
					ksxcglIdcard : $("#bmglSfzh").val(),
					ksxcglKkslx : "管理岗"
				},
				datatype : "json",
				success : function(kscjEng) {
					if (kscjEng > 0) {
						window.location.href = "queryGlgEng";
					} else {
						window.location.href = "querySj";
					}
				}
			});
		}, 20000);
	}
</script>
</head>

<body onload="KeyDown();">
	<input id="bmglSfzh" type="hidden"
		value="${cpglLoginSession1.bmglSfzh}" />
	<div id="top"></div>
	<div id="content">
		<div class="conTitle">
			<img src="images/tag04.png" />您提交的信息如下：
		</div>
		<div class="contable">
			<table width="100%">
				<tr>
					<td width="8%">姓名:</td>
					<td width="38%">${cpglLoginSession1.bmglKsxm}</td>
					<td width="8%">性别:</td>
					<td width="46%">${cpglLoginSession1.bmglKsxb}</td>
				</tr>
				<tr>
					<td>联系电话:</td>
					<td>${cpglLoginSession1.bmglLxdh}</td>
					<td>学历:</td>
					<td>${jyjl.resumeXl}</td>
				</tr>
				<tr>
					<td>毕业院校:</td>
					<td>${jyjl.resumeXxmc}</td>
					<td>专业:</td>
					<td>${jyjl.resumeZy}</td>
				</tr>
				<tr>
					<td>证件号:</td>
					<td>${cpglLoginSession1.bmglSfzh}</td>
					<td>考场名称:</td>
					<td>${kcglName}</td>
				</tr>
			</table>
			<hr />
			您选择的岗位：管理岗
		</div>
		<div class="conTitle">
			<img src="images/tag04.png" />您的成绩将由系统自动发送给让您来考试的单位和其他想要了解您成绩的单位
		</div>
		<!-- 		<ol class="Unit"> -->
		<!-- 			<c:forEach items="${ zzjgs}" var="map" varStatus="status"> -->
		<!-- 				<li>${ map.zzjgDwmc}</li> -->
		<!-- 			</c:forEach> -->
		<!-- 		</ol> -->
		<a href="javascript:void(0);" onclick="querySj();" class="btn">确定</a>
	</div>
	<%@ include file="../Main/cpglFooter.jsp"%>
</body>
</html>