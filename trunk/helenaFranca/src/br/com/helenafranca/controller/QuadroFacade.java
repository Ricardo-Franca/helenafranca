package br.com.helenafranca.controller;

import java.util.List;

import br.com.helenafranca.model.entity.Quadro;

public interface QuadroFacade extends BaseFacade<Quadro>{
	public void salva(Quadro q);

	public void remove(Quadro q);
	
	public Quadro procura(Long id);

	public void atualiza(Quadro q);
	
	public Quadro pesquisaQuadrosByNome(String nome);
	
	public List<Quadro> procuraByNomeCategoria(String nome, Long categoria);
	
	public List<Quadro> procuraByCategoria(Long categoria);
	
	public List<Quadro> procuraUltimosQuadros();
	
	public Quadro procuraById(Long codigo);
	
	public List<Quadro> procuraQuadrosByCodigoArtista(Long codigo);	
}