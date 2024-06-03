package com.tanle.employee.employeeRESTAPIs.service;

import com.tanle.employee.employeeRESTAPIs.dao.EmployeeDAO;
import com.tanle.employee.employeeRESTAPIs.dao.EmployeeRepository;
import com.tanle.employee.employeeRESTAPIs.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class EmployeeJpaServiceImpl implements  EmployeeService{
    private EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeJpaServiceImpl(EmployeeRepository theEmployeeRepo){
        employeeRepo = theEmployeeRepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepo.findById(theId);

        Employee theEmployee = null;
        if(result.isPresent()){
           theEmployee = result.get();
        }else {
            throw new RuntimeException("Did not find emplouyee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepo.save(theEmployee);
    }

    @Override
    public void delete(int theId) {
        employeeRepo.deleteById(theId);
    }
}
