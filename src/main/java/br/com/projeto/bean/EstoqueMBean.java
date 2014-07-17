package br.com.projeto.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.projeto.modelo.Estoque;
import br.com.projeto.persistence.HibernateUtil;

@ManagedBean(name="estoqueMBean")
public class EstoqueMBean {
	
	List<Estoque> estoques;

	public EstoqueMBean() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    System.out.println("Inicializado session factory"); 
		Session session = sessionFactory.openSession();
		System.out.println("sessao aberta");
	    session.beginTransaction();  
	    
	    System.out.println("---- Realizando consulta");
	    
	    System.out.println("---- Realizando consulta");
	    
		Query query2 = session.createSQLQuery(
		"SELECT "+
		" m.mes, "+
	    " p.nome, p.preco, "+ 
	    " COALESCE(r.recebimento_quantidade, 0) AS recebimento_quantidade, "+
	    " COALESCE(v.venda_quantidade, 0)    AS venda_quantidade "+
	    " FROM "+
	    " produto AS p "+
	  " CROSS JOIN "+
	    " ( VALUES (0), (1),(2),(3),(4),(5),(6), (7), (8), (9), (10), (11) ) AS m(mes) "+
	  " LEFT OUTER JOIN "+
	    " ( SELECT mes, produto_id, SUM(quantidade) AS recebimento_quantidade "+
	    " FROM recebimento "+
	    " GROUP BY mes, produto_id "+
	    " ) AS r "+
	    " ON  p.id_produto = r.produto_id "+
	    " AND m.mes = r.mes "+
	  " LEFT OUTER JOIN "+
	   " ( SELECT mes, produto_id, SUM(quantidade) AS venda_quantidade "+
	    "  FROM venda "+
	    "  GROUP BY mes, produto_id "+
	    " ) AS v "+
	    " ON  p.id_produto = v.produto_id "+
	    " AND m.mes = v.mes "+
	    " WHERE r.mes IS NOT NULL "+
	    " ORDER BY m.mes");
		
		query2.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		this.estoques = new ArrayList<Estoque>();
		
		List estoques = query2.list();
		for (Object object : estoques) {
			Map linha = (Map) object;
			System.out.println(" Nome: "+linha.get("nome"));
			Estoque estoque = new Estoque();
			estoque.setNome(linha.get("nome").toString());
			int preco = Integer.parseInt(linha.get("preco").toString());
			estoque.setPreco(preco);
			int recebimentos = Integer.parseInt(linha.get("recebimento_quantidade").toString());
			estoque.setRecebimento_quantidade(recebimentos);
			int vendas = Integer.parseInt(linha.get("venda_quantidade").toString());
			estoque.setVenda_quantidade(vendas);
			estoque.setLucro(preco*vendas);
			estoque.setEstoque_quantidade(recebimentos-vendas);
			System.out.println("Mes "+linha.get("mes").toString());
			this.estoques.add(estoque);
			//estoque.setMes(Mes.valueOf(linha.get("mes").toString()));
			
		}
			
		session.getTransaction().commit();
		session.close();
		
	}

	public List<Estoque> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

}
