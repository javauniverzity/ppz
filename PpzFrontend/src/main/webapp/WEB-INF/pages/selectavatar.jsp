<%@include file="fragments/taglib.jsp" %>

<div id="selectavatar">
	<form action="<c:url  value="/selectavatar.html" />"  method="post">
			<div class="avatarType">
				<div class="avatarData">
					<input type="radio" name="avatar" value="1" checked="checked" />
					<spring:message code="selectavatar.avatar1.name"/><br/>
					<spring:message code="selectavatar.avatar1.description"/>
				</div>
			<img src="<c:url value="/img/avatars/petrvolny.png" />"/>
			<div style="clear: both;"></div>
		</div>
		
		
		<div class="avatarType">
			<div class="avatarData">
				<input type="radio" name="avatar" value="2" />
				<spring:message code="selectavatar.avatar2.name"/><br/>
				<spring:message code="selectavatar.avatar2.description"/>
			</div>
			<img src="<c:url value="/img/avatars/ondrejnehoda.png" />"/>
			<div style="clear: both;"></div>
		</div>
		
		<div class="avatarType">
			<div class="avatarData">
				<input type="radio" name="avatar" value="3" />
				<spring:message code="selectavatar.avatar3.name"/><br/>
				<spring:message code="selectavatar.avatar3.description"/>
			</div>
			<img src="<c:url value="/img/avatars/tomaspohoda.png" />"/>
			<div style="clear: both;"></div>
		</div>
		
		<div class="avatarType">
			<div class="avatarData">
				<input type="radio" name="avatar" value="4" />
				<spring:message code="selectavatar.avatar4.name"/><br/>
				<spring:message code="selectavatar.avatar4.description"/>
			</div>
			<img src="<c:url value="/img/avatars/ivanhouska.png" />"/>
			<div style="clear: both;"></div>
		</div>
		
		<div class="avatarType">
			<div class="avatarData">
				<input type="radio" name="avatar" value="5" />
				<spring:message code="selectavatar.avatar5.name"/><br/>
				<spring:message code="selectavatar.avatar5.description"/>
			</div>
			<img src="<c:url value="/img/avatars/ivanapekna.png" />"/>
			<div style="clear: both;"></div>
		</div>
		
		<div class="avatarType">
			<div class="avatarData">
				<input type="radio" name="avatar" value="6" />
				<spring:message code="selectavatar.avatar6.name"/><br/>
				<spring:message code="selectavatar.avatar6.description"/>
			</div>
			<img src="<c:url value="/img/avatars/sylviekrahulcova.png" />"/>
			<div style="clear: both;"></div>
		</div>
		
		<div class="avatarType">
			<div class="avatarData">
				<input type="radio" name="avatar" value="7" />
				<spring:message code="selectavatar.avatar7.name"/><br/>
				<spring:message code="selectavatar.avatar7.description"/>
			</div>
			<img src="<c:url value="/img/avatars/zuzanastarostliva.png" />"/>
			<div style="clear: both;"></div>
		</div>
		
		<div class="avatarType">
			<div class="avatarData">
				<input type="radio" name="avatar" value="8" />
				<spring:message code="selectavatar.avatar8.name"/><br/>
				<spring:message code="selectavatar.avatar8.description"/>
			</div>
			<img src="<c:url value="/img/avatars/mariepracovita.png" />"/>
		</div>
		<div style="clear: both;"></div>
	
		<hr />
	
		<div id="overview">
		
			<div class="data">
				<strong><spring:message code="ppz.incomes"/></strong><br/>
				<spring:message code="ppz.demo.value1"/>
	
				<br /><br />

				<strong><spring:message code="ppz.outcomes"/></strong><br/>
				<spring:message code="ppz.demo.value5"/>
			</div>
	
			<div class="data">
				<strong><spring:message code="setup.family.title"/></strong><br/>
				<spring:message code="ppz.demo.value2"/>
			</div>
			
			<div class="data">
				<strong><spring:message code="setup.property.title"/></strong><br/>
				<spring:message code="ppz.demo.value3"/><br/>
				<spring:message code="ppz.demo.value4"/>
			</div>
			
			<div>
				<table>
					<tr>
						<th colspan="2"><spring:message code="ppz.demo.value6"/></th>
					</tr>
					<tr>
						<td><spring:message code="ppz.demo.value7"/></td>
						<td><spring:message code="ppz.demo.value8"/></td>
					</tr>
					<tr>
						<td><spring:message code="ppz.demo.value9"/></td>
						<td><spring:message code="ppz.demo.value10"/></td>
					</tr>
					<tr>
						<td><spring:message code="ppz.demo.value11"/></td>
						<td><spring:message code="ppz.demo.value12"/></td>
					</tr>
				</table>
			</div>

		</div>

		<input type="submit" value="<spring:message code="action.selectAndPlay"/>" />
		<br />
		<br />
	</form>		
</div>