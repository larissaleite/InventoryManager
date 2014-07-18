package br.com.projeto.bean;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.projeto.dao.IProdutoDao;
import br.com.projeto.modelo.Produto;

//@ManagedBean(name="produtoMBean")
@Controller
public class ProdutoMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IProdutoDao produtoDao;
	
	private String nome;
	private int preco;
	
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
		
		//produtoDao = new ProdutoDao();
		produtoDao.salvarProduto(produto);
		
	}
	
}
