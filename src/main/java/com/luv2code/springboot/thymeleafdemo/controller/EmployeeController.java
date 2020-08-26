package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel, String keyword) {
		
		// get employees from db
		List<Employee> theEmployees = employeeService.findAll();
		// check if there is a search keyword
		if(keyword != null){
			theModel.addAttribute("employees",employeeService.findByKeyword(keyword));
		}
		else {
			// add to the spring model
			theModel.addAttribute("employees", theEmployees);
		}

		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId")int theId, Model theModel){
		//get the employee from service
		Employee employee = employeeService.findById(theId);
		//set the employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", employee);
		// send over to our form
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		// save the employee
		employeeService.save(theEmployee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId")int theId){
		//get the employee
		employeeService.deleteById(theId);
		//redirect to list
		return "redirect:/employees/list";
	}
}












