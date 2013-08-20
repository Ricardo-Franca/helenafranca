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
		
			
	<link rel="StyleSheet" type="text/css" href="/helenafranca/style/paginaBiografia.css" />
	
	
	<script type="text/javascript">
           var primeiro=true;
           var segundo=false;
           var terceiro=false;
           var quarto=false;
           var quinto=false;
            
            
            function trataSlides()
            {
            	Fade2();
                Fade3();
                Fade4();
                Fade5();
            }
          
            function loopIt()
            {           	
                if(primeiro)
                {

                    Fade5();                	
                    Appear1();
                    
    
                    primeiro = false;
                    segundo = true;
                }
                else                   
                {
                	if(segundo)
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
                        	quarto = true;
                		}else                   
                        {
                        	if(quarto)
                        	{               	
                            	Fade3();
                           		Appear4();
                           		
                            	quarto = false;
                            	quinto = true;
                        	}else
                        	 {
                        		if(quinto)
                        		{
                                	Fade4();
                               		Appear5();
                               		
                                	quinto = false;
                                	primeiro = true;
                        		}
                	 		 }
                		}
            		}
                }
            }
            
       </script>
</head>
<body>
<div id="body">
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
		
		<a4j:region>
            <h:form>
                <a4j:poll id="poll1" interval="5000" enabled="true" oncomplete="loopIt();"></a4j:poll>
            </h:form>
        </a4j:region>
		
		<div id="Slide_1">				
		<h:form>
			<rich:dataTable  value="#{fotoMB.getFotos(1)}" columns="2" var="slide1" id="ultimos" width="10%" style="border:none;">
				<rich:column style="text-align:left;border:none;" width="50%">							
					<h:graphicImage value="#{slide1.foto}" height="500" width="430" />
				</rich:column>				
			</rich:dataTable>
        </h:form>        
		</div>
		
		<div id="Slide_2">				
		<h:form>
			<rich:dataTable  value="#{fotoMB.getFotos(2)}" columns="2" var="slide2" id="ultimos" width="10%" style="border:none;">
				<rich:column style="text-align:left;border:none;" width="50%">							
					<h:graphicImage value="#{slide2.foto}" height="500" width="430" />
				</rich:column>				
			</rich:dataTable>
        </h:form>        
		</div>
		
		<div id="Slide_3">				
		<h:form>
			<rich:dataTable  value="#{fotoMB.getFotos(3)}" columns="2" var="slide3" id="ultimos" width="10%" style="border:none;">
				<rich:column style="text-align:left;border:none;" width="50%">							
					<h:graphicImage value="#{slide3.foto}" height="500" width="430" />
				</rich:column>				
			</rich:dataTable>
        </h:form>        
		</div>
		
		<div id="Slide_4">				
		<h:form>
			<rich:dataTable  value="#{fotoMB.getFotos(4)}" columns="2" var="slide4" id="ultimos" width="10%" style="border:none;">
				<rich:column style="text-align:left;border:none;" width="50%">							
					<h:graphicImage value="#{slide4.foto}" height="500" width="430" />
				</rich:column>				
			</rich:dataTable>
        </h:form>        
		</div>
		
		<div id="Slide_5">				
		<h:form>
			<rich:dataTable  value="#{fotoMB.getFotos(5)}" columns="2" var="slide5" id="ultimos" width="10%" style="border:none;">
				<rich:column style="text-align:left;border:none;" width="50%">							
					<h:graphicImage value="#{slide5.foto}" height="500" width="430" />
				</rich:column>				
			</rich:dataTable>
        </h:form>        
		</div>		
		
        <rich:effect name="Appear1" for="Slide_1" type="Appear" ></rich:effect> 
        <rich:effect name="Appear2" for="Slide_2" type="Appear" ></rich:effect>
        <rich:effect name="Appear3" for="Slide_3" type="Appear" ></rich:effect>
        <rich:effect name="Appear4" for="Slide_4" type="Appear" ></rich:effect>
        <rich:effect name="Appear5" for="Slide_5" type="Appear" ></rich:effect>                        
        <rich:effect name="Fade1" for="Slide_1" type="Fade" ></rich:effect>
        <rich:effect name="Fade2" for="Slide_2" type="Fade" ></rich:effect>
        <rich:effect name="Fade3" for="Slide_3" type="Fade" ></rich:effect>
        <rich:effect name="Fade4" for="Slide_4" type="Fade" ></rich:effect>
        <rich:effect name="Fade5" for="Slide_5" type="Fade" ></rich:effect>
		
		<div  id="biografia">
		
		
				<h:form>
						<a4j:keepAlive beanName="biografiaMB" />
						<fieldset><legend>Biografia</legend>
							<rich:dataGrid  value="#{biografiaMB.biografia}" columns="1" elements="1" var="biografia" width="100%" cellspacing="0" cellpadding="0" border="0" style="text-align:center;">
								<h:column>	
									<h:outputText style="font-weight:bold;font-size:20px;" value="#{biografia.titulo}"/>
									<br/>
									<hr>
									<br/>												
									<h:inputTextarea value="#{biografia.texto}" readonly="true" style="width:100%;" rows="26" />		
								</h:column>					 	
							</rich:dataGrid>			    	  
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
</div>
</body>	
</html>