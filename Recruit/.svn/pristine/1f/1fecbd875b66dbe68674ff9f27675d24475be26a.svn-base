<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>中国航天科工集团公司人才招聘平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" href="css/style.css" rel="stylesheet" />
<script type="text/javascript" src="resources/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="resources/jquery/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript" src="resources/jquery/jquery.form.js"></script>
<script type="text/javascript" src="resources/jquery/jquery.jslides.js"></script>
<style type="text/css">
html {
	overflow: hidden;
	height: 200px;
	width: 223px;
}

body {
	height: 200px;
	width: 223px;
	min-width: 223px;
}

.loginLength {
	width: 153px;
}
</style>
<script type="text/javascript">
	//登录功能提交
	function Login() {
		if ($("#loginName").val() == "") {
			$("#loginName").focus();
			$("#result").html("请输入用户名!");
			return;
		}
		if ($("#userPassword").val() == "") {
			$("#userPassword").focus();
			$("#result").html("请输入密码!");
			return;
		}

		if ($("#rand").val() == "") {
			$("#rand").focus();
			$("#result").html("请输入验证码!");
			return;
		}
		var randjsp = $.ajax({
			url : "rand.jsp?anticache=" + Math.floor(Math.random() * 100000),
			async : false
		}).responseText;

		var randjsppro = jQuery.trim(randjsp);
		if (document.FormMain.rand.value.toLowerCase() != randjsppro
				.toLowerCase()) {
			$("#result").html("验证码输入错误!");
			RefreshCode();
			document.FormMain.rand.focus();
			return;
		}
		var options = {
			type : 'post',
			url : "UserLogin",
			datatype : "json",
			success : showResponse,
			error : showResponse,
			clearForm : false
		};
		// ajax上传表单
		$("#UserLogin").ajaxSubmit(options);
		/* document.forms[0].submit(); */
		//return false;
	}

	function UserLogout() {
		if (confirm("确认注销本次登陆么？")) {
			window.location.href = "UserLogout";
		}
	}
	function userUpd(userId) {
		window.parent.location = "register?userId=" + userId;
	}
	function zhmm() {
		window.parent.location = "zhmm";
	}
	function RefreshCode() {
		var ImgCodeInst = document.getElementById("randcode");
		var dt = new Date();
		ImgCodeInst.src = "image.jsp?" + dt.getMilliseconds();
	}
	function showResponse(responseText, statusText) {
		if (responseText && responseText[0].indexOf("成功") != -1) {
			if (window.parent.window.$.jBox != undefined) {
				window.parent.window.$.jBox.close();
				window.parent.window.location.reload();
				window.location.href=window.location.href; 
				window.location.reload; 
			}

		}

		else
			RefreshCode();
		alert(responseText);
	}
</script>
</head>
<body>
	<form id="UserLogin" name="FormMain" action="UserLogin" method="post">
		<input type="hidden" id="page" name="page" value="LoginFrm" />
		<div id="loginForm" class="loginForm">
			<c:choose>
				<c:when test="${userLoginSession eq null}">
					<table style=" width:230px; margin-left:30px;">
						<tr>
							<td>用户名：</td>
							<td>
								<input type="text" name="userName" id="loginName" class="loginLength" placeholder="登录名/手机号/身份证号" />
							</td>
						</tr>
						<tr>
							<td>密 &nbsp;&nbsp;码：</td>
							<td>
								<input type="password" name="userPassword" id="userPassword" class="loginLength" />
							</td>
						</tr>

						<tr>
							<td>验证码：</td>
							<td>
								<input name="rand" id="rand" type="text" value="" style="width: 75px;" />
								<img title="换一张" onclick="javascript:RefreshCode();" id="randcode" src="image.jsp" style="width: 75px;" />
							</td>
						</tr>



						<tr>
							<td colspan="2" style="font-size: 14px;color: red;" id="result">${result.message}</td>
						</tr>
						<tr>
							<td colspan="2">
								<a href="javascript:void(0);" onclick="Login();">
									<span>登录</span>
								</a>
								<a href="register" target="parent">
									<span style="margin-left:40px;">注册 </span>
								</a>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<a href="javascript:void(0);" onclick="window.parent.location ='/Recruit/htRecruit';">单位用户登录</a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="javascript:void(0);" onclick="zhmm()">找回密码</a>
							</td>
						</tr>
					</table>
					<div colspan="2" style=" width:280px; height:25px; background-color:#eee; border-top:1px solid #ccc;"></div>
				</c:when>
				<c:otherwise>
					<script type="text/javascript">
						if (window.parent.window.$.jBox != undefined) {
							window.parent.window.$.jBox.close();
							window.parent.window.location.reload();
						}
					</script>
				</c:otherwise>
			</c:choose>
		</div>
	</form>
</body>
</html>