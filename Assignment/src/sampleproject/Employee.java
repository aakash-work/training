package sampleproject;
import java.util.Scanner;

public class Employee {
	protected int empId;
	protected  String empFname,empLname,empDesignation,empDept;
	protected  String corrAdd,permAdd;
	protected  String contact1,contact2="";
	protected  String vehNo = "";
	protected  double salary;
	
	Scanner input = new Scanner(System.in);
   
	protected void readEmployeeDetails()
	{
		System.out.println("Enter the following details : ");
		System.out.print("ID                     : ");
		empId = input.nextInt();
		System.out.print("First Name             : ");
		empFname = input.next();
		System.out.print("Last Name              : ");
		empLname = input.next();
		readDetails();
	}
	
	protected void readDetails()
	{
		System.out.print("Designation            : ");
		input.nextLine();
		empDesignation = input.nextLine();
		System.out.print("Department             : ");
		empDept = input.nextLine();
		System.out.print("Corresponding Address  : ");
		corrAdd = input.nextLine();
		System.out.print("Permanent Address      : ");
		permAdd = input.nextLine();
		System.out.print("Contact Number(1)      : ");
		contact1 = input.nextLine();
		boolean result = isInteger(contact1);
		while(contact1.length()!=10 || result!=true)
		{
			System.out.print("Contact Number(1)      : ");
			contact1 = input.nextLine();
			result = isInteger(contact1);
		}
		System.out.print("Contact Number(2)      : ");
		contact2 = input.nextLine();
		if(contact2.length()!=0)
		{
			result = isInteger(contact2);
			while(contact2.length()!=10 || result!=true)
			{
				System.out.print("Contact Number(2)      : ");
				contact2 = input.nextLine();
				result = isInteger(contact2);
			}
		}
		System.out.println("Vehicle Number        : ");
		vehNo = input.nextLine();
		if(vehNo.length()!=0)
		{
			while(vehNo.length()!=9)
			{
				System.out.println("Vehicle Number        : ");
				vehNo = input.nextLine();
			}
		}
		System.out.println("Compenasation         : ");
		salary = input.nextDouble();
	}
	
	private boolean isInteger(String str)
	{
		if(str.matches(".*\\d+.*"))
			return true;
		else
			return false;
	}
}
