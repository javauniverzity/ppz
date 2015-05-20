<%@include file="fragments/taglib.jsp" %>

<div>
	<c:if test="${demo != null}">
		<spring:message code="ppz.demo.value13" /><br/>	
		<img style="width: 1043px" src="<c:url value="/img/demo.png" />"/>
	</c:if>

	<c:if test="${demo == null}">
		<spring:message code="ppz.demo.value13" />		
	</c:if>	
	
</div>