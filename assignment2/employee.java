import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

class employee
{
	static final String dbclass="com.mysql.jdbc.Driver";
		employee()
		{
			
		int id, n,vehicle, compensation;
			String name, designation, department, address;
			int[] contactnum;
		Scanner sc = new Scanner(System.in);

		java.sql.Connection conn=null;
		
		try{
		//String url ="jdbc:mysql://localhost:3306/db";
		//String user ="root";
		//String password="password";
		Class.forName(dbclass).newInstance();
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db", "root", "password");
		//conn=DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException e)
		{
			System.out.println("error in loading driver"+e);
			System.exit(1);
		}
		catch(Exception e)
		{
			System.out.println("error in connection"+e);
			System.exit(0);
		}
		java.sql.Statement s=conn.createStatement();
		
		while (true) {
				System.out.println("\n1.Insert\n2.Delete\n3.Update\n4.Display\n5.Exit");
				System.out.println("Enter your choice : ");
				int ch = sc.nextInt();
				
				switch (ch) {
				case 1:
					System.out.println("Enter the Deatils");
					System.out.println("Enter ID : ");
					id = sc.nextInt();
					System.out.println("Enter Name : ");
					sc.nextLine();
					name = sc.nextLine();
					System.out.println("Enter Designation : ");
					designation = sc.nextLine();
					System.out.println("Enter Department : ");
					department = sc.nextLine();
					System.out.println("Enter Address : ");
					address = sc.nextLine();
					System.out.println("Enter number of Vehicles  : ");
					vehicle = sc.nextInt();
					System.out.println("Enter compensation : ");
					compensation = sc.nextInt();
					String query = "INSERT INTO employee " + "VALUES ('" + id + "','" + name + "','" + designation
							+ "','" + department + "','" + address + "','" + vehicle + "','" + compensation +"');";
					s.executeUpdate(query);
					System.out.println("Enter Num of Contact Numbers : ");
					n = sc.nextInt();
					contactnum = new int[n];
					for (int i = 0; i < n; i++) {
						System.out.println("Enter contact : " + i + 1);
						contactnum[i] = sc.nextInt();
						query = "INSERT INTO contacts " + "VALUES ('" + id + "','" + contactnum[i] + "')";
						s.executeUpdate(query);
						System.out.println(contactnum[i]);
					}
					System.out.println("Inserted successfully");
					break;
				case 2:
					int id1;
					System.out.println("Enter ID : ");
					id1 = sc.nextInt();
					s.executeUpdate("DELETE FROM contactnum WHERE cid= " + id1 + ";");
					s.executeUpdate("DELETE FROM employee WHERE id= " + id1 + ";");
					break;
				case 3:System.out.println("Enter the id of employee");
						id = sc.nextInt();
						
					System.out.println("Enter Designation : ");
					designation = sc.nextLine();
					System.out.println("Enter Department : ");
					department = sc.nextLine();
					System.out.println("Enter Address : ");
					address = sc.nextLine();
					System.out.println("Enter number of Vehicles  : ");
					vehicle = sc.nextInt();
					System.out.println("Enter compensation : ");
					compensation = sc.nextInt();
					PreparedStatement pstmnt= conn.prepareStatement("update employee set designation=?,department=?,address=?,vehicles=?,compensation=? where id"+id);
					pstmnt.setString(1,designation);
					pstmnt.setString(2,department);
					pstmnt.setString(3,address);
					pstmnt.setInt(4,vehicle);
					pstmnt.setInt(5,compensation);
					int flag=pstmnt.executeUpdate();
					break;
				case 4:
					ResultSet rs = s.executeQuery(
							"SELECT id,name,designation,c.number,department,address,vehicles,compensation FROM employee,contactnum as c WHERE id=cid");
					while (rs.next())
						System.out.println(rs.getInt("id") + "  " + rs.getString("name") + "  " + rs.getString("designation") + "  "
								+ rs.getString("contact") + "  " + rs.getString("department") + "  " + rs.getString("address") + "  "
								+ rs.getInt("vehicles") + "  " + rs.getInt("compensation"));
					break;
				case 5:
					System.exit(0);
					break;

				default:
					System.out.println("Invalid Input!!");
					break;
				}
				
			}
		}
		public static void main(String args[])
		{
			
					new employee();
				
			
		}
	
}

