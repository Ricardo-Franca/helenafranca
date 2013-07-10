package br.com.helenafranca.model.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.helenafranca.model.entity.Artista;

public class ArtistaDAO extends DAO<Artista> {

	private Logger logger = Logger.getLogger(ArtistaDAO.class);

	public ArtistaDAO(Session session, Class<?> classe) {
		super(session, classe);
	}

	public Artista pesquisaArtistaById(Long idArtista) {
	   logger.info("pesquisaArtistaById : " + idArtista);
	   return (Artista) session.load(Artista.class, idArtista);
	}
	
	@SuppressWarnings("unchecked")
	public Artista pesquisaArtistaByCodigo(Long codigo) {		
		Criteria c = session.createCriteria(Artista.class);
		c.add(Restrictions.idEq(codigo));
		
		return (Artista) c.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Artista> pesquisaArtistas(String nome) {
		Criteria c = session.createCriteria(Artista.class);
		c.add(Restrictions.ilike("nome", "%" + nome + "%"));
		c.addOrder(Order.asc("nome"));

		return c.list();
	}
	public Artista pesquisaArtistaByUsuarioId(Long codigo) {

		System.out.println("DAO metodo pesquisaArtistaByUsuarioId...");
		System.out.println("DAO session.isOpen() >>> " + session.isOpen());

		Query query = session
		.createQuery(" select a from Artista a " +
				" left join fetch a.usuario " +
				" where a.usuario.cod_usuario = "+codigo+" ");

		return (Artista) query.uniqueResult();
	}
	
	public void inativaArtista(Long codigo)
	{
		Query query = session
		.createQuery(" update Usuario u " +
				" set status = 2 " +
				" where cod_usuario = "+codigo+"");
		
		query.executeUpdate();
	}
	/*
	public List<Artista> pesquisaArtistasAtivos() 
	{
		
		Query query = session
		.createQuery(" select e from Empresa e" +
				" where e.usuario.status = 1 ");

		return query.list();
	}*/
	
	
	public Artista pesquisaArtistaByEmail(String email) {
		Query query = session
		.createQuery(" select a from Artista a " +
				" where a.email = '"+email+"' ");

		return (Artista) query.uniqueResult();
	}
}