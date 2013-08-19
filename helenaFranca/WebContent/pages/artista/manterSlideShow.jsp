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
			<h:outputLabel value="Fotos da Biografia"/>			
		</div>
		
		<div id="foto1">
			<h:form>
			 <fieldset>
			 <legend>Primeiro quadro</legend>									
				<h:panelGrid id="erros">
					<h:messages globalOnly="true" style="color:Red;"/>
				</h:panelGrid>
				<fieldset>
					<h:panelGrid columns="3" id="quadro1">						
						
							<h:outputLabel for="fotoQuadro" value="Quadro atual"/>
							<h:graphicImage value="#{quadroMB.foto1.foto}" height="100" width="100" />
							<h:inputHidden value="" />
							
							<h:outputLabel for="Foto" value="Foto" />
							<rich:fileUpload fileUploadListener="#{fotoMB.uploadImage}" listWidth="150" listHeight="50" id="Logo" maxFilesQuantity="1" acceptedTypes="jpg, gif, png, bmp"/>
							<h:inputHidden value="" />                            
					</h:panelGrid>	
				</fieldset>																					
							
				<fieldset>
							<a4j:commandButton value="Atualizar" action="#{fotoMB.updateFoto(1)}" status="sts" reRender="foto1,erros" />								
					 <a4j:jsFunction name="submit" />
				</fieldset>	
			</fieldset>		
			</h:form>
		</div>
		
		<div id="foto2">
			<h:form>
			 <fieldset>
			 <legend>Segunda foto</legend>									
				<h:panelGrid id="erros">
					<h:messages globalOnly="true" style="color:Red;"/>
				</h:panelGrid>
				<fieldset>
					<h:panelGrid columns="3" id="foto2">						
						
							<h:outputLabel for="fotoArtista" value="Foto atual"/>
							<h:graphicImage value="#{fotoMB.foto2.foto}" height="100" width="100" />
							<h:inputHidden value="" />
							
							<h:outputLabel for="Foto" value="Foto" />
							<rich:fileUpload fileUploadListener="#{fotoMB.uploadImage}" listWidth="150" listHeight="50" id="Logo" maxFilesQuantity="1" acceptedTypes="jpg, gif, png, bmp"/>
							<h:inputHidden value="" />                            
					</h:panelGrid>	
				</fieldset>																					
							
				<fieldset>
							<a4j:commandButton value="Atualizar" action="#{fotoMB.updateFoto(2)}" status="sts" reRender="foto2,erros" />								
					 <a4j:jsFunction name="submit" />
				</fieldset>	
			</fieldset>		
			</h:form>
		</div>
		
		<div id="foto3">
			<h:form>
			 <fieldset>
			 <legend>Terceira foto</legend>									
				<h:panelGrid id="erros">
					<h:messages globalOnly="true" style="color:Red;"/>
				</h:panelGrid>
				<fieldset>
					<h:panelGrid columns="3" id="foto3">						
						
							<h:outputLabel for="fotoArtista" value="Foto atual"/>
							<h:graphicImage value="#{fotoMB.foto3.foto}" height="100" width="100" />
							<h:inputHidden value="" />
							
							<h:outputLabel for="Foto" value="Foto" />
							<rich:fileUpload fileUploadListener="#{fotoMB.uploadImage}" listWidth="150" listHeight="50" id="Logo" maxFilesQuantity="1" acceptedTypes="jpg, gif, png, bmp"/>
							<h:inputHidden value="" />                            
					</h:panelGrid>	
				</fieldset>																					
							
				<fieldset>
							<a4j:commandButton value="Atualizar" action="#{fotoMB.updateFoto(3)}" status="sts" reRender="foto3,erros" />								
					 <a4j:jsFunction name="submit" />
				</fieldset>	
			</fieldset>		
			</h:form>
		</div>
		
		<div id="foto4">
			<h:form>
			 <fieldset>
			 <legend>Quarta foto</legend>									
				<h:panelGrid id="erros">
					<h:messages globalOnly="true" style="color:Red;"/>
				</h:panelGrid>
				<fieldset>
					<h:panelGrid columns="3" id="foto4">						
						
							<h:outputLabel for="fotoArtista" value="Foto atual"/>
							<h:graphicImage value="#{fotoMB.foto4.foto}" height="100" width="100" />
							<h:inputHidden value="" />
							
							<h:outputLabel for="Foto" value="Foto" />
							<rich:fileUpload fileUploadListener="#{fotoMB.uploadImage}" listWidth="150" listHeight="50" id="Logo" maxFilesQuantity="1" acceptedTypes="jpg, gif, png, bmp"/>
							<h:inputHidden value="" />                            
					</h:panelGrid>	
				</fieldset>																					
							
				<fieldset>
							<a4j:commandButton value="Atualizar" action="#{fotoMB.updateFoto(4)}" status="sts" reRender="foto4,erros" />								
					 <a4j:jsFunction name="submit" />
				</fieldset>	
			</fieldset>		
			</h:form>
		</div>
		
		<div id="foto5">
			<h:form>
			 <fieldset>
			 <legend>Quinta foto</legend>									
				<h:panelGrid id="erros">
					<h:messages globalOnly="true" style="color:Red;"/>
				</h:panelGrid>
				<fieldset>
					<h:panelGrid columns="3" id="foto5">						
						
							<h:outputLabel for="fotoArtista" value="Foto atual"/>
							<h:graphicImage value="#{fotoMB.foto5.foto}" height="100" width="100" />
							<h:inputHidden value="" />
							
							<h:outputLabel for="Foto" value="Foto" />
							<rich:fileUpload fileUploadListener="#{fotoMB.uploadImage}" listWidth="150" listHeight="50" id="Logo" maxFilesQuantity="1" acceptedTypes="jpg, gif, png, bmp"/>
							<h:inputHidden value="" />                            
					</h:panelGrid>	
				</fieldset>																					
							
				<fieldset>
							<a4j:commandButton value="Atualizar" action="#{fotoMB.updateFoto(5)}" status="sts" reRender="foto5,erros" />								
					 <a4j:jsFunction name="submit" />
				</fieldset>	
			</fieldset>		
			</h:form>
		</div>
		
		<div id="botaoVoltar">
		<fieldset>
			<h:form>
				<fieldset>
					<a4j:commandButton value="Voltar" immediate="true" action="toHomeArtista" styleClass="botoes" />
								
					<a4j:jsFunction name="submit" />
				</fieldset>
			</h:form>
		</fieldset>			
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