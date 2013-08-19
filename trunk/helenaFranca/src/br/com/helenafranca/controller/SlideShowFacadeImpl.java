package br.com.helenafranca.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.helenafranca.model.dao.SlideShowDAO;
import br.com.helenafranca.model.entity.SlideShow;

public class SlideShowFacadeImpl implements SlideShowFacade {

	private static final long serialVersionUID = -3674992325248842220L;
	
	private SlideShowDAO slideShowDAO;
	private SessionFactory sf; 
	private	Session session;
	private Transaction tx;
	
	public void salva(SlideShow s) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		slideShowDAO = new SlideShowDAO(session, SlideShow.class);
		
		this.slideShowDAO.save(s);
				
		tx.commit();
		session.close();
		sf.close();
	}

	public void atualiza(SlideShow s) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		slideShowDAO = new SlideShowDAO(session, SlideShow.class);
		
		this.slideShowDAO.update(s);
		
		tx.commit();
		session.close();
		sf.close();
	}

	public SlideShow procura(Long id) {
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		slideShowDAO = new SlideShowDAO(session, SlideShow.class);
				
		SlideShow s = this.slideShowDAO.load(id);
		
		tx.commit();
		session.close();
		sf.close();
		
		return s;
	}
	
	public SlideShow procuraById(Long id){
		sf = new AnnotationConfiguration().configure().buildSessionFactory(); 
		session = sf.openSession();
		tx = session.beginTransaction();
		slideShowDAO = new SlideShowDAO(session, SlideShow.class);
				
		SlideShow s = this.slideShowDAO.pesquisaSlideShowById(id);
		
		tx.commit();
		session.close();
		sf.close();
		
		return s;
	}

	@Override
	public void remove(SlideShow t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SlideShow> lista() {
		// TODO Auto-generated method stub
		return null;
	}
}