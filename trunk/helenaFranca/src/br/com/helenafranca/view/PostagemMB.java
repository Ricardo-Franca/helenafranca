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


import br.com.helenafranca.controller.ArtistaFacade;
import br.com.helenafranca.controller.ArtistaFacadeImpl;
import br.com.helenafranca.controller.PostagemFacade;
import br.com.helenafranca.controller.PostagemFacadeImpl;
import br.com.helenafranca.model.entity.Artista;
import br.com.helenafranca.model.entity.Postagem;

public class PostagemMB implements Serializable {

	private static final long serialVersionUID = 2273212693618648253L;

	private Postagem postagem = new Postagem();
	
	private static String imagePath;

	public PostagemMB(){
		System.out.println(" >>>>>>>>>>>>>>>>>>>> Contrutor de POSTAGEM_MB <<<<<<<<<<<<<<<<<<");
		
		if(this.postagem == null){
			this.postagem = new Postagem(); 			
		}
	}	
	/*
	public String save() throws IOException
	{				
		
		QuadroFacade quadroService = new QuadroFacadeImpl();	
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Artista artista = (Artista) session.getAttribute("artistaLogado");
		
		this.quadro.getArtista().setCodigo(artista.getCodigo());		
		this.quadro.setQuadroImagem(getImagePath());
		quadroService.salva(this.quadro);		
		this.quadro = new Quadro();
		this.imagePath = null;
		
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        rp.sendRedirect(rq.getContextPath() + "/pages/artista/consultaQuadros.jsf");
		return "cadastraSucesso";
	}
	*/
	
	/*
	public String deleteQuadros() throws IOException{
		
		QuadroFacade quadroService = new QuadroFacadeImpl();		
		this.quadro = quadroService.procuraById(codigoQuadro);
		
		String nome = this.quadro.getFoto(); 	
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
	*/
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
	/*
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
	*/
		
	public List<Postagem> getUltimasPostagens() throws IOException
	{					
		List<Postagem> lista = new ArrayList();
		PostagemFacade postagemService = new PostagemFacadeImpl();
		lista = postagemService.procuraUltimasPostagens();		
		
		int tamanho = lista.size();
		
		ArtistaFacade artistaService = new ArtistaFacadeImpl();
		Artista artista = artistaService.procuraByCodigo(1L);
		
		for(int i=0;i<tamanho;i++)
		{
			lista.get(i).setArtista(artista);
		}		
			
        return lista;
	}
	/*
	public Quadro getQuadroAtual() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Quadro cadastroQuadro = new Quadro();
		cadastroQuadro = (Quadro) session.getAttribute("quadroAtual");

		return cadastroQuadro;
	}
	*/
	
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
	/*
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
	*/
	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

	public static String getImagePath() {
		return imagePath;
	}

	public static void setImagePath(String imagePath) {
		PostagemMB.imagePath = imagePath;
	}	
}