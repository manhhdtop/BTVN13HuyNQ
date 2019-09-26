package vn.topica.itlab4.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cart
{
	private int id;
	private User user;
	private List<Product> products;
	private long totalPrice;
	private Date created;
	private Date updated;
	
	public Cart()
	{
		this.id = -1;
		this.user = null;
		this.products = new ArrayList<>();
		this.totalPrice = 0;
		this.created = new Date();
		this.updated = new Date();
	}
	
	public Cart(int id, User user, List<Product> products, long totalPrice, Date created, Date updated)
	{
		this.id = id;
		this.user = user;
		this.products = products;
		this.totalPrice = totalPrice;
		this.created = created;
		this.updated = updated;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public User getUser()
	{
		return user;
	}
	
	public void setUser(User user)
	{
		this.user = user;
	}
	
	public List<Product> getProducts()
	{
		return products;
	}
	
	public void setProducts(List<Product> products)
	{
		this.products = products;
	}
	
	public int getProductNumber()
	{
		return products == null ? 0 : products.size();
	}
	
	public long getTotalPrice()
	{
		return totalPrice;
	}
	
	public void setTotalPrice(long totalPrice)
	{
		this.totalPrice = totalPrice;
	}
	
	public Date getCreated()
	{
		return created;
	}
	
	public void setCreated(Date created)
	{
		this.created = created;
	}
	
	public Date getUpdated()
	{
		return updated;
	}
	
	public void setUpdated(Date updated)
	{
		this.updated = updated;
	}
}
