package br.com.prog2.hf.persistencia;

import java.util.List;

import br.com.prog2.hf.model.Cliente;

public interface ClienteDAO {
	public String inserir(Cliente cli);
	public String alterar(Cliente cli);
	public String excluir(Cliente cli);

	public List<Cliente> listarTodos();
	public Cliente pesquisarPorCod(String cod_cli);
}
