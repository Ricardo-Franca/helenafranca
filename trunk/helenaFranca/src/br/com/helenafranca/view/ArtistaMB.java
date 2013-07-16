package br.com.helenafranca.view;

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
/*import br.com.sispo.controller.PedidoDePizzaFacade;
import br.com.sispo.controller.PedidoDePizzaFacadeImpl;
import br.com.sispo.controller.PedidoFacade;
import br.com.sispo.controller.PedidoFacadeImpl;*/
import br.com.helenafranca.model.entity.Cliente;
import br.com.helenafranca.model.entity.Artista;
//import br.com.sispo.model.entity.Pedido;
//import br.com.sispo.model.entity.PedidoDePizza;
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
		this.artista.setFotoArtista(imagePath);

		if (!senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage(
					"A senha nÃ£o foi confirmada corretamente");
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

	/*public String delete() throws IOException{
		ArtistaFacade artistaService = new ArtistaFacadeImpl();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		this.artista = (Artista)session.getAttribute("artistaLogado");
		artistaService.inativaArtista(this.artista.getUsuario().getCodigo());
		this.artista = new Artista();
		
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
     
		session.invalidate();
        rp.sendRedirect(rq.getContextPath() + "/pages/usuario/login.jsf");
		
		return "removeSucesso";
	}*/
	
	/*public String deleteArtistas() throws IOException{
		ArtistaFacade artistaService = new ArtistaFacadeImpl();
		this.artista.setCodigo(id);
		artistaService.inativaArtista(this.artista.getUsuario().getCodigo());
		this.artista = new Artista();		
		
		return "removeSucesso";
	}*/

	public String update() throws IOException {
		ArtistaFacade artistaService = new ArtistaFacadeImpl();
		artistaService.atualiza(this.artista);
		this.artista = new Artista();

		HttpServletResponse rp = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		HttpServletRequest rq = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		rp.sendRedirect(rq.getContextPath()
				+ "/pages/artista/atualizaArtista.jsf");

		return "atualizaSucesso";
	}

	public String updateCadastro() throws IOException {
		ArtistaFacade artistaService = new ArtistaFacadeImpl();
		if(getImagePath()!=null)
		{
			this.getCadastroArtista().setFotoArtista(imagePath);
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

	/*public List<Artista> getArtistas() {
		ArtistaFacade artistaService = new ArtistaFacadeImpl();

		return (List)artistaService.pesquisaArtistasAtivas();
	}*/

	public Artista getCadastroArtista() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		Artista cadastroArtista = new Artista();
		cadastroArtista = (Artista) session.getAttribute("artistaLogado");

		return cadastroArtista;
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
		Long tempo=System.currentTimeMillis();
		OutputStream out = new FileOutputStream(
				caminhoReal+"/imagensCadastro/" + "img"
						+ tempo + "." + extensao);
		setImagePath("/imagensCadastro/" + "img"
				+ tempo + "." + extensao);

		try {
			out.write(item.getData());
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void escolheConsultarPizzaria() throws IOException
	{		
		ArtistaFacade artistaService = new ArtistaFacadeImpl();
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	    HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	        
		Artista artista = (Artista)artistaService.procuraByCodigo(this.id);
			
		session.setAttribute("artistaConsultada",artista);
			
	    rp.sendRedirect(rq.getContextPath() + "/pages/cliente/pizzaria.jsf");	
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