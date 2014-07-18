package br.com.projeto.dao;

import java.util.List;

import br.com.projeto.modelo.Estoque;

public interface IEstoqueDao {
	
	public List<Estoque> recuperarEstoque();

}
