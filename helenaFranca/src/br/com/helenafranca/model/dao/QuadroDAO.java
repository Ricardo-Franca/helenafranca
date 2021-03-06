package br.com.helenafranca.model.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.helenafranca.model.entity.Quadro;

public class QuadroDAO extends DAO<Quadro> {

	private Logger logger = Logger.getLogger(QuadroDAO.class);

	public QuadroDAO(Session session, Class<?> classe) {
		super(session, classe);
	}

		
	@SuppressWarnings("unchecked")
	public Quadro pesquisaQuadroById(Long codigo) {		
		Criteria c = session.createCriteria(Quadro.class);
		c.add(Restrictions.idEq(codigo));
		
		return (Quadro) c.uniqueResult();
	}
	

	@SuppressWarnings("unchecked")
	public Quadro pesquisaQuadros(String nome) {
		Criteria c = session.createCriteria(Quadro.class);
		c.add(Restrictions.ilike("nome", "%" + nome + "%"));		

		return (Quadro) c.uniqueResult();
	}
	
	public List<Quadro> procuraByNomeCategoria(String nome, Long categoria) 
	{
		
		Query query = session
		.createQuery(" select q from Quadro q" +
				" where codigoCategoria = "+categoria+" and nome like '%"+nome+"%'");
		return query.list();
	}
	
	public List<Quadro> procuraByCategoria(Long categoria) 
	{
		
		Query query = session
		.createQuery(" select q from Quadro q" +
				" where codigoCategoria = "+categoria+"");
		return query.list();
	}
	
	public List<Quadro> procuraUltimosQuadros() 
	{
		
		Query query = session
		.createQuery(" select q from Quadro q" +
				" order by codigo desc ");
		return query.list();
	}
		
	public List<Quadro> procuraQuadrosDoArtista(Long codigo) 
	{
		
		Query query = session
		.createQuery(" select q from Quadro q" +
				" where codigoArtista = "+codigo+"" +
						" order by codigo desc ");

		return query.list();
	}
	
}