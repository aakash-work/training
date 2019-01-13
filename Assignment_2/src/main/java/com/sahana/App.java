package com.sahana;

import java.util.Scanner;



public class App 
{
    public static Scanner in = new Scanner(System.in);  // Reading from System.in
    public static void main( String[] args )
    {
        int ch;

        Employee e = new Employee();

        do{
            System.out.println( "1. Insert a record" );
            System.out.println( "2. Update an employee's department" );
            System.out.println( "3. Display a record" );
            System.out.println( "4. Delete a record" );
            System.out.println( "5. Exit" );

            System.out.println("Enter your choice: ");
            ch = in.nextInt();
            in.nextLine();
            System.out.println("choice: " + ch);

            switch (ch) {
                case 1:
                    e.createEmployee();
                    break;
                case 2:
                    e.updateEmployee();
                    break;
                case 3:
                    e.displayEmployee();
                    break;
                case 4:
                    e.deleteEmployee();
                    break;
            }
        } while(ch!=5);
        in.close();
    }
}
