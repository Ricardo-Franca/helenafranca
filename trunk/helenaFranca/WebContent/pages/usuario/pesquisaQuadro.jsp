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
		
	<!--  SLIDESHOW JQUERY
	------------------------------------
	
	<script type="text/javascript" src='/helenafranca/script/jquery.js' ></script>
	<script type="text/javascript" src='/helenafranca/script/cycle.js' ></script>	
	
	
	
	<link rel="StyleSheet" type="text/css" href="/helenafranca/style/slideshow.css" />	
	
	<script type="text/javascript">
	$('#slides').cycle();
	</script>
	
	------------------------------------
	-->
		
	<link rel="StyleSheet" type="text/css" href="/helenafranca/style/pesquisaQuadro.css" />
	
	
	
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
		
		
			<h:form>
		
		        <h:panelGrid styleClass="vertical-menu-cell" columnClasses="optionList" columns="1" cellspacing="0" cellpadding="0" width="250">
		            <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor}" value="Abstratos" submitMode="none" direction="bottom-right" jointPoint="tr">
		                <rich:menuItem  value="Suboption1-1" />
		                <rich:menuItem value="Suboption1-2">
		                    <f:facet name="icon">
		                    <h:graphicImage width="10" height="10" value="/imagens/rosa.png" />
		                    </f:facet>		                
		                </rich:menuItem>
		                <rich:menuItem value="Suboption1-3" />
		            </rich:dropDownMenu>
		            
		             <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor}" value="Animais" submitMode="none" direction="bottom-right" jointPoint="tr">
		                <rich:menuItem value="Suboption1-1" />
		                <rich:menuItem value="Suboption1-2">
		                    <f:facet name="icon">
		                    <h:graphicImage value="/richfaces/toolBar/images/print.gif" />
		                    </f:facet>
		                
		                </rich:menuItem>
		                <rich:menuItem value="Suboption1-3" />
		            </rich:dropDownMenu>
		            
		            <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor}" value="Florais" 
		                        submitMode="none" direction="bottom-right"  jointPoint="tr">
		                <rich:menuItem value="Suboption2-1" />
		                <rich:menuItem value="Suboption2-2" />
		                <rich:menuGroup value="Group2" direction="#{bean.groupDirection}">
		                    <rich:menuItem value="SuboptionG2-2-1" />
		                    <rich:menuItem value="SuboptionG2-2-2" />
		                </rich:menuGroup>
		                
		                <rich:menuItem value="Suboption2-3" />
		            </rich:dropDownMenu>
		            <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor}" value="Paisagens"
		                        submitMode="none" direction="bottom-right"  jointPoint="tr">
		                <rich:menuItem value="Suboption3-1" />
		                <rich:menuItem value="Suboption3-2" />
		                <rich:menuItem value="Suboption3-3" />
		            </rich:dropDownMenu>
		            
		            <rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor}" value="Pessoas"
		                        submitMode="none" direction="bottom-right"  jointPoint="tr">
		                <rich:menuItem value="Suboption3-1" />
		                <rich:menuItem value="Suboption3-2" />
		                <rich:menuItem value="Suboption3-3" />
		            </rich:dropDownMenu>
		         
		         	<rich:dropDownMenu style="border:1px solid #{a4jSkin.panelBorderColor}" value="Natureza Morta"
		                        submitMode="none" direction="bottom-right"  jointPoint="tr">
		                <rich:menuItem value="Suboption3-1" />
		                <rich:menuItem value="Suboption3-2" />
		                <rich:menuItem value="Suboption3-3" />
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
												<h:graphicImage value="#{atual.quadro_imagem}" height="300" width="300" />
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
						<rich:messages/>

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
		rodape
		</div> 
		
	</f:view>
	
</body>	
</html>