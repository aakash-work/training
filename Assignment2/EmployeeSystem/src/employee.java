import java.sql.*;


public class employee extends Vehicle{
	private String e_id;
	private String e_name;
	private String Desg;
	private String Dept;
	
	Connection conn = null;
	Statement stmt = null;
		
	public void insert(String ID, String name, String Desg, String Dept,String P_ADD,String C_ADD,String W_ADD,String M_NO,String H_NO,String W_NO,String V_ID,String V_type,String V_model,String V_year) {
		this.e_id=ID;
		this.e_name=name;
		this.Desg=Desg;
		this.Dept=Dept;
		this.P_Add=P_ADD;
		this.C_Add=C_ADD;
		this.W_Add=W_ADD;
		this.M_NO=M_NO;
		this.H_NO=H_NO;
		this.W_NO=W_NO;
		this.V_ID=V_ID;
		this.V_type=V_type;
		this.V_model=V_model;
		this.V_year=V_year;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/TEST?verifyServerCertificate=false&useSSL=true","root","");   
			Statement stmt=con.createStatement();
			String q_insert_emp="INSERT into EMPLOYEE values('"+e_id+"','"+e_name+"','"+Desg+"','"+Dept+"','"+V_ID+"')";
			stmt.executeUpdate(q_insert_emp);
			
			//ADDRESS
			if(!P_Add.equals("")) {
				String q_ins_P_Add="INSERT into ADDRESS values('"+e_id+"','"+P_Add+"','P')";
				stmt.executeUpdate(q_ins_P_Add);
			}
			if(!C_Add.equals("")) {
				String q_ins_C_Add="INSERT into ADDRESS values('"+e_id+"','"+C_Add+"','C')";
				stmt.executeUpdate(q_ins_C_Add);
			}
			if(!W_Add.equals("")) {
				String q_ins_W_Add="INSERT into ADDRESS values('"+e_id+"','"+W_Add+"','W')";
				stmt.executeUpdate(q_ins_W_Add);
			}
			
			
			//CONTACT
			if(!M_NO.equals("")) {
				String q_ins_M_NO="INSERT into CONTACT values('"+e_id+"','"+M_NO+"','M')";
				stmt.executeUpdate(q_ins_M_NO);
			}
			if(!H_NO.equals("")) {
				String q_ins_H_NO="INSERT into CONTACT values('"+e_id+"','"+H_NO+"','H')";
				stmt.executeUpdate(q_ins_H_NO);
			}
			if(!W_NO.equals("")) {
				String q_ins_W_NO="INSERT into CONTACT values('"+e_id+"','"+W_NO+"','W')";
				stmt.executeUpdate(q_ins_W_NO);
			}
			
			//VEHICLE
			String q_ins_veh="INSERT into VEHICLE values('"+V_ID+"','"+V_type+"','"+V_model+"','"+V_year+"')";
			stmt.executeUpdate(q_ins_veh);
			
			System.out.println("Record Inserted!");
			
			con.close();
	}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void read(String E_ID) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/TEST?verifyServerCertificate=false&useSSL=true","root","");   
			Statement stmt=con.createStatement();
			String q_read="select * from EMPLOYEE where employee_ID='"+E_ID+"'";
			ResultSet rs=stmt.executeQuery(q_read);
			
			while (rs.next())
		      {
		        String e_id = rs.getString("employee_ID");
		        String e_name = rs.getString("employee_name");
		        String desg = rs.getString("designation");
		        String dept = rs.getString("department");
		        this.V_ID = rs.getString("vehicle_id");
		        
		        System.out.println("Employee Id:"+e_id);
				System.out.println("Employee Name:"+e_name);
				System.out.println("Designation:"+desg);
				System.out.println("Department:"+dept);
		        
		        // print the results
		        //System.out.format("%s, %s, %s, %s, %s\n", e_id, e_name, desg, dept, V_ID);
		      }
			
			String q_read_add="select Address from ADDRESS where employee_ID='"+E_ID+"'";
			ResultSet rs2=stmt.executeQuery(q_read_add);
			String[] ADD=new String[3];
			int count=0;
			System.out.println("Addresses:-");
			while(rs2.next()) {
				
				ADD[count]=rs2.getString("Address");
				count++;
				System.out.println(count+". "+ADD[count-1]);
			}
			
			String q_read_Con="select Number from CONTACT where employee_ID='"+E_ID+"'";
			Statement st=con.createStatement();
			ResultSet rs3=st.executeQuery(q_read_Con);
			String[] CON=new String[3];
			count=0;
			System.out.println("Contact Numbers:-");
			while(rs3.next()) {
				CON[count]=rs3.getString("Number");
				count++;
				System.out.println(count+". "+CON[count-1]);
			}
			
			String q_read_veh="select * from VEHICLE where vehicle_id='"+this.V_ID+"'";
			ResultSet rs4=st.executeQuery(q_read_veh);
			System.out.println("Vehicle Details:-");
			while(rs4.next()) {
				String v_id=rs4.getString("vehicle_id");
				String v_type=rs4.getString("vehicle_type");
				String v_model=rs4.getString("vehicle_model");
				String v_year=rs4.getString("vehicle_year");
				
				System.out.println("Vehicle ID:"+v_id);
				System.out.println("Vehicle type:"+v_type);
				System.out.println("Vehicle model:"+v_model);
				System.out.println("Vehicle year:"+v_year);
			}
				
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void update(String E_ID,String col,String value) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/TEST?verifyServerCertificate=false&useSSL=true","root","");   
			Statement stmt=con.createStatement();
			//System.out.println(q_upd);
			
			String q_upd="UPDATE EMPLOYEE SET "+col+"='"+value+"' where employee_ID='"+E_ID+"'";
			stmt.executeUpdate(q_upd);
			
		
			System.out.println("Field updated sucessfully!");
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete(String E_ID) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/TEST?verifyServerCertificate=false&useSSL=true","root","");   
			Statement stmt=con.createStatement();
			String query="select vehicle_id from EMPLOYEE where employee_ID='"+E_ID+"'";
			ResultSet R=stmt.executeQuery(query);
			while(R.next()) {
				this.V_ID=R.getString("vehicle_id");
			}
			
			String q_del_emp="Delete from EMPLOYEE where employee_ID='"+E_ID+"'";
			stmt.executeUpdate(q_del_emp);
			
			String q_del_add="Delete from ADDRESS where employee_ID='"+E_ID+"'";
			stmt.executeUpdate(q_del_add);
					
			String q_del_con="Delete from CONTACT where employee_ID='"+E_ID+"'";
			stmt.executeUpdate(q_del_con);
			
			String q_del_veh="Delete from VEHICLE where vehicle_id='"+this.V_ID+"'";
			stmt.executeUpdate(q_del_veh);
					
			System.out.println("Field deleted sucessfully!");
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
}


