package br.com.helenafranca.controller;

import br.com.helenafranca.model.entity.Status;

public interface StatusFacade extends BaseFacade<Status>{
	
	public void salva(Status s);
}