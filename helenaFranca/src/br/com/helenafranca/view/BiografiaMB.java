package br.com.helenafranca.view;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.helenafranca.controller.ArtistaFacade;
import br.com.helenafranca.controller.ArtistaFacadeImpl;
import br.com.helenafranca.controller.BiografiaFacade;
import br.com.helenafranca.controller.BiografiaFacadeImpl;
import br.com.helenafranca.model.entity.Artista;
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

	public String updateCadastro() throws IOException {
		BiografiaFacade biografiaService = new BiografiaFacadeImpl();	
		
		biografiaService.atualiza(this.biografia);
		this.biografia = new Biografia();
		
		HttpServletResponse rp = (HttpServletResponse) FacesContext
		.getCurrentInstance().getExternalContext().getResponse();
		HttpServletRequest rq = (HttpServletRequest) FacesContext
		.getCurrentInstance().getExternalContext().getRequest();
		rp.sendRedirect(rq.getContextPath() + "/pages/artista/atualizaCadastroBiografia.jsf");


		return "atualizaSucesso";
	}

	public Biografia getBiografia() {

		BiografiaFacade biografiaService = new BiografiaFacadeImpl();
		
		this.biografia = biografiaService.procura(1L);		

		return this.biografia;
	}
}