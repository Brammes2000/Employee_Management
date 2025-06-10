package com.Employee_management.service;

import com.Employee_management.exception.EmployeeNotFoundException;
import com.Employee_management.model.Employee;
import com.Employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(String id){
        return employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Employee Not Found."));
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
    public void deleteById(String id){
        if (employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        }else {
            throw new EmployeeNotFoundException("Employee not found with this ID: "+id);
        }
    }
}
