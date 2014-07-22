package br.com.projeto.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.dao.AbstractHibernateDao;
import br.com.projeto.dao.IVendaDao;
import br.com.projeto.modelo.Venda;

@Repository
@Transactional /* colocar em cada método especificamente? */
public class VendaDao extends AbstractHibernateDao<Venda> implements IVendaDao {

	public VendaDao() {
		super();
		
		super.setClasse(Venda.class);
	}
	
	public void salvarVenda(Venda venda) {
		super.save(venda);
	}

	public List<Integer> recuperarQuantVendas() {
		
		List<Integer> quantVendas = new ArrayList<Integer>();
		
		String query = "SELECT DISTINCT m.mes, COALESCE(v.venda_quantidade, 0) AS venda_quantidade FROM venda CROSS JOIN ( VALUES (0), (1),(2),(3),(4),(5),(6), (7), (8), (9), (10), (11) ) AS m(mes) "+
				" LEFT OUTER JOIN ( SELECT mes, SUM(quantidade) AS venda_quantidade FROM venda GROUP BY mes ) AS v ON v.mes = m.mes " +
				" ORDER BY m.mes; ";
		
		@SuppressWarnings("rawtypes")
		List vendas = super.hqlQuery(query);
		
		for (Object object : vendas) {
			@SuppressWarnings("rawtypes")
			Map linha = (Map) object;
			quantVendas.add(Integer.parseInt(linha.get("venda_quantidade").toString()));
		}
		
		return quantVendas;
	}

}
