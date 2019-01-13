import java.util.Scanner;
import java.util.Vector;

public class Employee {
		
		private String name;
		private int id;
		private String desgn;
		private String dept;
		private String address;
		private Vector<String> cnumber;
		private String vehicle;
		private int compen;
		
		Employee()
		{
			cnumber = new Vector<String>();
		}
		
		public String getName() {
			return name;
		}

		public int getId() {
			return id;
		}

		public String getDesgn() {
			return desgn;
		}

		public String getDept() {
			return dept;
		}

		public String getAddress() {
			return address;
		}

		public Vector<String> getCnumber() {
			return cnumber;
		}

		public String getVehicle() {
			return vehicle;
		}

		public int getCompen() {
			return compen;
		}

		void createEmp()
		{
			Scanner input = new Scanner(System.in);
			
			System.out.println("Enter name: ");
			name = input.nextLine();
			
			System.out.println("Enter ID: ");
			id = input.nextInt();
			input.nextLine();
			
			System.out.println("Enter designation: ");
			desgn = input.nextLine();
			
			System.out.println("Enter department: ");
			dept = input.nextLine();
			
			System.out.println("Enter address: ");
			address = input.nextLine();
			
			System.out.println("Enter Contact Numbers (Enter -1 to exit): ");
			String cont = input.nextLine();
			
			while(!cont.equals("-1"))
			{
				cnumber.add(cont);
				cont = input.nextLine();
			}
			
			System.out.println("Enter vehicle Number: ");
			vehicle = input.nextLine();
			
			System.out.println("Enter compensation: ");
			compen = input.nextInt();
			
			input.close();
		}
		
		void createEmpWithId(int id)
		{
			Scanner input = new Scanner(System.in);
			
			System.out.println("Enter name: ");
			name = input.nextLine();
			
			this.id = id;
			
			System.out.println("Enter designation: ");
			desgn = input.nextLine();
			
			System.out.println("Enter department: ");
			dept = input.nextLine();
			
			System.out.println("Enter address: ");
			address = input.nextLine();
			
			System.out.println("Enter Contact Numbers (Enter -1 to exit): ");
			String cont = input.nextLine();
			
			while(!cont.equals("-1"))
			{
				cnumber.add(cont);
				cont = input.nextLine();
			}
			
			System.out.println("Enter vehicle Number: ");
			vehicle = input.nextLine();
			
			System.out.println("Enter compensation: ");
			compen = input.nextInt();
			
			input.close();
		}
		
}
