package com.aravindbs;

public interface AddressDAO {
    public boolean addAddress(Address a, Employee e);
    public Address getAddress(Long emp_id, String type);
}
