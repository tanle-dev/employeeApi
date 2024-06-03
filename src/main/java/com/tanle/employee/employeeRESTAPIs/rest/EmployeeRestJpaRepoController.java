package com.tanle.employee.employeeRESTAPIs.rest;

import com.tanle.employee.employeeRESTAPIs.entity.Employee;
import com.tanle.employee.employeeRESTAPIs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jparepo")
public class EmployeeRestJpaRepoController {

    private EmployeeService employeeServiceJpa;
    //    Quick and dirty: inject employee dao
    @Autowired
    public EmployeeRestJpaRepoController(EmployeeService theEmployeeService){
        employeeServiceJpa = theEmployeeService;
    }

    //    Expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeServiceJpa.findAll();
    }

    @GetMapping("/employees/{theId}")
    public Employee findById(@PathVariable int theId){
        Employee employee = employeeServiceJpa.findById(theId);

        if(employee == null){
            throw new RuntimeException("The id is out of bound" + theId);
        }

        return employeeServiceJpa.findById(theId);
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee){

        // Set id to 0 just in case the json data has been set an id value
        theEmployee.setId(0);

        Employee dbEmployee = employeeServiceJpa.save(theEmployee);

        return  dbEmployee;
    }

    @PutMapping("employees")
    public Employee update(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeServiceJpa.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("employees/{employeeId}")
    public String delete(@PathVariable int employeeId){
        Employee employee = employeeServiceJpa.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("The id is out of bound " + employeeId);
        }

        employeeServiceJpa.delete(employeeId);

        return "The employee with id " + employeeId + " has been deleted!";
    }
}
