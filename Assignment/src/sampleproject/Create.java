package sampleproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Create extends Employee{
	public  void addEmployee()
	{
		Employee emp  = new Employee();
		emp.readEmployeeDetails();
		try {
			Connection conn = DriverManager.getConnection(  
					 "jdbc:mysql://localhost:3306/Employee","root","password");
			Statement stat = conn.createStatement();
			String query = "insert into EmployeeDetails " 
					+ "value('"+emp.empId+"','"+emp.empFname+"','"+emp.empLname+"','"+emp.empDesignation+"','"+emp.empDept+"','"+emp.corrAdd+"','"+emp.permAdd+"','"+emp.contact1+"','"+emp.contact2+"','"+emp.vehNo+"','"+emp.salary+"')";
			stat.executeUpdate(query);
			System.out.println("Insertion successful");
			conn.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
