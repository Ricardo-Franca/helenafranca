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
				
		
	<link rel="StyleSheet" type="text/css" href="/helenafranca/style/paginaInicial.css" />
	
	<style type="text/css">
            .backgroundHigh { position: absolute; }
        </style>
	
	<script type="text/javascript">
            primeiro=true;
            
            
            function trataSlides()
            {
            	Fade2();
                Fade3();
            }
            
            function loopIt()
            {           	
                if(primeiro)
                {

                    Fade3();                	
                    Appear1();
                    
    
                    primeiro = false;
                    segundo = true;
                }
                else                   
                {
                	if( segundo)
                	{               	
                    	Fade1();
                   		Appear2();
                   		
                    	segundo = false;
                    	terceiro = true;
                	}else
                	 {
                		if(terceiro)
                		{
                        	Fade2();
                       		Appear3();
                       		
                        	terceiro = false;
                        	primeiro = true;
                		}
                	 }
                }
            }
        </script>
	
</head>
<body onload="trataSlides()">
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
		                <rich:menuItem  value="Suboption1-1"/>
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
	      	
        <a4j:region>
            <h:form>
                <a4j:poll id="poll1" interval="5000" enabled="true" oncomplete="loopIt();"></a4j:poll>
            </h:form>
        </a4j:region>
		
		<div id="Slide_1">
		
		<h:form>
			<rich:dataTable  value="#{quadroMB.slide1}" columns="2" var="ultimo" id="ultimos" width="100%" style="border:none;">
				<rich:column style="text-align:left;border:none;" width="60%">			
					<h:commandLink action="#{quadroMB.procuraById}">	
						<h:graphicImage value="#{ultimo.quadro_imagem}" height="220" width="600" />
						<f:setPropertyActionListener value="#{ultimo.cod_quadro}" target="#{quadroMB.codigoQuadro}" />								   
					</h:commandLink>
				</rich:column>
				
				<rich:column style="border:none;"  width="2%">	
				</rich:column>
				
				<rich:column style="border:none;">								    
					<br/>
					<h:outputText style="font-weight:bold;font-size:20px;" value="#{ultimo.nome}"/>
					<hr/>
					<p style="color:red;font-size: 20px">
					<h:outputText value="R$ "/><h:outputText value="#{ultimo.preco}"/>
					</p>
					<hr>
					<h:outputText value="Categoria: "/><h:outputText value="#{ultimo.categoria.descricao}"/>								   					
				</rich:column>
			</rich:dataTable>
        </h:form>
        
		</div>
		
		<div id="Slide_2">
		
		<h:form>
			<rich:dataTable  value="#{quadroMB.slide2}" columns="2" var="ultimo" id="ultimos" width="100%" style="border:none;">
				<rich:column style="text-align:left;border:none;" width="60%">			
					<h:commandLink action="#{quadroMB.procuraById}">	
						<h:graphicImage value="#{ultimo.quadro_imagem}" height="220" width="600" />
						<f:setPropertyActionListener value="#{ultimo.cod_quadro}" target="#{quadroMB.codigoQuadro}" />								   
					</h:commandLink>
				</rich:column>
				
				<rich:column style="border:none;"  width="2%">	
				</rich:column>
				
				<rich:column style="border:none;">								    
					<br/>
					<h:outputText style="font-weight:bold;font-size:20px;" value="#{ultimo.nome}"/>
					<hr/>
					<p style="color:red;font-size: 20px">
					<h:outputText value="R$ "/><h:outputText value="#{ultimo.preco}"/>
					</p>
					<hr>
					<h:outputText value="Categoria: "/><h:outputText value="#{ultimo.categoria.descricao}"/>								   					
				</rich:column>
			</rich:dataTable>
        </h:form>
        
		</div>
		
		<div id="Slide_3">
		
		<h:form>
			<rich:dataTable  value="#{quadroMB.slide3}" columns="2" var="ultimo" id="ultimos" width="100%" style="border:none;">
				<rich:column style="text-align:left;border:none;" width="60%">			
					<h:commandLink action="#{quadroMB.procuraById}">	
						<h:graphicImage value="#{ultimo.quadro_imagem}" height="220" width="600" />
						<f:setPropertyActionListener value="#{ultimo.cod_quadro}" target="#{quadroMB.codigoQuadro}" />								   
					</h:commandLink>
				</rich:column>
				
				<rich:column style="border:none;"  width="2%">	
				</rich:column>
				
				<rich:column style="border:none;">								    
					<br/>
					<h:outputText style="font-weight:bold;font-size:20px;" value="#{ultimo.nome}"/>
					<hr/>
					<p style="color:red;font-size: 20px">
					<h:outputText value="R$ "/><h:outputText value="#{ultimo.preco}"/>
					</p>
					<hr>
					<h:outputText value="Categoria: "/><h:outputText value="#{ultimo.categoria.descricao}"/>								   					
				</rich:column>
			</rich:dataTable>
        </h:form>
        
		</div>
		
		
        <rich:effect name="Appear1" for="Slide_1" type="Appear" ></rich:effect> 
        <rich:effect name="Appear2" for="Slide_2" type="Appear" ></rich:effect>
        <rich:effect name="Appear3" for="Slide_3" type="Appear" ></rich:effect>                
        <rich:effect name="Fade1" for="Slide_1" type="Fade" ></rich:effect>
        <rich:effect name="Fade2" for="Slide_2" type="Fade" ></rich:effect>
        <rich:effect name="Fade3" for="Slide_3" type="Fade" ></rich:effect>
        
		
		<div  id="quadros">
		
		
			<h:form>
						<a4j:keepAlive beanName="quadroMB" />
						<fieldset><legend>Quadros</legend>
							<rich:dataGrid  value="#{quadroMB.quadros}" columns="4" elements="20" var="ultimo"  id="ultimos" width="100%" cellspacing="0" cellpadding="0" border="0" style="text-align:center;">
								<h:column>									
									
									<h:commandLink action="#{quadroMB.procuraById}">	
										<h:graphicImage value="#{ultimo.quadro_imagem}" height="150" width="150" />
										<f:setPropertyActionListener value="#{ultimo.cod_quadro}" target="#{quadroMB.codigoQuadro}" />								   
								    </h:commandLink> 
								    
									<br/>
									<h:outputText style="font-weight: bold;" value="#{ultimo.nome}"/>
									<br/>
									<p style="color:red">
									<h:outputText value="R$ "/><h:outputText value="#{ultimo.preco}"/>
								    </p>
								    
								</h:column>
		
						 		<f:facet name="footer">
									<rich:datascroller />
								</f:facet>
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
		rodape
		</div> 
		
	</f:view>
	
</body>	
</html>