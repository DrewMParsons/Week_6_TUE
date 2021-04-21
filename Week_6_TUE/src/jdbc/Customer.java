package jdbc;

public class Customer
{
	private int id;
	private String name;
	private String phone;
	
	
	public Customer(String name, String phone)
	{
		super();
		this.name = name;
		this.phone = phone;
	}
	
	


	public Customer(int id, String name, String phone)
	{
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}




	protected String getName()
	{
		return name;
	}


	protected void setName(String name)
	{
		this.name = name;
	}


	protected String getPhone()
	{
		return phone;
	}


	protected void setPhone(String phone)
	{
		this.phone = phone;
	}


	protected int getId()
	{
		return id;
	}
	
	protected void setId(int id)
	{
		this.id = id;
	}
	
	
	
	
	

}
