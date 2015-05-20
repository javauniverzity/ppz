<%@include file="fragments/taglib.jsp" %>

<script type="text/javascript">
	function getAvatarDetailDemo(name) {
		if(name == "Zuzana") {
			$('detailTableNameTitle').innerHTML = 'Zuzana';
			$('detailTableIncomes').innerHTML = '0';
			$('detailTableOutcomes').innerHTML = '10 000';
		}
		if(name == "Baruska") {
			$('detailTableNameTitle').innerHTML = 'Baru\u0161ka';
			$('detailTableIncomes').innerHTML = '0';
			$('detailTableOutcomes').innerHTML = '6 000';
		}
		if(name == "Matysek") {
			$('detailTableNameTitle').innerHTML = 'Matýsek';
			$('detailTableIncomes').innerHTML = '0';
			$('detailTableOutcomes').innerHTML = '4 500';
		}
<%--		if(name == "Arcus") {
			$('detailTableNameTitle').innerHTML = 'Arcus';
			$('detailTableIncomes').innerHTML = '0';
			$('detailTableOutcomes').innerHTML = '2 100';
		}
--%>
		if(name == "Auto") {
			$('detailTableNameTitle').innerHTML = 'Auto';
			$('detailTableIncomes').innerHTML = '0';
			$('detailTableOutcomes').innerHTML = '2 000';
		}
		if(name == "Dum") {
			$('detailTableNameTitle').innerHTML = 'D\u016Fm';
			$('detailTableIncomes').innerHTML = '0';
			$('detailTableOutcomes').innerHTML = '7 500';
		}
		$('detailObjectTable').show();
	}
</script>

<div id="ppz">
	<div id="container">
		<div id="leftColumn">
			<div id="logo"></div>
			<div id="time">
				<div id="timeInfo">
					<span id="monthAndYear"><span id="month">${game.month}</span> <span id="year">${game.year}</span></span>
					<br />
					<span class="avatarInfo">${avatar.name} - <span id="avatarAge">${avatar.age}</span></span>
					<c:if test="${family != null && family != ''}">
						<c:forEach var="person" items="${family}">
						<br />
						<span class="avatarInfo" id="avatarInfo${person.type}">${person.name} - <span id="person${person.type}Age">${person.age}</span></span>
						</c:forEach>
					</c:if>
				</div>
				<div id="controlButtons">
					<input type="button" id="startTimer" value="Play" onclick="startTimer();"/>
					<input type="button" id="stepTimer" value="Step" onclick="stepTimer();"/>
					<input type="button" id="stopTimer" value="Pause" disabled="disabled" onclick="stopTimer();"/>
				</div>
				<img id="runningIndicator" src="<c:url value="/img/running.gif" />" style="display: none;"/>
			</div>
			<div id="events">
				<table id="eventTable">
					<tr><th class="date"><spring:message code="ppz.date"/></th><th><spring:message code="ppz.eventname"/></th></tr>
				</table>
		    </div>	      
		</div>
		
		<div id="centerColumn">
		  <div id="surroundings">
			<div id="avatarIcon"><img src="<c:url value="/img/man.png" />" onclick="getAvatarDetailJson();" /></div>
			<div id="partnerIcon"><img src="<c:url value="/img/woman.png" />" onclick="getAvatarDetailDemo('Zuzana');" /></div>
			<div id="child1Icon"><img src="<c:url value="/img/girl.png" />" onclick="getAvatarDetailDemo('Baruska');" /></div>
			<div id="child2Icon"><img src="<c:url value="/img/boy.png" />" onclick="getAvatarDetailDemo('Matysek');" /></div>
			<%-- nasledujicim kodem obalit dalsi cleny rodiny --%>
			<c:if test="${family != null && family != ''}">
				<c:forEach var="person" items="${family}">
					<c:if test="${person.type == 4}">
						<div id="dogIcon"><img src="<c:url value="/img/dog.png" />" onclick="getFamilyDetailJson(4);" /></div>
					</c:if>
				</c:forEach>
			</c:if>
			<div id="houseIcon"><img src="<c:url value="/img/house.png" />" onclick="getAvatarDetailDemo('Dum');" /></div>
			<div id="carIcon"><img src="<c:url value="/img/car.png" />"  onclick="getAvatarDetailDemo('Auto');" /></div>
		  </div>
		  <div id="detail">
		  	<div id="detailObject">
		  		<div id="detailObjectTable" style="display: none;">
			  		<table class="left">
						<tr>
							<th colspan="2" class="alignCenter"><span id="detailTableNameTitle"></span></th>
						</tr>
						<tr>
							<td><spring:message code="ppz.incomes"/></td>
							<td><span id="detailTableIncomes"></span> <spring:message code="ppz.czechcrownsymbol"/></td>
						</tr>
						<tr>
							<td><spring:message code="ppz.outcomes"/></td>
							<td><span id="detailTableOutcomes"></span> <spring:message code="ppz.czechcrownsymbol"/></td>
						</tr>
					</table>
					<div style="float: left; margin-right: 40px; margin-left: 5px;"><a href="<c:url value="/familySetup.html"/>"><spring:message code="ppz.changename"/></a></div>
			  		<div style="float: right; margin-right: 5px;"><a href="javascript: ;"><spring:message code="ppz.detail"/></a></div>
				</div>
		  	</div>
		  	<div id="detailEvent">
		  		<textarea id="detailEventText">Zde jsou vypisovány informace o událostech...</textarea>
		  		<div style="float: left; margin-right: 40px; margin-left: 5px;"><a href="javascript: ;"><spring:message code="ppz.yes"/></a></div>
		  		<div style="float: left;"><a href="javascript: ;"><spring:message code="ppz.no"/></a></div>
		  		
		  		<div style="float: right; margin-right: 5px;"><a href="javascript: ;"><spring:message code="ppz.thanks"/></a></div>
		  	</div>
		  	<div style="clear: both;"></div>
		  </div>
		  <div id="budget">
			<div style="float: left; width: 49%;">
				<table class="left">
					<tr>
						<th colspan="2" class="alignCenter"><spring:message code="ppz.incomes"/></th>
					</tr>
					<tr>
						<td><spring:message code="avatar.income"/></td>
						<td>${avatar.income} <spring:message code="ppz.czechcrownsymbol"/></td>
					</tr>
					<tr>
						<td><spring:message code="avatar.otherincome"/></td>
						<td>${avatar.otherIncome} <spring:message code="ppz.czechcrownsymbol"/></td>
					</tr>
					<tr class="highlightGrey">
						<td><spring:message code="ppz.total"/></td>
						<td>${fAvatar.income} <spring:message code="ppz.czechcrownsymbol"/></td>
					</tr>
				</table>
				<div id="distinct">${fAvatar.distinct} <spring:message code="ppz.czechcrownsymbol"/></div>
				<script type="text/javascript">
					if(!$('distinct').innerHTML.indexOf('-')!= -1) {
						$('distinct').innerHTML = '+ ' + $('distinct').innerHTML;
					}
				</script>
			</div>
		  	<div style="float: right; width: 49%;">
			  	<table class="right">
			  		<tr>
			  			<th colspan="2" class="alignCenter"><spring:message code="ppz.outcomes"/></th>
			  		</tr>
			  		<tr>
			  			<td><spring:message code="avatar.leasecosts"/></td>
			  			<td>${avatar.leaseCosts} <spring:message code="ppz.czechcrownsymbol"/></td>
			  		</tr>
			  		<tr>
			  			<td><spring:message code="avatar.energycosts"/></td>
			  			<td>${avatar.energyCosts} <spring:message code="ppz.czechcrownsymbol"/></td>
			  		</tr>
			  		<tr>
			  			<td><spring:message code="avatar.foodcosts"/></td>
			  			<td>${avatar.foodCosts} <spring:message code="ppz.czechcrownsymbol"/></td>
			  		</tr>
			  		<tr>
			  			<td><spring:message code="avatar.phonecosts"/></td>
			  			<td>${avatar.phoneCosts} <spring:message code="ppz.czechcrownsymbol"/></td>
			  		</tr>
			  		<tr>
			  			<td><spring:message code="avatar.trafficcosts"/></td>
			  			<td>${avatar.trafficCosts} <spring:message code="ppz.czechcrownsymbol"/></td>
			  		</tr>
			  		<tr>
			  			<td><spring:message code="avatar.clothescosts"/></td>
			  			<td>${avatar.clothesCosts} <spring:message code="ppz.czechcrownsymbol"/></td>
			  		</tr>
			  		<tr>
			  			<td><spring:message code="avatar.freetimecosts"/></td>
			  			<td>${avatar.freeTimeCosts} <spring:message code="ppz.czechcrownsymbol"/></td>
			  		</tr>
			  		<tr>
			  			<td><spring:message code="avatar.vacationcosts"/></td>
			  			<td>${avatar.vacationCosts} <spring:message code="ppz.czechcrownsymbol"/></td>
			  		</tr>
			  		<tr>
			  			<td><spring:message code="avatar.othercosts"/></td>
			  			<td>${avatar.otherCosts} <spring:message code="ppz.czechcrownsymbol"/></td>
			  		</tr>
			  		<tr class="highlightGrey">
			  			<td><spring:message code="ppz.total"/></td>
			  			<td>${fAvatar.outcome} <spring:message code="ppz.czechcrownsymbol"/></td>
			  		</tr>
			  	</table>
			  </div>
			</div>
		</div>
		
		<div id="rightColumn">
			<div id="bankProducts">
				<h3><spring:message code="ppz.account"/></h3>
				<div id="accountBalance">156 040 <spring:message code="ppz.czechcrownsymbol"/></div>
				<table>
					<tr>
						<th><spring:message code="ppz.producttype"/></th>
						<th></th>
					</tr>
					<c:if test="${products != null && products != ''}">
						<c:forEach var="product" items="${products}">
							<tr>
								<td><spring:message code="enum.financialassets.${product.type}"/></td>
								<td><span id="product${product.financialAssetsId}Amount">${product.value}</span> <spring:message code="ppz.czechcrownsymbol"/></td>
							</tr>
						</c:forEach>
					</c:if>
			  	</table>
			  	<br />
			  	<a href="<c:url value="/bank.html" />"><spring:message code="ppz.enterbank"/></a>
				<br />
				<br />
			</div>
			
			<div id="insuranceProducts">
				<h3><spring:message code="ppz.insurance"/></h3>
		      	<br />
		      	<table>
			  		<tr>
			  			<th><spring:message code="ppz.producttype"/></th>
			  		</tr>
			  		<tr>
			  			<td>Riz. ziv. poj.</td>
			  		</tr>
			  		<tr>
			  			<td>Povinne ruceni</td>
			  		</tr>
			  		<tr>
			  			<td>Poj. domácnosti</td>
			  		</tr>
		  		</table>
		  		<br />
			</div>
		</div>
	</div>
</div>