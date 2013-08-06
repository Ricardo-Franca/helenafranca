package br.com.helenafranca.controller;

import java.util.List;

import br.com.helenafranca.model.entity.Postagem;
import br.com.helenafranca.model.entity.Quadro;

public interface PostagemFacade extends BaseFacade<Postagem>{
	public void salva(Postagem p);

	public void remove(Postagem p);
	
	public Postagem procura(Long id);

	public void atualiza(Postagem p);
	
	public Postagem procuraById(Long codigo);
	
	public List<Postagem> procuraUltimasPostagens();
	
	public List<Postagem> procuraPostagensByData(String dataInicial, String dataFinal);	
}