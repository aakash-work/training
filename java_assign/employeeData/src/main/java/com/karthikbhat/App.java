package com.karthikbhat;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {

        Scanner input = new Scanner(System.in);
        int flag = 1;
        do {
            System.out.println("Enter an integer \n1 : Add an employee\n 2 : Update info of an employee \n 3 : Get the info of an employee \n 4: Remove an employee\n 5 : Exit");
            int us_in = input.nextInt();
            input.nextLine();
            if(us_in <= 0 && us_in >= 6){
                System.out.println("Input appropriate choice \n");
                continue;
            }
            else if(us_in == 5){
                System.out.println("Exiting \n");
                System.exit(0);
                break;
            }
            else{
//                    switch (us_in){
//                        case 1 :
//                    }
                switch (us_in){
                    case 1:
                        Employee employee = new Employee();

                        try {
                            System.out.println("Name :");
                            employee.setName(input.nextLine());

                            System.out.println("Id :");
                            employee.setId(input.nextLine());

                            Address address = new Address();
                            System.out.println("Permanent address :");
                            address.setPermanentAddress(input.nextLine());

                            System.out.println("Current address :");
                            address.setCurrentAddress(input.nextLine());

                            address.setId(employee.getId());

                            employee.setAddress(address);


                            System.out.println("Contact number :");
                            employee.setContactNumber(input.nextLine());

                            System.out.println("Department :");
                            employee.setDepartment(input.nextLine());

                            System.out.println("Designation :");
                            employee.setDesignation(input.nextLine());

                            System.out.println("Vehicle Details :");
                            employee.setVehicleDetails(input.nextLine());

                            System.out.println("Compensation :");
                            employee.setCompensation(input.nextInt());

                            DBOps.addEmp(employee);

                        }

                        catch(Exception ex){
                            System.out.println("Database error :"+ex);

                        }
                        break;
                    case 2:
                        employee = new Employee();

                        try {

                            System.out.println("Id :");
                            employee.setId(input.nextLine());

                            System.out.println("Name :");
                            employee.setName(input.nextLine());

                            Address address = new Address();
                            System.out.println("Permanent address :");
                            address.setPermanentAddress(input.nextLine());

                            System.out.println("Current address :");
                            address.setCurrentAddress(input.nextLine());

                            address.setId(employee.getId());

                            employee.setAddress(address);


                            System.out.println("Contact number :");
                            employee.setContactNumber(input.nextLine());

                            System.out.println("Department :");
                            employee.setDepartment(input.nextLine());

                            System.out.println("Designation :");
                            employee.setDesignation(input.nextLine());

                            System.out.println("Vehicle Details :");
                            employee.setVehicleDetails(input.nextLine());

                            System.out.println("Compensation :");
                            employee.setCompensation(input.nextInt());

                            DBOps.updateEmp(employee);

                        }

                        catch(Exception ex){
                            System.out.println("Database error :"+ex);
                        }
                        break;
                    case 3: System.out.println("Employee id :" );
                            String s1 = input.nextLine();
                            employee = DBOps.getEmp(s1);
                            if(employee == null)
                                System.out.println("Employee does not exist");
                            else
                                System.out.println(employee.toString());
                            break;
                    case 4: System.out.println("Employee id : ");
                            String s = input.nextLine();
                            DBOps.delEmp(s);
                            break;
                    default: flag = 0;

                            break;



                }

            }
        }while(flag == 1);
    }
}
