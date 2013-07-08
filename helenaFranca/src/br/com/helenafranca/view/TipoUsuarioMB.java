package br.com.helenafranca.view;

import java.io.Serializable;
import br.com.helenafranca.controller.TipoUsuarioFacade;
import br.com.helenafranca.controller.TipoUsuarioFacadeImpl;
import br.com.helenafranca.model.entity.TipoUsuario;

public class TipoUsuarioMB implements Serializable {

	private static final long serialVersionUID = 9186380132421958551L;

	private TipoUsuario tipoUsuario = new TipoUsuario();

	
	public TipoUsuarioMB(){
		System.out.println(" >>>>>>>>>>>>>>>>>>>> Contrutor do TIPOUSUARIO_MB <<<<<<<<<<<<<<<<<<");
		
		if(this.tipoUsuario == null){
			this.tipoUsuario = new TipoUsuario(); 
		}
	}
	
	public String save(){
		TipoUsuarioFacade tipoUsuarioService = new TipoUsuarioFacadeImpl();
			
		tipoUsuarioService.salva(this.tipoUsuario);
		
		this.tipoUsuario = new TipoUsuario(); 
		return "cadastraSucesso";
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}	
}