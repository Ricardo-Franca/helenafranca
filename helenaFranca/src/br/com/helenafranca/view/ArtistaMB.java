package br.com.helenafranca.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.helenafranca.controller.CategoriaFacade;
import br.com.helenafranca.controller.CategoriaFacadeImpl;
import br.com.helenafranca.controller.ClienteFacade;
import br.com.helenafranca.controller.ClienteFacadeImpl;
import br.com.helenafranca.controller.ArtistaFacade;
import br.com.helenafranca.controller.ArtistaFacadeImpl;
import br.com.helenafranca.model.entity.Categoria;
import br.com.helenafranca.model.entity.Cliente;
import br.com.helenafranca.model.entity.Artista;
import br.com.helenafranca.util.CriptografaSenha;


public class ArtistaMB implements Serializable {

	private static final long serialVersionUID = 2273212693618648253L;

	private Artista artista = new Artista();
	private static String imagePath;
	private Long id;
	private String confirmarSenha;
	private String senhaAtual;

	public ArtistaMB() {
		System.out
				.println(" >>>>>>>>>>>>>>>>>>>> Contrutor do Artista_MB <<<<<<<<<<<<<<<<<<");

		if (this.artista == null) {
			this.artista = new Artista();
		}
	}
	
	public String save() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		String senha = this.artista.getUsuario().getSenha();
		this.artista.setFoto(imagePath);

		if (!senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage(
					"A senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}

		ArtistaFacade artistaService = new ArtistaFacadeImpl();
		this.artista.getUsuario().setSenha(CriptografaSenha.md5(senha));
		
		artistaService.salva(this.artista);
		this.artista = new Artista();

		HttpServletResponse rp = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		HttpServletRequest rq = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		rp.sendRedirect(rq.getContextPath()
				+ "/pages/novoUsuario/usuarioCadastrado.jsf");
		return "cadastraSucesso";
	}

	public String updateCadastro() throws IOException {
		ArtistaFacade artistaService = new ArtistaFacadeImpl();
						
		if(getImagePath()!=null)
		{
			
			String nome = this.getCadastroArtista().getFoto(); 
			
			if(nome.equals(null))
			{
				nome = "http://localhost:8081/imagensHelenaFranca/imgcontroleDeErro.jpg";
			}
			
			nome = nome.substring(21);
			nome = "C:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps" + nome;
					
			File f = new File(nome);  
			f.delete();			
			
			this.getCadastroArtista().setFoto(imagePath);
			this.imagePath = null;
		}	
		
		artistaService.atualiza(this.getCadastroArtista());
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("artistaLogado", this.getCadastroArtista());
		this.artista = new Artista();
		
		HttpServletResponse rp = (HttpServletResponse) FacesContext
		.getCurrentInstance().getExternalContext().getResponse();
		HttpServletRequest rq = (HttpServletRequest) FacesContext
		.getCurrentInstance().getExternalContext().getRequest();
		rp.sendRedirect(rq.getContextPath() + "/pages/artista/atualizaCadastroArtista.jsf");


		return "atualizaSucesso";
	}

	public String alterarSenha() throws IOException {

		FacesContext context = FacesContext.getCurrentInstance();
		String senha = this.artista.getUsuario().getSenha();

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Artista cadastroArtista = (Artista) session.getAttribute("artistaLogado");

		String senhaCadastrada = cadastroArtista.getUsuario().getSenha();

		FacesMessage facesMessage = new FacesMessage();
		
		if (!senha.equals(this.confirmarSenha) || (!senhaCadastrada.equals(this.senhaAtual))) 
		{			

			if (!senha.equals(this.confirmarSenha)) 
			{
				facesMessage.setSummary("Nova senha não corresponde a confirmação.");
			} else 
			{
				if (!senhaCadastrada.equals(this.senhaAtual)) 
				{
					facesMessage.setSummary("Senha atual não foi confirmada corretamente.");
				}
			}
			
			context.addMessage(null, facesMessage);
			return null;
		}
		
		

		cadastroArtista.getUsuario().setSenha(CriptografaSenha.md5(this.artista.getUsuario().getSenha()));
		this.artista = cadastroArtista;

		ArtistaFacade artistaService = new ArtistaFacadeImpl();
		artistaService.atualiza(this.artista);
		this.artista = new Artista();

		facesMessage.setSummary("Senha alterada com sucesso!");
		context.addMessage(null, facesMessage);
		return "atualizaSucesso";
	}

	public String load() {
		ArtistaFacade artistaService = new ArtistaFacadeImpl();
		this.artista = artistaService.procura(this.id);

		return "pesquisaSucesso";
	}

	public Artista getCadastroArtista() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		Artista cadastroArtista = new Artista();
		cadastroArtista = (Artista) session.getAttribute("artistaLogado");

		return cadastroArtista;
	}
	
	public Artista getBuscaArtista() {
		
		ArtistaFacade artistaService = new ArtistaFacadeImpl();
		Artista cadastroArtista = new Artista();
		cadastroArtista = artistaService.procuraByCodigo(1L);

		return cadastroArtista;
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
		this.setImagePath("http://localhost:8081/imagensHelenaFranca/" + "img"	+ tempo + "." + extensao);
		
		try {
			out.write(item.getData());
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Artista getArtistaConsultada()
	{
		
   	   HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	   Artista artistaConsultada = new Artista();
	   artistaConsultada = (Artista)session.getAttribute("artistaConsultada");
		
		return artistaConsultada;
	}
	

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Long getCodigo() {
		return id;
	}

	public void setCodigo(Long id) {
		this.id = id;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImagePath() {
		return imagePath;
	}
	
	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		
		this.senhaAtual = CriptografaSenha.md5(senhaAtual);
	}
}