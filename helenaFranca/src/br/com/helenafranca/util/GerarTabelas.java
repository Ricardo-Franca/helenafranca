package br.com.helenafranca.util;

import java.io.IOException;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.transaction.Transaction;

import org.apache.catalina.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.helenafranca.controller.QuadroFacade;
import br.com.helenafranca.controller.QuadroFacadeImpl;
import br.com.helenafranca.model.dao.DAO;
import br.com.helenafranca.model.entity.Quadro;
import br.com.helenafranca.model.entity.Categoria;
import br.com.helenafranca.view.QuadroMB;
import br.com.helenafranca.view.CategoriaMB;


public class GerarTabelas {
	
	public static void main(String[] args) throws IOException {
		
	
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();

		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
		
		/*		
		Categoria categoria = new Categoria();
		categoria.setCodigo(1);
		categoria.setDescricao("Abstrato");
		CategoriaMB categoriaMB = new CategoriaMB();
		categoriaMB.setCategoria(categoria);
		categoriaMB.save();		
		
		categoria.setCodigo(2);
		categoria.setDescricao("Animais");
		categoriaMB.setCategoria(categoria);
		categoriaMB.save();
		
		categoria.setCodigo(3);
		categoria.setDescricao("Florais");
		categoriaMB.setCategoria(categoria);
		categoriaMB.save();
		
		categoria.setCodigo(4);
		categoria.setDescricao("Paisagens");
		categoriaMB.setCategoria(categoria);
		categoriaMB.save();
		
		categoria.setCodigo(5);
		categoria.setDescricao("Pessoas");
		categoriaMB.setCategoria(categoria);
		categoriaMB.save();
		
		categoria.setCodigo(6);
		categoria.setDescricao("Natureza Morta");
		categoriaMB.setCategoria(categoria);
		categoriaMB.save();			
		*/
	}
}