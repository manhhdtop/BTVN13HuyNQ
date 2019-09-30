package vn.topica.itlab4.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	//	@Column(name = "price")
	private long price;
	//	@Column(name = "image")
	private String image;
	private Category category;
	private List<Tag> tags;
	
	public Product()
	{
		this.id = -1;
		this.name = "";
		this.description = "";
		this.price = 0;
		this.tags = new ArrayList<>();
		this.category = null;
	}
	
	public Product(int id, String name, String description, long price,
			Category category, List<Tag> tags)
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.tags = tags;
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
	
	public long getPrice()
	{
		return price;
	}
	
	public void setPrice(long price)
	{
		this.price = price;
	}
	
	public Category getCategory()
	{
		return category;
	}
	
	public void setCategory(Category category)
	{
		this.category = category;
	}
	
	public List<Tag> getTags()
	{
		return tags;
	}
	
	public void setTags(List<Tag> tags)
	{
		this.tags = tags;
	}
}
