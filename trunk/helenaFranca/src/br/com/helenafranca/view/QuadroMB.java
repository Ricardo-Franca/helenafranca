package br.com.helenafranca.view;

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
			
		this.quadro.setQuadro_imagem(getImagePath());
		quadroService.salva(this.quadro);		
		this.quadro = new Quadro();
		
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        //rp.sendRedirect(rq.getContextPath() + "/pages/empresa/consultaPizzas.jsf");
		return "cadastraSucesso";
	}
	
	public String deleteQuadros() throws IOException{
		QuadroFacade quadroService = new QuadroFacadeImpl();
		this.quadro.setCod_quadro(id);
		
		quadroService.remove(this.quadro);
		this.quadro = new Quadro();	
		
		return "removeSucesso";
	}
	
	public String update() throws IOException{
		QuadroFacade quadroService = new QuadroFacadeImpl();
		quadroService.atualiza(this.quadro);
		this.quadro = new Quadro();

		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        //rp.sendRedirect(rq.getContextPath() + "/pages/empresa/atualizaPizza.jsf");
		return "atualizaSucesso";
	}
	
	/*public String updateCadastro() throws IOException {
		QuadroFacade quadroService = new QuadroFacadeImpl();
		this.getCadastroQuadro().setQuadro_imagem(getImagePath());
		quadroService.atualiza(this.getCadastroQuadro());
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("pizzaAtual", this.getCadastroQuadro());
		this.quadro = new Quadro();

		return "atualizaSucesso";
	}*/
	
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
	
	public String toIndex() throws IOException
	{	
		System.out.println("******************");
		System.out.println("******************redirecionando para index.");
		System.out.println("******************");
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
	
	
	public void  uploadImage(UploadEvent evento) throws FileNotFoundException {
		FacesContext fc= FacesContext.getCurrentInstance();
		ServletContext sc= (ServletContext)fc.getExternalContext().getContext();
		String caminhoReal = sc.getRealPath("/");
		String extensao = "";
		UploadItem item = evento.getUploadItem();
		String fileName = item.getFileName();
		String ext[] = fileName.split("\\.");
		int i = ext.length;

		if (i > 1) {
			extensao = ext[i - 1];

		}


		Long tempo = System.currentTimeMillis();
		OutputStream out = new FileOutputStream(
				caminhoReal+"/ImagensQuadros/" + "img"
						+ tempo + "." + extensao);
		setImagePath("/ImagensQuadros/" + "img"
				+ tempo + "." + extensao);
		
		try {
			out.write(item.getData());
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
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