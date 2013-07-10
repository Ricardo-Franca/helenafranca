package br.com.helenafranca.util;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.helenafranca.model.entity.Artista;
import br.com.helenafranca.model.entity.Quadro;
import br.com.helenafranca.model.entity.Usuario;
import br.com.helenafranca.view.QuadroMB;
import br.com.helenafranca.controller.*;

public class testes {
	
	public static void main(String[] args) 
	{
		Artista artista = new Artista();
		ArtistaFacade artistaService = new ArtistaFacadeImpl();
		
		artista = artistaService.procuraByUsuarioId(1L);
		
		/*int tamanho = lista.size();
		
		for(int i=0;i<tamanho;i++)
		{*/
			System.out.println(artista.getUsuario().getLogin());
			System.out.println(artista.getUsuario().getSenha());			
		//}
	}
}

