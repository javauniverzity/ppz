<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="fragments/taglib.jsp" %>


	<span id="User${user.id}Value">
		<span id="User${user.id}ValueText1">${user.username}</span><br/>
		<span id="User${user.id}ValueText2">${user.code}</span><br/>
		<a href="#" id="User${user.id}ValueEditLink">změnit</a>
	</span>
	<span id="User${user.id}ValueEdit" style="display: none">
		1: <input id="User${user.id}ValueEditInput1" name="value"/><br/>
		2: <input id="User${user.id}ValueEditInput2" name="value2"/><br/>
		<span id="User${user.id}ValueEditError"></span>
		<input id="User${user.id}ValueEditSubmit" type="submit" value="odeslat" /> nebo
		<a href="#" id="User${user.id}ValueEditCancelLink">zrušit</a>
	</span>
