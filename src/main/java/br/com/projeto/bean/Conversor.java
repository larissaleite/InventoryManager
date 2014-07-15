package br.com.projeto.bean;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.Entity;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.projeto.modelo.Produto;
import br.com.projeto.persistence.HibernateUtil;

@FacesConverter("Conversor")
public class Conversor implements Converter{
	/* Classe necessária para converter os valores provenientes do h:selectOneMenu para objetos */

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		/* usar um service ao invés de diretamente acessar o banco de dados */
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    System.out.println("Inicializado session factory"); 
		Session session = sessionFactory.openSession();
		System.out.println("sessao aberta");
	    session.beginTransaction();  
	    
		Query query = session.createQuery("from Produto where id_produto = :id");
		query.setParameter("id", arg2);
		Object obj = query.list().get(0);
		if (obj instanceof Produto) {
			System.out.println("objeto é um produto ---- "+((Produto) obj).getNome());
			
		}
		session.getTransaction().commit();
		session.close();
		return obj;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		/*tornar mais genérico */
		Entity entity = (Entity) arg2;
	    return ((UIComponent) entity).getId() != null ? String.valueOf(((UIComponent) entity).getId()) : null;
	}

}
