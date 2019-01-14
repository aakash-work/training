package com.chandan.DatabaseConnection;
import java.sql.*;
import java.util.Scanner;

public class App 
{
	public static void main(String args[]) throws Exception{
		System.out.println("CONNECTION ESTABLISHED\n\n");
		System.out.println("----------EMPLOYEE MANAGEMENT SYSTEM-----------\n\n");
		System.out.print("OPERATIONS");
		Scanner scan=new Scanner(System.in);
		Connection conn=getConnection();
		
		int choice;
		while(true){
			System.out.println("\n\n");
			System.out.println("1.CREATE TABLE \n2.UPDATE \n3.DELETE \n4.READ \n5.Exit\n");
			System.out.print("\nCHOICE ");
			choice=scan.nextInt();
			switch(choice){
			case 1:create_table(conn);
				   break;
			case 2:update(conn);
				   break;
			case 3:delete(conn);
			      break;
			case 4:read(conn);
				   break;
			case 5:terminate(conn);
				   break;
			
		}
			
		}
	
		//create_table();
	}
	public static void terminate(Connection conn) throws Exception{
		try {
			System.out.println("\n\nTerminating connection........");
			conn.close();
			System.out.println("Connection Terminated");
			}catch(Exception e){System.out.println("Error in terminating connection");System.exit(0);}
		
	}
	public static Connection getConnection() throws Exception{
		try{
    	String url = "jdbc:mysql://localhost:3306/test";
    	String username= "root";
    	String password="";
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection(url,username,password);
        return conn;
		}catch(Exception e){System.out.println(e);}
		return null;
	}
	
   public static void create_table(Connection conn) throws Exception{
	  try{
		
		System.out.print("Query : ");
		Scanner scan=new Scanner(System.in);
		String query=scan.nextLine();
		PreparedStatement st=conn.prepareStatement(query);
		st.executeUpdate();  
	   }catch(Exception e){System.out.println("Error in creating table syntax");System.exit(0);}
	   finally{System.out.println("Table created\n\n\n");}
   }
   
   public static void read(Connection conn) throws Exception{
	   try{
		   	System.out.print("Query : ");
			Scanner scan=new Scanner(System.in);
			String query=scan.nextLine();
			PreparedStatement st=conn.prepareStatement(query);
			st.executeQuery(); 
			ResultSet rs=st.getResultSet(); 
			System.out.println();
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			rs.close();
	   }catch(Exception e){System.out.println("Error in read query");System.exit(0);}
	   finally{System.out.println("Read operation executed");}
	
   }
   public static void update(Connection conn) throws Exception{
	   try {
		    System.out.print("Query : ");
			Scanner scan=new Scanner(System.in);
			String query=scan.nextLine();
			PreparedStatement st=conn.prepareStatement(query);
			st.executeUpdate(); 
		   
	   }catch(Exception e) {System.out.println("Error in updating table");System.exit(0);}
	   finally {System.out.println("Update executed");}
   }
   
   public static void delete(Connection conn) throws Exception{
	   try {
		   System.out.print("Query : ");
			Scanner scan=new Scanner(System.in);
			String query=scan.nextLine();
			PreparedStatement st=conn.prepareStatement(query);
			st.executeUpdate(); 
		   
	   }catch(Exception e){System.out.println("Error in delete query syntax");System.exit(0);}
	   finally {System.out.println("Delete opeteartion succeeded");}
   }
	
}
