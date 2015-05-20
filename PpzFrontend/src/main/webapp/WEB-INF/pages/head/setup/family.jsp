<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="<c:url value="/js/prototype.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/scriptaculous.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/effects.js"/>" ></script>
<script type='text/javascript' src='<c:url value="/dwr/engine.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/util.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/interface/FamilySetupControllerJS.js"/>'></script>
<script type="text/javascript" src="<c:url value="/js/edit.js"/>" ></script>
<script type="text/javascript">
function editAvatar(id) {
	
	age = $('Avatar' + id + 'ValueEditAge');
	name = $('Avatar' + id + 'ValueEditName');
	
	FamilySetupControllerJS.edit(id, age, name, {
		callback : function(json) {// sem je potreba aby se vracel json, kde bude id, error atd, vse potrebne
			// musi prijit jeste errory a ty pak pripadne zobrazit
			//json.id
			//json.errors -> age -> neni cislo;
				//$('Avatar' + id + 'ValueEditError').innerHTML = 'neni cislo';
			$('Avatar' + id + 'ValueEditError').innerHTML = '';
			// hodnoty z inputu se presunou do zobrazeni
			$('Avatar' + id + 'ValueName').innerHTML = $('Avatar' + id + 'ValueEditName').value;
			$('Avatar' + id + 'ValueAge').innerHTML = $('Avatar' + id + 'ValueEditAge').value;
			// schovame editaci a zobrazime hodnoty
			$$('.' + id + 'Value').each(function(e) {e.show();});
			$$('.' + id + 'ValueEdit').each(function(e) {e.hide();});
		}
	});
}
function editLinkAvatar(id) {
	$('Avatar' + id + 'ValueEditName').value = $('Avatar' + id + 'ValueName').innerHTML;
	$('Avatar' + id + 'ValueEditAge').value = $('Avatar' + id + 'ValueAge').innerHTML;
}

function editLinkedPerson(id) {
	
	name = $('LinkedPerson' + id + 'ValueEditName').value;
	
	FamilySetupControllerJS.edit(id, name, {
		callback : function(id) {// sem je potreba aby se vracel json, kde bude id, error atd, vse potrebne
			// musi prijit jeste errory a ty pak pripadne zobrazit
			//json.id
			//json.errors -> age -> neni cislo;
				//$('Avatar' + id + 'ValueEditError').innerHTML = 'neni cislo';
			//$('LinkedPerson' + id + 'ValueEditError').innerHTML = '';
			// hodnoty z inputu se presunou do zobrazeni
			$('LinkedPerson' + id + 'ValueName').innerHTML = $('LinkedPerson' + id + 'ValueEditName').value;
			// schovame editaci a zobrazime hodnoty
			$$('.LinkedPerson' + id + 'Value').each(function(e) {e.show();});
			$$('.LinkedPerson' + id + 'ValueEdit').each(function(e) {e.hide();});
		}
	});
}
function editLinkLinkedPerson(id) {
	$('LinkedPerson' + id + 'ValueEditName').value = $('LinkedPerson' + id + 'ValueName').innerHTML;
}

</script>
