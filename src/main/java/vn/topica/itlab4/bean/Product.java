package vn.topica.itlab4.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "jpa_product")
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private double price;
	@Column(name = "image")
	private String image;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@Column(name = "created")
	private Date created;
	@Column(name = "updated")
	private Date updated;
	
	public Product()
	{
		this.id = -1;
		this.name = "";
		this.description = "";
		this.price = 0;
		this.category = null;
		this.created = new Date();
		this.updated = new Date();
	}
	
	public Product(String name, String description, double price, String image, Category category, Date created, Date updated)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.category = category;
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
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public void setPrice(String price)
	{
		this.price = Double.parseDouble(price);
	}
	
	public String getImage()
	{
		return image;
	}
	
	public void setImage(String image)
	{
		this.image = image;
	}
	
	public Category getCategory()
	{
		return category;
	}
	
	public void setCategory(Category category)
	{
		this.category = category;
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
