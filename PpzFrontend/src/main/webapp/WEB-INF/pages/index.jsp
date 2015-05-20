<%@include file="fragments/taglib.jsp" %>

<div id="index">
	<spring:message code="index.text1"/>
	<div class="iFrame"> 
		<iframe style="width: 425px; height: 349px;" src="http://www.youtube.com/embed/6hCSHB5_lRU?hl=cs&fs=1&autoplay=1" frameborder="0" allowfullscreen="1"></iframe>
	</div>
	<div style="clear: both;"></div>
	<spring:message code="index.text2"/>
	
	<br />
	<br />
	<a style="font-size: 20px;" href="<c:url value="/code.html" />"><spring:message code="code.try"/></a>
	<br />
	<br />
	
</div>
<div style="clear: both;"></div>