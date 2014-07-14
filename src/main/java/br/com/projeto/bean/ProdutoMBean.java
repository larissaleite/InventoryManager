package br.com.projeto.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import br.com.projeto.modelo.Produto;

@ManagedBean(name="produtoMBean")
public class ProdutoMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private int preco;
	
	/*
	 * Não funciona para acessar os campos da classe Produto de dentro do xhtml
	 * 
	private Produto produto;

	public ProdutoMBean() {
		produto = new Produto();
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	*/
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public void cadastrarProduto() {
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(preco);
		System.out.println("Cadastrar Produto - "+produto.getNome()+"   "+produto.getPreco());
	}
	
}
