package br.com.projeto.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.projeto.dao.AbstractHibernateDao;
import br.com.projeto.dao.IProdutoDao;
import br.com.projeto.modelo.Produto;
import br.com.projeto.persistence.HibernateUtil;

public class ProdutoDao implements IProdutoDao {

    private SessionFactory sessionFactory;
	
	public ProdutoDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public void salvarProduto(Produto produto) {
		Session session = sessionFactory.openSession();
		System.out.println("sessao aberta");
	    session.beginTransaction();  
	    
	    session.save(produto);
	    
	    session.getTransaction().commit();
	    session.close();
	    System.out.println("sessao fechada");
	}

	public List<Produto> produtosSalvos() {
		List<Produto> produtos = null;
		return produtos;
	}
	
}
