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
				<h:commandLink action="#{quadroMB.toIndex}">							
					<h:graphicImage value="../../imagens/logo.png" width="350" />  					   		
				</h:commandLink>			
			<hr style="color:red;">	
			</h:form>			
		</div>	
		
				
			<div  id="homeArtista">	
			<h:form>
				<fieldset>
					<legend>Atualização de Cadastro</legend>
						
						<h:panelGrid id="erros">
							<h:messages globalOnly="true" style="color:Red;"/>
						</h:panelGrid>
						
				<fieldset>
					<legend>Dados Pessoais</legend>
					<h:panelGrid columns="3" id="pessoais">							
							<h:outputLabel for="nome" value="Nome" />
							<h:inputText id="nome" value="#{artistaMB.cadastroArtista.nome}" required="true" requiredMessage="Campo nome obrigatório!" styleClass="edit" size="30" />
							<h:message for="nome" errorClass="campoError" style="color:Red;" />
							
							<h:outputLabel for="nomeArtistico" value="Nome artístico" />
							<h:inputText id="nomeArtistico" value="#{artistaMB.cadastroArtista.nomeArtistico}" required="true" requiredMessage="Campo nome artístico obrigatório!" styleClass="edit" size="30" />
							<h:message for="nomeArtistico" errorClass="campoError" style="color:Red;" />				
					</h:panelGrid>	
				</fieldset>
				
				<fieldset>
					<h:panelGrid columns="3" id="contato">						
							
							<h:outputLabel for="telefone" value="Telefone" />
							<h:inputText id="telefone" value="#{artistaMB.cadastroArtista.telefone}" required="true" requiredMessage="Campo telefone obrigatório!" styleClass="edit" size="10" >
							<rich:jQuery selector="#telefone" query="mask('(99) 9999-9999')" timing="onload" />
							</h:inputText>
							<h:message for="telefone" errorClass="campoError" style="color:Red;" />
							
							<h:outputLabel for="email" value="E-mail " />
							<h:inputText id="email" value="#{artistaMB.cadastroArtista.email}" required="true" requiredMessage="Campo e-mail obrigatório!" styleClass="edit" size="30">
								<f:validator validatorId="alteraEmailArtistaValidator" />
							</h:inputText>
							<h:message for="email" errorClass="campoError" style="color:Red;" />
							
							<h:outputLabel for="fotoArtista" value="Foto atual" />
							<h:graphicImage value="#{artistaMB.cadastroArtista.fotoArtista}" height="100" width="100" />
							<h:inputHidden value="" />
							
							<h:outputLabel for="Foto" value="Foto" />
							<rich:fileUpload fileUploadListener="#{artistaMB.uploadImage}" listWidth="200" listHeight="50" id="Logo" maxFilesQuantity="1" acceptedTypes="jpg, gif, png, bmp"/>
							<h:inputHidden value="" />                            
					</h:panelGrid>	
				</fieldset>						
																
				<fieldset>							
					<legend>Acesso ao Sistema</legend>									
							<h:panelGrid columns="3" id="acesso">
							
							<h:outputLabel for="login" value="Login " />
							<h:outputLabel id="login" value="#{artistaMB.cadastroArtista.usuario.login}" style=" width : 254px;">
							</h:outputLabel>
							<h:inputHidden value="" />							
							</h:panelGrid>
				</fieldset>																
							
				<fieldset>
							<a4j:commandButton value="Atualizar" action="#{artistaMB.updateCadastro}" status="sts" reRender="pessoais,contato,acesso,erros" />
							<a4j:commandButton value="Voltar" immediate="true" action="toHomeArtista" styleClass="botoes" />
								
					 <a4j:jsFunction name="submit" />
				</fieldset>
			</fieldset>
		</h:form>				
	</div>
		    
	
		    			
		<div  id="rodape2">
			<hr style="color:red">
			<fieldset style="background-color: #EE2C2C; border: 0;">
				<h:outputText style="text-align:center;">© Helena França - 2013 | helenafranca.com.br </h:outputText>
			</fieldset>
		</div> 
		</f:view>
	
	
</body>	
</html>