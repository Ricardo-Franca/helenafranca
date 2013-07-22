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


import br.com.helenafranca.controller.QuadroFacade;
import br.com.helenafranca.controller.QuadroFacadeImpl;
import br.com.helenafranca.model.entity.Artista;
import br.com.helenafranca.model.entity.Quadro;

public class QuadroMB implements Serializable {

	private static final long serialVersionUID = 2273212693618648253L;

	private Quadro quadro = new Quadro();

	private Long id;
	private Long codigoQuadro;
	private String nome;
	private Long codigoCategoria;
	private static String imagePath;

	public QuadroMB(){
		System.out.println(" >>>>>>>>>>>>>>>>>>>> Contrutor da QUADRO_MB <<<<<<<<<<<<<<<<<<");
		
		if(this.quadro == null){
			this.quadro = new Quadro(); 			
		}
	}	
	
	public String save() throws IOException
	{				
		
		QuadroFacade quadroService = new QuadroFacadeImpl();	
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Artista artista = (Artista) session.getAttribute("artistaLogado");
		
		this.quadro.getArtista().setCodigo(artista.getCodigo());		
		this.quadro.setQuadroImagem(getImagePath());
		quadroService.salva(this.quadro);		
		this.quadro = new Quadro();
		
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        rp.sendRedirect(rq.getContextPath() + "/pages/artista/consultaQuadros.jsf");
		return "cadastraSucesso";
	}
	
	public String deleteQuadros() throws IOException{
		
		QuadroFacade quadroService = new QuadroFacadeImpl();		
		this.quadro = quadroService.procuraById(codigoQuadro);
		
		String nome = this.quadro.getQuadroImagem(); 	
		nome = nome.substring(21);
		nome = "C:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps" + nome;
				
		File f = new File(nome);  
		f.delete();
			
		quadroService.remove(this.quadro);
		this.quadro = new Quadro();
		
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        rp.sendRedirect(rq.getContextPath() + "/pages/artista/consultaQuadros.jsf");
		
		return "removeSucesso";
	}
	
	public String updateCadastro() throws IOException {
		QuadroFacade quadroService = new QuadroFacadeImpl();
		
		
		if(getImagePath()!=null)
		{
			String nome = this.getCadastroQuadro().getQuadroImagem();
			
			if(nome.equals(null))
			{
				nome = "http://localhost:8081/imagensHelenaFranca/imgcontroleDeErro.jpg";
			}
			
			nome = nome.substring(21);
			nome = "C:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps" + nome;
					
			File f = new File(nome);  
			f.delete();
			
			this.getCadastroQuadro().setQuadroImagem(getImagePath());
			this.imagePath = null;
		}
		
		quadroService.atualiza(this.getCadastroQuadro());
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("quadroAtual", this.getCadastroQuadro());
		this.quadro = new Quadro();

		return "atualizaSucesso";
	}
	
	public Quadro getCadastroQuadro() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Quadro cadastroQuadro = new Quadro();
		cadastroQuadro = (Quadro) session.getAttribute("quadroAtual");

		return cadastroQuadro;
	}
	
	
	public String load(){
		QuadroFacade quadroService = new QuadroFacadeImpl();
		this.quadro = quadroService.procura(this.id);
		
		return "pesquisaSucesso";
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
	
	public Quadro getSlide1() throws IOException
	{	
		Quadro quadro = new Quadro();
		QuadroFacade quadroService = new QuadroFacadeImpl();
		quadro = quadroService.procuraById(1L);
						
		return quadro;
	}
	
	public Quadro getSlide2() throws IOException
	{	
		Quadro quadro = new Quadro();
		QuadroFacade quadroService = new QuadroFacadeImpl();
		quadro = quadroService.procuraById(2L);
						
		return quadro;
	}
	
	public Quadro getSlide3() throws IOException
	{	
		Quadro quadro = new Quadro();
		QuadroFacade quadroService = new QuadroFacadeImpl();
		quadro = quadroService.procuraById(3L);
						
		return quadro;
	}
	
	
	public String toIndex() throws IOException
	{		
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();	
		
        rp.sendRedirect(rq.getContextPath() + "/pages/index.jsf");	 
        
        return "redirecionando";
	}
	
	public String escolheProcuraByNomeCategoria() throws IOException
	{	
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			
        session.setAttribute("nome", nome);
        session.setAttribute("codigoCategoria", codigoCategoria);
        
        rp.sendRedirect(rq.getContextPath() + "/pages/usuario/pesquisaByNomeCategoria.jsf");	
        return null;
	}
	
	public List<Quadro> getProcuraByNomeCategoria() throws IOException
	{	
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		this.nome = (String) session.getAttribute("nome");
		this.codigoCategoria = (Long) session.getAttribute("codigoCategoria");
		
		List<Quadro> lista = new ArrayList();
		QuadroFacade quadroService = new QuadroFacadeImpl();
		lista = quadroService.procuraByNomeCategoria(this.nome, this.codigoCategoria);
			
        return lista;
	}
	
	public String escolheProcuraByCategoria() throws IOException
	{	
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			       
        session.setAttribute("codigoCategoria", codigoCategoria);
        
        rp.sendRedirect(rq.getContextPath() + "/pages/usuario/pesquisaByCategoria.jsf");	
        return null;
	}
	
	public List<Quadro> getProcuraByCategoria() throws IOException
	{	
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		this.nome = (String) session.getAttribute("nome");
		this.codigoCategoria = (Long) session.getAttribute("codigoCategoria");
		
		List<Quadro> lista = new ArrayList();
		QuadroFacade quadroService = new QuadroFacadeImpl();
		lista = quadroService.procuraByCategoria(this.codigoCategoria);
			
        return lista;
	}
	
	public List<Quadro> getUltimosQuadros() throws IOException
	{					
		List<Quadro> lista = new ArrayList();
		QuadroFacade quadroService = new QuadroFacadeImpl();
		lista = quadroService.procuraUltimosQuadros();
			
        return lista;
	}
	
	public Quadro getQuadroAtual() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Quadro cadastroQuadro = new Quadro();
		cadastroQuadro = (Quadro) session.getAttribute("quadroAtual");

		return cadastroQuadro;
	}
		
	public List<Quadro> getQuadros(){
		QuadroFacade quadroService = new QuadroFacadeImpl();		
		
		return quadroService.lista();
	}
	
	public void  uploadImage(UploadEvent evento) throws FileNotFoundException 
	{		
		String caminhoReal = "C:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/imagensHelenaFranca";
		String extensao = "";
		UploadItem item = evento.getUploadItem();
		String fileName = item.getFileName();
		String ext[] = fileName.split("\\.");
		int i = ext.length;

		Long tempo = System.currentTimeMillis();
		
		if (i > 1) {
			extensao = ext[i - 1];

		}
				
		OutputStream out = new FileOutputStream(caminhoReal+"/" + "img"+ tempo + "." + extensao);
		setImagePath("http://localhost:8081/imagensHelenaFranca/" + "img"	+ tempo + "." + extensao);
		
		try {
			out.write(item.getData());
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Quadro> getSeusQuadros()
	{
		QuadroFacade quadroService = new QuadroFacadeImpl();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Artista artista = (Artista)session.getAttribute("artistaLogado");
				
		List<Quadro> quadros = new ArrayList();
		
		quadros = (List)quadroService.procuraQuadrosByCodigoArtista(artista.getCodigo());
		
		return quadros;
		
	}
	
	public void escolheAlterarQuadro() throws IOException
	{	
		Quadro quadro = new Quadro();
		QuadroFacade quadroService = new QuadroFacadeImpl();
		quadro = quadroService.procuraById(codigoQuadro);
						
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
        session.setAttribute("quadroAtual", quadro);	
		
        rp.sendRedirect(rq.getContextPath() + "/pages/artista/atualizaQuadro.jsf");		
	}
	
	public Quadro getQuadro() {
		return quadro;
	}

	public void setQuadro(Quadro quadro) {
		this.quadro = quadro;
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

	public static String getImagePath() {
		return imagePath;
	}

	public static void setImagePath(String imagePath) {
		QuadroMB.imagePath = imagePath;
	}

	public Long getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Long codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}