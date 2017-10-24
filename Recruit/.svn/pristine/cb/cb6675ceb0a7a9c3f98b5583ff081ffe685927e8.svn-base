<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<link href="skins/default/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="resources/jBox/Skins/Blue/jbox.css" type="text/css"></link>
<link rel="stylesheet" href="resources/validator-0.7.1/jquery.validator.css" type="text/css"></link>
<link rel="stylesheet" href="resources/pagination/pagination.css" type="text/css"></link>
<script type="text/javascript" src="resources/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="resources/jquery/jquery-migrate-1.2.1.js"></script>

<script type="text/javascript" src="resources/validator-0.7.1/jquery.validator.js"></script>
<script type="text/javascript" src="resources/validator-0.7.1/local/zh_CN.js"></script>
<script type="text/javascript" src="resources/jBox/jquery.jBox-2.3.min.js"></script>
<script type="text/javascript" src="resources/jBox/jquery.jBox-zh-CN.js"></script>
<script type="text/javascript" src="resources/pagination/jquery.pagination.js"></script>
<script type="text/javascript" src="js/Xdjl.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<style type="text/css">
.inputText {
	width: 40px;
} 
</style>

</head>
<body>
	<div class="title">当前位置:招聘管理>优才详情</div>
	<div  class="editBlock">
		<table>
			<tbody>
				<tr>
					<td height="32" colspan="3" class="subtitle">${userinfo.userName} 的优才职位申请记录:</td>
				</tr>
				<c:choose>
					<c:when test="${Applications == null || fn:length(Applications) == 0}">
						<tr>
							<td height="32" colspan="3" class="subtitle"><p style="text-indent: 5em;">${userinfo.userName} 暂无优才职位申请记录。</p></td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td>申请单位</td>
							<td>申请岗位</td>
							<td>简历状态</td>
						</tr>


						<c:forEach items="${ Applications}" var="map" varStatus="status">
							<tr>
								<td>${ map.sqdw}</td>
								<td>${ map.sqgw}</td>
								<td>${ map.jlsx}</td>
							</tr>
						</c:forEach>

					</c:otherwise>
				</c:choose>
				<tr>
					<td height="32" colspan="3" class="subtitle" align = "center"><input type="button" value="返回" onclick="goback()" /></td>
				</tr>

			</tbody>
		</table>
	</div>

</body>
</html>
