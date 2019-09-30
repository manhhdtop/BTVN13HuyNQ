package vn.topica.itlab4.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import vn.topica.itlab4.bean.User;
import vn.topica.itlab4.util.Constant;

import javax.persistence.NoResultException;

public class CartModel
{
	private static SessionFactory factory;
	
	static
	{
		factory = Factory.getInstance();
	}
	
	public static User getCart(int userId)
	{
		Session session = factory.getCurrentSession();
		session.getTransaction().begin();
		// Tạo đối tượng Query.
		Query<User> query = session.createQuery(Constant.SELECT_USER);
		query.setParameter("username", userId);
		User user;
		try
		{
			user = query.getSingleResult();
		}
		catch (NoResultException e)
		{
			user = null;
		}
		session.getTransaction().commit();
		session.close();
		
		return user;
	}
	
}
