//package jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class JDBCDemoOne
//{
//	
//
//	public static void main(String[] args) throws ClassNotFoundException
//	{
//		Connection con = null;
//		Statement stmt=null;
//		ResultSet rs =null;
//		PreparedStatement prepstmt=null;
//		
//		
//		try {
//			//register  your driver
//			con = createDBConnection();
//			
//			//execute a query
//			stmt =  con.createStatement();
//			String findAllEmployee = "Select * from employees limit 3";
//			rs = stmt.executeQuery(findAllEmployee);
//			printResultSet(rs);
//			System.out.println("-------------");
//			
//			//using prepared statement
//			String findAllEmpWithOffice = "Select * from employees where officeCode = ?";
//			prepstmt = con.prepareStatement(findAllEmpWithOffice);
//			prepstmt.setInt(1, 1);
//			rs = prepstmt.executeQuery();
//			printResultSet(rs);
//			System.out.println("-------------");
//			
//			//using insert with prepared statement
////			String insertEmployee = "insert into employees(employeeNumber,lastName,firstName,extension,email,officeCode,reportsTo,jobTitle)value (?,?,?,?,?,?,?,?)";
////			prepstmt = con.prepareStatement(insertEmployee);
////			prepstmt.setInt(1, 1000);
////			prepstmt.setString(2, "Jepson");
////			prepstmt.setString(3, "Gleef");
////			prepstmt.setString(4, "x7890");
////			prepstmt.setString(5, "g.jepson@gmail.com");
////			prepstmt.setString(6, "7");
////			prepstmt.setInt(7, 1102);
////			prepstmt.setString(8, "Sales Rep");
////			int i = prepstmt.executeUpdate();
////			System.out.println(i + "row inserted in db");
//			
//			//get metadata for db
//			ResultSetMetaData rsmd = rs.getMetaData();
//			System.out.println(rsmd.getColumnName(1));
//			
//		}catch(SQLException  e) {
//			System.out.println(e);
//			
//			
//		}finally {
//			try
//			{
//				con.close();
//			} catch (SQLException e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	
//
//	private static void printResultSet(ResultSet rs) throws SQLException
//	{
//		while(rs.next()) {
//			int empID = rs.getInt(1); //by column number "employeeNumber"
//			String  lastName = rs.getString("lastName");
//			String  firstName = rs.getString("firstName");
//			String  extension = rs.getString("extension");
//			String  email = rs.getString("email");
//			String  office = rs.getString("officeCode");
//			int managerID = rs.getInt("reportsTo");
//			String  title = rs.getString("jobTitle");
//			
//			System.out.println(empID+" , "+firstName+" "+lastName+" , "+title);
//		}
//	}
//
//	//get all info from customers
//	//insert customer to db
//	//update customer 
//	//delete customer
//}
