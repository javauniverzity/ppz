function valueEditLinkClick(event) {
	var element = event.element();
	id = element.id.replace('ValueEditLink','');
	$$('.' + id + 'Value').each(function(e) {e.hide();});
	$$('.' + id + 'ValueEdit').each(function(e) {e.show();});
	if (id.startsWith('Avatar')) {
		id = id.replace('Avatar','');
		editLinkAvatar(id);	
	} else if (id.startsWith('Product')) {
		id = id.replace('Product','');
		editLinkProduct(id);		
	} else if (id.startsWith('LinkedPerson')) {
		id = id.replace('LinkedPerson','');
		editLinkLinkedPerson(id);
	}
	return false;
}

function valueEditCancelLinkClick(event) {
	var element = event.element();
	id = element.id.replace('ValueEditCancelLink','');
	$$('.' + id + 'Value').each(function(e) {e.show();});
	$$('.' + id + 'ValueEdit').each(function(e) {e.hide();});
	return false;
}

function valueEditSubmitClick(event) {
	var element = event.element();
	id = element.id.replace('ValueEditSubmit','');
	if (id.startsWith('Avatar')) {
		id = id.replace('Avatar','');
		editAvatar(id);	
	} else if (id.startsWith('Product')) {
		id = id.replace('Product','');
		editProduct(id);		
	} else if (id.startsWith('LinkedPerson')) {
		id = id.replace('LinkedPerson','');
		editLinkedPerson(id);
	}
	
}

document.observe("dom:loaded", function() {
	links = $$('a');
	$$('a').each(function(a) {
		if (a.id.endsWith('ValueEditLink')) {
			$(a.id).observe('click', valueEditLinkClick);
		} else if (a.id.endsWith('ValueEditCancelLink')) {
			$(a.id).observe('click', valueEditCancelLinkClick);
		} 
	});
	
	inputs = $$('input');
	$$('input').each(function(input) {
		if (input.id.endsWith('ValueEditSubmit')) {
			$(input.id).observe('click', valueEditSubmitClick);
		}
	});
});
