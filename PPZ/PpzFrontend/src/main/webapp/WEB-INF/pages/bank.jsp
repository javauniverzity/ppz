<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="fragments/taglib.jsp" %>

<div id="familySetup">
	<div id="container">
		<div id="leftColumn">
			<div id="logo"></div>
		</div>
		
		<div id="centerColumn">
		
			<div id="description">
				
			</div>
			
			<div id="setup">
				<div id="settings">
					<h3></h3>					
					<br />					
					<a href='<spring:url value="bankAdd.html" />'><spring:message code="action.add"/> <spring:message code="enum.financialassets.3"/></a>
					<br />
					<br />
					<table style="width: 100%;">
						<tr>
							<th style="width: 150px;"></th>
							<th style="width: 150px;"></th>
							<th></th>
						</tr>
						<c:forEach var="product" items="${products}">
							<tr>
								<td><spring:message code="enum.financialassets.${product.type}"/></td>
								<td>
									<div class="Product${product.financialAssetsId}Value">
										<span id="Product${product.financialAssetsId}ValueValue">${product.value}</span>
									</div>
									<div class="Product${product.financialAssetsId}ValueEdit" style="display: none">
										<input id="Product${product.financialAssetsId}ValueEditValue" name="value"/>
									</div>
								</td>
								<td>
									<div class="Product${product.financialAssetsId}Value">
										<a href="javascript: ;" id="Product${product.financialAssetsId}ValueEditLink"><spring:message code="action.edit"/></a>
										<a href='<spring:url value="bankRemove.html?id=${product.financialAssetsId}"/>'><spring:message code="action.remove"/></a>
									</div>
									
									<div class="Product${product.financialAssetsId}ValueEdit" style="display: none">
										<input id="Product${product.financialAssetsId}ValueEditSubmit" type="submit" value="odeslat" /> <spring:message code="or"/>
										<a href="javascript: ;" id="Product${product.financialAssetsId}ValueEditCancelLink"><spring:message code="action.cancelChanges"/></a>
									</div>									
								</td>
							</tr>
						</c:forEach>
					</table>
					
					<c:if test="${product != null}">
						<form:form commandName="product" action="bankAdd.html">
							<spring:bind path="product.value">
								<form:input path="value"/>
								<c:if test="${status.errorMessage != ''}"><spring:message code="${status.errorMessage}"/></c:if>
							</spring:bind>
					
							<input type="submit" value='<spring:message code="action.confirm"/>'/>
						</form:form>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>