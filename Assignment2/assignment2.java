package com.likhitha.assignment2;
import java.sql.*;
import java.util.Scanner;

public class App
{
	public static void main(String args[]) throws Exception
	{
		System.out.print("CRUD OPERATIONS");
		Scanner scan= new Scanner(System.in);
		Connection connect = getConnection();
		int choice;
		while(true)
		{
			System.out.println("\n1.Create\n2.Read\n3.Update\n4.Delete\n5.Exit");
			choice = scan.nextInt();
			switch(choice)
			{
				case 1:create(connect);
					break;
				case 2:read(connect);
					break;
				case 3:update(connect);
					break;
				case 4:delete(connect);
					break;
				case 5:terminate(connect);
					break;
			}
		}
	}
	public static void terminate(Connection conn) throws Exception{
		try {
			System.out.println("\n\nTerminating connection........");
			conn.close();
			System.out.println("Connection Terminated");
			}
		catch(Exception e)
		{
			System.out.println("Error in terminating connection");
			System.exit(0);}
		}
	public static Connection getConnection() throws Exception
	{
		try{
			String url="jdbc:mysql://localhost:3306/assign";
			String username="root";
			String password="password";
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect=DriverManager.getConnection(url,username,password);
			return connect;
		}
		catch(Exception e){
			System.out.println("cannot connect");
		}
		return null;
	}
	
	public static void create(Connection connect) throws Exception
	{
		try
		{
		  System.out.print("Write Queries: ");
		  Scanner scan=new Scanner(System.in);
		  String query=scan.nextLine();
		  PreparedStatement st=connect.prepareStatement(query);
		  st.executeUpdate();  
	   	}
	  	catch(Exception e)
	  	{
		  System.out.println("Table cannot be created");
		  System.exit(0);
	  	}
	   	finally
	   	{
		   System.out.println("Table is created\n\n");
	   	}
	}

	public static void read(Connection connect) throws Exception
	{
	   try{
		  System.out.print("Query : ");
		  Scanner scan=new Scanner(System.in);
		  String query=scan.nextLine();
		  PreparedStatement st=connect.prepareStatement(query);
		  st.executeQuery(); 
		  ResultSet rs=st.getResultSet(); 
		  System.out.println();
		  while(rs.next())
		  {
		    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		  }
		  rs.close();
		}
	   catch(Exception e)
	   {
		   System.out.println("Error");
		   System.exit(0);
	   }
	   finally
	   {
		   System.out.println("Reading done");
	   }
	
   }
   public static void update(Connection connect) throws Exception
	{
	   try {
		    System.out.print("write Queries : ");
		    Scanner scan=new Scanner(System.in);
		    String query=scan.nextLine();
		    PreparedStatement st=connect.prepareStatement(query);
		    st.executeUpdate();    
	   }
	  catch(Exception e) 
		{
		  System.out.println("Error");
		  System.exit(0);
     		}
	   finally {
		System.out.println("Updating done");
		}
	}
   
	public static void delete(Connection connect) throws Exception
	{
	   try {
		System.out.print("Write Queries: ");
		Scanner scan=new Scanner(System.in);
		String query=scan.nextLine();
		PreparedStatement st=connect.prepareStatement(query);
		st.executeUpdate();    
	       }
	   catch(Exception e)
		{
		  System.out.println("Error");
		  System.exit(0);
		}
	   finally 
		{
		  System.out.println("Deleting done");
		}
	}
	
}
