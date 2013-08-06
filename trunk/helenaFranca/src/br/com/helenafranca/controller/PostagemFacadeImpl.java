package br.com.helenafranca.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.helenafranca.model.dao.PostagemDAO;
import br.com.helenafranca.model.dao.QuadroDAO;
import br.com.helenafranca.model.entity.Postagem;
import br.com.helenafranca.model.entity.Quadro;

public class PostagemFacadeImpl implements PostagemFacade {

	private static final long serialVersionUID = -3674992325248842220L;
	
	private PostagemDAO postagemDAO;
	private SessionFactory sf; 
	private	Session session;
	private Transaction tx;
	
	public void salva(Postagem p) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		postagemDAO = new PostagemDAO(session, Postagem.class);
		
		this.postagemDAO.save(p);
				
		tx.commit();
		session.close();
		sf.close();
	}
	
	public void remove(Postagem p) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		postagemDAO = new PostagemDAO(session, Postagem.class);		
		
		this.postagemDAO.delete(p);
		
		session.flush();
		tx.commit();
		session.close();
		sf.close();
	}
	
	public Postagem procura(Long id) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		postagemDAO = new PostagemDAO(session, Postagem.class);
				
		Postagem p = this.postagemDAO.load(id);
		
		tx.commit();
		session.close();
		sf.close();
		
		return p;
	}

	public void atualiza(Postagem p) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		postagemDAO = new PostagemDAO(session, Postagem.class);
		
		this.postagemDAO.update(p);
		
		tx.commit();
		session.close();
		sf.close();
	}
	

	public List<Postagem> lista() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		postagemDAO = new PostagemDAO(session, Postagem.class);
				
		List<Postagem> lista = this.postagemDAO.list();
		
		tx.commit();
		session.close();
		sf.close();
		
		return lista;
	}
	
	public List<Postagem> procuraUltimasPostagens() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		postagemDAO = new PostagemDAO(session, Postagem.class);
		
		List<Postagem> lista = this.postagemDAO.procuraUltimasPostagens();
		tx.commit();
		session.close();
		sf.close();
		
		return lista;
	}
	
	public List<Postagem> procuraPostagensByData(String dataInicial, String dataFinal) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		postagemDAO = new PostagemDAO(session, Postagem.class);
		
		List<Postagem> lista = this.postagemDAO.procuraPostagensByData(dataInicial,dataFinal);
		tx.commit();
		session.close();
		sf.close();
		
		return lista;
	}
	
	public Postagem procuraById(Long id){
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		postagemDAO = new PostagemDAO(session, Postagem.class);
				
		Postagem p = this.postagemDAO.pesquisaPostagemById(id);
		
		tx.commit();
		session.close();
		sf.close();
		
		return p;
	}
}