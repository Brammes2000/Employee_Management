package com.Employee_management.controller;


import com.Employee_management.model.Employee;
import com.Employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String getAllEmployee(Model model) {
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("employeeList", employeeList);
        return "index";
    }

    @GetMapping("/addEmployee")
    public String showaddEmployeeForm(Model model){
        model.addAttribute("employee",new Employee());
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String getEmployeeById(@PathVariable String id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String showeditemployeeform(@PathVariable String id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployeeById(@PathVariable String id, @ModelAttribute("employee") Employee employee){
        employee.setId(id);
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable String id){
        employeeService.deleteById(id);
        return "redirect:/";
    }
}
