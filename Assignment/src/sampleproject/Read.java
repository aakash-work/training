package sampleproject;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Read{
	public void displayEmployee() {
		Scanner input = new Scanner(System.in);
		String fname = " ",lname=" ",design=" ",dept="";
		String coradd="",peradd=""; 
		String ph1="",ph2="",vehno="";
		double sal=0.0;
		try {
			Connection conn = DriverManager.getConnection(  
					 "jdbc:mysql://localhost:3306/Employee","root","password");
			Statement stat = conn.createStatement();
			System.out.println("Enter Employee ID : ");
			int empid = input.nextInt();
			String query = "select * from EmployeeDetails where id = '"+empid+"'";
			ResultSet res = stat.executeQuery(query);
			while(res.next())
			{
				 fname = res.getString("firstName");
				 lname = res.getString("lastName");
				 design = res.getString("designation");
				 dept = res.getString("department");
				 coradd = res.getString("corresponAdd");
				 peradd = res.getString("permanentAdd");
				 ph1 = res.getString("contact1");
				 ph2 = res.getString("contact2");
				 vehno = res.getString("vehicleno");
				 sal = res.getDouble("compenastion");
				 System.out.println("First Name            : " + fname  +"\nLast Name             : "+ lname);
				 System.out.println("Designation           : " + design +"\nDepartment            : "+ dept);
				 System.out.println("Corresponding Address : " + coradd +"\nPermanent Address     : "+ peradd);
				 System.out.println("Contact No[1]         : " + ph1    +"\nContact No[2]         : "+ ph2);
				 System.out.println("Vehicle No            : " +  vehno +"\nCompensation          : " + sal);
				 return;
			}
			if(!res.next())
			{
				System.out.println("The employee with Id "+ empid + " does not exists!!");
			}
			conn.close();
			input.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
}
