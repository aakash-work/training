package com.pratik;

import java.sql.Connection;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static DbOps dbContext;
    public static Scanner input = new Scanner(System.in);
    public static void main( String[] args )
    {
        System.out.println( "Starting Application");

        //String name = input.nextLine();

        dbContext = new DbOps();

        Connection con = dbContext.connect();

        try(Statement stmt = (Statement)con.createStatement()) {
            String st1 = "CREATE TABLE IF NOT EXISTS employees "+
            "(employeeid integer, " +
            "name varchar(255), " +
            "designation varchar(255), " +
            "department varchar(255), " +
            "compensation integer, " +
            "PRIMARY KEY ( employeeid ))";

            stmt.executeUpdate(st1);

            String st2 = "CREATE TABLE IF NOT EXISTS address "+
            "(employeeid integer," +
            "street varchar(255), "+
            "city varchar(255), "+
            "state varchar(255), "+
            "country varchar(255), "+
            "FOREIGN KEY(employeeid) REFERENCES employees(employeeid))";

            stmt.executeUpdate(st2);


            String st3 = "CREATE TABLE IF NOT EXISTS contact " +
            "(employeeid integer, "+
            "home integer, "+
            "office integer, "+
            "personal integer, "+ 
            "FOREIGN KEY(employeeid) REFERENCES employees(employeeid))";

            stmt.executeUpdate(st3);

            String st4 = "CREATE TABLE IF NOT EXISTS vehicle "+
            "(employeeid integer, "+
            "name varchar(255), "+
            "number varchar(255), "+
            "FOREIGN KEY(employeeid) REFERENCES employees(employeeid))";

            stmt.executeUpdate(st4);

            System.out.println("Database done!");
        } catch (Exception e) {
            System.out.println("Error in executing db creation scripts");
        }

        int selection;

        Employee emp = new Employee();

        do{
            System.out.println( "1. Create" );
            System.out.println( "2. Read" );
            System.out.println( "3. Update" );
            System.out.println( "4. Delete" );
            System.out.println( "5. Exit" );

            System.out.println("Please enter your choice: ");

            Scanner in = new Scanner(System.in);
            selection = in.nextInt();

            switch (selection) {
                case 1:
                    //Create
                    emp.createEmployee();
                    break;
                
                case 2:
                    //Read

                case 3:
                    //Update

                case 4:
                    //Delete
            
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }while(selection != 5);
    }
}
