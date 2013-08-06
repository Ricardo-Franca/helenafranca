package br.com.helenafranca.util;

import br.com.helenafranca.model.entity.Artista;
import br.com.helenafranca.model.entity.Postagem;
import br.com.helenafranca.model.entity.Quadro;
import br.com.helenafranca.controller.*;

public class testes {
	
	public static void main(String[] args) 
	{
		PostagemFacade postagemService = new PostagemFacadeImpl();
	
		//postagemService.remove(postagemService.procura(1L));
		
		Postagem postagem = new Postagem();
		
		postagem = postagemService.procuraById(1L);
		
		Artista artista = new Artista();
		artista.setCodigo(2L);
		ArtistaFacade artistaService = new ArtistaFacadeImpl();
		artistaService.salva(artista);
		
		//postagemService.remove(postagem);
			
	
	}
}

