package br.com.projeto.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

import br.com.projeto.modelo.Mes;
import br.com.projeto.modelo.Produto;
import br.com.projeto.modelo.Recebimento;
import br.com.projeto.service.IServiceEstoque;

/* @SessionScoped faz com que os valores de produtos não atualizem quando um novo produto é inserido no banco */
//@ManagedBean(name="recebimentoMBean")
@Controller
@Scope("request")
public class RecebimentoMBean {

	private Produto produto;
	private int quantidade;
	private Mes mes;
	
	private List<Produto> produtos;
	
	@Autowired
	private IServiceEstoque serviceEstoque;
	
	public RecebimentoMBean() {
		//this.produtos = serviceEstoque.produtosCadastrados();
	}
	
	@PostConstruct
	public void init() {
		this.produtos = serviceEstoque.produtosCadastrados();
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Mes getMes() {
		return mes;
	}
	
	public void setMes(Mes mes) {
		this.mes = mes;
	}
	
	public Mes[] getMeses() {
		return Mes.values();
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void cadastrarRecebimento() {
		System.out.println("Cadastrando recebimento");
		Recebimento recebimento = new Recebimento();
		recebimento.setMes(mes);
		recebimento.setProduto(produto);
		recebimento.setQuantidade(quantidade);
		
		System.out.println("Cadastrar recebimento - Qtd: "+quantidade+"  Produto: "+produto.getId()+"  Mes: "+mes);
		
		serviceEstoque.cadastrarRecebimento(recebimento);
		
	}
	
	
}
