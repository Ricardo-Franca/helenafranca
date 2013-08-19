package br.com.helenafranca.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;


import br.com.helenafranca.controller.SlideShowFacade;
import br.com.helenafranca.controller.SlideShowFacadeImpl;
import br.com.helenafranca.controller.QuadroFacade;
import br.com.helenafranca.controller.QuadroFacadeImpl;
import br.com.helenafranca.model.entity.Artista;
import br.com.helenafranca.model.entity.SlideShow;
import br.com.helenafranca.model.entity.Quadro;

public class SlideShowMB implements Serializable {

	private static final long serialVersionUID = 2273212693618648253L;

	private SlideShow slideShow = new SlideShow();

	private Long id;
	private Long codigoQuadro;

	public SlideShowMB(){
		System.out.println(" >>>>>>>>>>>>>>>>>>>> Contrutor de SlideShow_MB <<<<<<<<<<<<<<<<<<");
		
		if(this.slideShow == null){
			this.slideShow = new SlideShow(); 			
		}
	}	
	
	public String save() throws IOException
	{				
		
		SlideShowFacade slideShowService = new SlideShowFacadeImpl();	
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Artista artista = (Artista) session.getAttribute("artistaLogado");
		Quadro quadro = (Quadro) session.getAttribute("quadroEscolhido");
		
		this.slideShow.getArtista().setCodigo(artista.getCodigo());
		this.slideShow.getQuadro().setCodigo(quadro.getCodigo());
		
		slideShowService.salva(this.slideShow);
		
		this.slideShow = new SlideShow();
		
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        rp.sendRedirect(rq.getContextPath() + "/pages/artista/manterSlideShow.jsf");
		return "cadastraSucesso";
	}

	/*
	public String updateCadastro() throws IOException {
		QuadroFacade quadroService = new QuadroFacadeImpl();
		
		
		if(getImagePath()!=null)
		{
			String nome = this.getCadastroQuadro().getFoto();
			
			if(nome.equals(null))
			{
				nome = "http://localhost:8081/imagensHelenaFranca/imgcontroleDeErro.jpg";
			}
			
			nome = nome.substring(21);
			nome = "C:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps" + nome;
					
			File f = new File(nome);  
			f.delete();
			
			this.getCadastroQuadro().setQuadroImagem(getImagePath());
			
		}
		
		quadroService.atualiza(this.getCadastroQuadro());
		this.imagePath = null;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("quadroAtual", this.getCadastroQuadro());
		this.quadro = new Quadro();

		return "atualizaSucesso";
	}
	*/
	
	public String procuraById() throws IOException
	{	
		Quadro quadro = new Quadro();
		QuadroFacade quadroService = new QuadroFacadeImpl();
		quadro = quadroService.procuraById(codigoQuadro);
						
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
        session.setAttribute("quadroAtual", quadro);	
		
        rp.sendRedirect(rq.getContextPath() + "/pages/usuario/pesquisaQuadro.jsf");	
        return "setado";
	}
	
	public SlideShow getSlide1() throws IOException
	{
		SlideShow slideShow = new SlideShow();
		SlideShowFacade slideShowService = new SlideShowFacadeImpl();	
		slideShow = slideShowService.procuraById(1L);
				
		return slideShow;
	}
	
	public SlideShow getSlide2() throws IOException
	{
		SlideShow slideShow = new SlideShow();
		SlideShowFacade slideShowService = new SlideShowFacadeImpl();	
		slideShow = slideShowService.procuraById(2L);
				
		return slideShow;
	}
	
	public SlideShow getSlide3() throws IOException
	{
		SlideShow slideShow = new SlideShow();
		SlideShowFacade slideShowService = new SlideShowFacadeImpl();	
		slideShow = slideShowService.procuraById(3L);
				
		return slideShow;
	}
	
	public SlideShow getSlide4() throws IOException
	{
		SlideShow slideShow = new SlideShow();
		SlideShowFacade slideShowService = new SlideShowFacadeImpl();	
		slideShow = slideShowService.procuraById(4L);
				
		return slideShow;
	}
	
	public SlideShow getSlide5() throws IOException
	{
		SlideShow slideShow = new SlideShow();
		SlideShowFacade slideShowService = new SlideShowFacadeImpl();	
		slideShow = slideShowService.procuraById(5L);
				
		return slideShow;
	}	
	
	public Long getCodigo() {
		return id;
	}

	public void setCodigo(Long id) {
		this.id = id;
	}

	public Long getCodigoQuadro() {
		return codigoQuadro;
	}

	public void setCodigoQuadro(Long codigoQuadro) {
		this.codigoQuadro = codigoQuadro;
	}	
}