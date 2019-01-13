import java.sql.*;
import java.util.Scanner;
import java.util.Vector;

public class Driver {
	
	public static void main(String args[])
	{
		
		System.out.println("Which operation do you want to do?\n1.Create\n2.Read\n3.Update\n4.Delete");
		Scanner in = new Scanner(System.in);
		
		int ch = in.nextInt();
		
		switch(ch)
		{
		
		case 1:
			
			Employee e = new Employee();
			e.createEmp();
			
			try
			{
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ayush", "root" , "");
				
				PreparedStatement ps = null;
				String sql = "insert into emp values(?,?,?,?,?,?,?);";
				ps = myConn.prepareStatement(sql);
				ps.setString(1,e.getName());
				ps.setInt(2, e.getId());
				ps.setString(3,e.getDesgn());
				ps.setString(4,e.getDept());
				ps.setString(5,e.getAddress());
				ps.setString(6, e.getVehicle());
				ps.setInt(7,e.getCompen());
				
				ps.executeUpdate();
				
				Vector<String> cnumber = e.getCnumber();
				for(int i = 0; i < cnumber.size(); i++)
				{
					sql = "insert into empContact values(?,?);";
					ps = myConn.prepareStatement(sql);
					ps.setInt(1, e.getId());
					ps.setString(2, cnumber.elementAt(i));
					
					ps.executeUpdate();
				}
				
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}
			
			break;
			
		case 2:
			
			try
			{
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ayush", "root" , "");
				Statement myStmt = myConn.createStatement();
				
				System.out.println("Enter ID of the employee: ");
				int idch = in.nextInt();

				ResultSet myRs = myStmt.executeQuery("select * from emp where id = " + idch + ";");
				
				while(myRs.next())
				{
					System.out.println("Name: " + myRs.getString(1));
					System.out.println("Designation: " + myRs.getString(3));
					System.out.println("Department: " + myRs.getString(4));
					System.out.println("Address: " + myRs.getString(5));
					System.out.println("Vehicle Number: " + myRs.getString(6));
					System.out.println("Compensation: " + myRs.getInt(7));
				}
				
				System.out.println("Contact Numbers:");
				myRs = myStmt.executeQuery("select * from empContact where id = " + idch + ";");
				while(myRs.next())
				{
					System.out.println(myRs.getString(2));
				}
				
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}
			
			break;
			
		case 3:
			
			try
			{
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ayush", "root" , "");
				Statement myStmt = myConn.createStatement();
				
				System.out.println("Enter ID of the employee: ");
				int idch = in.nextInt();
				
				String query1 = "delete from empContact where id = " + idch + ";";
				String query2 = "delete from emp where id = " + idch + ";";
				
				myStmt.executeUpdate(query1);
				myStmt.executeUpdate(query2);
				
				e = new Employee();
				e.createEmpWithId(idch);
				
				PreparedStatement ps = null;
				query1 = "insert into emp values(?,?,?,?,?,?,?);";
				ps = myConn.prepareStatement(query1);
				ps.setString(1,e.getName());
				ps.setInt(2, e.getId());
				ps.setString(3,e.getDesgn());
				ps.setString(4,e.getDept());
				ps.setString(5,e.getAddress());
				ps.setString(6, e.getVehicle());
				ps.setInt(7,e.getCompen());
				
				ps.executeUpdate();
				
				Vector<String> cnumber = e.getCnumber();
				for(int i = 0; i < cnumber.size(); i++)
				{
					query1 = "insert into empContact values(?,?);";
					ps = myConn.prepareStatement(query1);
					ps.setInt(1, e.getId());
					ps.setString(2, cnumber.elementAt(i));
					
					ps.executeUpdate();
				}
				
				
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}
			
			break;
			
		case 4:
			
			try
			{
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ayush", "root" , "");
				Statement myStmt = myConn.createStatement();
				
				System.out.println("Enter ID of the employee: ");
				int idch = in.nextInt();
				
				String query1 = "delete from empContact where id = " + idch + ";";
				String query2 = "delete from emp where id = " + idch + ";";
				
				myStmt.executeUpdate(query1);
				myStmt.executeUpdate(query2);
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}
			
			break;
		}
		
		in.close();
	}
}
