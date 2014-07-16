package br.com.projeto.bean;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

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
	    
	    System.out.println("Id produto = "+arg2);
		
	    Query query = session.createQuery("from Produto where id_produto = '"+arg2+"'");
		//query.setParameter("id", arg2); nao funciona
		Object obj = query.list().get(0);
		
		if (obj instanceof Produto) {
			System.out.println("objeto é um produto ---- "+((Produto) obj).getNome());
			
		}
		session.getTransaction().commit();
		session.close();
		return obj;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (!(arg2 instanceof Produto)) {
			return null;
		}

		String s =  String.valueOf(((Produto) arg2).getId());
			
		return s;
	}

}
