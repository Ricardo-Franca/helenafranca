package br.com.helenafranca.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.helenafranca.model.dao.TipoUsuarioDAO;
import br.com.helenafranca.model.entity.TipoUsuario;

public class TipoUsuarioFacadeImpl implements TipoUsuarioFacade {
	
	private static final long serialVersionUID = 8474545329502315667L;
	
	private TipoUsuarioDAO tipoUsuarioDAO;
	private SessionFactory sf; 
	private	Session session;
	private Transaction tx;
	
	public void salva(TipoUsuario u) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		tipoUsuarioDAO = new TipoUsuarioDAO(session, TipoUsuario.class);
		
		this.tipoUsuarioDAO.save(u);
		
		tx.commit();
		session.close();
		sf.close();
	}

	public void remove(TipoUsuario t) {
		// TODO Auto-generated method stub
		
	}

	public TipoUsuario procura(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void atualiza(TipoUsuario t) {
		// TODO Auto-generated method stub
		
	}

	public List<TipoUsuario> lista() {
		// TODO Auto-generated method stub
		return null;
	}
	
}