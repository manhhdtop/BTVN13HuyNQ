package vn.topica.itlab4.bean;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "jpa_category")
public class Category
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "slug")
	private String slug;
	@ManyToOne
	@JoinColumn(name = "parent")
	private Category parent;
	@Column(name = "created")
	private Date created;
	@Column(name = "updated")
	private Date updated;
	
	public Category()
	{
		this.id = -1;
		this.name = "";
		this.slug = "";
		this.parent = null;
		this.created = new Date();
		this.updated = new Date();
	}
	
	public Category(int id, String name, String slug)
	{
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.parent = null;
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
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getSlug()
	{
		return slug;
	}
	
	public void setSlug(String slug)
	{
		this.slug = slug;
	}
	
	public Category getParent()
	{
		return parent;
	}
	
	public void setParent(Category parent)
	{
		this.parent = parent;
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
