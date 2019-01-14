package com.aravindbs;

import java.sql.*;

public class AddressDAOImpl implements AddressDAO {
    Connection connection;

    public AddressDAOImpl() {
        this.connection = DBConnection.getConnection();
    }

    public boolean addAddress(Address addr, Employee e) {
        try {
            String queryInsertAddress = " create table if not exists address (" +
                    "employee_id int, " +
                    "addr_id int primary key auto_increment," +
                    "door_no int not null," +
                    "street_name varchar(15) not null," +
                    "locality varchar(15) not null," +
                    "city varchar(15) not null," +
                    "state varchar(15) not null," +
                    "country varchar(15) not null," +
                    "addr_type varchar(4) not null ," +
                    "pin_code int not null," +
                    "foreign key(employee_id) references employee(employee_id) on delete cascade);";

            Statement create = connection.createStatement();
            create.execute(queryInsertAddress);
            PreparedStatement stmt = connection.prepareStatement("insert into address values(?,NULL,?,?,?,?,?,?,?,?)");
            stmt.setLong(1, e.getEmployee_id());
            stmt.setInt(2, addr.getDoor_no());
            stmt.setString(3, addr.getStreet_name());
            stmt.setString(4, addr.getLocality());
            stmt.setString(5, addr.getCity());
            stmt.setString(6, addr.getState());
            stmt.setString(7, addr.getCountry());
            stmt.setString(8, addr.getType());
            stmt.setInt(9, addr.getPin_code());

            stmt.execute();
            return true;
        } catch (SQLException exp) {
            System.out.println(exp.toString());
            return false;
        }
    }

    protected void finalize() throws Throwable {
        connection.close();

    }


    public Address getAddress(Long emp_id, String type) {
        try {
            String query = " select * from address where employee_id = ? and addr_type = ?  ";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, emp_id);
            stmt.setString(2, type);
            ResultSet res = stmt.executeQuery();
            Address addr;
            res.next();
            System.out.println(res.getString("state"));
            addr = new Address(
                    res.getInt("door_no"),
                    res.getString("street_name"),
                    res.getString("locality"),
                    res.getString("city"),
                    res.getString("state"),
                    res.getString("country"),
                    res.getInt("pin_code"),
                    res.getString("addr_type")
            );
            stmt.close();
            return addr;
        } catch (SQLException expl) {
            System.out.println((expl.toString()));
        }
        return null;
    }
}


