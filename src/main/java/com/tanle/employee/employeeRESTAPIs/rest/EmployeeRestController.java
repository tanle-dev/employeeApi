package com.tanle.employee.employeeRESTAPIs.rest;

import com.tanle.employee.employeeRESTAPIs.dao.EmployeeDAO;
import com.tanle.employee.employeeRESTAPIs.entity.Employee;
import com.tanle.employee.employeeRESTAPIs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
//    Quick and dirty: inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

//    Expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
}
