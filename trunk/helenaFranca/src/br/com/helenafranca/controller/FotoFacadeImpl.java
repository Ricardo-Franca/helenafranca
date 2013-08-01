package br.com.helenafranca.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.helenafranca.model.dao.BiografiaDAO;
import br.com.helenafranca.model.dao.FotoDAO;
import br.com.helenafranca.model.dao.QuadroDAO;
import br.com.helenafranca.model.entity.Biografia;
import br.com.helenafranca.model.entity.Foto;
import br.com.helenafranca.model.entity.Quadro;

public class FotoFacadeImpl implements FotoFacade {

	private static final long serialVersionUID = -3674992325248842220L;
	
	private FotoDAO fotoDAO;
	private SessionFactory sf; 
	private	Session session;
	private Transaction tx;

	public void atualiza(Foto f) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		fotoDAO = new FotoDAO(session, Foto.class);
		
		this.fotoDAO.update(f);
		
		tx.commit();
		session.close();
		sf.close();
	}
	
	public Foto procura(Long id) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		fotoDAO = new FotoDAO(session, Foto.class);
				
		Foto f = this.fotoDAO.pesquisaFotoByCodigo(id);
		
		tx.commit();
		session.close();
		sf.close();
		
		return f;
	}

	@Override
	public void salva(Foto t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Foto t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Foto> lista() {
		// TODO Auto-generated method stub
		return null;
	}
}