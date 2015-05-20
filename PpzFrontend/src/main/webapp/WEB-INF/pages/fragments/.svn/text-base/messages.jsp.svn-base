<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	Object errors = new ArrayList<String>();
	Object infos = new ArrayList<String>();

	if (request != null && request.getSession() != null) {
		if (request.getSession().getAttribute("errors") != null) {
			errors = request.getSession().getAttribute("errors");
		}
		if (request.getSession().getAttribute("infos") != null) {
			infos = request.getSession().getAttribute("infos");
		}
	}
%>

<c:if test="${infos != '' && infos != null && infos != '[]'}">
	<div class="messageInfo" onclick="this.style.display='none'">
		<c:forEach items="${infos}" var="infoMessage" >
			<spring:message code="${infoMessage}" />
			<br>
		</c:forEach>
	</div>
</c:if>

<c:if test="${errors != '' && errors != null && errors != '[]'}">
	<div class="messageError" onclick="this.style.display='none'">
		<c:forEach items="${errors}" var="errorMessage">
			<spring:message code="${errorMessage}" />
			<br>
		</c:forEach>
	</div>
</c:if>

<%
	if (request != null && request.getSession() != null) {
		request.getSession().setAttribute("errors", null);
		request.getSession().setAttribute("infos", null);
	}
%>
