package vn.topica.itlab4.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import vn.topica.itlab4.bean.User;
import vn.topica.itlab4.util.Constant;

import java.util.List;

public class UserModel
{
	private static SessionFactory factory;
	
	static
	{
		factory = Factory.getInstance();
	}
	
	public List<User> getUser()
	{
		List<User> users = null;
		
		Session session = factory.getCurrentSession();
		session.getTransaction().begin();
		
		// Tạo một câu lệnh HQL query object.
		// Tương đương với Native SQL:
		// Select e.* from EMPLOYEE e order by e.EMP_NAME, e.EMP_NO
		
		String sql = Constant.SELECT_USERS;
		
		// Tạo đối tượng Query.
		Query<User> query = session.createQuery(sql);
		
		// Thực hiện truy vấn.
		users = query.getResultList();
		
		return users;
	}
}
