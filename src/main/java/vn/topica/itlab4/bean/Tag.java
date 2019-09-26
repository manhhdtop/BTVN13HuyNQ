package vn.topica.itlab4.bean;

public class Tag
{
	int id;
	String tag;
	
	public Tag()
	{
		this.id = -1;
		this.tag = "";
	}
	
	public Tag(int id, String tag)
	{
		this.id = id;
		this.tag = tag;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getTag()
	{
		return tag;
	}
	
	public void setTag(String tag)
	{
		this.tag = tag;
	}
}
