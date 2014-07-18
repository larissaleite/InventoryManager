package br.com.projeto.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.dao.AbstractHibernateDao;
import br.com.projeto.dao.IRecebimentoDao;
import br.com.projeto.modelo.Recebimento;

@Repository
@Transactional /* colocar em cada método especificamente? */
public class RecebimentoDao extends AbstractHibernateDao<Recebimento> implements IRecebimentoDao {

	public RecebimentoDao() {
		super();
		
		super.setClasse(Recebimento.class);
	}
	
	public void salvarRecebimento(Recebimento recebimento) {
		super.save(recebimento);
	}

}
