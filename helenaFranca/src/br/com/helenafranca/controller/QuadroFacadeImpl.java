package br.com.helenafranca.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.helenafranca.model.dao.QuadroDAO;
import br.com.helenafranca.model.entity.Quadro;

public class QuadroFacadeImpl implements QuadroFacade {

	private static final long serialVersionUID = -3674992325248842220L;
	
	private QuadroDAO quadroDAO;
	private SessionFactory sf; 
	private	Session session;
	private Transaction tx;
	
	public void salva(Quadro q) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		quadroDAO = new QuadroDAO(session, Quadro.class);
		
		this.quadroDAO.save(q);
				
		tx.commit();
		session.close();
		sf.close();
	}

	public void atualiza(Quadro q) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		quadroDAO = new QuadroDAO(session, Quadro.class);
		
		this.quadroDAO.update(q);
		
		tx.commit();
		session.close();
		sf.close();
	}

	public Quadro procura(Long id) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		quadroDAO = new QuadroDAO(session, Quadro.class);
				
		Quadro q = this.quadroDAO.load(id);
		
		tx.commit();
		session.close();
		sf.close();
		
		return q;
	}

	public void remove(Quadro q) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		quadroDAO = new QuadroDAO(session, Quadro.class);		
		
		this.quadroDAO.delete(q);
		
		tx.commit();
		session.close();
		sf.close();
	}

	public List<Quadro> lista() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		quadroDAO = new QuadroDAO(session, Quadro.class);
				
		List<Quadro> lista = this.quadroDAO.list();
		
		tx.commit();
		session.close();
		sf.close();
		
		return lista;
	}
	
	public Quadro pesquisaQuadrosByNome(String nome) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		quadroDAO = new QuadroDAO(session, Quadro.class);
		
		Quadro lista = this.quadroDAO.pesquisaQuadros(nome);
		tx.commit();
		session.close();
		sf.close();
		
		return lista;
	}
	
	public Quadro procuraById(Long id){
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		quadroDAO = new QuadroDAO(session, Quadro.class);
				
		Quadro q = this.quadroDAO.pesquisaQuadroById(id);
		
		tx.commit();
		session.close();
		sf.close();
		
		return q;
	}
}