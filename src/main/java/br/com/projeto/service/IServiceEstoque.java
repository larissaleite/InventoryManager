package br.com.projeto.service;

import java.util.List;

import br.com.projeto.modelo.Estoque;
import br.com.projeto.modelo.Mes;
import br.com.projeto.modelo.Produto;
import br.com.projeto.modelo.Recebimento;
import br.com.projeto.modelo.Venda;

public interface IServiceEstoque {
	
	public void cadastrarProduto(Produto produto);
	public void cadastrarRecebimento(Recebimento recebimento);
	public void cadastrarVenda(Venda venda);
	
	public List<Produto> produtosCadastrados();
	public List<Estoque> recuperarEstoque();
	public List<Estoque> recuperarEstoqueNoMes(Mes mes);
	public List<Integer> recuperarQuantVendas();
	public List<Integer> lucroAnual();
	
}
