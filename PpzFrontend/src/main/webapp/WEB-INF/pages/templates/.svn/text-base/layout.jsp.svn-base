<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title><tiles:insertAttribute name="title" /></title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/stylesheet.css"/>"/>

		<tiles:insertAttribute name="head" />
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<tiles:insertAttribute name="header" />
			
				<ul id="menu">
					<tiles:insertAttribute name="menu" />
				</ul>
			</div>
			<div id="center">			
				<div id="submenu">
					<tiles:insertAttribute name="submenu" />
				</div>
		
				<tiles:insertAttribute name="messages" />
		
				<div id="content">
					<tiles:insertAttribute name="content" />
				</div>
				<div style="clear: both;"></div>
			</div>
			
			<div id="footer">
				<tiles:insertAttribute name="footer" />
			</div>
		</div>
	</body>
</html>