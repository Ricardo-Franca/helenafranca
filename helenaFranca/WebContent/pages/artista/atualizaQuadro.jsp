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
					<legend>Atualização de Quadros</legend>
						
						<h:panelGrid id="erros">
							<h:messages globalOnly="true" style="color:Red;"/>
						</h:panelGrid>
							
						<h:panelGrid columns="2" id="inputs">
																						
						<h:outputLabel for="nome" value="Nome" />
						<h:inputHidden value="" />
						
						<h:inputText id="nome" value="#{quadroMB.cadastroQuadro.nome}" required="true" requiredMessage="Campo nome obrigatório!" styleClass="edit" size="30" />
						<h:message for="nome" errorClass="campoError" style="color:Red;" />
							
						<h:outputLabel for="altura" value="Altura (Centímetros)" />
						<h:inputHidden value="" />
						
						<h:inputText id="altura" value="#{quadroMB.cadastroQuadro.altura}" required="true" requiredMessage="Campo altura obrigatório!" styleClass="edit" size="3" />
						<h:message for="altura" errorClass="campoError" style="color:Red;" />
						
						<h:outputLabel for="largura" value="Largura (Centímetros)" />
						<h:inputHidden value="" />
						
						<h:inputText id="largura" value="#{quadroMB.cadastroQuadro.largura}" required="true" requiredMessage="Campo largura obrigatório!" styleClass="edit" size="3" />
						<h:message for="largura" errorClass="campoError" style="color:Red;" />
						
						<h:outputLabel for="peso" value="Peso Kg" />
						<h:inputHidden value="" />
						
						<h:inputText id="peso" value="#{quadroMB.cadastroQuadro.peso}" required="true" requiredMessage="Campo peso obrigatório!" styleClass="edit" size="4" >
							<rich:jQuery selector="#peso" query="mask('99.99')" timing="onload"/>
						</h:inputText>
						<h:message for="peso" errorClass="campoError" style="color:Red;" />
						
						<h:outputLabel for="preco" value="Preço R$ *" />
						<h:inputHidden value="" />
						
						<h:inputText id="preco" value="#{quadroMB.cadastroQuadro.preco}" size="4" required="true" requiredMessage="Campo preço obrigatório!">
							<rich:jQuery selector="#preco" query="mask('999.99')" timing="onload"/>
						</h:inputText>
						<h:message for="preco" errorClass="campoError" style="color:Red;" />
																		
						<h:outputLabel for="categoria" value="Categoria *" />
						<h:inputHidden value="" />
												
						<h:selectOneMenu id="categoria" value="#{quadroMB.cadastroQuadro.categoria.codigo}" required="true"
							requiredMessage="Campo categoria obrigatório!">
							<f:selectItem itemValue="" itemLabel="Categoria" />
							<f:selectItems value="#{categoriaMB.categorias}" />
						</h:selectOneMenu>						
						<h:message for="categoria" errorClass="campoError" style="color:Red;" />
												
						<h:outputLabel for="Imagem" value="Imagem atual" />
						<h:inputHidden value=""/>
						
						<h:graphicImage value="#{quadroMB.cadastroQuadro.foto}" height="100" width="100" />
						<h:inputHidden value="" />
					
						<rich:fileUpload fileUploadListener="#{quadroMB.uploadImage}" listWidth="200" listHeight="50" id="Imagem" maxFilesQuantity="1" acceptedTypes="jpg, gif, png, bmp"/>
                    	<h:message for="Imagem" errorClass="campoError"/>					
																
					</h:panelGrid>
				</fieldset>																		
							
				<fieldset>
							<a4j:commandButton value="Alterar" action="#{quadroMB.updateCadastro}" status="sts" reRender="erros,inputs" />
							<a4j:commandButton value="Voltar" immediate="true" action="toConsultaQuadros" styleClass="botoes" />
								
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