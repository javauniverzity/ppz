<%@include file="fragments/taglib.jsp" %>

<div id="login">
	<c:if test="${not empty param.login_error}">
	    <font color="red">
		<spring:message code="login.badlogin"/><br/><br/>
	    <spring:message code="login.reason"/>: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
	    </font>
	</c:if>
	
	<form name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
	    <table class="login">
	    	<tr><th colspan="2"><spring:message code="login.title"/></th></tr>
	    	<tr><td colspan="2" style="height: 8px;"></td></tr>
	        <tr><td class="alignRight" style="width: 100px;"><spring:message code="login.username"/>:</td><td><input type='text' name='j_username' value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/></td></tr>
	        <tr><td class="alignRight" style="width: 100px;"><spring:message code="login.password"/>:</td><td><input type='password' name='j_password'></td></tr>
	        <tr><td class="alignRight" style="width: 100px;"><input type="checkbox" name="_spring_security_remember_me"></td><td><spring:message code="login.dontask"/></td></tr>
	
	        <tr><td colspan="2" class="alignCenter"><input name="submit" value="<spring:message code="login.submit"/>" type="submit"></td></tr>
	        <%-- zbytecny formularovy prvek --%>
	        <%--<tr><td colspan='2'><input name="reset" value="<spring:message code="login.reset"/>" type="reset"></td></tr>--%>
	    </table>
	</form>
</div>
