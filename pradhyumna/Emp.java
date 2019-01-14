package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Emp {

	public static void main(String[] args)
	{
		Connection con=null;
		try
		{
			int id, n;
			String name, designation, department, address, vehicle, compensation;
			String[] contactnum;

			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "");
			// here sonoo is database name, root is username and password
			System.out.println("Connection successful");
			Statement stmt = con.createStatement();
			Scanner sc = new Scanner(System.in);
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
					System.out.println("Enter Vehicle Number : ");
					vehicle = sc.nextLine();
					System.out.println("Enter compensation : ");
					compensation = sc.nextLine();
					String query = "INSERT INTO employee " + "VALUES ('" + id + "','" + name + "','" + designation
							+ "','" + department + "','" + address + "','" + vehicle + "','" + compensation + "');";
					stmt.executeUpdate(query);
					System.out.println("Enter Num of Contact Numbers : ");
					n = sc.nextInt();
					contactnum = new String[n];
					for (int i = 0; i < n; i++) {
						System.out.println("Enter contact : " + i + 1);
						contactnum[i] = sc.next();
						query = "INSERT INTO contactnum " + "VALUES ('" + id + "','" + contactnum[i] + "')";
						stmt.executeUpdate(query);
						System.out.println(contactnum[i]);
					}
					System.out.println("Inserted successfully");
					break;
				case 2:
					int id1;
					System.out.println("Enter ID : ");
					id1 = sc.nextInt();
					stmt.executeUpdate("DELETE FROM contactnum WHERE cid= " + id1 + ";");
					stmt.executeUpdate("DELETE FROM employee WHERE id= " + id1 + ";");
					break;
				case 3:

					System.out.println("Enter the id of employee");
                    id = sc.nextInt();
                    sc.nextLine();
                System.out.println("Enter Designation : ");
                designation = sc.nextLine();
                System.out.println("Enter Department : ");
                department = sc.nextLine();
                System.out.println("Enter Address : ");
                address = sc.nextLine();
                System.out.println("Enter Vehicle number  : ");
                vehicle = sc.nextLine();
                System.out.println("Enter compensation : ");
                compensation = sc.nextLine();
                query= "update employee set designation='"+designation+"', address='"+address+"', veh_deatils='"+vehicle+"',compensation='"+compensation+"' where id='"+id+"';";
                stmt.executeUpdate(query);
					break;
				case 4:
					ResultSet rs = stmt.executeQuery(
							"SELECT id,name,designation,c.number,department,address,veh_deatils,compensation FROM employee,contactnum as c WHERE id=cid");
					while (rs.next())
						System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  "
								+ rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6) + "  "
								+ rs.getString(7) + "  " + rs.getString(8));
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
		catch (Exception e)
		{
			System.out.println(e);
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
