package br.com.helenafranca.model.dao;

import org.hibernate.Session;

import br.com.helenafranca.model.entity.Categoria;

public class CategoriaDAO extends DAO<Categoria> {

	public CategoriaDAO(Session session, Class<?> classe) {
		super(session, classe);
	}
}