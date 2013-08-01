package br.com.helenafranca.model.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.helenafranca.model.entity.Artista;
import br.com.helenafranca.model.entity.Biografia;

public class BiografiaDAO extends DAO<Biografia> {

	private Logger logger = Logger.getLogger(BiografiaDAO.class);

	public BiografiaDAO(Session session, Class<?> classe) {
		super(session, classe);
	}
	
	@SuppressWarnings("unchecked")
	public Biografia pesquisaBiografiaByCodigo(Long codigo) {		
		Criteria c = session.createCriteria(Biografia.class);
		c.add(Restrictions.idEq(codigo));
		
		return (Biografia) c.uniqueResult();
	}
}