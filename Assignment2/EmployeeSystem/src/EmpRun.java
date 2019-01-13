import java.util.Scanner;

class EmpRun{  
	public static void main(String args[]){  
		try{    
			employee E=new employee();
			System.out.println("Select an option:\n1.Create\n2.Read\n3.Update\n4.Delete");
			Scanner sc=new Scanner(System.in);
			int i=sc.nextInt();
			switch(i) {
			case 1:
				Scanner S=new Scanner(System.in);
				
				System.out.println("Enter Employee ID:");
				String ID=S.nextLine();
				System.out.println("Enter Employee Name:");
				String Name=S.nextLine();
				System.out.println("Enter Designation:");
				String DESG=S.nextLine();
				System.out.println("Enter Department:");
				String DEPT=S.nextLine();
				System.out.println("Enter Permanent Address:");
				String P_ADD=S.nextLine();
				System.out.println("Enter Current Address:");
				String C_ADD=S.nextLine();
				System.out.println("Enter Work Address:");
				String W_ADD=S.nextLine();
				System.out.println("Enter Mobile No.:");
				String M_NO=S.nextLine();
				System.out.println("Enter Home No.:");
				String H_NO=S.nextLine();
				System.out.println("Enter Work No.:");
				String W_NO=S.nextLine();
				System.out.println("Enter Vehicle No.:");
				String V_NO=S.nextLine();
				System.out.println("Enter Vehicle Type:");
				String V_TYPE=S.nextLine();
				System.out.println("Enter Vehicle Model:");
				String V_MODEL=S.nextLine();
				System.out.println("Enter Vehicle Reg. Year:");
				String V_YEAR=S.nextLine();
				
				E.insert(ID,Name,DESG,DEPT,P_ADD,C_ADD,W_ADD,M_NO,H_NO,W_NO,V_NO,V_TYPE,V_MODEL,V_YEAR);
				break;
				
			case 2:
				System.out.println("Enter Employee ID:");
				Scanner S2=new Scanner(System.in);
				String ID2=S2.nextLine();
				E.read(ID2);
				break;
				
			case 3:
				System.out.println("Enter Employee ID:");
				Scanner S3=new Scanner(System.in);
				String ID3=S3.nextLine();
				System.out.println("Enter Field to Update:");
				String col=S3.nextLine();
				System.out.println("Enter a value:");
				String val=S3.nextLine();
				E.update(ID3, col, val);
				break;
				
			case 4:
				System.out.println("Enter Employee ID");
				Scanner S4=new Scanner(System.in);
				String ID4=S4.nextLine();
				E.delete(ID4);
				break;
			
			default:
				System.out.println("Invalid Choice");
				break;
			}
			
		
		
		}
		catch(Exception e)
		{ 
			System.out.println(e);
			}  
	}  
}  