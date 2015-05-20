<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="<c:url value="/js/prototype.js"/>" ></script>
<script type='text/javascript' src='<c:url value="/dwr/engine.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/util.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/interface/PpzAjaxComponentJS.js"/>'></script>

<script type="text/javascript">

	var timer;
	
	function timeout() {
		timer = setTimeout("getJson(true)", 1500);	
	}
	
	function stopTimer() {
		clearTimeout(timer);
		$('runningIndicator').hide();
		$('stopTimer').disabled='disabled';
		$('startTimer').disabled='';
	}
	
	function startTimer() {
		getJson(true);
	}
	
	function stepTimer() {
		if(timer) {
			stopTimer();
			$('runningIndicator').hide();
		}
		getJson(false);
	}
	
	// plneni dat v casovem intervalu
	function getJson(play) {
		PpzAjaxComponentJS.getJson({
			callback : function(json) {
				if(json) {
					
					if(play == true) {
						$('startTimer').disabled='disabled';
						$('stopTimer').disabled='';
						$('runningIndicator').show();
					}
					
					var eventTableRowsCount = 5;
					
					// parse JSON
					var data = json.evalJSON();
					
					if(data.ppz.game) {
						$('month').innerHTML = data.ppz.month;
						$('year').innerHTML = data.ppz.year;
						$('avatarAge').innerHTML = data.ppz.game.avatar.age;
					}
					
					if(data.events) {						
						// eventTable
						if($('eventTable').rows.length > eventTableRowsCount) {
							$('eventTable').deleteRow(eventTableRowsCount);
						}
						
						var newCell;
						var newRow = $('eventTable').insertRow(1);
					
						newCell = newRow.insertCell(-1);
						newCell.update('31.8.2011');
						
						newCell = newRow.insertCell(-1);
						newCell.innerHTML = data.events.name;
						
						if(data.events.stopper == true) {
							$(newRow).addClassName('red');
							stopTimer();
							alert('Na udalost je treba reagovat');
						}
					}
				}
			}
		});
		if(play == true) {
			timeout();
		}
	}
	
	// plneni tabulky zobrazovane po kliknuti na ikonku - avatar
	function getAvatarDetailJson() {
		PpzAjaxComponentJS.getAvatarDetailJson({
			callback : function(json) {
				if(json) {
					// parse JSON
					var data = json.evalJSON();
					
					if(data.fAvatar.avatar.name) {
						$('detailTableNameTitle').innerHTML = data.fAvatar.avatar.name;
					}
					if(data.fAvatar.incomes) {
						$('detailTableIncomes').innerHTML = data.fAvatar.incomes;
					}
					if(data.fAvatar.outcomes) {
						$('detailTableOutcomes').innerHTML = data.fAvatar.outcomes;
					}
					
					$('detailObjectTable').show();
				}
			}
		});
	}
	
	// plneni tabulky zobrazovane po kliknuti na ikonku - family
	function getFamilyDetailJson(type) {
		PpzAjaxComponentJS.getFamilyDetailJson(type, {
			callback : function(json) {
				if(json) {
					// parse JSON
					var data = json.evalJSON();
					
					if(data.person.name) {
						$('detailTableNameTitle').innerHTML = data.person.name;
					}
					$('detailTableIncomes').innerHTML = '0';
					$('detailTableOutcomes').innerHTML = '900';
					$('detailObjectTable').show();
				}
			}
		});
	}

</script>
