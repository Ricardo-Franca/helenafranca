package br.com.helenafranca.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.helenafranca.model.dao.StatusDAO;
import br.com.helenafranca.model.entity.Status;

public class StatusFacadeImpl implements StatusFacade {

	private static final long serialVersionUID = 1471852322170590757L;
	
	private StatusDAO statusDAO;
	private SessionFactory sf; 
	private	Session session;
	private Transaction tx;
	
	public void salva(Status s) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		statusDAO = new StatusDAO(session, Status.class);
		
		this.statusDAO.save(s);
		this.session.flush();
		tx.commit();
		session.close();
		sf.close();
	}

	public void remove(Status t) {
		// TODO Auto-generated method stub
		
	}

	public Status procura(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void atualiza(Status t) {
		// TODO Auto-generated method stub
		
	}

	public List<Status> lista() {
		// TODO Auto-generated method stub
		return null;
	}
	
}