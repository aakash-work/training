package com.swetha;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Employee manager
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Employee Management System" );
        Scanner sc=new Scanner(System.in);
        int cont=1;
        int empId;
        int ch;
        do{
            System.out.println("-----------------------------------------------------------");
            System.out.println("1- Insert Employee records");
            System.out.println("2- Add Contact number");
            System.out.println("3- Add/update Vehicle details");
            System.out.println("4- Display Employee details");
            System.out.println("5- Update Employee Compensation");
            System.out.println("6- Delete Employee Record");
            System.out.println("-----------------------------------------------------------");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:

                    String name;
                    String des;
                    String dep;
                    int comp;
                    System.out.println("Enter Employee ID:");
                    empId=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name:");
                    name=sc.nextLine();
                    System.out.println("Enter designation:");
                    des=sc.nextLine();
                    System.out.println("Enter department:");
                    dep=sc.nextLine();
                    System.out.println("Enter compensation:");
                    comp=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Address details");
                    System.out.println("Enter house no/building name:");
                    String house=sc.nextLine();
                    System.out.println("Enter street name:");
                    String street=sc.nextLine();
                    System.out.println("Enter city:");
                    String city=sc.nextLine();
                    System.out.println("Enter country:");
                    String country=sc.nextLine();
                    System.out.println("Provide contact info(max of 3):");
                    int ph,phcnt=1,phch=1;
                    ArrayList<Integer> contact=new ArrayList<Integer>();
                    do{
                        ph=sc.nextInt();
                        contact.add(ph);
                        phcnt++;
                        System.out.println("Enter 1 to add another contact");
                        phch=sc.nextInt();

                    }while(phcnt<=3 && phch==1);
                    Employee e1=new Employee(empId,name,dep,des,comp,contact,house,street,city,country);
                    break;
                case 2:
                    System.out.println("Enter Employee ID:");
                    empId=sc.nextInt();
                    System.out.println("Provide contact info(max of 3):");
                    int pho=sc.nextInt();
                    Employee.addContact(empId,pho);
                    break;
                case 3:
                    System.out.println("Enter Employee ID:");
                    empId=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter vehicle regno:");
                    String regNo=sc.nextLine();
                    System.out.println("Enter vehicle type:");
                    String type=sc.nextLine();
                    Employee.addVehicle(empId,regNo,type);
                    break;
                case 4:
                    System.out.println("Enter Employee ID:");
                    empId=sc.nextInt();
                    Employee.readInfo(empId);
                    break;
                case 5:
                    System.out.println("Enter Employee ID:");
                    empId=sc.nextInt();
                    System.out.println("Enter compensation:");
                    comp=sc.nextInt();
                    Employee.updateComp(empId,comp);
                    break;
                case 6:
                    System.out.println("Enter Employee ID:");
                    empId=sc.nextInt();
                    Employee.deleteEmp(empId);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;

            }
            System.out.println("Enter -1 to quit");
            cont=sc.nextInt();
        }while(cont!=-1);
        Employee.finish();

    }
}
