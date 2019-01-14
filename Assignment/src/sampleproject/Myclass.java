package sampleproject;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Myclass{
 public static void main(String args[])
 {
	 Statement stat;
	 try {
		 	Class.forName("com.mysql.jdbc.Driver");
		 	Connection conn = DriverManager.getConnection(  
				 "jdbc:mysql://localhost:3306/Employee","root","password"); 
		 	System.out.println("Database Connection Successful");
		 	stat = conn.createStatement();
		 	String sql = "CREATE TABLE IF NOT EXISTS EmployeeDetails " +
                 "(id INTEGER not NULL, " +
                 " firstName VARCHAR(255) not NULL, " + 
                 " lastName VARCHAR(255) , " + 
                 " designation VARCHAR(255) not NULL, " + 
                 " department VARCHAR(255) not NULL, " +
                 " corresponAdd VARCHAR(1000) not NULL, " +
                 " permanentAdd VARCHAR(1000) not NULL, " +
                 " contact1 VARCHAR(10) not NULL, " +
                 " contact2 VARCHAR(10) ," +
                 " vehicleno VARCHAR(9) ," +
                 " compenastion DOUBLE(10,2) not NULL, " +
                 " PRIMARY KEY ( id ))"; 
		 	stat.executeUpdate(sql);
	 }catch(Exception e)
	 {
		 System.out.println(e);
	 }
	 Scanner input = new Scanner(System.in);
	 System.out.println("The following operations are performed on Employee  :");
	 while(true)
	 {
		 System.out.println("1.ADD\n2.DELETE\n3.UPDATE\n4.DISPLAY");
		 System.out.print("Enter your choice : ");
		 int choice = input.nextInt();
		 switch(choice)
		 {
		  case 1:Create create = new Create();
		  		 create.addEmployee();
			    break;
		  case 2:Delete delete = new Delete();
		  		 delete.deleteEmployee();
			    break;
		  case 3:Update update = new Update();
			     update.updateEmployee();
			    break;
		  case 4:Read read = new Read();
			     read.displayEmployee();
			    break;
		  case 5:System.exit(0);
		         input.close();  
	      default : System.out.println("Invalid choice");
		 }
	 }
 }
}
