package br.com.helenafranca.model.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.helenafranca.model.entity.Postagem;
import br.com.helenafranca.model.entity.Quadro;

public class PostagemDAO extends DAO<Postagem> {

	private Logger logger = Logger.getLogger(PostagemDAO.class);

	public PostagemDAO(Session session, Class<?> classe) {
		super(session, classe);
	}

	public List<Postagem> procuraUltimasPostagens() 
	{
		
		Query query = session
		.createQuery(" select p from Postagem p" +
				" order by codigo desc ");
		return query.list();
	}
		
	public List<Postagem> procuraPostagensByData(String dataInicial, String dataFinal) 
	{
		
		Query query = session
		.createQuery(" select p from Postagem p" +
				" where data >= "+dataInicial+" and data <= " +dataFinal+ "" +
						" order by data desc ");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public Postagem pesquisaPostagemById(Long codigo) {		
		Criteria c = session.createCriteria(Postagem.class);
		c.add(Restrictions.idEq(codigo));
		
		return (Postagem) c.uniqueResult();
	}
	
}