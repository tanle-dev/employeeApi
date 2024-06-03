package com.tanle.employee.employeeRESTAPIs.rest;

import com.tanle.employee.employeeRESTAPIs.dao.EmployeeDAO;
import com.tanle.employee.employeeRESTAPIs.entity.Employee;
import com.tanle.employee.employeeRESTAPIs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{theId}")
    public Employee findById(@PathVariable int theId){
        Employee employee = employeeService.findById(theId);

        if(employee == null){
            throw new RuntimeException("The id is out of bound" + theId);
        }

        return employeeService.findById(theId);
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee){

        // Set id to 0 just in case the json data has been set an id value
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return  dbEmployee;
    }

    @PutMapping("employees")
    public Employee update(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("employees/{employeeId}")
    public String delete(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("The id is out of bound " + employeeId);
        }

        employeeService.delete(employeeId);

        return "The employee with id " + employeeId + " has been deleted!";
    }
}
