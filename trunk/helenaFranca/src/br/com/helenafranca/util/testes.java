package br.com.helenafranca.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.helenafranca.model.entity.Artista;
import br.com.helenafranca.model.entity.Postagem;
import br.com.helenafranca.model.entity.Quadro;
import br.com.helenafranca.model.entity.SlideShow;
import br.com.helenafranca.controller.*;

public class testes {
	
	public static void main(String[] args) 
	{
		//PostagemFacade postagemService = new PostagemFacadeImpl();
	
		//postagemService.remove(postagemService.procura(1L));
		/*
		Postagem postagem = new Postagem();
		
		postagem = postagemService.procuraById(1L);
		
		Artista artista = new Artista();
		artista.setCodigo(2L);
		ArtistaFacade artistaService = new ArtistaFacadeImpl();
		artistaService.salva(artista);
		
		//postagemService.remove(postagem);
			*/
		//Calendar calendar = new GregorianCalendar();
		//String data = ""+calendar.get(Calendar.DAY_OF_MONTH)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+(calendar.get(Calendar.YEAR));
						
		//System.out.println(data);
		
		/*
		Date date = new Date(); 
		SimpleDateFormat formataHora = new SimpleDateFormat("HH:mm"); // 12:00:00
		SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd"); //2014-01-01
		
		String hora = formataHora.format(date);
		String data = formataData.format(date);
		
		System.out.println(data);
		System.out.println(hora);
		*/
		
		SlideShow slideShow = new SlideShow();
		SlideShowFacade slideShowService = new SlideShowFacadeImpl();	
		slideShow = slideShowService.procuraById(1L);
				
		System.out.println("Codigo"+slideShow.getArtista().getNome());
		
		
	
	}
}

