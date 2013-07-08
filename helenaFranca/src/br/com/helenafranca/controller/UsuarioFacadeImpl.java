package br.com.helenafranca.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.helenafranca.model.dao.UsuarioDAO;
import br.com.helenafranca.model.entity.Usuario;

public class UsuarioFacadeImpl implements UsuarioFacade {
	
	private static final long serialVersionUID = -4230977397949665286L;
	
	private UsuarioDAO usuarioDAO;
	private SessionFactory sf; 
	private	Session session;
	private Transaction tx;
	
	public void salva(Usuario u) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
		
		this.usuarioDAO.save(u);
		
		tx.commit();
		session.close();
		sf.close();
	}

	public void atualiza(Usuario u) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
		
		this.usuarioDAO.update(u);
		
		tx.commit();
		session.close();
		sf.close();
	}

	public Usuario procura(String login) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
				
		Usuario u = this.usuarioDAO.load(login);
		
		tx.commit();
		session.close();
		sf.close();
		
		return u;
	}
	
	public Usuario procura(Long id) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
				
		Usuario u = this.usuarioDAO.load(id);
		
		tx.commit();
		session.close();
		sf.close();
		
		return u;
	}

	public void remove(Usuario u) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
		
		this.usuarioDAO.delete(u);
		
		tx.commit();
		session.close();
		sf.close();
	}

	public List<Usuario> lista() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
				
		List<Usuario> lista = this.usuarioDAO.list();
		
		tx.commit();
		session.close();
		sf.close();
		
		return lista;
	}
	
	public List<Usuario> pesquisaUsuariosByLogin(String login) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
		
		List<Usuario> lista = this.usuarioDAO.pesquisaUsuarios(login);
		tx.commit();
		session.close();
		sf.close();
		
		return lista;
	}
	
	public Usuario pesquisaUsuarioByLogin(String login){
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
				
		Usuario u = this.usuarioDAO.pesquisaUsuarioByLogin(login);
		
		tx.commit();
		session.close();
		sf.close();
		
		return u;
	}
	
	public Usuario procuraById(Long id){
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);
				
		Usuario u = this.usuarioDAO.pesquisaUsuarioById(id);
		
		tx.commit();
		session.close();
		sf.close();
		
		return u;
	}
	
	public boolean autentica(String login, String senha,Integer tipo,Integer status){
		boolean autenticado; 
		
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		usuarioDAO = new UsuarioDAO(session, Usuario.class);

		autenticado = this.usuarioDAO.verificaLoginSenha(login, senha, tipo, status);
		
		tx.commit();
		session.close();
		sf.close();
		
		return autenticado; 
	}
}