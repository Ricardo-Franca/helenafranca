package br.com.helenafranca.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.helenafranca.model.dao.ArtistaDAO;
import br.com.helenafranca.model.entity.Artista;

public class ArtistaFacadeImpl implements ArtistaFacade {

	private static final long serialVersionUID = -3674992325248842220L;
	
	private ArtistaDAO artistaDAO;
	private SessionFactory sf; 
	private	Session session;
	private Transaction tx;
	
	public void salva(Artista a) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		artistaDAO = new ArtistaDAO(session, Artista.class);
		session.flush();
		this.artistaDAO.save(a);
		
		
		tx.commit();
		session.close();
		sf.close();
	}

	public void atualiza(Artista a) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		artistaDAO = new ArtistaDAO(session, Artista.class);
		
		this.artistaDAO.update(a);
		
		tx.commit();
		session.close();
	}

	public Artista procura(Long id) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		artistaDAO = new ArtistaDAO(session, Artista.class);
				
		Artista a = this.artistaDAO.load(id);
		
		tx.commit();
		session.close();
		
		return a;
	}

	public void remove(Artista a) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		artistaDAO = new ArtistaDAO(session, Artista.class);		
		
		this.artistaDAO.delete(a);
		
		tx.commit();
		session.close();
	}

	public List<Artista> lista() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		artistaDAO = new ArtistaDAO(session, Artista.class);
				
		List<Artista> lista = this.artistaDAO.list();
		
		tx.commit();
		session.close();
		
		return lista;
	}
	
	public List<Artista> pesquisaArtistasByNome(String nome) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		artistaDAO = new ArtistaDAO(session, Artista.class);
		
		List<Artista> lista = this.artistaDAO.pesquisaArtistas(nome);
		tx.commit();
		session.close();
		
		return lista;
	}
	
	public Artista procuraById(Long id){
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		artistaDAO = new ArtistaDAO(session, Artista.class);
				
		Artista a = this.artistaDAO.pesquisaArtistaById(id);
		
		tx.commit();
		session.close();
		
		return a;
	}
	
	public Artista procuraByCodigo(Long id){
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		artistaDAO = new ArtistaDAO(session, Artista.class);
				
		Artista a = this.artistaDAO.pesquisaArtistaByCodigo(id);
		
		tx.commit();
		session.close();
		
		return a;
	}

	public Artista procuraByUsuarioId(Long id) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		artistaDAO = new ArtistaDAO(session, Artista.class);
				
		Artista a = this.artistaDAO.pesquisaArtistaByUsuarioId(id);
		
		tx.commit();
		session.close();
		
		return a;
	}
	
	public Artista procuraByEmail(String email){
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		artistaDAO = new ArtistaDAO(session, Artista.class);

		Artista a = this.artistaDAO.pesquisaArtistaByEmail(email);
		
		tx.commit();
		session.close();
		
		return a; 
	}
}