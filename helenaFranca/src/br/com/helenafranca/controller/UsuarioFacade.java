package br.com.helenafranca.controller;

import java.util.List;

import br.com.helenafranca.model.entity.Usuario;

public interface UsuarioFacade extends BaseFacade<Usuario>{
	public void salva(Usuario u);

	public void remove(Usuario u);
	
	public Usuario procura(String login);

	public void atualiza(Usuario u);
	
	public List<Usuario> pesquisaUsuariosByLogin(String login);
	
	public Usuario pesquisaUsuarioByLogin(String login);
	
	public boolean autentica(String login, String senha, Integer tipo, Integer status);
}