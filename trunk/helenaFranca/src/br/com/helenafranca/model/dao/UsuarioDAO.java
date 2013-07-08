package br.com.helenafranca.model.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.com.helenafranca.model.entity.Usuario;

public class UsuarioDAO extends DAO<Usuario> {

	private Logger logger = Logger.getLogger(UsuarioDAO.class);

	public UsuarioDAO(Session session, Class<?> classe) {
		super(session, classe);
	}

	public Usuario pesquisaUsuarioById(Long idUsuario) {
		logger.info("pesquisaUsuarioById : " + idUsuario);
		return (Usuario) session.load(Usuario.class, idUsuario);
	}

	public Usuario pesquisaUsuarioByLogin(String login) {
		
		Query query = session
		.createQuery(" select u from Usuario u " +
				" where u.login = '"+login+"' ");

		return (Usuario) query.uniqueResult();
		
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> pesquisaUsuarios(String login) {
		Criteria c = session.createCriteria(Usuario.class);
		c.add(Restrictions.ilike("login", "%" + login + "%"));
		c.addOrder(Order.asc("login"));

		return c.list();
	}

	public boolean verificaLoginSenha(String login, String senha, Integer tipo, Integer status) {
		boolean valid = false;

		System.out.println("DAO metodo isValidLoginAndPassword...");
		System.out.println("DAO session.isOpen() >>> " + session.isOpen());

		Query query = session
		.createQuery(" from Usuario u where u.login = :em and u.senha = :sen and u.tipoUsuario = :co and u.status = :st ");
		query.setString("em", login);
		query.setString("sen", senha);
		query.setInteger("co", tipo);
		query.setInteger("st", status);

		Usuario usuario = (Usuario) query.uniqueResult();

		if (usuario != null) {
			valid = true;
		}

		System.out.println("DAO Usuario >>> " + usuario);

		return valid;
	}
}