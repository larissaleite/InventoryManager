package br.com.projeto.dao;

import java.util.List;

import br.com.projeto.modelo.Estoque;
import br.com.projeto.modelo.Mes;
import br.com.projeto.modelo.Produto;

public interface IEstoqueDao {
	
	public List<Estoque> recuperarEstoque();
	public List<Estoque> recuperarEstoqueDoMes(Mes mes);
	public List<Integer> lucroAnual();
	public int estoqueProdutoMes (Produto produto, Mes mes);

}
