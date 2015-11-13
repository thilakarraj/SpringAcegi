<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.acegisecurity.ui.AbstractProcessingFilter"%>
<%@ page
	import="org.acegisecurity.ui.webapp.AuthenticationProcessingFilter"%>
<%@ page import="org.acegisecurity.AuthenticationException"%>
<html>
<head>
<script>
  function focusUserName(){
	document.forms[0].j_username.focus();
  }
</script>
<title>Login</title>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<link href="${ctx}/styles/global.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/images/favicon.ico" rel="SHORTCUT ICON" />

</head>


<body onload="focusUserName()">
<div id="container">
<div id="intro">
<div id="image"></div>
<div id="gap"></div>
<br>
<br>
<br>
<br>
<br>

<form action="<c:url value='j_acegi_security_check'/>" method="POST">
<table width=50% border=0 align="center">
	<c:if test="${not empty param.login_error}">
		<tr>
			<td colspan=2><font color="red"> Your login attempt was
			not successful, try again.<BR>
			Reason: <%=((AuthenticationException) session
									.getAttribute(AbstractProcessingFilter.ACEGI_SECURITY_LAST_EXCEPTION_KEY))
									.getMessage()%> </font></td>
			</td>
	</c:if>

	<tr>
		<td>User:</td>
		<td><input type='text' name='j_username'
			<c:if test="${not empty param.login_error}">value='<c:out value="${ACEGI_SECURITY_LAST_USERNAME}"/>'</c:if>></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input type='password' name='j_password'></td>
	</tr>

	<tr>
		<td colspan='2'><input name="submit" type="submit">&nbsp;
		<input name="reset" type="reset" value="Clear"></td>
	</tr>
</table>
</div>
</div>
</form>
</body>
</html>


