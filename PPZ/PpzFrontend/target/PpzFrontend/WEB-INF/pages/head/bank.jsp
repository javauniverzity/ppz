<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="<c:url value="/js/prototype.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/scriptaculous.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/effects.js"/>" ></script>
<script type='text/javascript' src='<c:url value="/dwr/engine.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/util.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/interface/BankControllerJS.js"/>'></script>
<script type="text/javascript" src="<c:url value="/js/edit.js"/>" ></script>
<script type="text/javascript">
function editProduct(id) {
	
	value = $('Product' + id + 'ValueEditValue').value;
	
	BankControllerJS.edit(id, value, {
		callback : function(id) {// sem je potreba aby se vracel json, kde bude id, error atd, vse potrebne
			// musi prijit jeste errory a ty pak pripadne zobrazit
			//json.id
			//json.errors -> age -> neni cislo;
			//$('Avatar' + id + 'ValueEditError').innerHTML = 'neni cislo';
			//$('Product' + id + 'ValueEditError').innerHTML = '';
			// hodnoty z inputu se presunou do zobrazeni
			//$('Product' + id + 'ValueValue').innerHTML = $('Product' + id + 'ValueEditValue').value;
			// schovame editaci a zobrazime hodnoty
			$('Product' + id + 'ValueValue').innerHTML = $('Product' + id + 'ValueEditValue').value;
			$$('.Product' + id + 'Value').each(function(e) {e.show();});
			$$('.Product' + id + 'ValueEdit').each(function(e) {e.hide();});
		}
	});
}

function editLinkProduct(id) {
	$('Product' + id + 'ValueEditValue').value = $("Product" + id + 'ValueValue').innerHTML;
}


</script>
