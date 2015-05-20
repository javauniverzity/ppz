<%@include file="fragments/taglib.jsp" %>

<div id="code">
	<strong><spring:message code="code.text1.title"/></strong>
	<br />
	<spring:message code="code.text1"/>
	
	<br />
	<br />
	
	<strong><spring:message code="code.text2.title"/></strong>
	<br />
	<spring:message code="code.text2"/>
	<ul>
		<li><spring:message code="code.text2.li1"/></li>
		<li><spring:message code="code.text2.li2"/></li>
		<li><spring:message code="code.text2.li3"/></li>
	</ul>

	<br />

	<strong><spring:message code="code.text3.title"/></strong>
	<br />
	<spring:message code="code.text3"/>
	
	<br />
	<br />
	
	<strong><spring:message code="code.text4.title"/></strong>
	<ul>
		<li><spring:message code="code.text4.li1"/></li>
		<li><spring:message code="code.text4.li2"/></li>
		<li><spring:message code="code.text4.li3"/></li>
	</ul>
	
	<br />
	<br />
	
	<strong><spring:message code="code.text4"/></strong>
	
	<br />
	<br />
	<br />
	
	<form action="<c:url  value="/code.html" />"  method="post">
		<span><spring:message code="code.entercode" />:</span>
		<input name="code"/>
		<input type="submit" value="odeslat" />
	</form>
	<br />
	<br />
</div>