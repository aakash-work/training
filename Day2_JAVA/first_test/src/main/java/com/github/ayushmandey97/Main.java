package com.github.ayushmandey97;


import java.util.Scanner;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Main {

    public static void main(String[] args) throws IOException {

        int choice, id;
        do{

            System.out.println("****** MENU *******");
            System.out.println("1. Insert an employee");
            System.out.println("2. Get details of an employee");
            System.out.println("3. Update the details of an employee");
            System.out.println("4. Delete an employee");
            System.out.println("5. Exit");

            Scanner s = new Scanner(System.in);
            choice = s.nextInt();

            Main crud = new Main();

            switch(choice){
                case 1:
                    System.out.println("**** EMPLOYEE CREATION ******");
                    crud.create_data();
                    break;

                case 2:
                    System.out.println("Enter the ID of the employee to be retrieved: ");
                    id = s.nextInt();
                    crud.read_data(id);
                    break;

                case 3:
                    System.out.println("Enter the ID of the employee to be updated: ");
                    id = s.nextInt();
                    crud.update_data(id);
                    break;

                case 4:
                    System.out.println("Enter the ID of the employee to be deleted: ");
                    id = s.nextInt();
                    crud.delete_data(id);
                    break;

                case 5:
                    System.out.println("**** TERMINATED ****");
                    System.exit(0);
                    break;
            }

        }while(choice !=5);

    }

    public void create_data(){
        dbConnection conn= new dbConnection() ;
        Connection connection=conn.get_connection();
        PreparedStatement ps = null;
        Scanner s = new Scanner(System.in);
        try {

            System.out.println("---- Enter the details for the new employee ---- ");
            System.out.println("Enter name: ");
            String name = s.nextLine();

            System.out.println("Enter department: ");
            String dept = s.nextLine();

            System.out.println("Enter desgination: ");
            String desig = s.nextLine();

            System.out.println("Enter compensation: ");
            int comp = s.nextInt();

            String query="insert into employee(name, designation, department, compensation) values (?,?,?,?)";
            ps=connection.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, desig);
            ps.setString(3, dept);
            ps.setInt(4, comp);
            System.out.println(ps);
            ps.executeUpdate();

            query="SELECT `AUTO_INCREMENT` FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'emp' AND TABLE_NAME = 'employee';";
            ps=connection.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            rs.next();
            int id = rs.getInt("auto_increment") - 1;

            int ch = 0;
            do{
                s.nextLine();
                System.out.println("Enter a phone number: ");
                String num = s.nextLine();

                query="insert into contact_num (emp_id, number) values (?,?)";
                ps=connection.prepareStatement(query);
                ps.setInt(1, id);
                ps.setString(2, num);

                System.out.println(ps);
                ps.executeUpdate();

                System.out.println("Do you want to enter more phone numbers? (Press 1 for yes)");
                ch = s.nextInt();

            }while(ch == 1);


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void read_data(int id){
        dbConnection conn = new dbConnection();
        Connection connection = conn.get_connection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query="select * from employee where emp_id = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            rs.next();

            System.out.println("Name: "+rs.getString("name"));
            System.out.println("Department: "+rs.getString("department"));
            System.out.println("Designation: "+rs.getString("designation"));
            System.out.println("Compensation: "+rs.getString("compensation"));

            //Displaying the phone numbers
            query="select number from contact_num where emp_id = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            System.out.println("The available phone numbers are:");
            while(rs.next()){
                System.out.println(rs.getString("number"));
            }

            System.out.println("*********************************");



        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update_data(int id){
        dbConnection conn=new dbConnection();
        Connection connection=conn.get_connection();
        Scanner s = new Scanner(System.in);

        System.out.println("---- Enter the updated details ---- ");
        System.out.println("Enter name: ");
        String name = s.nextLine();

        System.out.println("Enter department: ");
        String dept = s.nextLine();

        System.out.println("Enter desgination: ");
        String desig = s.nextLine();

        System.out.println("Enter compensation: ");
        int comp = s.nextInt();

        PreparedStatement ps=null;
        try {
            String query="update employee set name=?,department=?,designation=?,compensation=? where emp_id=?";
            ps=connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, dept);
            ps.setString(3, desig);
            ps.setInt(4, comp);
            ps.setInt(5, id);

            System.out.println(ps);
            ps.executeUpdate();
            System.out.println("-------RECORDS UPDATED--------");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete_data(int id){
        dbConnection conn=new dbConnection();
        Connection connection=conn.get_connection();

        PreparedStatement ps=null;
        try {
            String query="delete from employee where emp_id=?";
            ps=connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();

            //Updating the phone numbers
            query="delete from contact_num where emp_id=?";
            ps=connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("-------RECORD DELETED--------");

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}



