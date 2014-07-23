package br.com.projeto.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.dao.AbstractHibernateDao;
import br.com.projeto.dao.IEstoqueDao;
import br.com.projeto.modelo.Estoque;
import br.com.projeto.modelo.Mes;

@Repository
@Transactional /* colocar em cada método especificamente? */
public class EstoqueDao extends AbstractHibernateDao<Estoque> implements IEstoqueDao {

	public EstoqueDao() {
		super();
		
		super.setClasse(Estoque.class);
	}
	
	public List<Estoque> recuperarEstoque() {
		
		List<Estoque> estoque = new ArrayList<Estoque>();
		
		String query =
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
			    " ORDER BY m.mes";
				
				@SuppressWarnings("rawtypes")
				List estoques = super.hqlQuery(query);

				for (Object object : estoques) {
					@SuppressWarnings("rawtypes")
					Map linha = (Map) object;

					Estoque e = new Estoque();
					e.setNome(linha.get("nome").toString());
					
					int preco = Integer.parseInt(linha.get("preco").toString());
					e.setPreco(preco);
					
					int recebimentos = Integer.parseInt(linha.get("recebimento_quantidade").toString());
					e.setRecebimento_quantidade(recebimentos);
					
					int vendas = Integer.parseInt(linha.get("venda_quantidade").toString());
					e.setVenda_quantidade(vendas);
					
					e.setLucro(preco*vendas);
					
					e.setEstoque_quantidade(recebimentos-vendas);
					
					//estoque.setMes(Mes.valueOf(linha.get("mes").toString()));
					
					estoque.add(e);
					
				}
				
				return estoque;
	}

	public List<Estoque> recuperarEstoqueDoMes(Mes mes) {
		List<Estoque> estoque = new ArrayList<Estoque>();
		
		String query = "SELECT p.nome, COALESCE(r.recebimento_quantidade, 0) AS recebimento_quantidade, COALESCE(v.venda_quantidade, 0) AS venda_quantidade FROM produto AS p "
				+ " LEFT OUTER JOIN ( SELECT mes, produto_id, SUM(quantidade) AS recebimento_quantidade FROM recebimento GROUP BY mes, produto_id  ) AS r ON  p.id_produto = r.produto_id "
				+ " LEFT OUTER JOIN ( SELECT mes, produto_id, SUM(quantidade) AS venda_quantidade FROM venda GROUP BY mes, produto_id ) AS v ON  p.id_produto = v.produto_id WHERE v.mes='"+mes.ordinal()+"' AND r.mes='"+mes.ordinal()+"';";

		@SuppressWarnings("rawtypes")
		List estoques = super.hqlQuery(query);

		for (Object object : estoques) {
			@SuppressWarnings("rawtypes")
			Map linha = (Map) object;

			Estoque e = new Estoque();
			e.setNome(linha.get("nome").toString());
			
			/*int preco = Integer.parseInt(linha.get("preco").toString());
			e.setPreco(preco);*/
			
			int recebimentos = Integer.parseInt(linha.get("recebimento_quantidade").toString());
			e.setRecebimento_quantidade(recebimentos);
			
			int vendas = Integer.parseInt(linha.get("venda_quantidade").toString());
			e.setVenda_quantidade(vendas);
			
			/*e.setLucro(preco*vendas);
			
			e.setEstoque_quantidade(recebimentos-vendas);*/
			
			//estoque.setMes(Mes.valueOf(linha.get("mes").toString()));
			
			estoque.add(e);
			
		}
		
		return estoque;	
	}

	public List<Integer> lucroAnual() {
		List<Integer> lucroAnual = new ArrayList<Integer>();
		
		String query = "SELECT m.mes, SUM(COALESCE((p.preco*venda_quantidade), 0)) AS lucro FROM produto AS p "
				+ " CROSS JOIN ( VALUES (0), (1),(2),(3),(4),(5),(6), (7), (8), (9), (10), (11) ) AS m(mes) "
				+ " LEFT OUTER JOIN ( SELECT mes, produto_id, SUM(quantidade) AS venda_quantidade FROM venda GROUP BY mes, produto_id ) AS v ON  p.id_produto = v.produto_id "
				+ " AND m.mes = v.mes GROUP BY m.mes ORDER BY m.mes;";
		
		@SuppressWarnings("rawtypes")
		List vendas = super.hqlQuery(query);

		for (Object object : vendas) {
			@SuppressWarnings("rawtypes")
			Map linha = (Map) object;
			
			int lucro = Integer.parseInt(linha.get("lucro").toString());
			
			lucroAnual.add(lucro);
			
		}
		
		return lucroAnual;
	}

}
