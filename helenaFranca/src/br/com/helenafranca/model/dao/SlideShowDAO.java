package br.com.helenafranca.model.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.helenafranca.model.entity.SlideShow;

public class SlideShowDAO extends DAO<SlideShow> {

	private Logger logger = Logger.getLogger(SlideShowDAO.class);

	public SlideShowDAO(Session session, Class<?> classe) {
		super(session, classe);
	}
		
	@SuppressWarnings("unchecked")
	public SlideShow pesquisaSlideShowById(Long codigo) {		
		Criteria c = session.createCriteria(SlideShow.class);
		c.add(Restrictions.idEq(codigo));
		
		return (SlideShow) c.uniqueResult();
	}	
}