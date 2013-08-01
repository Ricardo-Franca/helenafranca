package br.com.helenafranca.view;

import java.io.Serializable;
import br.com.helenafranca.controller.BiografiaFacade;
import br.com.helenafranca.controller.BiografiaFacadeImpl;
import br.com.helenafranca.model.entity.Biografia;


public class BiografiaMB implements Serializable {

	private static final long serialVersionUID = 2273212693618648253L;

	private Biografia biografia = new Biografia();

	public BiografiaMB() {
		System.out
				.println(" >>>>>>>>>>>>>>>>>>>> Contrutor do Biografia_MB <<<<<<<<<<<<<<<<<<");

		if (this.biografia == null) {
			this.biografia = new Biografia();
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
	public Biografia getBiografia() {

		BiografiaFacade biografiaService = new BiografiaFacadeImpl();
		Biografia cadastroBiografia = new Biografia();
		
		cadastroBiografia = biografiaService.procura(1L);		

		return cadastroBiografia;
	}
}