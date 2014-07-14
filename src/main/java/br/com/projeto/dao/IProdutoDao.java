package br.com.projeto.dao;

import java.util.List;

import br.com.projeto.modelo.Produto;

public interface IProdutoDao {
	public void salvarProduto(Produto produto);
	public List<Produto> produtosSalvos();
}
