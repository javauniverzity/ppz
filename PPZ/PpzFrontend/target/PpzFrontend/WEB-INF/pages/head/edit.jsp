<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="<c:url value="/js/prototype.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/scriptaculous.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/effects.js"/>" ></script>
<script type='text/javascript' src='<c:url value="/dwr/engine.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/util.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/interface/EditAjaxComponentJS.js"/>'></script>
<script type="text/javascript">
function setValue(value) {
	EditAjaxComponentJS.setValue(value1, value2, {
		callback : function(error) {// sem je potreba aby se vracel json, kde bude id, error atd, vse potrebne
			if (error != "") {
				$('User' + id + 'ValueEditError').innerHTML = error;
			} else {
				$('User' + id + 'ValueEditError').innerHTML = '';
				$('User' + id + 'ValueText1').innerHTML = $('ValueEditInput1').value;
				$('User' + id + 'ValueText2').innerHTML = $('ValueEditInput2').value;
				$('User' + id + 'Value').show();
				$('User' + id + 'ValueEdit').hide();
			}
		}
	});
}

function valueEditLinkClick(event) {
	var element = event.element();
	id = element.id.replace('ValueEditLink','');
	$(id + 'Value').hide();
	$(id + 'ValueEdit').show();
	
	$(id + 'ValueEditInput1').value = $(id + 'ValueText1').innerHTML;
	$(id + 'ValueEditInput2').value = $(id + 'ValueText2').innerHTML;
	return false;
}

function valueEditCancelLinkClick(event) {
	var element = event.element();
	id = element.id.replace('ValueEditCancelLink','');
	$(id + 'Value').show();
	$(id + 'ValueEdit').hide();
	return false;
}

function valueEditSubmitClick(event) {
	var element = event.element();
	id = element.id.replace('ValueEditSubmit','');
	value1 = $(id + 'ValueEditInput1').value;
	value2 = $(id + 'ValueEditInput2').value;
	setValue(value1, value2);
}

document.observe("dom:loaded", function() {
	$$('a').each(function(link) {
		if (link.id.endsWith('ValueEditLink')) {
			$(link.id).observe('click', valueEditLinkClick);
		} else if (link.id.endsWith('ValueEditCancelLink')) {
			$(link.id).observe('click', valueEditCancelLinkClick);
		}
	});
	
	$$('input').each(function(input) {
		if (inputs.id.endsWith('ValueEditSubmit')) {
			$(inputs.id).observe('click', valueEditSubmitClick);
		}
	});
});


</script>
