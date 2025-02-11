package com.sathya.springbootmvc.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.springbootmvc.employeemodel.EmployeeModel;
import com.sathya.springbootmvc.entity.EmployeeEntity;
import com.sathya.springbootmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	  @Autowired
	  EmployeeService employeeService;

	  @GetMapping("/employeeform")
	  public String getEmployeeForm()
	  {
		  return "add-employee";			  
	  }
	
	  @PostMapping("/saveemployee")
	  public String saveEmployee(EmployeeModel employeeModel)
	  {
		  employeeService.saveEmployeeDetails(employeeModel);
		  return "successful";
	  }
	
      @GetMapping("/getallemployees")
      public String getAllEmployees(Model model)
      {
    	  List<EmployeeEntity> employees=employeeService.getAllEmployees();
    	  model.addAttribute("employees",employees);
    	  return "employee-list";
      }
      
      @GetMapping("/searchemployeeform")
      public String getSearchForm()
      {
    	  return "search-employee";
      }
      
      @PostMapping("/searchById")
      public String searchById(@RequestParam Long id,Model model)
      {
    	  EmployeeEntity employee=employeeService.searchById(id);
    	  model.addAttribute("employee",employee);
    	  return "search-employee";
      }
      
      @GetMapping("/delete/{id}")
      public String getdeleteProductById(@PathVariable ("id") Long id)
      {
    	  employeeService.deleteEmployeeById(id);
    	  return "redirect:/getallemployees";
      }
      
      
      
}
