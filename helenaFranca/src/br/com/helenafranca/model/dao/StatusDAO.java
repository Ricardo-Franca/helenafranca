package br.com.helenafranca.model.dao;

import org.hibernate.Session;

import br.com.helenafranca.model.entity.Status;

public class StatusDAO extends DAO<Status> {

	public StatusDAO(Session session, Class<?> classe) {
		super(session, classe);
	}
}