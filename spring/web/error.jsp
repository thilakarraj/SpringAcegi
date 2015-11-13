<%-- SiteMesh has a bug where error pages aren't decorated - hence the full HTML --%>
<%@ page language="java" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
		   <link href="${ctx}/styles/global.css" type="text/css" rel="stylesheet"/>
		   <link href="${ctx}/images/favicon.ico" rel="SHORTCUT ICON"/>
		<title>Error!</title>
	</head>	

An Error has occurred in this application.

<% if (exception != null) { %>
    <pre><% exception.printStackTrace(new java.io.PrintWriter(out)); %></pre>
<% } else { %>
    Please contact your System Administrator or <a href="../j_acegi_logout">click here</a> to go to Home Page.
<% } %>

</html>