package br.com.projeto.modelo;

import java.util.List;

public class Estoque {
	
	private Mes mes;
	private  List<Recebimento> recebimentos;
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
	}
	
	public Mes getMes() {
		return mes;
	}
	
	public void setMes(Mes mes) {
		this.mes = mes;
	}
	
}
