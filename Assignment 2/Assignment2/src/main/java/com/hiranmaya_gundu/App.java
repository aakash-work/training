package com.hiranmaya_gundu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Connectivity com = new Connectivity();
        Scanner in = new Scanner(System.in);
        Employee e;
        Boolean flag = true;
        while(flag)
        {
            System.out.println("Menu\n1.Create Employee\n2.Read Employee\n3.Update Name\n4.Delete Employee\n5.Exit");
            int ch = in.nextInt();
            switch(ch)
            {
                case 1: System.out.println("Enter ID");
                int id = in.nextInt();
                in.nextLine();
                System.out.println("Enter name");
                String name = in.nextLine();
                System.out.println("Enter designation");
                String des = in.nextLine();
                System.out.println("Enter department");
                String dep = in.nextLine();
                System.out.println("Enter compensation");
                int compensation = in.nextInt();
                in.nextLine();                ArrayList<Integer> con = new ArrayList<Integer>();
                System.out.println("How many numbers do you wish to add? ");
                int num = in.nextInt();
                in.nextLine();
                for(int  i =0; i < num; i++)
                {
                    con.add(in.nextInt());
                    in.nextLine();
                }
                System.out.println("Enter street");
                String str = in.nextLine();
                System.out.println("Enter city");
                String ci = in.nextLine();
                System.out.println("Enter state");
                String sta = in.nextLine();
                System.out.println("Enter country");
                String co = in.nextLine();
                Address ad = new Address(str,ci,sta,co);
                System.out.println("Enter Vehicle Type");
                String ty = in.nextLine();
                System.out.println("Enter Reg No");
                String reg = in.nextLine();
                Vehicle ve = new Vehicle(ty,reg);
                e = new Employee(name,id,des,dep,compensation,con,ad,ve);
                e.printDetails();
                com.create(e);
                break;
                case 2: System.out.println("Enter ID");
                int idr = in.nextInt();
                in.nextLine();
                e = com.read(idr);
                e.printDetails();
                break;
                case 3: System.out.println("Enter ID");
                int id_u = in.nextInt();
                in.nextLine();
                System.out.println("Enter name");
                String name_u = in.nextLine();
                com.update(id_u, name_u);
                break;
                case 4: System.out.println("Enter ID");
                int id_d = in.nextInt();
                in.nextLine(); 
                com.delete(id_d);
                break;
                case 5: System.out.println("Exiting");
                flag = false;
                break;
                default: System.out.println("Invalid entry");
            }
        }
    }
}
