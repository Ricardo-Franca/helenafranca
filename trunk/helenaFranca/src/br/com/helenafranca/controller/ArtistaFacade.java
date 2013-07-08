package br.com.helenafranca.controller;

//import java.util.List;

import br.com.helenafranca.model.entity.Artista;

public interface ArtistaFacade extends BaseFacade<Artista>{
	public void salva(Artista a);

	public void remove(Artista a);
	
	public Artista procura(Long id);

	public void atualiza(Artista a);
	
	//public List<Artista> pesquisaArtistasByNome(String nome);
	
	public Artista procuraByUsuarioId(Long codigo);
	
	public Artista procuraByCodigo(Long codigo);
	
	public Artista procuraByEmail(String email);
	
	//public void inativaArtista(Long codigo);
}