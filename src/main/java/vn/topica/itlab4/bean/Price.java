package vn.topica.itlab4.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "jpa_price")
public class Price
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@Column(name = "price")
	private double price;
	@Column(name = "created")
	private Date created;
	@Column(name = "updated")
	private Date updated;
	
	public Price()
	{
		this.id = -1;
		this.price = 0;
		this.product = null;
		this.created = new Date();
		this.updated = new Date();
	}
	
	public Price(double price)
	{
		this.id = -1;
		this.price = price;
		this.product = null;
		this.created = new Date();
		this.updated = new Date();
	}
	
	public Price(String price)
	{
		this.id = -1;
		this.product = null;
		this.price = Double.parseDouble(price);
		this.created = new Date();
		this.updated = new Date();
	}
	
	public Price(int id, double price, Product product)
	{
		this.id = id;
		this.product = product;
		this.price = price;
		this.created = new Date();
		this.updated = new Date();
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public Date getCreated()
	{
		return created;
	}
	
	public void setCreated(Date created)
	{
		this.created = created;
	}
	
	public Product getProduct()
	{
		return product;
	}
	
	public void setProduct(Product product)
	{
		this.product = product;
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
