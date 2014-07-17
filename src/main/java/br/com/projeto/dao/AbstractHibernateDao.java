package br.com.projeto.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.projeto.persistence.HibernateUtil;

public abstract class AbstractHibernateDao<T extends Serializable> {

	private Class<T> classe;

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

	protected final Session getCurrentSession() {
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}

}
