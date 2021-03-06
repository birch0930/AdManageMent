<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ include file="include.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Advert Management</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"></link>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
		
</script>
</head>

<body>
	<header>
	<div class="container-fluid">
		<blockquote>
			<p>Advertisement Management System</p>
		</blockquote>
	</div>
	</header>
	<div class="container-fluid">
		<a href="getAdvertList.lol?time=<%=new Date().getTime() %>"  role="button" class="btn btn-default btn-sm">Show</a>	
		<form action="getAdvertById.do"></form>

		<table class="table table-striped">
			<thead>
				<tr>
					<td>Id</td>
					<td>用户</td>
					<td>起始</td>
					<td>过期</td>
					<td>有效期</td>
					<td>剩余</td>
					<td>状态</td>
					<td>Operation</td>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${advertList}" var="var">
					<tr>
						<td>${var.advertId}</td>
						<td>${var.username}</td>
						<td><fmt:formatDate value="${var.startDate}" type="date"
								dateStyle="medium" />
						</td>
						<td><fmt:formatDate value="${var.expiryDate}" type="date"
								dateStyle="medium" />  
						</td>
						<td>${var.servicePeriod} 天</td>
						<c:choose>
						<c:when test="${var.remainedPeriod >= 0 }">
							<td>${var.remainedPeriod} 天</td>
						</c:when>
						<c:otherwise>
							<td>已过期</td>
						</c:otherwise>
						</c:choose>
						<c:choose>
						<c:when test="${var.status == 0 }">
							<td>暂停</td>
							<td><a role="button"
								href="suspendAd.lol?advertId=${var.advertId}"
								class="btn btn-primary disabled" value="" />Suspend</a> <a
								role="button" href="resumeAd.lol?advertId=${var.advertId}"
								class="btn btn-primary">Resume</a>
							</td>
						</c:when>
						
						<c:when test="${var.status ==1}">
							<td>有效</td>
							<td><a role="button"
								href="suspendAd.lol?advertId=${var.advertId}"
								class="btn btn-primary">Suspend</a> <a role="button"
								href="resumeAd.lol?advertId=${var.advertId}"
								class="btn btn-primary disabled">Resume</a>
							</td>
						</c:when>
						<c:otherwise>
							<td>无效</td>
							<td><a role="button"
								href="suspendAd.lol?advertId=${var.advertId}"
								class="btn btn-primary disabled">Suspend</a> <a role="button"
								href="resumeAd.lol?advertId=${var.advertId}"
								class="btn btn-primary disabled">Resume</a>
							</td>
						</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<footer>
	<div class="container-fluid">
		<div></div>
	</div>
	</footer>
</body>
</html>
