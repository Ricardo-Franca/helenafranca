package br.com.helenafranca.controller;

import br.com.helenafranca.model.entity.Categoria;

public interface CategoriaFacade extends BaseFacade<Categoria>{
	
	public void salva(Categoria c);
}