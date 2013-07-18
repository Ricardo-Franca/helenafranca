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
			
			<fieldset>
				<legend>Home Artista</legend>	
				<h:form>		
				<rich:panelMenu mode="ajax" styleClass="rf-pm-top-itm-lbl" style=" width : 180px;">					
						<rich:panelMenuGroup label="Cadastro">
							<rich:panelMenuItem icon="../../imagens/atualizar.png">
								<h:commandLink value="Alterar Cadastro"
									action="toAtualizaCadastroArtista" />
							</rich:panelMenuItem>
							<rich:panelMenuItem icon="../../imagens/chave.png">
								<h:commandLink value="Alterar Senha" action="toAlterarSenha" />
							</rich:panelMenuItem>
						</rich:panelMenuGroup>
						
						<rich:panelMenuGroup label="Quadros">
							<rich:panelMenuItem icon="../../imagens/adicionar.png">
								<h:commandLink value="Incluir" action="toCadastraQuadro" />
							</rich:panelMenuItem>
							<rich:panelMenuItem icon="../../imagens/Quadro.jpg">
								<h:commandLink value="Consultar" action="toConsultaQuadros" />
							</rich:panelMenuItem>
						</rich:panelMenuGroup>
												
						<rich:panelMenuGroup label="Quadros do SlideShow">						
						<rich:panelMenuItem icon="../../imagens/Quadro.jpg">
							<h:commandLink value="Consultar" />
						</rich:panelMenuItem>
						</rich:panelMenuGroup>
						
						<rich:panelMenuGroup label="Relatório">
							<rich:panelMenuItem icon="../../imagens/relatorio.png">
								<h:commandLink value="Gerar Relatório"/>
							</rich:panelMenuItem>
							<rich:panelMenuItem icon="../../imagens/graficos.png">
								<h:commandLink value="Gerar Gráficos" />
							</rich:panelMenuItem>
						</rich:panelMenuGroup>											
												
					</rich:panelMenu>	
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