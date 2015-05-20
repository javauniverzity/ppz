<%@include file="taglib.jsp" %>

<c:if test="${principal != null}">
	<a href="<c:url value="/ppz.html" />" style="margin-right: 20px;"><spring:message code="header.ppz"/></a>
	<a href="<c:url value="/avatarSetup.html" />" style="margin-right: 20px;"><spring:message code="header.setupavatar"/></a>
	<a href="<c:url value="/familySetup.html" />" style="margin-right: 20px;"><spring:message code="header.setupfamily"/></a>
	<a href="<c:url value="/bank.html" />"><spring:message code="header.bank"/></a>
</c:if>

<div style="float:right" class="alignRight">
    <c:choose>
        <c:when test="${principal != null}">
        <span style="color: #8A8A8A;"><spring:message code="header.logged"/>:</span>
            ${principal.username}
            <a href="<spring:url value="/j_spring_security_logout"/>"><spring:message code="header.logout"/></a>
        </c:when>
        <c:otherwise>
            <a href="<spring:url value="/login.html" />"><spring:message code="header.login"/></a>
        </c:otherwise>
    </c:choose>
</div>  
<div style="clear: both;"></div>