package br.com.projeto.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.projeto.modelo.Produto;

public interface IProdutoDao {
	public void salvarProduto(Produto produto);
	public List<Produto> produtosSalvos();
}
