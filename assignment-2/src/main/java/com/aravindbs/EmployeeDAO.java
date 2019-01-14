
package com.aravindbs;

public interface EmployeeDAO {
    Long addEmployee(Employee e);
    Long updateEmployee(Employee e);
    Employee getEmployee (Long emp_id);
    boolean deleteEmployee(Long emp_id);
}


