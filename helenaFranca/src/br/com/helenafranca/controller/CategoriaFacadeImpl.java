package br.com.helenafranca.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.helenafranca.model.dao.CategoriaDAO;
import br.com.helenafranca.model.entity.Categoria;

public class CategoriaFacadeImpl implements CategoriaFacade {
	
	private static final long serialVersionUID = 8474545329502315667L;
	
	private CategoriaDAO categoriaDAO;
	private SessionFactory sf; 
	private	Session session;
	private Transaction tx;
	
	public void salva(Categoria c) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		categoriaDAO = new CategoriaDAO(session, Categoria.class);
		
		this.categoriaDAO.save(c);
		
		tx.commit();
		session.close();
	}

	public void remove(Categoria c) {
		// TODO Auto-generated method stub
		
	}

	public Categoria procura(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void atualiza(Categoria c) {
		// TODO Auto-generated method stub
		
	}

	public List<Categoria> lista() {
		// TODO Auto-generated method stub
		return null;
	}
	
}