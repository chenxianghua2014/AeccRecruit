<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
</head>
<body>
	<%@ include file="../Main/Header.jsp"%>
	<div class="wrap clr">
		<div class="menu">
			<div class="menuTop">
				<img src="images/title03.png" />
			</div>
			<ul>
				<li><a href="SearchEnterprise">招聘日程</a></li>
				<li><a href="SearchPosition">招聘职位</a></li>
				<li><a href="MyRecruit" style="color:#0046ae;">我的求职</a></li>
			</ul>
		</div>
		<div class="content">
			<div class="conTop">
				<span>您的当前位置：首页 >> 校园招聘 >> 我的求职 >> 优才计划收藏</span> <img src="images/tag04.png" />&nbsp; <strong>我的求职</strong>My Recruit
			</div>
			<div class="result">
				<div class="Tabbg">
					<a href="MyRecruit">我的简历</a>
					<a href="MyApplication">我的申请</a>
					<a href="MyCollection">我的收藏</a>
					<a class="spe" href="MyUniApplication">优才计划申请</a>
					<a class="spe Tabactive" href="MyUniCollection">优才计划收藏</a>
					<a href="Message">消息中心</a>
				</div>
				<div class="resultTitle">
					<img src="images/tag05.png" />我的收藏记录
				</div>
				<c:choose>

					<c:when test="${positions == null || fn:length(positions) == 0}">
						<p style="text-indent: 5em;">您暂无优才职位收藏记录。</p>
					</c:when>

					<c:otherwise>
						<table width="800px">
							<thead>
								<tr>
									<td>职位名称</td>
									<td>职位类别</td>
									<td>学历要求</td>
									<td>招聘专业</td>
									<td>需求人数</td>
									<td>招聘单位</td>
									<td>工作地点</td>
									<td>发布时间</td>
									<td style="width:180px">&nbsp;</td>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${userLoginSession eq null}">
										<script type="text/javascript">
											$.jBox.open("iframe:LoginFrm",
													"用户登录", 280, 200, {
														buttons : {}
													});
										</script>
									</c:when>
									<c:otherwise>
										<c:forEach items="${ positions}" var="map" varStatus="status">
											<tr>
												<td>${ map.positionName}</td>
												<td>${ map.positionType}</td>
												<td>${ map.positionXlyq}</td>
												<td>${ map.positionZpzy}</td>
												<td>${ map.positionXqrs}</td>
												<td>${ map.positionZsdw}</td>
												<td>${ map.positionWorkaddress}</td>
												<td><fmt:formatDate value="${ map.positionAddtime}" type="date" dateStyle="long" /></td>
												<td><a href="javascript:void(0);" onclick="window.location.href = 'PositionDetails?id=${ map.positionId}'">查看详情</a>&nbsp;&nbsp; <a
														href="javascript:void(0);" onclick="ApplyPosition('${ map.positionId}')">申请岗位</a>&nbsp;&nbsp; <a href="javascript:void(0);"
														onclick="CancelPosition('${ map.positionId}')">取消收藏</a>&nbsp;&nbsp;</td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
	</div>
	<%@ include file="../Main/Footer.jsp"%>
</body>
<script type="text/javascript">
	function ShowLogin() {
		$.jBox.open("iframe:LoginFrm", "用户登录", 280, 200, {
			buttons : {}
		});
	}
	function ApplyPosition(id) {
		window.location.href = "ApplyPosition?id=" + id + "&page=MyCollection";
	}
	function CancelPosition(id) {
		window.location.href = "CancelUniPosition?id=" + id;
	}
</script>
</html>