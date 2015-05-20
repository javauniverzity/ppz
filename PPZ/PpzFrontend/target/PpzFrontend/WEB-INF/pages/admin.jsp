<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="fragments/taglib.jsp" %>

Advisors
<table>
<tr><td>advisor</td><td></td></tr>
<c:forEach var="advisor" items="${advisors}">
<tr><td>${advisor.name}</td>
	<td>
		<form action='<c:url value="admin.html"/>' method="post">
			<input type="hidden" name="advisorId" value="${advisor.advisorId}"/>
			username:<input type="text" name="username"/>
			<input type="submit" value="create"/>
		</form>
	</td>
</tr>
</c:forEach>
</table>

New advisor
<form action='<c:url value="adminAddAdvisor.html"/>' method="post">
	name:<input type="text" name="name"/>
	<input type="submit" value="create"/>
</form>
<br/><br/>
GameCodes
<table>
<tr><td>code</td><td>advisor</td><td>user</td></tr>
<c:forEach var="gameCode" items="${gameCodes}">
<tr><td>${gameCode.code}</td><td>${gameCode.advisor.name}</td><td>${gameCode.user.username}</td></tr>
</c:forEach>
</table>

