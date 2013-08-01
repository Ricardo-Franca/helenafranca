package br.com.helenafranca.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.helenafranca.controller.FotoFacade;
import br.com.helenafranca.controller.FotoFacadeImpl;
import br.com.helenafranca.model.entity.Foto;


public class FotoMB implements Serializable {

	private static final long serialVersionUID = 2273212693618648253L;

	private Foto foto = new Foto();

	public FotoMB() {
		System.out
				.println(" >>>>>>>>>>>>>>>>>>>> Contrutor do Foto_MB <<<<<<<<<<<<<<<<<<");

		if (this.foto == null) {
			this.foto = new Foto();
		}
	}
/*
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
*/
	public Foto getFotos(Long codigo) {

		FotoFacade fotoService = new FotoFacadeImpl();
		Foto foto = new Foto();
		
		foto = fotoService.procura(codigo);	

		return foto;
	}
}