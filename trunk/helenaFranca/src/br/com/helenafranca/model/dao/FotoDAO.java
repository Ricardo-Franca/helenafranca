package br.com.helenafranca.model.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.helenafranca.model.entity.Biografia;
import br.com.helenafranca.model.entity.Foto;

public class FotoDAO extends DAO<Foto> {

	private Logger logger = Logger.getLogger(FotoDAO.class);

	public FotoDAO(Session session, Class<?> classe) {
		super(session, classe);
	}
	
	@SuppressWarnings("unchecked")
	public Foto pesquisaFotoByCodigo(Long codigo) {		
		Criteria c = session.createCriteria(Foto.class);
		c.add(Restrictions.idEq(codigo));
		
		return (Foto) c.uniqueResult();
	}
}