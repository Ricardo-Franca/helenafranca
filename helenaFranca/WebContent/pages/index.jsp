<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="StyleSheet" type="text/css" href="/jsf/style/estilos.css" media="screen" />
<script type="text/javascript" src="/jsf/resources/jquery.maskedinput-1.2.1.js"></script>

<script>
	if (navigator.userAgent.indexOf("Chrome") != -1) 
	{ // Chorme 
		window.location.href ='http://localhost:8080/helenafranca/pages/usuario/paginaInicial.jsf';
	}else
	 {		
		alert('Atenção: Esse site pode não funcionar perfeitamente com esse navegador. Baixe o Navegador Google Chrome para uma melhor visualização.');
		window.showModalDialog("http://www.google.com/intl/pt-BR/chrome/");
		window.location.href ='http://localhost:8080/helenafranca/pages/usuario/paginaInicial.jsf';				 
	}
	
	
	
</script>

</head>
<body>


		
		

</body>
</html>