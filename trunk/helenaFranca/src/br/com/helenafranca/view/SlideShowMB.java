package br.com.helenafranca.view;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
	
	public void escolheAlterarQuadro(Long indice) throws IOException
	{
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("indiceDoSlideShow", indice);
		
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		rp.sendRedirect(rq.getContextPath() + "/pages/artista/consultaQuadrosSlideShow.jsf");
	}
	
	public void escolheCadastrarQuadro(Long indice) throws IOException
	{		
		SlideShowFacade slideShowService = new SlideShowFacadeImpl();

		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

		FacesContext context = FacesContext.getCurrentInstance();
		
		FacesMessage facesMessage = new FacesMessage();
		
		if(slideShowService.procuraById(indice)==null)
		{
			rp.sendRedirect(rq.getContextPath() + "/pages/artista/cadastraQuadrosSlideShow.jsf");			
		}else
		 {
			facesMessage.setSummary("Já existe uma quadro cadastrado.");
			context.addMessage(null, facesMessage);
			
			rp.sendRedirect(rq.getContextPath() + "/pages/artista/manterSlideShow.jsf");
		 }				
	}
	
public void cadastraQuadroDoSlideShow() throws IOException {
		

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
				
		SlideShowFacade slideShowService = new SlideShowFacadeImpl();	
		
		QuadroFacade quadroService = new QuadroFacadeImpl();
		Quadro quadro = quadroService.procuraById(codigoQuadro);
		Artista artista = (Artista)session.getAttribute("artistaLogado");
		
		this.slideShow.setQuadro(quadro);		
		this.slideShow.setArtista(artista);
		
		slideShowService.salva(this.slideShow);
		
		this.slideShow = new SlideShow();


		response.sendRedirect(request.getContextPath() + "/pages/artista/manterSlideShow.jsf");
	}
	
	public void alterarQuadroDoSlideShow() throws IOException {
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
				
		SlideShowFacade slideShowService = new SlideShowFacadeImpl();				
		long indice = (Long) session.getAttribute("indiceDoSlideShow");		
		this.slideShow = slideShowService.procuraById(indice);
		
		QuadroFacade quadroService = new QuadroFacadeImpl();
		Quadro quadro = quadroService.procuraById(codigoQuadro);		
		this.slideShow.setQuadro(quadro);		
		
		slideShowService.atualiza(this.slideShow);
		this.slideShow = new SlideShow();


		response.sendRedirect(request.getContextPath() + "/pages/artista/manterSlideShow.jsf");
	}
	
	
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