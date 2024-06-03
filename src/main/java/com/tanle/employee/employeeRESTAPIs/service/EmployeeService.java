package com.tanle.employee.employeeRESTAPIs.service;

import com.tanle.employee.employeeRESTAPIs.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void delete(int theId);
}
