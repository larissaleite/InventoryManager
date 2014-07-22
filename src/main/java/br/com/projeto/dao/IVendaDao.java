package br.com.projeto.dao;

import java.util.List;

import br.com.projeto.modelo.Venda;

public interface IVendaDao {
	public void salvarVenda(Venda venda);
	public List<Integer> recuperarQuantVendas();

}
