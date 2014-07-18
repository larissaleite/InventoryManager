package br.com.projeto.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHibernateDao<T extends Serializable> {

	private Class<T> classe;
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setClasse(final Class<T> classToSet) {
		classe = classToSet;
	}

	@SuppressWarnings("unchecked")
	public T findOne(final int id) {
		return (T) getCurrentSession().get(classe, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + classe.getName())
				.list();
	}

	public void save(final T entity) {
		getCurrentSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	public T update(final T entity) {
		return (T) getCurrentSession().merge(entity);
	}

	public void delete(final T entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteById(final int id) {
		final T entity = findOne(id);
		delete(entity);
	}
	
	@SuppressWarnings("rawtypes")
	public List hqlQuery(String sql) {
		Query query = getCurrentSession().createSQLQuery(sql);
		return query.list();
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
