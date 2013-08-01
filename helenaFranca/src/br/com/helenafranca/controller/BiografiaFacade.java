package br.com.helenafranca.controller;

import br.com.helenafranca.model.entity.Biografia;

public interface BiografiaFacade extends BaseFacade<Biografia>{
	
	public Biografia procura(Long id);

	public void atualiza(Biografia b);
}