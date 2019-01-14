package sampleproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

public class Update extends Employee {

	public void updateEmployee()
	{
		final int empid;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Employee ID to update the details : ");
		empid = input.nextInt();
		try {
			Connection conn = DriverManager.getConnection(  
					 "jdbc:mysql://localhost:3306/Employee","root","password");
			Statement stat = conn.createStatement();
			String query = "select firstName,lastName from EmployeeDetails where id = '"+empid+"'";
			ResultSet res = stat.executeQuery(query);
			while(res.next())
			{
				 String fname = res.getString("firstName");
				 String lname = res.getString("lastName");
				 System.out.println("First Name : " + fname +"\nLast Name  : "+ lname);
				 System.out.println("Enter the following details : ");
				 super.readDetails();
				 String sql = "update EmployeeDetails set designation = '"+super.empDesignation+"',department = '"+super.empDept+"',corresponAdd='"+super.corrAdd+"'" +
						 ",contact1 = '"+super.contact1+"',contact2 = '"+super.contact2+"',vehicleno = '"+super.vehNo+"',compenastion = '"+super.salary+"' where id='"+empid+"'";
				 stat.executeUpdate(sql);
				 System.out.println("Updation Successful");
				 return;
			}
			if(!res.next())
			{
				System.out.println("The employee with Id "+ empid + " does not exists!!");
			}
			conn.close();
			input.close();
		}catch(SQLException e)
		{
			System.out.println(e);
		}
	}
}
