package vn.topica.itlab4.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import vn.topica.itlab4.bean.User;
import vn.topica.itlab4.util.Constant;

import javax.persistence.NoResultException;
import java.util.List;

public class UserModel
{
	private static SessionFactory factory;
	
	static
	{
		factory = Factory.getInstance();
	}
	
	public static User getUser(String username)
	{
		Session session = factory.getCurrentSession();
		session.getTransaction().begin();
		// Tạo đối tượng Query.
		Query<User> query = session.createQuery(Constant.SELECT_USER);
		query.setParameter("username", username);
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
	
	public static List<User> getUsers()
	{
		List<User> users = null;
		
		Session session = factory.getCurrentSession();
		session.getTransaction().begin();
		
		String sql = Constant.SELECT_USERS;
		Query<User> query = session.createQuery(sql);
		
		// Thực hiện truy vấn.
		users = query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		return users;
	}
	
	public static int addUser(User u)
	{
		Session session = factory.getCurrentSession();
		session.getTransaction().begin();
		
		session.save(u);
		
		session.getTransaction().commit();
		session.close();
		
		return 1;
	}
	
	public static int updateUser(User u)
	{
		Session session = factory.getCurrentSession();
		session.getTransaction().begin();
		
		session.update(u);
		
		session.getTransaction().commit();
		session.close();
		
		return 1;
	}
}
