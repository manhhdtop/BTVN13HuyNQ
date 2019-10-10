package vn.topica.itlab4.bean;


import javax.persistence.*;

@Entity
@Table(name = "jpa_user")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "salt")
	private String salt;
	@Column(name = "name")
	private String name;
	@Column(name = "role")
	private int role;
	
	public User()
	{
		this.id = -1;
		this.username = "";
		this.password = "";
		this.salt = "";
		this.name = "";
		this.role = 0;
	}
	
	public User(int id, String username, String password, String salt, String name, int role)
	{
		this.id = id;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.name = name;
		this.role = role;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getSalt()
	{
		return salt;
	}
	
	public void setSalt(String salt)
	{
		this.salt = salt;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getRole()
	{
		return role;
	}
	
	public void setRole(int role)
	{
		this.role = role;
	}
	
	@Override
	public String toString()
	{
		return "User[Username: " + username + "; Role=" + role + "]";
	}
}
