package br.com.helenafranca.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import br.com.helenafranca.model.entity.Quadro;

public class PostagemMB implements Serializable {

	private static final long serialVersionUID = 2273212693618648253L;

	private Postagem postagem = new Postagem();
	private Long codigoPostagem;

	private static String imagePath;

	public PostagemMB() {
		System.out
				.println(" >>>>>>>>>>>>>>>>>>>> Contrutor de POSTAGEM_MB <<<<<<<<<<<<<<<<<<");

		if (this.postagem == null) {
			this.postagem = new Postagem();
		}
	}

	public String save() throws IOException {

		PostagemFacade postagemService = new PostagemFacadeImpl();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		Artista artista = (Artista) session.getAttribute("artistaLogado");

		Date date = new Date();
		SimpleDateFormat formataHora = new SimpleDateFormat("HH:mm"); // 12:00:00
		SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd"); // 2014-01-01

		String hora = formataHora.format(date);
		String data = formataData.format(date);

		this.postagem.setHora(hora);
		this.postagem.setData(data);

		this.postagem.getArtista().setCodigo(artista.getCodigo());
		this.postagem.setImagem(getImagePath());

		postagemService.salva(this.postagem);
		this.postagem = new Postagem();
		this.imagePath = null;

		HttpServletResponse rp = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		HttpServletRequest rq = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		rp.sendRedirect(rq.getContextPath()
				+ "/pages/artista/consultaPostagens.jsf");
		return "cadastraSucesso";
	}

	
	  public String deletePostagem() throws IOException
	  {	  
		  PostagemFacade postagemService = new PostagemFacadeImpl(); 
		  this.postagem = postagemService.procuraById(codigoPostagem);
		  
		  String nome = this.postagem.getImagem();
		  nome = nome.substring(21); nome = "C:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps" + nome;
		  
		  File f = new File(nome); f.delete();
		  
		  postagemService.remove(this.postagem);
		  this.postagem = new Postagem();
		  
		  HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		  HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		  rp.sendRedirect(rq.getContextPath() +"/pages/artista/consultaPostagens.jsf");
		  
		  return "removeSucesso"; 
	  }
	 

	public String updateCadastro() throws IOException {
		PostagemFacade postagemService = new PostagemFacadeImpl();

		if (getImagePath() != null) {
			if (this.getPostagemAtual().getImagem() != null) {
				String nome = "";
				nome += this.getPostagemAtual().getImagem();

				if (nome.equals(null) || nome.equals("")) {
					nome = "http://localhost:8081/imagensHelenaFranca/imgcontroleDeErro.jpg";
				}

				nome = nome.substring(21);
				nome = "C:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps"
						+ nome;

				File f = new File(nome);
				f.delete();
			}
			this.getPostagemAtual().setImagem(getImagePath());
		}

		postagemService.atualiza(this.getPostagemAtual());
		this.imagePath = null;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.setAttribute("quadroAtual", this.getPostagemAtual());
		this.postagem = new Postagem();

		return "atualizaSucesso";
	}

	public List<Postagem> getUltimasPostagens() throws IOException {
		List<Postagem> lista = new ArrayList();
		PostagemFacade postagemService = new PostagemFacadeImpl();
		lista = postagemService.procuraUltimasPostagens();

		int tamanho = lista.size();

		ArtistaFacade artistaService = new ArtistaFacadeImpl();
		Artista artista = artistaService.procuraByCodigo(1L);
		
		String auxiliar = "";
		
		for (int i = 0; i < tamanho; i++) {
			lista.get(i).setArtista(artista);
			
			// Formata Data para apresentação			
			auxiliar = lista.get(i).getData().substring(8,10);
			auxiliar +="/";
			auxiliar += lista.get(i).getData().substring(5,7);
			auxiliar +="/";
			auxiliar += lista.get(i).getData().substring(0,4);			
			lista.get(i).setData(auxiliar);	
			
		}

		return lista;
	}
	
	public List<Postagem> getPostagensDaArtista() throws IOException {
		List<Postagem> lista = new ArrayList();
		PostagemFacade postagemService = new PostagemFacadeImpl();
		lista = postagemService.procuraUltimasPostagens();

		int tamanho = lista.size();

		ArtistaFacade artistaService = new ArtistaFacadeImpl();
		Artista artista = artistaService.procuraByCodigo(1L);

		for (int i = 0; i < tamanho; i++) {
			lista.get(i).setArtista(artista);
		}

		return lista;
	}

	public void uploadImage(UploadEvent evento) throws FileNotFoundException {
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

		OutputStream out = new FileOutputStream(caminhoReal + "/" + "img"
				+ tempo + "." + extensao);
		setImagePath("http://localhost:8081/imagensHelenaFranca/" + "img"
				+ tempo + "." + extensao);

		try {
			out.write(item.getData());
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void escolheAlterarPostagem() throws IOException {
		Postagem postagem = new Postagem();
		PostagemFacade postagemService = new PostagemFacadeImpl();
		postagem = postagemService.procuraById(codigoPostagem);

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		HttpServletResponse rp = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		HttpServletRequest rq = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();

		session.setAttribute("postagemAtual", postagem);

		rp.sendRedirect(rq.getContextPath()
				+ "/pages/artista/atualizaPostagem.jsf");
	}

	public Postagem getPostagemAtual() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		Postagem cadastroPostagem = new Postagem();
		cadastroPostagem = (Postagem) session.getAttribute("postagemAtual");

		return cadastroPostagem;
	}

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

	public Long getCodigoPostagem() {
		return codigoPostagem;
	}

	public void setCodigoPostagem(Long codigoPostagem) {
		this.codigoPostagem = codigoPostagem;
	}
}