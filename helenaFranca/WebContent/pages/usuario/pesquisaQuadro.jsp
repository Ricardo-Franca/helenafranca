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
		
			
	<link rel="StyleSheet" type="text/css" href="/helenafranca/style/pesquisaQuadro.css" />
	
	
	
</head>
<body>
	<f:view >
		<div  id="topo">
		<div id="botaoToLogin">
			<h:form style="align:right;">
				<h:panelGrid columns="1" id="inputs">
					<a4j:commandLink value="LOGIN" immediate="true" action="toLogin"
						styleClass="botoes" />
				</h:panelGrid>
			</h:form>
		</div>
		<br>
		<hr style="color:red;">		
		</div>
				 
		<div  id="testeira">
			<h:form>				
				<h:commandLink action="#{quadroMB.toIndex}">							
					<h:graphicImage value="../../imagens/logo.png" width="350" />  					   		
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
		
		<div  id="menuLateral">		
		
			<h:form>
			<br>
		        <h:panelGrid styleClass="vertical-menu-cell" columnClasses="optionList" columns="1" cellspacing="0" cellpadding="0" width="250" bgcolor="">
		            <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor}" value="Abstratos" submitMode="none" direction="bottom-right" jointPoint="tr">
		                <rich:menuItem>	                   
			                <h:commandLink action="#{quadroMB.escolheProcuraByCategoria}" >
								<f:setPropertyActionListener value="1" target="#{quadroMB.codigoCategoria}" />
								<h:outputText value="Abstratos" />					   
							</h:commandLink> 	                
		                </rich:menuItem>
		            </rich:dropDownMenu>
		            
		              <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor}" value="Animais" submitMode="none" direction="bottom-right" jointPoint="tr">
		                <rich:menuItem>	                   
			                <h:commandLink action="#{quadroMB.escolheProcuraByCategoria}" >
								<f:setPropertyActionListener value="2" target="#{quadroMB.codigoCategoria}" />
								<h:outputText value="Animais" />					   
							</h:commandLink> 	                
		                </rich:menuItem>
		            </rich:dropDownMenu>
		            
		            <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor}" value="Florais" 
		                        submitMode="none" direction="bottom-right"  jointPoint="tr">		                
		                <rich:menuGroup value="Florais">
		                	<rich:menuItem>	                   
			                <h:commandLink action="#{quadroMB.escolheProcuraByCategoria}" >
								<f:setPropertyActionListener value="3" target="#{quadroMB.codigoCategoria}" />
								<h:outputText value="Florais" />					   
							</h:commandLink> 	                
		                </rich:menuItem>		                    
		                </rich:menuGroup>
		            </rich:dropDownMenu>
		            
		            <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor}" value="Paisagens"
		                        submitMode="none" direction="bottom-right"  jointPoint="tr">
		                <rich:menuItem>	                   
			                <h:commandLink action="#{quadroMB.escolheProcuraByCategoria}" >
								<f:setPropertyActionListener value="4" target="#{quadroMB.codigoCategoria}" />
								<h:outputText value="Paisagens" />					   
							</h:commandLink> 	                
		                </rich:menuItem>
		            </rich:dropDownMenu>
		            
		            <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor}" value="Pessoas"
		                        submitMode="none" direction="bottom-right"  jointPoint="tr">
		                <rich:menuItem>	                   
			                <h:commandLink action="#{quadroMB.escolheProcuraByCategoria}" >
								<f:setPropertyActionListener value="5" target="#{quadroMB.codigoCategoria}" />
								<h:outputText value="Pessoas" />					   
							</h:commandLink> 	                
		                </rich:menuItem>
		            </rich:dropDownMenu>
		         
		         	<rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor}" value="Natureza Morta"
		                        submitMode="none" direction="bottom-right"  jointPoint="tr">
		                <rich:menuItem>	                   
			                <h:commandLink action="#{quadroMB.escolheProcuraByCategoria}" >
								<f:setPropertyActionListener value="6" target="#{quadroMB.codigoCategoria}" />
								<h:outputText value="Natureza Morta" />					   
							</h:commandLink> 	                
		                </rich:menuItem>
		            </rich:dropDownMenu>
		            
		        </h:panelGrid>
		    </h:form> 
		</div>
		
		<div  id="adSense">
		adSense
		</div> 
				
		
		<div  id="quadro">
		
		
			<h:form>
						<a4j:keepAlive beanName="quadroMB" />
						<fieldset><legend>Quadro</legend>
							<rich:dataGrid  value="#{quadroMB.quadroAtual}" columns="1" elements="1" var="atual"  id="atuais" width="100%" cellspacing="0" cellpadding="0" border="0" style="text-align:center;">
								<h:column>	
									<table>
										<tr>
											<td>
												<h:graphicImage value="#{atual.quadroImagem}" height="300" width="400" />
											</td>
											<td width="50"></td>
											<td width="500" align="left">
												<h:outputText style="font-weight:bold;font-size:20px;" value="#{atual.nome}"/>
											    <hr>
												<p style="color:red;font-size: 20px">
													<h:outputText value="R$ "/><h:outputText value="#{atual.preco}"/>
								   				</p>
								   				<hr>
								   					<h:outputText value="Altura: "/><h:outputText value="#{atual.altura}"/>
								   					<br/><br/>
								   					<h:outputText value="Largura: "/><h:outputText value="#{atual.largura}"/>
								   					<br/><br/>
								   					<h:outputText value="PESO: "/><h:outputText value="#{atual.peso}"/>
								   				<hr>
								   					<h:outputText value="Categoria: "/><h:outputText value="#{atual.categoria.descricao}"/>
								   															
											</td>
										</tr>
									</table>
								</h:column>					 	
							</rich:dataGrid>

			    	    <a4j:region id="regiaoAjax">
					 	<a4j:status id="sts">
				            	<f:facet name="start">
				            		<h:graphicImage value="/images/ajax-loader.gif" />
				               	</f:facet>
				        </a4j:status>
				        </a4j:region>
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