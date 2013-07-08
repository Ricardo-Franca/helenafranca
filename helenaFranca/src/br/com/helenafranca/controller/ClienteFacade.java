package br.com.helenafranca.controller;

import java.util.List;

import br.com.helenafranca.model.entity.Cliente;

public interface ClienteFacade extends BaseFacade<Cliente>{
	public void salva(Cliente c);

	public void remove(Cliente c);
	
	public Cliente procura(Long id);

	public void atualiza(Cliente c);
	
	public Cliente pesquisaClientesByNome(String nome);
	
	public Cliente procuraById(Long codigo);
	
	public Cliente procuraByEmail(String email);
	
	public Cliente procuraByCpf(String cpf);
	
	public Cliente procuraByUsuarioId(Long codigo);
	
	public void inativaCliente(Long codigo);
	
	public List<Cliente> pesquisaClientesAtivos();
}