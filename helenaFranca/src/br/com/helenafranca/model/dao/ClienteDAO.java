package br.com.helenafranca.model.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.helenafranca.model.entity.Cliente;

public class ClienteDAO extends DAO<Cliente> {

	private Logger logger = Logger.getLogger(ClienteDAO.class);

	public ClienteDAO(Session session, Class<?> classe) {
		super(session, classe);
	}

	public Cliente pesquisaClienteByCpf(String cpf) {
		Query query = session
		.createQuery(" select c from Cliente c " +
				" where c.cpf = '"+cpf+"' ");

		return (Cliente) query.uniqueResult();
	}
	
	public Cliente pesquisaClienteByEmail(String email) {
		Query query = session
		.createQuery(" select c from Cliente c " +
				" where c.email = '"+email+"' ");

		return (Cliente) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public Cliente pesquisaClienteById(Long codigo) {		
		Criteria c = session.createCriteria(Cliente.class);
		c.add(Restrictions.idEq(codigo));
		
		return (Cliente) c.uniqueResult();
	}
	
	public Cliente pesquisaClienteByUsuarioId(Long codigo) {

		System.out.println("DAO metodo pesquisaClienteByUsuarioId...");
		System.out.println("DAO session.isOpen() >>> " + session.isOpen());

		Query query = session
		.createQuery(" select c from Cliente c " +
				" left join fetch c.usuario " +
				" where c.usuario.cod_usuario = "+codigo+" ");

		return (Cliente) query.uniqueResult();
	}
	

	@SuppressWarnings("unchecked")
	public Cliente pesquisaClientes(String nome) {
		Criteria c = session.createCriteria(Cliente.class);
		c.add(Restrictions.ilike("nome", "%" + nome + "%"));
		

		return (Cliente) c.uniqueResult();
	}

	public void inativaCliente(Long codigo)
	{
		Query query = session
		.createQuery(" update Usuario u " +
				" set status = 2 " +
				" where cod_usuario = "+codigo+"");
		
		query.executeUpdate();
	}
	
	public List<Cliente> pesquisaClientesAtivos() 
	{
		
		Query query = session
		.createQuery(" select c from Cliente c" +
				" where c.usuario.status = 1 ");

		return query.list();
	}
}