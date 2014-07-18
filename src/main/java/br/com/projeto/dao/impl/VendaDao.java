package br.com.projeto.dao.impl;

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

}
