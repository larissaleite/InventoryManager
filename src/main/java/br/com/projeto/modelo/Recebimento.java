package br.com.projeto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Recebimento {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id_recebimento", unique=true, nullable=false)
	private int id;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	private int quantidade;
	private Mes mes;
	
	public Recebimento() { }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
}
