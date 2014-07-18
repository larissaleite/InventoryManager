package br.com.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.dao.IEstoqueDao;
import br.com.projeto.dao.IProdutoDao;
import br.com.projeto.dao.IRecebimentoDao;
import br.com.projeto.dao.IVendaDao;
import br.com.projeto.modelo.Estoque;
import br.com.projeto.modelo.Produto;
import br.com.projeto.modelo.Recebimento;
import br.com.projeto.modelo.Venda;

@Service("serviceEstoque")
public class ServiceEstoque implements IServiceEstoque {
	
	@Autowired
	private IProdutoDao daoProduto;
	
	@Autowired
	private IRecebimentoDao daoRecebimento;
	
	@Autowired
	private IVendaDao daoVenda;
	
	@Autowired
	private IEstoqueDao daoEstoque;
	
	public ServiceEstoque() {
	}

	public void cadastrarProduto(Produto produto) {
		daoProduto.salvarProduto(produto);
	}

	public void cadastrarRecebimento(Recebimento recebimento) {
		daoRecebimento.salvarRecebimento(recebimento);
	}

	public void cadastrarVenda(Venda venda) {
		daoVenda.salvarVenda(venda);
	}

	public List<Produto> produtosCadastrados() {
		return daoProduto.produtosSalvos();
	}

	public List<Estoque> recuperarEstoque() {
		return daoEstoque.recuperarEstoque();
	}

}
