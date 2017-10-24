<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
body {
	font-family: SimSun;
}

table.admintable {
	border: 1px solid #000000;
	border-collapse: collapse;
	table-layout: fixed;
	word-break: break-strict;
}

.titleBg {
	background-color: #c6d9f1;
	font-weight: 600;
}

.titleHi {
	height: 70px;
	font-weight: 800;
}
</style>
</head>
<body>
	<table width="100%">
		<tr>
			<td align="center"><h1>${ mv.model['resume'].resumeName }简历
				</h1></td>
		</tr>
	</table>
	<table width="100%" height="300px" border="1" class="admintable">
		<tr>
			<td colspan="5" class="titleHi">应聘岗位： <c:forEach
					items="${ mv.model['Ma']}" var="map" varStatus="status">
${ map.sqgw}
<c:if test="${fn:length(mv.model['Ma']) != status.index + 1}">
、
</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td colspan="5" class="titleBg">基本信息:</td>
		</tr>
		<tr>
			<td width="17%" align="center">姓名</td>
			<td width="24%" align="center">${ mv.model['resume'].resumeName }</td>
			<td width="15%" align="center">性别</td>
			<td width="23%" align="center">${ mv.model['resume'].resumeSex }</td>
			<td width="21%" rowspan="3" align="center"><img
				src="${ mv.model['resume'].resumePhotos }" width="90" height="100" />
			</td>
		</tr>
		<tr>
			<td align="center">出生日期</td>
			<td align="center">${ mv.model['resume'].resumeBirthday }</td>
			<td align="center">生源地</td>
			<td align="center">${ mv.model['resume'].resumeRxqhkszcsProvince }-${mv.model['resume'].resumeRxqhkszcsCity }</td>
		</tr>
		<tr>
			<td align="center">身份证号</td>
			<td colspan="3" align="center">${ mv.model['resume'].resumeSfzh }</td>
		</tr>
		<tr>
			<td colspan="5" class="titleBg">联系信息:</td>
		</tr>
		<tr>
			<td width="17%" align="center">手机号码</td>
			<td width="24%" align="center">${ mv.model['resume'].resumeTelphone }</td>
			<td width="15%" align="center">电子邮箱</td>
			<td width="44%" colspan="2" align="center">${ mv.model['resume'].resumeEmail }</td>
		</tr>
	</table>
	<table width="100%" border="1" class="admintable">
		<tr height="50px">
			<td colspan="6" class="titleBg">最高学历:</td>
		</tr>
		<tr height="50px">
			<td width="16%" align="center">时间</td>
			<td width="16%" align="center">毕业学校</td>
			<td width="16%" align="center">专业</td>
			<td width="16%" align="center">学历</td>
			<td width="16%" align="center">院系排名</td>
			<td width="20%" align="center">班级排名</td>
		</tr>
		<c:forEach items="${ mv.model['Jyjl']}" begin="0" end="0" var="map"
			varStatus="status">
			<tr height="50px">
				<td width="16%" align="center">${map.resumeJdsj}到${map.resumeJdsj1}</td>
				<td width="16%" align="center">${map.resumeXxmc}</td>
				<td width="16%" align="center">${map.resumeZyl}-${map.resumeZy}</td>
				<td width="16%" align="center">${map.resumeXl}</td>
				<td width="16%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeYxpm,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="20%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeBjpm,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
			</tr>
			<tr height="50px">
				<td width="16%" align="center">专业描述</td>
				<td colspan="5" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeZyms,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
			</tr>
		</c:forEach>
	</table>

	<table width="100%" border="1" class="admintable">
		<tr height="50px">
			<td colspan="6" class="titleBg">其他学历:</td>
		</tr>
		<tr height="50px">
			<td width="16%" align="center">时间</td>
			<td width="16%" align="center">毕业学校</td>
			<td width="16%" align="center">专业</td>
			<td width="16%" align="center">学历</td>
			<td width="16%" align="center">院系排名</td>
			<td width="20%" align="center">班级排名</td>
		</tr>
		<c:forEach items="${ mv.model['Jyjl']}" begin="1" var="map"
			varStatus="status">
			<tr height="50px">
				<td width="16%" align="center">${map.resumeJdsj}到${map.resumeJdsj1}</td>
				<td width="16%" align="center">${map.resumeXxmc}</td>
				<td width="16%" align="center">${map.resumeZyl}-${map.resumeZy}</td>
				<td width="16%" align="center">${map.resumeXl}</td>
				<td width="16%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeYxpm,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="20%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeBjpm,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
			</tr>
			<tr height="50px">
				<td width="16%" align="center">专业描述</td>
				<td colspan="5" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeZyms,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
			</tr>
		</c:forEach>
	</table>

	<table width="100%" border="1" class="admintable">
		<tr height="50px">
			<td colspan="6" class="titleBg">语言能力:</td>
		</tr>
		<c:forEach items="${ mv.model['Yynl']}" var="map" varStatus="status">
			<tr height="50px">
				<td width="16%" rowspan="2" align="center">语言类别</td>
				<td width="16%" rowspan="2" align="center">${map.resumeYylb}</td>
				<td width="16%" align="center">听说能力</td>
				<td width="16%" align="center">${map.resumeTsnl}</td>
				<td width="16%" align="center">读写能力</td>
				<td width="16%" align="center">${map.resumeDxnl}</td>
			</tr>
			<tr height="50px">
				<td width="16%" align="center">等级考试</td>
				<td width="16%" align="center">${map.resumeDjks}</td>
				<td width="16%" align="center">语言分数</td>
				<td width="16%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeYyfs,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
			</tr>
		</c:forEach>
	</table>

	<table width="100%" border="1" class="admintable">
		<tr height="50px">
			<td colspan="7" class="titleBg">工作经历:</td>
		</tr>
		<tr height="50px">
			<td width="14%" align="center">时间</td>
			<td width="14%" align="center">单位</td>
			<td width="14%" align="center">城市</td>
			<td width="14%" align="center">部门</td>
			<td width="14%" align="center">职位</td>
			<td width="14%" align="center">行业</td>
			<td width="14%" align="center">描述</td>
		</tr>
		<c:forEach items="${ mv.model['Gzjl']}" var="map" varStatus="status">
			<tr height="50px">
				<td width="14%" align="center">${map.resumeGzsj}到${map.resumeGzsj1}</td>
				<td width="14%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeGzgs,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="14%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeGzcs,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="14%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeGzbm,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="14%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeGzzw,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="14%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeGzhy,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="14%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeGzms,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
			</tr>
		</c:forEach>
	</table>

	<table width="100%" border="1" class="admintable">
		<tr height="50px">
			<td colspan="3" class="titleBg">校内奖励:</td>
		</tr>
		<tr height="50px">
			<td width="25%" align="center">时间</td>
			<td width="50%" align="center">奖项名称</td>
			<td width="25%" align="center">奖励级别</td>
		</tr>
		<c:forEach items="${ mv.model['Xnjl']}" var="map" varStatus="status">
			<tr height="50px">
				<td width="25%" align="center">${map.resumeHjsj}</td>
				<td width="50%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeJxmc,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="25%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeJlsm,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
			</tr>
		</c:forEach>
	</table>

	<table width="100%" border="1" class="admintable">
		<tr height="50px">
			<td colspan="3" class="titleBg">校内职务:</td>
		</tr>
		<tr height="50px">
			<td width="25%" align="center">时间</td>
			<td width="50%" align="center">任职名称</td>
			<td width="25%" align="center">职业和业绩:</td>
		</tr>
		<c:forEach items="${ mv.model['Xnzw']}" var="map" varStatus="status">
			<tr height="50px">
				<td width="25%" align="center">${map.resumeRzsj}到${map.resumeRzsj1}</td>
				<td width="50%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeXnzwmc,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="25%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeZzhyj,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
			</tr>
		</c:forEach>
	</table>

	<table width="100%" border="1" class="admintable">
		<tr height="50px">
			<td colspan="3" class="titleBg">实践经历:</td>
		</tr>
		<tr height="50px">
			<td width="25%" align="center">时间</td>
			<td width="50%" align="center">实践名称</td>
			<td width="25%" align="center">实践描述</td>
		</tr>
		<c:forEach items="${ mv.model['Sjjl']}" var="map" varStatus="status">
			<tr height="50px">
				<td width="25%" align="center">${map.resumeSjsj}-${map.resumeSjsj1}</td>
				<td width="50%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeSjmc,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="25%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeSjms,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
			</tr>
		</c:forEach>
	</table>

	<table width="100%" border="1" class="admintable">
		<tr height="50px">
			<td colspan="7" class="titleBg">实习经历:</td>
		</tr>
		<tr height="50px">
			<td width="14%" align="center">时间</td>
			<td width="14%" align="center">单位</td>
			<td width="14%" align="center">城市</td>
			<td width="14%" align="center">部门</td>
			<td width="14%" align="center">职位</td>
			<td width="14%" align="center">所属行业</td>
			<td width="14%" align="center">经历描述</td>
		</tr>
		<c:forEach items="${ mv.model['Sxjl']}" var="map" varStatus="status">
			<tr height="50px">
				<td width="14%" align="center">${map.resumeSxsj}到${map.resumeSxsj1}</td>
				<td width="14%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeSxgs,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="14%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeSxcs,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="14%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeSxbm,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="14%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeSxzw,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="14%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeSxhy,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="14%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeSxms,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
			</tr>
		</c:forEach>
	</table>

	<table width="100%" border="1" class="admintable">
		<tr height="50px">
			<td colspan="6" class="titleBg">项目经验:</td>
		</tr>
		<tr height="50px">
			<td width="16%" align="center">时间</td>
			<td width="16%" align="center">项目名称</td>
			<td width="16%" align="center">团队规模</td>
			<td width="16%" align="center">项目角色</td>
			<td width="16%" align="center">项目简介</td>
			<td width="16%" align="center">项目成果</td>
		</tr>
		<c:forEach items="${ mv.model['Xmjy']}" var="map" varStatus="status">
			<tr height="50px">
				<td width="16%" align="center">${map.resumeCysj}到${map.resumeCysj1}</td>
				<td width="16%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeXmmc,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="16%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeTdgm,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="16%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeXmjs,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="16%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeXmjj,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="16%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeXmcg,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
			</tr>
		</c:forEach>
	</table>

	<table width="100%" border="1" class="admintable">
		<tr height="50px">
			<td colspan="4" class="titleBg">培训经历:</td>
		</tr>
		<tr height="50px">
			<td width="20%" align="center">时间</td>
			<td width="20%" align="center">培训名称</td>
			<td width="25%" align="center">培训机构</td>
			<td width="35%" align="center">培训内容</td>
		</tr>
		<c:forEach items="${ mv.model['Pxjl']}" var="map" varStatus="status">
			<tr height="50px">
				<td width="20%" align="center">${map.resumePxsj}到${map.resumePxsj1}</td>
				<td width="20%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumePxmc,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="25%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumePxjg,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
				<td width="35%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumePxnr,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
			</tr>
		</c:forEach>
	</table>

	<table width="100%" border="1" class="admintable">
		<tr height="50px">
			<td colspan="2" class="titleBg">证书:</td>
		</tr>
		<tr height="50px">
			<td width="30%" align="center">证书种类</td>
			<td width="70%" align="center">证书名称</td>
		</tr>
		<c:forEach items="${ mv.model['Zs']}" var="map" varStatus="status">
			<tr height="50px">
				<td width="30%" align="center">${map.resumeHdzs}</td>
				<td width="70%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeQtzs,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
			</tr>
		</c:forEach>
	</table>

	<table width="100%" border="1" class="admintable">
		<tr height="50px">
			<td colspan="2" class="titleBg">IT技能:</td>
		</tr>
		<c:forEach items="${ mv.model['ITjn']}" var="map" varStatus="status">
			<tr height="50px">
				<td width="30%" align="center">IT精通技能</td>
				<td width="70%" align="center">${map.resumeITjtjn}</td>
			</tr>
			<tr height="50px">
				<td width="30%" align="center">IT熟悉技能</td>
				<td width="70%" align="center">${map.resumeITsxjn}</td>
			</tr>
			<tr height="50px">
				<td width="30%" align="center">其他IT技能</td>
				<td width="70%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeQtjn,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
			</tr>
		</c:forEach>
	</table>

	<table width="100%" border="1" class="admintable">
		<tr height="50px">
			<td colspan="2" class="titleBg">其他信息:</td>
		</tr>
		<tr height="50px">
			<td width="30%" align="center">其他信息类别</td>
			<td width="70%" align="center">信息描述</td>
		</tr>
		<c:forEach items="${ mv.model['Qtxx']}" var="map" varStatus="status">
			<tr height="50px">
				<td width="30%" align="center">${ map.resumeQtxxlb1 }-${ map.resumeQtxxlb2 }</td>
				<td width="70%" align="center"><c:set var="string1"
						value="${fn:replace(map.resumeXxms,'|', '｜')}" /> <c:set
						var="string2" value="${fn:replace(string1,'<', '＜')}" /> <c:set
						var="string3" value="${fn:replace(string2,'>', '＞')}" />
					${fn:replace(string3,'-',
					'－')}</td>
			</tr>
		</c:forEach>
	</table>

	<table width="100%" border="1" class="admintable">
		<tr height="50px">
			<td class="titleBg">附件内容</td>
		</tr>
		<tr height="150px">
			<td><c:if
					test="${mv.model['resume'].resumeZzjl!=null&&mv.model['resume'].resumeZzjl!=''}">
					<a href="${mv.model['resume'].resumeZzjl}">自制个人简历</a>
					<br />
					<br />
					<br />
				</c:if> 附件:<br /> <c:forEach items="${ mv.model['Fj']}" var="map"
					varStatus="status">
					<a href="javascript:void(0)"
						onclick="window.open('${ map.resumeFj }')">查看文件</a>
				</c:forEach></td>
		</tr>
	</table>
</body>
</html>
