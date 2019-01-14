import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess{
	
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    int n=0;
    Scanner sc=new Scanner(System.in);
    String empname="";
    String desg="";
    String dept="";
    String add="";
    String num1="";
    String num2="";
    String veh="";
    Float comp;
    
    
    public void conn()throws Exception
    {
    	
    	try
    	{
    		Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/employe?"
                            + "user=emp&password=empemp123");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
    		
    	}catch(Exception e){}
    }

    
    public void readDataBase() throws Exception {
        try {
        	
        	
            System.out.println("enter the number of employee");
            n=sc.nextInt();
            System.out.println("enter the details");
            for (int i=0;i<n;i++)
            {
            	System.out.println("enter the name of employee");
            	empname=sc.next();
            	System.out.println("enter the designation of employee");
            	desg=sc.next();
            	System.out.println("enter the department of employee");
            	dept=sc.next();
            	System.out.println("enter the address of employee");
            	add=sc.next();
            
                System.out.println("enter the vehicle details of employee");
                veh=sc.next();
                System.out.println("enter the compensation of employee");
            	comp=sc.nextFloat();
            
            	System.out.println("enter the contact of employee");
            	num1=sc.next();
            	
            	//Regexp for validation of indian mobile numbers
            	   Pattern pattern = Pattern.compile("^[6-9]{10}$");
            	      Matcher matcher = pattern.matcher(num1);
            	      
            	      if (matcher.matches()) {
            	    	  
            	    	  System.out.println("Phone Number Valid");
            	    		System.out.println("Do you have any alternative number??Press Y or N");
                            char c = sc.next().charAt(0); 
                            if(c=='y')
                            {
                            	System.out.println("enter the alternate number");
                            	num2=sc.next();
                            }
            	      }
            	      else
              	      {
              	    	  System.out.println("Invalid phone number\n");
              	    	System.out.println("enter the  correct contact of employee");
                    	num1=sc.next();
                    	System.out.println("Do you have any alternative number??Press Y or N");
                        char c = sc.next().charAt(0); 
                        if(c=='y')
                        {
                        	System.out.println("enter the alternate number");
                        	num2=sc.next();
                        }
              	    	  
              	      }
            	      
            	      
            
            	preparedStatement = connect.prepareStatement("insert into  employe.emp values (default, ?, ?, ?, ? , ?, ?,?,?)");
            	preparedStatement.setString(1,empname);
                preparedStatement.setString(2,desg);
                preparedStatement.setString(3,dept);
                preparedStatement.setString(4,add);
                preparedStatement.setString(5,veh);
                preparedStatement.setFloat(6,comp);
                preparedStatement.setString(7,num1);
                preparedStatement.setString(8,num2);
                preparedStatement.executeUpdate();
            }
            System.out.println("data inserted successfully");


        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }
    
    public void display()throws Exception
    {
    	
        try
        {
        	;
        	String query = "SELECT * FROM employe.emp";
       
        	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/employe?", "emp", "empemp123");
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(query);
   
          while (resultSet.next()) {
          String id = resultSet.getString("id");
          String nam = resultSet.getString("name");
          String de = resultSet.getString("designation");
          String dep = resultSet.getString("department");
          String ad = resultSet.getString("address");
          String ve = resultSet.getString("vehicle");
          String nu1 = resultSet.getString("num1");
          String nu2 = resultSet.getString("num2");
          Float co = resultSet.getFloat("compensation");
          System.out.println("id: " + id);
          System.out.println("name: " +nam );
          System.out.println("designation: " + de);
          System.out.println("department: " + dep);
          System.out.println("address: " + ad);
          System.out.println("vehicle: " + ve);
          System.out.println("compensation: " + co);
          System.out.println("num1: " + nu1);
          System.out.println("num2: " + nu2);
          System.out.println("------------------"); 
        }
        }catch(Exception e){
        
        	System.out.println("s");
        }
     
    }
    
    public void delete() throws Exception
    {
    	System.out.println("enter the employee id to be deleted");
    	int id =sc.nextInt();
    	try
    	{
    		
    	preparedStatement = connect
              .prepareStatement( "DELETE FROM employe.emp WHERE id = ?");
    	  preparedStatement.setInt(1, id);
              preparedStatement.executeUpdate();
           	System.out.println(" deleted");
            
            
    	  } catch (Exception e) {
            throw e;
        } 
    	
    }
    public void update()throws Exception
    {
    	System.out.println("enter the employee id to be updated");
    	int id =sc.nextInt();
     	String name;
    	System.out.println("enter the new name");
    	name=sc.next();
    	
    	try
    	{
    		
    	preparedStatement = connect
              .prepareStatement( "update employe.emp set name = ? where id = ?");
    	  preparedStatement.setString(1, name);
    	  preparedStatement.setInt(2,id);
              preparedStatement.executeUpdate();
           	System.out.println(" updated");
            
            
    	  } catch (Exception e) {
            throw e;
        } 
    	
    	
    }
    

  

    


    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
    public static void main(String[] args) throws Exception {
    	  Scanner sc=new Scanner(System.in);
        MySQLAccess dao = new MySQLAccess();
        dao.conn();
      
     
    
     
     
       System.out.println(" 1: enter records\n 2: delete records \n 3: update records \n 4: display records");
   
       while(true)
       {
    	   System.out.println("enter your choice");
    	   int choice=sc.nextInt();
    	   switch(choice)
    	   {
    	   
    	   case 1:dao.readDataBase();
    	   break;
    	   case 2:dao.delete();
    	   break;
    	   case 3:dao.update();
    	   break;
    	   case 4:dao.display();
    	   break;
    	   default: System.out.println("invalid input");
    	   dao.close();
    	  
    	   }
    	   
    	  
       }
     
    }


}


