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
				<a4j:keepAlive beanName="quadroMB" />
				<fieldset><legend>Consulta por Quadros</legend> 
				<rich:dataTable value="#{quadroMB.seusQuadros}" columns="6" var="quadroDoArtista" rows="10" id="quadrosDoArtista" width="100%" cellspacing="0" cellpadding="0" border="1" style="text-align:center;">	
					<h:column>
						<f:facet name="header">
							<h:outputText value="Imagem" />
						</f:facet>					
						<h:graphicImage value="#{quadroDoArtista.quadroImagem}" height="100" width="100"/>					
					</h:column>
							
					<h:column>
						<f:facet name="header">
									<h:outputText value="Nome" />
								</f:facet>
								<h:outputText value="#{quadroDoArtista.nome}" />
							</h:column>
				
							<h:column>
								<f:facet name="header">
									<h:outputText value="Preço" />
								</f:facet>
								R$<h:outputText value=" #{quadroDoArtista.preco}" />
							</h:column>
															
							<h:column>
								<f:facet name="header">
									<h:outputText value="Categoria" />
								</f:facet>
								<h:outputText value="#{quadroDoArtista.categoria.descricao}" />
							</h:column>
			
							<h:column >
								<f:facet name="header">
									<h:outputText value="Alterar"/>
								</f:facet>
						
								<a4j:commandLink  action="#{quadroMB.escolheAlterarQuadro}" status="sts" reRender="quadrosDoArtista">
									<h:outputText value="Alterar"/>
									<f:setPropertyActionListener value="#{quadroDoArtista.cod_quadro}" target="#{quadroMB.codigoQuadro}" />			
								</a4j:commandLink>
							</h:column>		
											
							<h:column>
								<f:facet name="header">
									<h:outputText value="Exclusão"/>
								</f:facet>
						
								<a4j:commandLink  value="Excluir" action="#{quadroMB.deleteQuadros}"  status="sts" reRender="prontas">
									<f:setPropertyActionListener value="#{quadroDoArtista.cod_quadro}" target="#{quadroMB.codigoQuadro}" />				
								</a4j:commandLink>
							</h:column>
				 			
					 		<f:facet name="footer">
								<rich:datascroller />
							</f:facet>
						</rich:dataTable>
						
						<rich:messages/>
						
			    	    <a4j:region id="regiaoAjax">
						 	<a4j:status id="sts">
				            	<f:facet name="start">
				            		<h:graphicImage value="/images/ajax-loader.gif" />
				               	</f:facet>
				            </a4j:status>
				        </a4j:region>
				        <h:commandButton value="Voltar" immediate="true" action="toHomeArtista" styleClass="botoes"/>
				        <h:commandButton value="Cadastrar Novo Quadro" immediate="true" action="toCadastraQuadro" styleClass="botoes"/>
					</fieldset>	
			</h:form>
			<br/>
			
			<hr style="color:red">			
			<fieldset style="background-color: #EE2C2C; border: 0;text-align:center;">
				<h:outputText style="text-align:center;">© Helena França - 2013 | helenafranca.com.br </h:outputText>
			</fieldset>	
				
		</div>
		</f:view>
	
	
</body>	
</html>