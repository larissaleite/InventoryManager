package br.com.projeto.modelo;

public class Estoque {
	
	private Mes mes;
	private String nome;
	private int preco;
	private int recebimento_quantidade;
	private int venda_quantidade;
	private int lucro;
	private int estoque_quantidade;
	
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

	public int getRecebimento_quantidade() {
		return recebimento_quantidade;
	}

	public void setRecebimento_quantidade(int recebimento_quantidade) {
		this.recebimento_quantidade = recebimento_quantidade;
	}

	public int getVenda_quantidade() {
		return venda_quantidade;
	}

	public void setVenda_quantidade(int venda_quantidade) {
		this.venda_quantidade = venda_quantidade;
	}

	public Mes getMes() {
		return mes;
	}
	
	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public int getLucro() {
		return lucro;
	}

	public void setLucro(int lucro) {
		this.lucro = lucro;
	}

	public int getEstoque_quantidade() {
		return estoque_quantidade;
	}

	public void setEstoque_quantidade(int estoque_quantidade) {
		this.estoque_quantidade = estoque_quantidade;
	}
	
	/*private List<Recebimento> recebimentos;
	private List<Venda> vendas;
		
	public List<Venda> getVendas() {
		return vendas;
	}
	
	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
	public List<Recebimento> getRecebimentos() {
		return recebimentos;
	}
	
	public void setRecebimentos(List<Recebimento> recebimentos) {
		this.recebimentos = recebimentos;
	}*/
	
}
