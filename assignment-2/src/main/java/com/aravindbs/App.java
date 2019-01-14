package com.aravindbs;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.ObjectOutputStream;

public class App
{
    private static EmployeeDAOImpl emp_db = new EmployeeDAOImpl();
    public static void main( String[] args )
    {
        try {
            System.out.println("Choose an option\n 1. Add a new employee\n 2. Update Employee\n 3. Get employee details\n4. Delete Employee\n5. Exit\n ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();

            switch (str.charAt(0)) {
                case '1': {
                    System.out.println(str);
                    App.addEmployee();
                    break;
                }

                case '2': {
                    System.out.println("Enter Employee ID");
                    String in = reader.readLine();
                    System.out.println(Long.parseLong(in));
                    Employee e = emp_db.getEmployee(Long.parseLong(in));
                    System.out.println(e);
                    break;
                }
                case '3': {
                    System.out.println("Enter Employee ID");
                    String in = reader.readLine();
                    System.out.println(Long.parseLong(in));
                    boolean del = emp_db.deleteEmployee(Long.parseLong(in));
                    System.out.println(del);
                    break;
                }



            }
        }
        catch ( IOException exp ){
            System.out.println(exp);
        }
        System.out.println( "Hello World!" );
    }

    public static void addEmployee() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the first name");
        String first_name = reader.readLine();
        System.out.println(first_name);

        System.out.println("Enter the last name");
        String last_name = reader.readLine();
        System.out.println(last_name);

        System.out.println("Enter the designation");
        String designation = reader.readLine();

        System.out.println("Enter the department");
        String department = reader.readLine();

        System.out.println("Enter the employee id");
        String strEmpId = reader.readLine();
        Long employee_id = Long.parseLong( strEmpId );


        System.out.println("Enter Perm .Address");
        Address perm_addr = getAddress("PERM");

        System.out.println("Enter Cur .Address");
        Address cur_addr = getAddress("CURR");

        System.out.println("Enter Mobile No");
        String mob = reader.readLine();

        System.out.println("Enter Compensation");
        String strComp = reader.readLine();
        Double compensation = Double.parseDouble ( strComp );

        Employee e =  new Employee(first_name,last_name, designation, department, employee_id, perm_addr, cur_addr, mob, compensation);
        emp_db.addEmployee(e);

    }

    public static Address getAddress(String type) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter door no");
        String no = reader.readLine();

        int door_no = Integer.parseInt(no);

        System.out.println("Enter street_name");
        String street_name = reader.readLine();

        System.out.println("Enter locality");
        String locality = reader.readLine();

        System.out.println("Enter city");
        String city = reader.readLine();

        System.out.println("Enter state");
        String state = reader.readLine();

        System.out.println("Enter country");
        String country = reader.readLine();

        System.out.println("Enter pin code");
        int pin_code = reader.read();

        return new Address(door_no, street_name, locality, city, state, country, pin_code, type);

    }


}
