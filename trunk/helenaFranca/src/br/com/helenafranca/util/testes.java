package br.com.helenafranca.util;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.helenafranca.model.entity.Quadro;
import br.com.helenafranca.view.QuadroMB;
import br.com.helenafranca.controller.*;

public class testes {
	
	public static void main(String[] args) 
	{
		List<Quadro> lista = new ArrayList();
		QuadroFacade quadroService = new QuadroFacadeImpl();
		lista = quadroService.procuraByNomeCategoria("a", (long) 1);
		
		int tamanho = lista.size();
		
		for(int i=0;i<tamanho;i++)
		{
			System.out.println(lista.get(i).getNome());
			System.out.println("");			
		}
	}
}

