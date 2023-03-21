package com.prog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.Entity.Employee;
import com.prog.Service.EmpService;

@Controller
public class Emp1Controller {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home1(Model m)
	{
		List<Employee> emp = service.getAllEmp();
		m.addAttribute("emp", emp);
		return "home1";
	}
	
	@GetMapping("/addEmp")
	public String add()
	{
		return "addEmp1";
	}

	@PostMapping("/register")
	public String register(Employee e)
	{
		service.addEmp(e);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		Employee e = service.getEMpById(id);
		System.out.println(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String update(Employee e)
	{
		service.addEmp(e);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,Model m)
	{
		service.delete(id);
		return "redirect:/";
	}
	
}
