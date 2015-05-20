<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../fragments/taglib.jsp" %>

<div id="familySetup">
	<div id="container">
		<div id="leftColumn">
			<div id="logo"></div>
		</div>
		
		<div id="centerColumn">
		
			<div id="description">
				<spring:message code="setup.family.about"/>
			</div>
			
			<div id="setup">
				<ul id="tabs">
					<li class="tab active"><a href="familySetup.html"><spring:message code="setup.family.title"/></a></li>
					<li class="tab"><a href="setupProperty.html"><spring:message code="setup.property.title"/></a></li>
					<li class="tab"><a href="setupFinancialProducts.html"><spring:message code="setup.financialProducts.title"/></a></li>
					<li class="tab"><a href="setupBudget.html"><spring:message code="setup.budget.title"/></a></li>
				</ul>
				<div id="settings">
					<h3><spring:message code="setup.family.subTitle"/></h3>					
					<br />					
					<a href='<spring:url value="familySetupAdd.html" />'><spring:message code="action.add"/></a>
					<br />
					<br />
					<table style="width: 100%;">
						<tr>
							<th style="width: 150px;"></th>
							<th style="width: 150px;"><spring:message code="setup.family.name"/></th>
							<th style="width: 50px;"><spring:message code="setup.family.age"/></th>
							<th></th>
						</tr>
						<c:if test="${avatar != null && avatar != ''}">
						<tr>
							<td><spring:message code="setup.family.you"/></td>
							<td>${avatar.name}</td>
							<td>${avatar.age}</td>
							<td></td>
						</tr>
						</c:if>
						
						
						<c:forEach var="person" items="${family}">
							<tr>
								<td><spring:message code="ppz.dog"/></td>
								<td>
									<div class="LinkedPerson${person.linkedPersonId}Value">
										<span id="LinkedPerson${person.linkedPersonId}ValueName">${person.name}</span>
									</div>
									<div class="LinkedPerson${person.linkedPersonId}ValueEdit" style="display: none">
										<input id="LinkedPerson${person.linkedPersonId}ValueEditName" name="value"/>
									</div>
								</td>
								<td>
									${person.age}
								</td>
								<td>
									<div class="LinkedPerson${person.linkedPersonId}Value">
										<a href="javascript: ;" id="LinkedPerson${person.linkedPersonId}ValueEditLink"><spring:message code="action.edit"/></a>
										<a href='<spring:url value="familySetupRemove.html?id=${person.linkedPersonId}"/>'><spring:message code="action.remove"/></a>
									</div>
									
									<div class="LinkedPerson${person.linkedPersonId}ValueEdit" style="display: none">
										<input id="LinkedPerson${person.linkedPersonId}ValueEditSubmit" type="submit" value="odeslat" /> <spring:message code="or"/>
										<a href="javascript: ;" id="LinkedPerson${person.linkedPersonId}ValueEditCancelLink"><spring:message code="action.cancelChanges"/></a>
									</div>									
								</td>
								<%-- <span id="LinkedPerson${person.linkedPersonId}ValueEdit" style="display: none">
									1: <input id="LinkedPerson${person.linkedPersonId}ValueEditName" name="value"/><br/>
									2: <input id="LinkedPerson${person.linkedPersonId}ValueEditAge" name="value2"/><br/>
									<span id="LinkedPerson${person.linkedPersonId}ValueEditError"></span>
									
								</span>
								
								</td>
								--%>
							</tr>
						</c:forEach>
						<c:if test="${linkedPerson != null && linkedPerson != ''}">
						<form:form commandName="linkedPerson" action="familySetupAdd.html">
							<tr>
								<td><select><option value="1">Pes</option></select></td>
								<td>
									<spring:bind path="linkedPerson.name">
										<form:input path="name"/>
										<c:if test="${status.errorMessage != ''}"><spring:message code="${status.errorMessage}"/></c:if>
									</spring:bind>
								</td>
								<td></td>
								<td><input type="submit" value='<spring:message code="action.confirm"/>'/></td>
							</tr>
						</form:form>
						</c:if>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>