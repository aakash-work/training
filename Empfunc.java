package empdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.sql.*;
import java.util.Scanner;
public class Empfunc {
	public static void main( String[] args)
	{
		Connection conn = null;
		Scanner input= new Scanner(System.in);
		int id;
		String uname;
		String pwd;
		String name;
		String vehicle_no;
		String vehicle_type;
		int d_id;
		String d_name;
		int salary;
		int flag;
		int flag1;
		String cont1;
		String cont2;
		int dno;
		String street;
		String city;
		String district;
		String state;
		String country;
		String pincode;
		String database;
		try {
			System.out.println("which database you would like to work on ?");
			database=input.next();
			System.out.println("whats ur user name ?");
			uname=input.next();
			System.out.println("password ?");
			pwd=input.next();
			conn= (Connection)DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+database,uname,pwd);
            if(conn!=null)
            {
            	Statement stmt=conn.createStatement();
            	System.out.println("connected successfully");
            	while(true){
            	System.out.println("please select from one of the following options ");
            	System.out.println("1.Add employee\n 2.view employee details \n 3.update employee contact \n 4.delete employee record\n5. exit");
            	flag=input.nextInt();
            	switch(flag)
            	{
            	case 1: System.out.println("please enter required details to add employee");
            	System.out.println("employee id: ");
            	id=input.nextInt();
            	System.out.println("employee name: ");
            	name=input.next();
            	System.out.println("/n employee vehicle number: ");
            	vehicle_no=input.next();
            	System.out.println("/n employee vehicle type: ");
            	vehicle_type=input.next();
            	System.out.println("/n employee compensation ");
            	salary=input.nextInt();
            	System.out.println("/n employee department id ( 1 for tech, 2 for analysis: ");
            	d_id=input.nextInt();
            	PreparedStatement pstmnt3=conn.prepareStatement("insert into employee values( ?,?,?,?,?,?)");
            	pstmnt3.setInt(1,id);
            	pstmnt3.setString(2, name);
            	pstmnt3.setString(3, vehicle_no);
            	pstmnt3.setString(4,vehicle_type);
            	pstmnt3.setInt(5,salary);
            	pstmnt3.setInt(6,d_id);
            	flag1=pstmnt3.executeUpdate();
            	System.out.println("\nemployee contact number");
            	cont1=input.next();
            	System.out.println("\nemergency contact number");
            	cont2=input.next();
            	pstmnt3=conn.prepareStatement("insert into contacts values (?,?,?)");
            	pstmnt3.setInt(1,id);
            	pstmnt3.setString(2, cont1);
            	pstmnt3.setString(3,cont2);
                flag1=pstmnt3.executeUpdate();
            	System.out.println("\n d.no: " );
            	dno=input.nextInt();
            	System.out.println("\n street " );
            	street=input.next();
            	System.out.print("\n city/town: " );
            	city=input.next();
            	System.out.println("\n district " );
            	district=input.next();
            	System.out.println("\n state " );
            	state=input.next();
            	System.out.println("\n country: " );
            	country=input.next();
            	System.out.println("\n pincode " );
            	pincode=input.nextLine();
            	pstmnt3=conn.prepareStatement("insert into adress values(?,?,?,?,?,?,?,?)");
            	pstmnt3.setInt(1, id);
            	pstmnt3.setInt(2, dno);
            	pstmnt3.setString(3,street);
            	pstmnt3.setString(4,city);
            	pstmnt3.setString(5,district);
            	pstmnt3.setString(6,state);
            	pstmnt3.setString(7,country);
            	pstmnt3.setString(8,pincode);
            	flag1=pstmnt3.executeUpdate();
            	System.out.println("employee added successfully"+ "to verify select view employee details option \n" );
            	break;
            	case 2: 
            		System.out.println("give employee id to get his/her details");
            		id=input.nextInt();
            		ResultSet rs=stmt.executeQuery("select * from employee join department where emp_id="+id);
            		while(rs.next()){
                    	id=rs.getInt("emp_id");
                    	name=rs.getString("emp_name");
                    	vehicle_no=rs.getString("vehicle_num");
                    	vehicle_type=rs.getString("vehicle_type");
                    	salary=rs.getInt("compensation");
                    	d_id=rs.getInt("dept_id");
                    	d_name=rs.getString("dept_name");
                    	System.out.println("id:"+id+"\nname:"+name+"\nvehicle number:"+vehicle_no+"\nvehicle type: "+vehicle_type+"\ncompensation: "+salary+"\ndepartment id: "+d_id+"\ndepartment: "+d_name);
            		}
                    	rs.close();
                    	rs=stmt.executeQuery("select * from contacts join adress on contacts.emp_id=adress.emp_id where contacts.emp_id="+id);
                    	while(rs.next()){
                    	cont1=rs.getString("contact1");
                    	cont2=rs.getString("contact2");
                    	dno=rs.getInt("flat_no");
                        street=rs.getString("street");
                        city=rs.getString("city");
                        district=rs.getString("district");
                        state=rs.getString("state");
                        country=rs.getString("country");
                        pincode=rs.getString("pincode");
                        System.out.print("contact number 1: "+cont1+"\ncontact number 2: "+cont2+"\nadress:\n "+dno+", "+street+"\n"+city+","+district+"\n"+state+","+country+"\n"+pincode);	
                    	}
            		rs.close();
     
            		break;
            	case 3: 
            		System.out.println("enter id of the employee to update his/her contact");
            		id=input.nextInt();
            		ResultSet rs2= stmt.executeQuery("select * from contacts where emp_id="+id);
            		while(rs2.next()){
            			id=rs2.getInt("emp_id");
            			cont1=rs2.getString("contact1");
            			cont2=rs2.getString("contact2");
            		System.out.println("contact details of employee are "+cont1+","+cont2);
            		}
            		System.out.println("enter 1 to change contact 1 or 2 for contact 2");;
            		int choice=input.nextInt();
            		if(choice==1){
            			System.out.println("enter new contact :");
            			cont1=input.next();
            			PreparedStatement pstmnt= conn.prepareStatement("update contacts set contact1= ? where emp_id= ?");
            			pstmnt.setString(1, cont1);
            			pstmnt.setInt(2,id);
            		   flag1=pstmnt.executeUpdate();
            		}
            		else if(choice==2)
            		{
            			System.out.println("enter new contact :");
            			cont2=input.next();
            			PreparedStatement pstmnt1= conn.prepareStatement("update contacts set contact2= ? where emp_id= ?");
            			pstmnt1.setString(1, cont2);
            			pstmnt1.setInt(2,id);
            			flag1=pstmnt1.executeUpdate();
            		}
            		else
            			System.out.println("wrong choice try again");
                   break;
            	case 4: 
            		System.out.println("enter employee id to delete his record");
            		id=input.nextInt();
            		flag1=stmt.executeUpdate("delete from employee where emp_id="+id);
            		break;
            	case 5:
            		stmt.close();
            		conn.close();
            		System.exit(0);
            	}
            	
            	}
            }
		}
		catch(Exception e)
		{
		
		System.out.println("not connected to the database");
		
		}
	}
	
}
