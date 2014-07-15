package br.com.projeto.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.projeto.modelo.Mes;
import br.com.projeto.modelo.Produto;
import br.com.projeto.modelo.Recebimento;
import br.com.projeto.persistence.HibernateUtil;

@ManagedBean(name="recebimentoMBean")
public class RecebimentoMBean {

	private Produto produto;
	private int quantidade;
	private Mes mes;
	
	private List<Produto> produtos;
	
	public RecebimentoMBean() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    System.out.println("Inicializado session factory"); 
		Session session = sessionFactory.openSession();
		System.out.println("sessao aberta");
	    session.beginTransaction();  
	    
		Query query = session.createQuery("from Produto");

		this.produtos = query.list();
		for (Produto produto : produtos) {
			System.out.println(produto.getNome());
		}
		
		session.getTransaction().commit();
		session.close();
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
		Recebimento recebimento = new Recebimento();
		recebimento.setMes(mes);
		recebimento.setProduto(produto);
		recebimento.setQuantidade(quantidade);
		
		System.out.println("Cadastrar recebimento - Qtd: "+quantidade+"  Produto: "+produto.getId()+"  Mes: "+mes);
	}
	
	
}
