package br.com.helenafranca.controller;

import br.com.helenafranca.model.entity.TipoUsuario;

public interface TipoUsuarioFacade extends BaseFacade<TipoUsuario>{
	
	public void salva(TipoUsuario u);
}