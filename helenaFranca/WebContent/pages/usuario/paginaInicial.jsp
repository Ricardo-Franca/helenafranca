<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Helenafranca.com.br - Helena França</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript"
	src="/jsf/resources/jquery.maskedinput-1.2.1.js"></script>

<link rel="StyleSheet" type="text/css" href="/helenafranca/style/estilos.css" />



</head>
<body>
	<f:view >
		<div  id="topo">
		<div id="botaoToLogin">
			<h:form style="align:right;">
				<h:panelGrid columns="1" id="inputs">
					<a4j:commandButton value="LOGIN" immediate="true" action="toLogin"
						styleClass="botoes" />
				</h:panelGrid>
			</h:form>
		</div>		
		</div>
		
		
		<div  id="testeira">
			<table border="0">			
				<tr>
					<td><img alt="" src="/helenafranca/imagens/rosa.png" width="70" /></td>
					<td><font style="font-weight:bold;font-size:250%;color:#FF1493;">Helena França</font></td>
					<td style=" width : 200px;"></td>
					<td>
						<h:panelGrid columns="3" id="pesquisa">
							<input type="text" style="width:485px;" value=""></input>
							<select >
							  <option value="00">Categoria</option>
							  <option value="01">Abstrato</option>
							  <option value="02">Natureza morta</option>
							  <option value="03">Paisagem</option>
							</select>
							<input type="button" value="pesquisar"> 
											
						</h:panelGrid>					
					</td>
				</tr>
			</table>
		</div>
		
		<div  id="menuLateral">
		Menu Lateral
		</div>
		
		<div  id="adSense">
		adSense
		</div> 
		
		<div  id="slideShow">
		SlideShow
		</div> 
		
		<div  id="quadros">
		quadros
		</div> 
		
		<div  id="rodape">
		rodape
		</div> 
		
	</f:view>

</body>
</html>