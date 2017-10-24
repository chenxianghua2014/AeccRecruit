<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<link rel="stylesheet" href="resources/pagination/pagination.css" type="text/css"></link>
<link rel="stylesheet" href="resources/jBox/Skins/Blue/jbox.css" type="text/css"></link>
<link rel="stylesheet" href="resources/validator-0.7.1/jquery.validator.css" type="text/css"></link>
<link href="skins/default/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resources/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="resources/jquery/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript" src="resources/jquery/jquery.form.js"></script>

<script type="text/javascript" src="resources/validator-0.7.1/jquery.validator.js"></script>
<script type="text/javascript" src="resources/validator-0.7.1/local/zh_CN.js"></script>
<script type="text/javascript" src="resources/jBox/jquery.jBox-2.3.min.js"></script>
<script type="text/javascript" src="resources/jBox/jquery.jBox-zh-CN.js"></script>
<script type="text/javascript" src="resources/pagination/jquery.pagination.js"></script>
<script type="text/javascript" src="js/Scdjl.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<style type="text/css">
.inputText {
	width: 40px;
}
</style>
</head>
<body>
	<div class="title">当前位置:招聘管理>收藏的简历</div>
	<div class="editBlock">
		<table>
			<tbody>
				<tr>
					<td height="32" colspan="4" class="subtitle">收藏的简历查询</td>
				</tr>
				<tr>
					<%--					<th width="150"></th>--%>
					<td style="text-align:right;">
						姓名:
						<input name="jtjlkName" type="text" class="inputText" id="jtjlkName" />
						&nbsp; 毕业院校:
						<input name="jtjlkByyx" type="text" class="inputText" id="jtjlkByyx" style="width:95px;" placeholder="请输入学校全称" />
						&nbsp; 专业:
						<input name="jtjlkZy" type="text" class="inputText" id="jtjlkZy" />
						&nbsp; 学历:
						<select name="jtjlkXl" class="inputText" id="jtjlkXl">
							<option value=""></option>
							<option value="大专">大专</option>
							<option value="本科">本科</option>
							<option value="硕士">硕士</option>
							<option value="博士">博士</option>
						</select>
						&nbsp; 优才职位:
						<select name="isuniposition" class="inputText" id="isuniposition">
							<option value=""></option>
							<option value="1">是</option>
							<option value="0">否</option>
						</select>
						&nbsp; 职位:
						<input name="jtjlkZw" type="text" class="inputText" id="jtjlkZw" />
						&nbsp;职位类别:
						<select id="jtjlkGwlb" name="jtjlkGwlb">
							<option value=""></option>
							<option value="综合管理类">综合管理类</option>
							<option value="科研管理类">科研管理类</option>
							<option value="生产管理类">生产管理类</option>
							<option value="经营管理类">经营管理类</option>
							<option value="市场营销类">市场营销类</option>
							<option value="其他管理类">其他管理类</option>
							<option value="研发类">研发类</option>
							<option value="设计类">设计类</option>
							<option value="工艺类">工艺类</option>
							<option value="其他技术类">其他技术类</option>
							<option value="技能类">技能类</option>
							<option value="医护类">医护类</option>
							<option value="教育培训类">教育培训类</option>
							<option value="服务保障类">服务保障类</option>
						</select>
						&nbsp; <label>标注排序：<input id="startpp" name="button" type="checkbox" value="6" /></label>&nbsp;&nbsp;
						<input name="button" type="button" onclick="loadData();" class="inputButton" value="查询" />
						<input name="button" type="button" onclick="loadDataExp();" class="inputButton" value="批量导出" />
						&nbsp;
						<!-- <input name="button" type="button" onclick="showBatch();" class="inputButton" value="批量操作" /> -->
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="dataGrid">
		<table>
			<caption>收藏的简历查询结果</caption>
			<thead>
				<tr>
					<th width="30">
						<input id="checkAll" type="checkbox" />
					</th>
					<th width="50">姓名</th>
					<th width="80">出生日期</th>
					<th>身份证号</th>
					<th width="40">性别</th>
					<th>毕业院校</th>
					<th>专业</th>
					<th width="40">学历</th>
					<!-- <th>普通职位</th>
					<th>优才职位</th> -->
					<th>生源地</th>
					<th width="60" class="alignCenter">测评成绩</th>
					<th width="60" class="alignCenter">面试状态</th>
					<th width="60" class="alignCenter">标注/备注</th>
					<th width="60">投递时间</th>
					<th width="60" class="alignCenter">简历详情</th>
					<th width="60" class="alignCenter">优才详情</th>
					<th width="60" class="alignCenter">操作</th>
				</tr>
			</thead>
			<tbody id="tbList"></tbody>
		</table>
		<table class="page">
			<tr>
				<td style="text-align: right;">
					<div id="Pagination" class="pagination"></div>
				</td>
				<td style="width:265px;text-align: center;">
					当前显示 <span id="start">1</span> - <span id="end">10</span> 条记录 共 <span id="count">0</span> 条记录
				</td>
			</tr>
		</table>
	</div>
	<div class="editBlock" id="divControll" style="display: none;">
		<table>
			<tr>
				<td colspan="2" class="subtitle">操作</td>
			</tr>
			<tbody>
				<tr>
					<td>
						<input type="hidden" id="Id" name="Id" />
						<input type="hidden" id="jtjlkCpcj" name="jtjlkCpcj" />
						<input type="hidden" id="jtjlkCpjg" name="jtjlkCpjg" />
						<input type="hidden" id="jtjlkMszt" name="jtjlkMszt" />
						<input type="hidden" id="UserId" name="UserId" />
						<input type="hidden" id="jtjlkPositionId" name="jtjlkPositionId" />
						<input type="hidden" id="jtjlkUniPositionId" name="jtjlkUniPositionId" />
					</td>
				</tr>
				<tr>
					<td style="text-align: right;">姓名：</td>
					<td id="name"></td>
				</tr>
				<tr>
					<td style="text-align: right;">安排职位：</td>
					<td>
						<span id="zw"></span><span id="tdApzw"><input name="button" type="button" onclick="Apzw('')" class="inputButton" value="安排职位" /> </span>
					</td>
				</tr>
				<tr>
					<td style="text-align: right;">进入测评环节：</td>
					<td>
						<input name="button" type="button" onclick="Tzcp()" class="inputButton" value="通知测评" />
					</td>
				</tr>
				<tr>
					<td style="text-align: right;">进入面试环节：</td>
					<td>
						<input name="button" type="button" onclick="Apms('')" class="inputButton" value="安排面试" />
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="editBlock" id="divControllBatch" style="display: none;">
		<input type="hidden" id="Id" name="Id" />
		<input type="hidden" id="jtjlkCpcj" name="jtjlkCpcj" />
		<input type="hidden" id="jtjlkCpjg" name="jtjlkCpjg" />
		<input type="hidden" id="jtjlkMszt" name="jtjlkMszt" />
		<input type="hidden" id="UserId" name="UserId" />
		<input type="hidden" id="jtjlkPositionId" name="jtjlkPositionId" />
		<input type="hidden" id="jtjlkUniPositionId" name="jtjlkUniPositionId" />
		<table>
			<tr>
				<td colspan="2" class="subtitle">批量操作</td>
			</tr>
			<tbody>
				<tr>
					<td style="text-align: right;">安排职位：</td>
					<td>
						<span id="zwBatch"></span> <span id="tdApzwBatch"><input name="button" type="button" onclick="Apzw('batch')" class="inputButton"
								value="安排职位" /></span>
					</td>
				</tr>
				<tr>
					<td style="text-align: right;">进入测评环节：</td>
					<td>
						<input name="button" type="button" onclick="TzcpBatch();" class="inputButton" value="通知测评" />
					</td>
				</tr>
				<tr>
					<td style="text-align: right;">进入面试环节：</td>
					<td>
						<input name="button" type="button" onclick="Apms('batch')" class="inputButton" value="安排面试" />
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<script language="JavaScript" type="text/JavaScript">
		function showBatch() {
			$("#zwBatch").hide();
			$("#tdApzwBatch").show();
			$("#divControll").hide();
			$("#divControllBatch").show();
			document.body.scrollTop = document.body.scrollHeight;
		}
	</script>
</body>
</html>
