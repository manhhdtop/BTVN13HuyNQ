package vn.topica.itlab4.bean;

public class Category
{
	int id;
	String name;
	Category parent;
	
	public Category()
	{
		this.id = -1;
		this.name = "";
		this.parent = null;
	}
	
	public Category(int id, String name, Category parent)
	{
		this.id = id;
		this.name = name;
		this.parent = parent;
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
	
	public Category getParent()
	{
		return parent;
	}
	
	public void setParent(Category parent)
	{
		this.parent = parent;
	}
}
