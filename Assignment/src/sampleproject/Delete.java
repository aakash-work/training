package sampleproject;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete {

	public void deleteEmployee() {
		Scanner input = new Scanner(System.in);
		try {
			Connection conn = DriverManager.getConnection(  
					 "jdbc:mysql://localhost:3306/Employee","root","password");
			Statement stat = conn.createStatement();
			System.out.println("Enter the Employee ID to delete the record : ");
			int empid = input.nextInt();
			String query = "delete from EmployeeDetails where id = '"+empid+"'";
			stat.executeUpdate(query);
			System.out.println("Deletion successful");
			conn.close();
			return;
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
