package vn.topica.itlab4.model;

import org.hibernate.SessionFactory;
import vn.topica.itlab4.util.HibernateUtils;

public class Factory
{
	private static SessionFactory factory;
	
	public static SessionFactory getInstance()
	{
		if (factory == null)
		{
			factory = HibernateUtils.getSessionFactory();
		}
		return factory;
	}
	
}
