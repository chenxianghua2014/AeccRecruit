<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="resources/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="resources/jquery/jquery-migrate-1.2.1.js"></script>
</head>
<body>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		if ("${uri}" == "SessionLost") {
			alert("登录超时，请重新登录！");
			window.location.href = "Main";
		} else if ("${uri}" == "SearchPositionSuccess") {
			alert("收藏成功！");
			history.back();
		} else if ("${uri}" == "SearchPositionError") {
			alert("你已收藏该简历！");
			history.back();
		} else if ("${uri}" == "MyCollection") {
			alert("取消收藏成功！");
			window.location.href = "${uri}";
		} else if ("${uri}" == "RegistrationSuccess") {
			alert("报名成功，请打印准考证！");
			window.location.href = "MyApplication";
		}
		else if ("${uri}" == "RegistrationUniSuccess") {
			alert("报名成功，请打印准考证！");
			window.location.href = "MyUniApplication";
		} else if ("${uri}" == "RegistrationIsExist") {
			alert("同类型的考试只需报考一次，您已报过名了，无需再次预约考试!");
			window.location.href = "MyApplication";
		} else if ("${uri}" == "RegistrationUniIsExist") {
			alert("同类型的考试只需报考一次，您已报过名了，无需再次预约考试!");
			window.location.href = "MyUniApplication";
		}else if ("${uri}".indexOf("NoResume") != -1) {
			alert("请填写简历信息，再申请职位！");
			window.location.href = "MyRecruit";
		} else if ("${uri}".indexOf("IsExist") != -1) {
			alert("一个单位只能申请一个岗位，您已向该单位投递过简历。");
			window.location.href = "MyApplication";
		} else if ("${uri}".indexOf("OrdMore") != -1) {
			alert("只能同时向5家企业投递简历！");
			window.location.href = "MyApplication";
		} else if ("${uri}".indexOf("ApplySuccess") != -1) {
			alert("申请职位成功！");
			window.location.href = "${uri}".replace("ApplySuccess", "");
		} else if ("${uri}".indexOf("Main") != -1) {
			window.location.href = "${uri}";
		} else if ("${uri}".indexOf("MyApplicationRevoke") != -1) {
			alert("撤销成功！");
			history.back();
		} else if ("${uri}".indexOf("RegistrationFull") != -1) {
			alert("考场容量已满，请选择其他考场！");
			window.location.href = "MyApplication";
		} else if ("${uri}".indexOf("RegistrationUniFull") != -1) {
			alert("考场容量已满，请选择其他考场！");
			window.location.href = "MyUniApplication";
		}else if ("${uri}".indexOf("UniSuccess") != -1) {
			alert("申请优才职位成功！");
			/* window.location.href = "SearchUniPosition"; */
			history.back();
		} else if ("${uri}".indexOf("OutOfList") != -1) {
			alert("对不起，您不符合招聘条件，无法申请优才职位。");
			window.location.href = "UniPositionIntroduce";
		} else if ("${uri}".indexOf("UniExist") != -1) {
			alert("一个单位只能申请一个优才岗位，您已向该单位投递过简历。");
			window.location.href = "MyUniApplication";
		} else if ("${uri}".indexOf("UniMore") != -1) {
			alert("只能同时向3家企业投递优才职位！");
			window.location.href = "MyUniApplication";
		}else if ("${uri}" == "MyUniCollection") {
			alert("取消收藏成功！");
			window.location.href = "MyUniCollection";
		}else if ("${uri}".indexOf("MyUniApplicationRevoke") != -1) {
			alert("该优才职位撤销成功！");
			window.location.href = "MyUniApplication";
		}else if ("${uri}".indexOf("limitRegister") != -1) {
			alert("注册功能暂未开放！");
			window.location.href = "Main";
		} 
	});
</script>
</html>
