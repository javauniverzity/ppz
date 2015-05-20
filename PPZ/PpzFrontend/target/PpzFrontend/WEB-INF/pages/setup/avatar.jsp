<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../fragments/taglib.jsp" %>

<div id="avatarSetup">
	<div id="container">
		<div id="leftColumn">
			<div id="logo"></div>
		</div>
		
		<div id="centerColumn">
			<div id="description">
				<spring:message code="setup.family.about"/>
			</div>

			<div id="avatarCreate">
				<c:if test="${avatar != null}">
					<form:form commandName="avatar" action="avatarSetup.html">
						<table>
							<tr>
								<th colspan="2" class="alignCenter">
									<spring:message code="setup.avatar.subTitle"/>
								</th>
							</tr>
							<tr>
								<spring:bind path="avatar.name">
									<td class="alignRight">
										<spring:message code="avatar.name"/>:
									</td>
									<td>
										<form:input path="name" />
										<c:if test="${status.errorMessage != ''}"><br /><span class="error"><spring:message code="${status.errorMessage}"/></span></c:if>
									</td>
								</spring:bind>
							</tr>
							<tr>
								<spring:bind path="avatar.age">
									<td  class="alignRight">
										<spring:message code="avatar.age"/>:
									</td>
									<td>
										<form:input path="age"/>
										<c:if test="${status.errorMessage != ''}"><br /><span class="error"><spring:message code="${status.errorMessage}"/></span></c:if>
									</td>
								</spring:bind>
							</tr>
							
							<tr class="alignCenter highlightGrey"><td colspan="2"><spring:message code="avatar.incomes"/></td></tr>
							
							<tr>
								<spring:bind path="avatar.income">
									<td  class="alignRight">
										<spring:message code="avatar.income"/>:
									</td>
									<td>
										<form:input path="income"/>
										<c:if test="${status.errorMessage != ''}"><br /><span class="error"><spring:message code="${status.errorMessage}"/></span></c:if>
									</td>
								</spring:bind>
							</tr>
							<tr>
								<spring:bind path="avatar.otherIncome">
									<td  class="alignRight">
										<spring:message code="avatar.otherincome"/>:
									</td>
									<td>
										<form:input path="otherIncome"/>
										<c:if test="${status.errorMessage != ''}"><br /><span class="error"><spring:message code="${status.errorMessage}"/></span></c:if>
									</td>
								</spring:bind>
							</tr>
							
							<tr class="alignCenter highlightGrey"><td colspan="2"><spring:message code="avatar.outcomes"/></td></tr>
							
							<tr>
								<spring:bind path="avatar.leaseCosts">
									<td  class="alignRight">
										<spring:message code="avatar.leasecosts"/>:
									</td>
									<td>
										<form:input path="leaseCosts"/>
										<c:if test="${status.errorMessage != ''}"><br /><span class="error"><spring:message code="${status.errorMessage}"/></span></c:if>
									</td>
								</spring:bind>
							</tr>
							<tr>
								<spring:bind path="avatar.energyCosts">
									<td  class="alignRight">
										<spring:message code="avatar.energycosts"/>:
									</td>
									<td>
										<form:input path="energyCosts"/>
										<c:if test="${status.errorMessage != ''}"><br /><span class="error"><spring:message code="${status.errorMessage}"/></span></c:if>
									</td>
								</spring:bind>
							</tr>
							<tr>
								<spring:bind path="avatar.foodCosts">
									<td  class="alignRight">
										<spring:message code="avatar.foodcosts"/>:
									</td>
									<td>
										<form:input path="foodCosts"/>
										<c:if test="${status.errorMessage != ''}"><br /><span class="error"><spring:message code="${status.errorMessage}"/></span></c:if>
									</td>
								</spring:bind>
							</tr>
							<tr>
								<spring:bind path="avatar.phoneCosts">
									<td  class="alignRight">
										<spring:message code="avatar.phonecosts"/>:
									</td>
									<td>
										<form:input path="phoneCosts"/>
										<c:if test="${status.errorMessage != ''}"><br /><span class="error"><spring:message code="${status.errorMessage}"/></span></c:if>
									</td>
								</spring:bind>
							</tr>
							<tr>
								<spring:bind path="avatar.trafficCosts">
									<td  class="alignRight">
										<spring:message code="avatar.trafficcosts"/>:
									</td>
									<td>
										<form:input path="trafficCosts"/>
										<c:if test="${status.errorMessage != ''}"><br /><span class="error"><spring:message code="${status.errorMessage}"/></span></c:if>
									</td>
								</spring:bind>
							</tr>
							<tr>
								<spring:bind path="avatar.clothesCosts">
									<td  class="alignRight">
										<spring:message code="avatar.clothescosts"/>:
									</td>
									<td>
										<form:input path="clothesCosts"/>
										<c:if test="${status.errorMessage != ''}"><br /><span class="error"><spring:message code="${status.errorMessage}"/></span></c:if>
									</td>
								</spring:bind>
							</tr>
							<tr>
								<spring:bind path="avatar.freeTimeCosts">
									<td  class="alignRight">
										<spring:message code="avatar.freetimecosts"/>:
									</td>
									<td>
										<form:input path="freeTimeCosts"/>
										<c:if test="${status.errorMessage != ''}"><br /><span class="error"><spring:message code="${status.errorMessage}"/></span></c:if>
									</td>
								</spring:bind>
							</tr>
							<tr>
								<spring:bind path="avatar.vacationCosts">
									<td  class="alignRight">
										<spring:message code="avatar.vacationcosts"/>:
									</td>
									<td>
										<form:input path="vacationCosts"/>
										<c:if test="${status.errorMessage != ''}"><br /><span class="error"><spring:message code="${status.errorMessage}"/></span></c:if>
									</td>
								</spring:bind>
							</tr>
							<tr>
								<spring:bind path="avatar.otherCosts">
									<td  class="alignRight">
										<spring:message code="avatar.othercosts"/>:
									</td>
									<td>
										<form:input path="otherCosts"/>
										<c:if test="${status.errorMessage != ''}"><br /><span class="error"><spring:message code="${status.errorMessage}"/></span></c:if>
									</td>
								</spring:bind>
							</tr>
							
							<tr>
								<td colspan="2" class="alignCenter">
									<input type="submit" value='<spring:message code="action.confirm"/>'/>
								</td>
							</tr>
						</table>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
</div>