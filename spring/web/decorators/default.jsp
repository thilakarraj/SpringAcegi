<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/taglibs.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<title><decorator:title default="MyUsers" /></title>


<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<link href="${ctx}/styles/global.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/images/favicon.ico" rel="SHORTCUT ICON" />

<decorator:head />

</head>
<body onload="<decorator:getProperty property="body.onload" />">

<a name="top"></a>

<div id="container">

<div id="intro">
<div id="image"></div>

<div id="gap"></div>
<br>	Welcome <%= org.acegisecurity.context.SecurityContextHolder.getContext().getAuthentication().getName() %>!
<div id="menu">
<ul>
	<li><a href="<c:url value="/index.jsp"/>">Home</a></li>
	<li><a href="<c:url value="/order/createOrder.jsp"/>">Create
	Order</a></li>
	<li><a href="<c:url value="/order/authorizeOrder.jsp"/>">Authorize
	Order</a></li>
	<li><a href="<c:url value="/j_acegi_logout"/>">Logoff</a></li>
</ul>
</div>

<div id="content">
<decorator:body /></div>
</div>
</div>

</body>
</html>