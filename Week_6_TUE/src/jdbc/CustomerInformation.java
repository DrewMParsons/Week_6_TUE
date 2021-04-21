package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CustomerInformation
{
	static Connection con = null;
	ResultSet rs = null;
	PreparedStatement prepstmt = null;
	Map<Integer, Customer> customerMap = new HashMap<Integer, Customer>();

	
	public static void createDBConnection()
	{
		try
		{
			Class.forName(ConnConsts.DRIVER);
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// open the connection
		try
		{
			con = DriverManager.getConnection(ConnConsts.URL, ConnConsts.USER, ConnConsts.PASSWORD);
		} catch (SQLException e)
		{

			e.printStackTrace();
		}
		System.out.println("Connected to the Database  Successfully");

	}

	public void findAllCustomer()
	{
		createDBConnection();
		String findAllCust = "Select * from customers";
		try
		{
			prepstmt = con.prepareStatement(findAllCust);
			rs = prepstmt.executeQuery();

			while (rs.next())
			{
				Customer cust = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3));
				customerMap.put(cust.getId(), cust);

			}
		} catch (SQLException e)
		{

			e.printStackTrace();
		}
	}

	public void printAllCustomers()
	{
		customerMap.forEach((k, n) -> System.out.println(n.getId() + " , " + n.getName() + " , " + n.getPhone()));
	}

	public void UpdateCustomer(Customer customer)
	{
		createDBConnection();

		String updateCust = "Update customers set Name = ?, phone = ? where id = ?";
		try
		{
			prepstmt = con.prepareStatement(updateCust);
			prepstmt.setString(1, customer.getName());
			prepstmt.setString(2, customer.getPhone());
			prepstmt.setInt(3, customer.getId());
			int result = prepstmt.executeUpdate();
			if (result != 0)
			{
				System.out.println(result + "row updated");
				customerMap.replace(customer.getId(), customer);
			} else
			{
				System.out.println(result + "row updated. Update failed");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void deleteCustomerById(int id)
	{
		createDBConnection();
		String deleteCust = "Delete from customers where CustomerId = ?";
		try
		{
			prepstmt = con.prepareStatement(deleteCust);
			prepstmt.setInt(1, id);
			int result = prepstmt.executeUpdate();
			customerMap.remove(id);
			System.out.println(result + "row deleted");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void addCustomer(Customer customer)
	{
		createDBConnection();
		String insertCust = "Insert into customers (Name, phone) values (?,?)";

		try
		{
			prepstmt = con.prepareStatement(insertCust);
			prepstmt.setString(1, customer.getName());
			prepstmt.setString(2, customer.getPhone());
			int result = prepstmt.executeUpdate();
			if (result != 0)
			{
				System.out.println("Customer was added to the DB");

				int id = getCustomerIdFromDB(customer);
				if (id != -1)
				{
					customer.setId(id);
					customerMap.put(id, customer);
					System.out.println("Customer was added to the list");
				}
				else if(id==-1){
					System.out.println("Customer was not added to the list, customer is not in the DB");
					
				}

			} else
			{
				System.out.println("Customer was not updated to the DB");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public int getCustomerIdFromDB(Customer customer)
	{
		createDBConnection();
		String getCustId = "Select CustomerId from customers where Name = ? and phone = ?";
		try
		{
			prepstmt = con.prepareStatement(getCustId);
			prepstmt.setString(1, customer.getName());
			prepstmt.setString(2, customer.getPhone());
			rs = prepstmt.executeQuery();
			if (rs.next())
			{
				int result = rs.getInt(1);
				return result;
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return -1;

	}

}
