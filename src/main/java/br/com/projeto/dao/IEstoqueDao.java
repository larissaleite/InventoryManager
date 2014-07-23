package br.com.projeto.dao;

import java.util.List;

import br.com.projeto.modelo.Estoque;
import br.com.projeto.modelo.Mes;

public interface IEstoqueDao {
	
	public List<Estoque> recuperarEstoque();
	public List<Estoque> recuperarEstoqueDoMes(Mes mes);
	public List<Integer> lucroAnual();

}
