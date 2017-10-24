<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>中国航天科工集团公司人才招聘平台</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" href="css/style.css" rel="stylesheet" />
<link type="text/css" href="resources/jBox/Skins/Blue/jbox.css" rel="stylesheet"></link>
<script type="text/javascript" src="resources/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="resources/jquery/jquery-migrate-1.2.1.js"></script>

<script type="text/javascript" src="resources/jBox/jquery.jBox-2.3.min.js"></script>
<script type="text/javascript" src="resources/jBox/jquery.jBox-zh-CN.js"></script>
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
	width: 142px;
}

.loginForm {
	*padding-top: 0px;
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
		document.forms[0].submit();
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

	function UserLogin() {
		window.parent.window.$.jBox.open("iframe:LoginFrm", "用户登录", 280, 230, {
			buttons : {}
		});
	}
</script>
</head>
<body>
	<form id="UserLogin" action="UserLogin" method="post">
		<input type="hidden" id="page" name="page" value="LoginFrmFirst" />
		<div id="loginForm" class="loginForm">
			<c:choose>
				<c:when test="${userLoginSession eq null}">
					<table>
						
						<tr>
							<td>请您先登陆。</td>	
						</tr>
					
						<tr>
							<td colspan="2">
								<a href="javascript:void(0);" onclick="UserLogin()">
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
				</c:when>
				<c:otherwise>
					<input type="hidden" name="userIdcard" value="${userLoginSession.userIdcard}" />
					<input type="hidden" name="userPassword" value="${userLoginSession.userPassword}" />
					<div class="loginForm">
						<table width="100%">
							<tr>
								<td style=" text-align: left;">
									用户名：</u>
								</td>
								<td style=" text-align: left;">${userLoginSession.userIdcard}</td>
							</tr>
							<tr>
								<td style=" text-align: left;">姓&nbsp;&nbsp;&nbsp;名：</td>
								<td style=" text-align: left;">${userLoginSession.userName}</td>
							</tr>
							<tr>
								<td colspan="2">
									<a href="javascript:void(0);" onclick="userUpd('${userLoginSession.userId}')">
										<span>账号管理</span>
									</a>
									<a href="javascript:void(0);" onclick="window.parent.location ='Message';">
										<span style="margin-left:40px;">消息中心</span>
									</a>
								</td>
							</tr>
						</table>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</form>
</body>
</html>