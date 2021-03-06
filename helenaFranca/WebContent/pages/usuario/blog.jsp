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
		
		<div  id="menuLateral">		
		
			<h:form>
			<br>
		        <h:panelGrid  style="border-color:#87CEEB;" columnClasses="optionList" columns="1" cellspacing="0" cellpadding="0" width="190" border="1">
		            <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor};background-color:#CAE1FF;" value="Abstratos" submitMode="none" direction="bottom-right" jointPoint="tr">
		                <rich:menuItem icon="../../imagens/abstrato.png" >	                   
			                <h:commandLink action="#{quadroMB.escolheProcuraByCategoria}" >
								<f:setPropertyActionListener value="1" target="#{quadroMB.codigoCategoria}" />
								<h:outputText value="Abstratos" />					   
							</h:commandLink> 	                
		                </rich:menuItem>
		            </rich:dropDownMenu>
		            
		              <rich:dropDownMenu  style="border:1px solid #{a4jSkin.panelBorderColor};background-color:#CAE1FF;" value="Animais" submitMode="none" direction="bottom-right" jointPoint="tr">
		                <rich:menuItem icon="../../imagens/animais.png">	                   
			                <h:commandLink action="#{quadroMB.escolheProcuraByCategoria}" >
								<f:setPropertyActionListener value="2" target="#{quadroMB.codigoCategoria}" />
								<h:outputText value="Animais" />					   
							</h:commandLink> 	                
		                </rich:menuItem>
		            </rich:dropDownMenu>
		            
		            <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor};background-color:#CAE1FF;" value="Florais" 
		                        submitMode="none" direction="bottom-right"  jointPoint="tr">		                
		                <rich:menuItem icon="../../imagens/floral.png">	                   
			                <h:commandLink action="#{quadroMB.escolheProcuraByCategoria}" >
								<f:setPropertyActionListener value="3" target="#{quadroMB.codigoCategoria}" />
								<h:outputText value="Florais" />					   
							</h:commandLink> 	                
		                </rich:menuItem>	
		            </rich:dropDownMenu>
		            
		            <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor};background-color:#CAE1FF;" value="Paisagens"
		                        submitMode="none" direction="bottom-right"  jointPoint="tr">
		                <rich:menuItem icon="../../imagens/paisagem.png">	                   
			                <h:commandLink action="#{quadroMB.escolheProcuraByCategoria}" >
								<f:setPropertyActionListener value="4" target="#{quadroMB.codigoCategoria}" />
								<h:outputText value="Paisagens" />					   
							</h:commandLink> 	                
		                </rich:menuItem>
		            </rich:dropDownMenu>
		            
		            <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor};background-color:#CAE1FF;" value="Pessoas"
		                        submitMode="none" direction="bottom-right"  jointPoint="tr">
		                <rich:menuItem icon="../../imagens/pessoa.png">	                   
			                <h:commandLink action="#{quadroMB.escolheProcuraByCategoria}" >
								<f:setPropertyActionListener value="5" target="#{quadroMB.codigoCategoria}" />
								<h:outputText value="Pessoas" />					   
							</h:commandLink> 	                
		                </rich:menuItem>
		            </rich:dropDownMenu>
		         
		         	<rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor};background-color:#CAE1FF;" value="Natureza Morta"
		                        submitMode="none" direction="bottom-right"  jointPoint="tr">
		                <rich:menuItem icon="../../imagens/naturezaMorta.png">	                   
			                <h:commandLink action="#{quadroMB.escolheProcuraByCategoria}" >
								<f:setPropertyActionListener value="6" target="#{quadroMB.codigoCategoria}" />
								<h:outputText value="Natureza Morta" />					   
							</h:commandLink> 	                
		                </rich:menuItem>
		            </rich:dropDownMenu>
		            
		            <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor};background-color:#CAE1FF;" value="Releitura"
		                        submitMode="none" direction="bottom-right"  jointPoint="tr">
		                <rich:menuItem icon="../../imagens/releitura.png">	                   
			                <h:commandLink action="#{quadroMB.escolheProcuraByCategoria}" >
								<f:setPropertyActionListener value="7" target="#{quadroMB.codigoCategoria}" />
								<h:outputText value="Releitura" />					   
							</h:commandLink> 	                
		                </rich:menuItem>
		            </rich:dropDownMenu>	            
		        </h:panelGrid>
		    </h:form> 
		</div>				
		
		<div  id="contato">
		
		
			<h:form>
						<a4j:keepAlive beanName="postagemMB" />
						<fieldset><legend>Blog</legend>
							<rich:dataGrid  value="#{postagemMB.ultimasPostagens}" columns="1" elements="10" var="postagem" width="100%" cellspacing="0" cellpadding="0" border="0" style="text-align:center;">
								<h:column>	
									<table style="width:100%;">
										<tr>
											<td>
												<h:outputText style="font-weight:bold;font-size:20px;" value="#{postagem.titulo}"/>
											</td>
										</tr>
										
										<tr>
											<td>
												<hr/>
												<h:outputText style="font-weight:bold;" value="Postado por "/><h:outputText value="#{postagem.artista.nomeArtistico}"/>
												<h:outputText style="font-weight:bold;" value=" em: "/><h:outputText value="#{postagem.data}"/>
												<h:outputText style="font-weight:bold;" value=" às "/><h:outputText value="#{postagem.hora}"/>
												<hr/>
											</td>
										</tr>
										<tr>
											<td>
												<h:graphicImage value="#{postagem.imagem}" height="200" width="200" />
											</td>
										</tr>
										<tr>											
											<td>
											    <br/>												
												<h:outputText value="#{postagem.texto}"/>
											</td>
										</tr>
									</table>
								</h:column>	
								<f:facet name="footer">
									<rich:datascroller />
								</f:facet>				 	
							</rich:dataGrid>			    	  
					</fieldset>
				</h:form>
		</div> 		
	</f:view>
	
</body>	
</html>