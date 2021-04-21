package jdbc;

public class App
{

	public static void main(String[] args)
	{
		CustomerInformation custInfo = new CustomerInformation();
		custInfo.findAllCustomer();
		
		Customer cust1 = new Customer("Doug","567804");
		Customer cust2 = new Customer("Drew","567804546");
		//custInfo.addCustomer(cust1);
		
		custInfo.printAllCustomers();
		
		//cust1.setId(custInfo.getCustomerIdFromDB(cust1));
		//custInfo.customerList.add(cust1);
		
		//custInfo.deleteCustomerById(cust1.getId());
		//custInfo.printAllCustomers();	

	}

}
