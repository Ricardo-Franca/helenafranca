<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link  rel="shortcut icon" href="/helenafranca/imagens/rosa.png"/>
	<title>Helena França - helenafranca.com.br</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">			
		
	<script type="text/javascript" src="/helenafranca/resources/jquery.maskedinput-1.2.1.js"></script>		
	<link rel="StyleSheet" type="text/css" href="/helenafranca/style/paginaPadrao.css" />
	
			
</head>
<body>
	<f:view >
		<div  id="topo">
		
		<div id="botaoToLogout">
		<h:form>
				<h:panelGrid>
					<h:commandLink style="text-decoration: none;color: black" value="Sair" action="#{usuarioMB.logout}" />
				</h:panelGrid>
			</h:form>		
		</div>
		
		<br>
		
		<hr style="color:#FF0000;">	
			
		</div>
		
		<div id="bemvindo">
			<h:form>
				<h:panelGrid columns="2">					
					<h:outputLabel for="bemvindo" value="Bem Vindo (a) :" style="color:black;" />					
					<h:outputLabel for="nome" value="#{artistaMB.cadastroArtista.nomeArtistico}" style="color:black;font-size:10px;"/>										
				</h:panelGrid>
				
			</h:form>
		</div>
				 
		<div  id="testeira">		
			<h:form>				
				<h:commandLink style="color:white;text-decoration:none;border:none;" action="#{quadroMB.toIndex}">							
					<h:graphicImage style="color:white;text-decoration:none;border:none;" value="../../imagens/logo.png" width="350" />  					   		
				</h:commandLink>			
			<hr style="color:red;">	
			</h:form>			
		</div>	
		
				
			<div  id="homeArtista">	
			<h:form>
			<fieldset>
				<fieldset>
					<legend>Atualização de Biografia</legend>
						
						<h:panelGrid id="erros">
							<h:messages globalOnly="true" style="color:Red;"/>
						</h:panelGrid>
						
						<h:panelGrid columns="2" id="inputs" width="80%">
																						
						<h:outputLabel for="titulo" value="Título" />
						<h:inputHidden value="" />
						
						<h:inputText id="titulo" value="#{biografiaMB.biografia.titulo}" required="true" requiredMessage="Campo título obrigatório!" styleClass="edit" size="30" />
						<h:message for="titulo" errorClass="campoError" style="color:Red;" />
							
						<h:outputLabel for="texto" value="Texto" />
						<h:inputHidden value="" />
						
						<h:inputTextarea id="texto" value="#{biografiaMB.biografia.texto}" required="true" requiredMessage="Campo texto obrigatório!" style="width:80%;" rows="15"/>
						<h:message for="texto" errorClass="campoError" style="color:Red;" />						
																
					</h:panelGrid>
				</fieldset>																		
							
				<fieldset>
							<a4j:commandButton value="Alterar" action="#{biografiaMB.updateCadastro}" status="sts" reRender="erros,inputs" />
							<a4j:commandButton value="Voltar" immediate="true" action="toHomeArtista" styleClass="botoes" />
								
					 <a4j:jsFunction name="submit" />
				</fieldset>
			</fieldset>
		</h:form>				
	</div>
		    
	
			
		<div  id="rodape3">
			<hr style="color:red;">
			<fieldset style="background-color: #EE2C2C; border: 0;">
				<h:outputText style="text-align:center;">© Helena França - 2013 | helenafranca.com.br </h:outputText>
			</fieldset>
		</div> 
		</f:view>	
	
</body>	
</html>