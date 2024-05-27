package com.tanle.employee.employeeRESTAPIs.rest;

import com.tanle.employee.employeeRESTAPIs.dao.EmployeeDAO;
import com.tanle.employee.employeeRESTAPIs.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;
//    Quick and dirty: inject employee dao
    public EmployeeRestController(EmployeeDAO theEmployeeDao){
        employeeDAO = theEmployeeDao;
    }

//    Expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
