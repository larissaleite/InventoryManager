package br.com.projeto.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.dao.AbstractHibernateDao;
import br.com.projeto.dao.IProdutoDao;
import br.com.projeto.modelo.Produto;

@Repository
@Transactional /* colocar em cada método especificamente? */
public class ProdutoDao extends AbstractHibernateDao<Produto> implements IProdutoDao {

	public ProdutoDao() {
		super();
		super.setClasse(Produto.class);
		//sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public void salvarProduto(Produto produto) {
		/*Session session = sessionFactory.openSession();
		System.out.println("sessao aberta");
	    session.beginTransaction();  
	    
	    session.save(produto);
	    
	    session.getTransaction().commit();
	    session.close();
	    System.out.println("sessao fechada");*/
		super.save(produto);
		
	}

	public List<Produto> produtosSalvos() {
		List<Produto> produtos = super.findAll();
		return produtos;
	}
	
}
