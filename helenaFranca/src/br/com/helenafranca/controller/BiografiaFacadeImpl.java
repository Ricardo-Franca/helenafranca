package br.com.helenafranca.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.helenafranca.model.dao.BiografiaDAO;
import br.com.helenafranca.model.entity.Biografia;

public class BiografiaFacadeImpl implements BiografiaFacade {

	private static final long serialVersionUID = -3674992325248842220L;
	
	private BiografiaDAO biografiaDAO;
	private SessionFactory sf; 
	private	Session session;
	private Transaction tx;

	public void atualiza(Biografia b) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		biografiaDAO = new BiografiaDAO(session, Biografia.class);
		
		this.biografiaDAO.update(b);
		
		tx.commit();
		session.close();
		sf.close();
	}

	public Biografia procura(Long id) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		biografiaDAO = new BiografiaDAO(session, Biografia.class);
				
		Biografia b = this.biografiaDAO.pesquisaBiografiaByCodigo(id);
		
		tx.commit();
		session.close();
		sf.close();
		
		return b;
	}

	@Override
	public void salva(Biografia t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Biografia t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Biografia> lista() {
		// TODO Auto-generated method stub
		return null;
	}	
}