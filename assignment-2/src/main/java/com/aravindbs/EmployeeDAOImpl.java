package com.aravindbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.lang.Exception;

public class EmployeeDAOImpl implements EmployeeDAO {

    Connection connection;


    public EmployeeDAOImpl() {
        this.connection = DBConnection.getConnection();
    }

    public Long addEmployee(Employee e) {
        try {
            String queryCreateEmployee = "create table if not exists employee (\n" +
                    "  first_name varchar(15) not null,\n" +
                    "  last_name varchar(15) not null,\n" +
                    "  designation varchar(15) not null,\n" +
                    "  department varchar(15) not null,\n" +
                    "  employee_id int not null primary key,\n" +
                    "  mobile_no varchar(10) not null,\n" +
                    "  compensation double not null\n" +
                    ");";


            Statement create = connection.createStatement();
            create.execute(queryCreateEmployee);
            PreparedStatement stmt = connection.prepareStatement("insert into employee values(?,?,?,?,?,?,?);");
            stmt.setString(1, e.getFirst_name());
            stmt.setString(2, e.getLast_name());
            stmt.setString(3, e.getDesignation());
            stmt.setString(4, e.getDepartment());
            stmt.setLong(5, e.getEmployee_id());
            stmt.setString(6, e.getMobile_no());
            stmt.setDouble(7, e.getCompensation());

            stmt.execute();


            AddressDAOImpl addr = new AddressDAOImpl();
            boolean curr = addr.addAddress(e.getTemp_addr(), e);
            boolean perm = addr.addAddress(e.getPerm_addr(), e);


            if (curr && perm)
                return e.getEmployee_id();

            else
                throw new Exception("Address not added to db");
        } catch (SQLException exp) {
            System.out.println(exp);
        } catch (Exception exp) {
            System.out.println(exp.toString());
        }
        return (long) 0;
    }

    public Long updateEmployee(Employee e) {


        return null;
    }

    public Employee getEmployee(Long emp_id) {

        try {

            PreparedStatement stmt = connection.prepareStatement(" select * from employee where employee_id = ?");

            stmt.setLong(1, emp_id);

            ResultSet res = stmt.executeQuery();
            res.next();
           // System.out.println(res.getString("first_name"));
            AddressDAOImpl addr_db = new AddressDAOImpl();
            Address cur = addr_db.getAddress(emp_id, "CURR");
            Address per = addr_db.getAddress(emp_id, "PERM");
           // res.next();
           // System.out.println(res.getString("first_name"));
            Employee e;
            e = new Employee(
                    res.getString("first_name"),
                    res.getString("last_name"),
                    res.getString("designation"),
                    res.getString("department"),
                    Long.valueOf(res.getInt("employee_id")),
                    per,
                    cur,
                    res.getString("mobile_no"),
                    res.getDouble("compensation")
            );
           // System.out.println(e.getFirst_name());
            return e;
        } catch (SQLException exp) {
            System.out.println(exp);
        }
        return null;
    }

    public boolean deleteEmployee(Long emp_id) {
        try {
            String query = String.format("delete from employee where employee_id=%d;", emp_id);
            System.out.println(query);
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            return true;
        }
        catch ( SQLException exp){
            System.out.println(exp.toString());
        }
        return false;
    }
}


