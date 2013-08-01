package br.com.helenafranca.controller;

import br.com.helenafranca.model.entity.Foto;

public interface FotoFacade extends BaseFacade<Foto>{
	
	public void atualiza(Foto f);
	
	public Foto procura(Long id);	
}