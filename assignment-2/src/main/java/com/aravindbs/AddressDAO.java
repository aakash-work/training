package com.aravindbs;

public interface AddressDAO {
    boolean addAddress(Address a, Employee e);
    Address getAddress(Long emp_id, String type);
}
