import java.sql.*;  
import java.util.Scanner;
class EMS{ 
    
    Scanner in = new Scanner(System.in);            
    public void create(int x){
        
        try{
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/EMS1","rati","root");  
        //here sonoo is database name, root is username and password  
        Statement stmt=con.createStatement(); 
    
        System.out.println("Enter the following details: \nEmployee Id: ");
        int Emp_id=in.nextInt();
        in.nextLine();
            
        if(x==1){
            String sq= "delete from EMPLOYEE where Emp_id="+Emp_id+";";
            int r = stmt.executeUpdate(sq);
        }
        
        System.out.println("Name: ");
        String Name = in.nextLine();
        
        System.out.println("Designation: ");
        String Designation = in.nextLine();
        
        System.out.println("Salary: ");
        String Salary = in.nextLine();
        
        System.out.println("Department:\n1.Sales\n2.Marketing\n3.Tech\n4.Analyst\n");
        int Dept_id = in.nextInt();
        /*Switch(dept){
            case '1':
                        
                        break;
            case '2':
                        break;
            case '3':
                        break;
            case '4':
                        break;
            default:
                        System.out.println("Invalid choice");
            
            
        }*/
        System.out.println("Number of Addresses: ");
        int numAdd = in.nextInt();
        in.nextLine();
        String[] Address = new String[numAdd];
        for(int i =0;i<numAdd;i++){
            System.out.println("Address "+i+" : ");
            Address[i] = in.nextLine();
        }
        
        System.out.println("Number of contacts: ");
        int numCon = in.nextInt();
        in.nextLine();
        String[] Contact = new String[numCon];
        for(int i =0;i<numCon;i++){
            System.out.println("Contact "+i+" : ");
            Contact[i] = in.nextLine();
        }
        
        System.out.println("Number of vehicle: ");
        int numVeh = in.nextInt();
        in.nextLine();
        String [][] Vehicle = new String[numVeh][2];
        
        for(int i =0;i<numVeh;i++){
            System.out.println("Vehicle "+i+" details: ");
            System.out.println("Registration Number: ");
            Vehicle[i][0] = in.nextLine();
            System.out.println("Vehicle type: ");
            Vehicle[i][1] = in.nextLine();
        }
        
        
        String sql1 = "insert into EMPLOYEE(Emp_id,Name, Designation,Salary,Dept_id)values('"+Emp_id+"','"+Name+"','"+Designation+"','"+Salary+"','"+Dept_id+"');";
            stmt.executeUpdate(sql1);
        for(int i=0;i<numAdd;i++){
            String sql2 = "insert into ADDRESS(Line1,Emp_Id)values('"+Address[i]+"','"+Emp_id+"');";
            stmt.executeUpdate(sql2);
        }
        for(int i=0;i<numCon;i++){
            String sql3 = "insert into CONTACT(Phone_no,Emp_Id)values('"+Contact[i]+"','"+Emp_id+"');";
            stmt.executeUpdate(sql3);
        }
        
        for(int i=0;i<numVeh;i++){
            String sql4 = "insert into VEHICLE(Reg_no,Type,Emp_Id)values('"+Vehicle[i][0]+"','"+Vehicle[i][1]  +"','"+Emp_id+"');";
            stmt.executeUpdate(sql4);
        }
            

        con.close();
        }catch(Exception e){ System.out.println(e);}
        
    }
    
    
    
    
    public void retrieve(){
        try{
        System.out.println("Enter the Emp_id to fetch data: ");
        int Emp_id = in.nextInt();
        String sqlE = "select Name,Designation,Salary,Dept_name from EMPLOYEE natural join DEPARTMENT where Emp_id ="+Emp_id+";";
        
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/EMS1","rati","root");  
        //here sonoo is database name, root is username and password  
        Statement stmt=con.createStatement();    
        ResultSet rs = stmt.executeQuery(sqlE);
            
        String sqlA = "select Line1 from ADDRESS where Emp_id ="+Emp_id+";"; 
        Statement stmt1=con.createStatement(); 
        ResultSet rs1 = stmt1.executeQuery(sqlA);
            
        String sqlC = "select Phone_no from CONTACT where Emp_id="+Emp_id+";";   
        Statement stmt2=con.createStatement(); 
        ResultSet rs2 = stmt2.executeQuery(sqlC);
            
        String sqlV = "select Reg_no,Type from VEHICLE where Emp_id="+Emp_id+";";
        Statement stmt3=con.createStatement(); 
        ResultSet rs3 = stmt3.executeQuery(sqlV);
           
        System.out.println("______________________________________________________________________________________________________\nNAME  | DESIGNATION  | SALARY | DEPARTMENT | ADDRESS  |   PHONE NO    | VEHICLE_REG-NO  |VEHICLE_TYPE\n------------------------------------------------------------------------------------------------------");
        while(rs.next())
            System.out.print(rs.getString(1)+" |     "+rs.getString(2)+"     |  "+rs.getString(3)+"  | "+rs.getString(4));
        while(rs1.next())
            System.out.print("   |   "+rs1.getString(1));
        while(rs2.next())
            System.out.print("  |  "+rs2.getString(1));
        while(rs3.next())
            System.out.println("  |    "+rs3.getString(1)+"      |  "+rs3.getString(2)+" |");
            
        System.out.println("______________________________________________________________________________________________________");
        con.close();
        }catch(Exception e){System.out.println(e);}
        
        
    }
    
    public void delete(){
        
        try{
            
            System.out.println("Enter the Employee id: ");
            int Emp_id = in.nextInt();
            in.nextLine();
            System.out.println("Enter the field to be deleted\n1.Employee Info\n2.Vehicle Info\n3.Contact Info\n4.Employee's Address\n5.Department");
            int inp = in.nextInt();
            in.nextLine();
            String sql="";
            switch(inp){
            case 1: 
                        sql = "delete from EMPLOYEE where Emp_id ="+Emp_id+";";
                        break;
            case 2:
                        sql = "delete from VEHICLE where Emp_id ="+Emp_id+";";
                        break;
            case 3:
                        sql = "delete from CONTACT where Emp_id ="+Emp_id+";";
                        break;
            case 4:
                        sql = "delete from ADDRESS where Emp_id ="+Emp_id+";";
                        break;
            case 5:
                        sql = "delete from DEPARTMENT where Emp_id ="+Emp_id+";";
                        break;
            default:
                        System.out.println("Invalid choice"); 
            
        } 
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/EMS1","rati","root");  
            //here sonoo is database name, root is username and password  
            Statement stmt=con.createStatement(); 
            int rows = stmt.executeUpdate(sql);
         
        }catch(Exception e){System.out.println(e);}
           
        
    }
    
    
    
    
    public static void main(String args[]){  
    try{  
        
            Test ob = new Test();
        
    /*
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/EMS","rati","root");  
            //here sonoo is database name, root is username and password  
            Statement stmt=con.createStatement(); 
    */
            
        
        
            System.out.println("Enter\n1.Create\n2.Retrieve\n3.Update\n4.Delete an entry ");
            int i = ob.in.nextInt();
        
            switch(i)
            {
                case 1:     ob.create(0);
                            break;
                case 2:
                            ob.retrieve();
                            break;
                case 3:
                            ob.create(1);
                            break;
                case 4: 
                            ob.delete();
                            break;
                default:
                            System.out.println("Invalid choice  Try again");
                            break;
                
                   
            }
        
  /*          String var = "Name";
            ResultSet rs=stmt.executeQuery("select "+var+" from EMPLOYEE limit 5");  
            while(rs.next()) {
                System.out.println(rs.getString(1));
                //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4)); 
            }
            

            con.close();  
*/
        }catch(Exception e){ System.out.println(e);}  
    }  
}  
