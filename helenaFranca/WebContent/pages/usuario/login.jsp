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
			
	<script type="text/javascript" src="/jsf/resources/jquery.maskedinput-1.2.1.js"></script>
				
		
	<link rel="StyleSheet" type="text/css" href="/helenafranca/style/paginaLogin.css" />
	
	<style type="text/css">
    	.backgroundHigh { position: absolute; }
    </style>
		
	
</head>
<body>
	<f:view >
		
		<div  id="topo">
		
		<div id="menuTopo">
					
			<h:form>
				<rich:toolBar>
		               	                   
			                <h:commandLink action="#{usuarioMB.escolheLogin}" style="color:black;text-decoration:none;" >
								<h:outputText value="Meu Cadastro" />					   
							</h:commandLink> 
		                |
		                 	                   
			                <h:commandLink action="#{usuarioMB.escolheBiografia}" style="color:black;text-decoration:none;" >
								<h:outputText value="Biografia" />					   
							</h:commandLink> 	  
		                |
		               
							<h:commandLink action="#{usuarioMB.escolheBlog}" style="color:black;text-decoration:none;" >
								<h:outputText value="Blog" />					   
							</h:commandLink>
						|
		            
							<h:commandLink action="#{usuarioMB.escolheContato}" style="color:black;text-decoration:none;" >
								<h:outputText value="Contato" />					   
							</h:commandLink>        
		            </rich:toolBar>	            
		   
		   </h:form>
		</div>

		<br>
		<hr style="color:#FF0000;">		
		</div>
					
		<div  id="testeira">		
			<h:form>				
				<h:commandLink style="color:white;text-decoration:none;border:none;" action="#{quadroMB.toIndex}">							
					<h:graphicImage style="color:white;text-decoration:none;border:none;" value="../../imagens/logo.png" width="350" />  					   		
				</h:commandLink>			
			<hr style="color:red;">	
			</h:form>			
			<h:form>
			
			<h:panelGrid id="testeira" border="0"> 			
								
				<h:inputText value="#{quadroMB.nome}" id="nome" required="true" requiredMessage="Informe o termo para pesquisa!" style="position:absolute;top:35%;width:485px;left:40%;"/>
				<h:message for="nome" errorClass="campoError" style="color:Red;position:absolute;top:64%; left:40%;"/>
				
				
				<h:selectOneMenu id="categoria" value="#{quadroMB.codigoCategoria}" required="true" requiredMessage="Informe a categoria!" style="position:absolute;top:35%; left:80%;">
						<f:selectItem itemValue="" itemLabel="Categoria"/>
						<f:selectItems value="#{categoriaMB.categorias}" />
				</h:selectOneMenu> 												
				<h:message for="categoria" errorClass="campoError" style="color:Red;position:absolute;top:64%; left:81%;"/>
				
				<a4j:commandLink action="#{quadroMB.escolheProcuraByNomeCategoria}" status="sts" reRender="testeira" styleClass="botoes" style="position:absolute;top:34%; left:90%;">
					<h:graphicImage value="../../imagens/pesquisar.png" width="80" />
				</a4j:commandLink>
				<hr>
			</h:panelGrid>
			
			</h:form>
		</div>		
		
		<div style="left: 50%;position: absolute;top: 45%;" id="linha">
			<hr size="200" width="1" align="left">
		</div>
		
		<div id="erros" style="left: 65%;top:45%;position: absolute;">
			<h:panelGrid columns="1" border="0" width="230">
					<h:messages style="color:red;"/>
				</h:panelGrid>
		</div>	
				
		<div id="menuLogin">
			<h:form>				
				
				<fieldset style="background-color:#FF3030;border: 0;">
					<legend style="color:Green;font-size: medium;font-weight: bold;">Entrar</legend>
					<h:panelGrid columns="2" border="0">
						<h:outputText value="Login" styleClass="rotulos" style="FONT-SIZE: small; font-weight:bold;"/>
						<h:inputText id="login" value="#{usuarioMB.usuario.login}"  styleClass="edit" size="90" style=" width : 150px;" required="true" requiredMessage="Campo Usuário obrigatório!" >	
						</h:inputText>

						<h:outputLabel for="senha" value="Senha" styleClass="rotulos"  style="FONT-SIZE: small; font-weight:bold;"/>
						<h:inputSecret id="senha" styleClass="edit" validatorMessage="A senha deve ter no mínimo 6 caracteres!" value="#{usuarioMB.usuario.senha}" size="60" style=" width : 150px;" required="true" requiredMessage="Campo Senha obrigatório!" >
							<f:validateLength minimum="6" />
						</h:inputSecret>

						<h:commandButton id="botao" value="Entrar"  action="#{usuarioMB.login}"  />
						<br></br>												
					</h:panelGrid>
				</fieldset>				
			</h:form>
		</div>
		
				
		<div  id="rodape">
			<hr style="color:red">
			<fieldset style="background-color: #EE2C2C; border: 0;">
				<h:outputText style="text-align:center;">© Helena França - 2013 | helenafranca.com.br </h:outputText>
			</fieldset>
		</div> 
		
	</f:view>
	
</body>	
</html>