package com.osmanforhad.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.osmanforhad.main.model.Programmer;
import com.osmanforhad.main.repository.ProgrammerRepo;

@Controller
@ControllerAdvice
public class MainController {
	
	//create repository instance to save data
	@Autowired
	ProgrammerRepo pr;
	
	//method for mapping the home page
	@GetMapping("/home")
	public String homePage() {
		return "HomePage.html";
	}
	
	//method for mapping the ProgrammerInfo page
	@PostMapping("/addProgrammer")
	public String addProgrammer(@ModelAttribute Programmer programmer) {
		
		//save data into DB through the Interface which is ProgrammerRepo class
		pr.save(programmer);
		
		return  "redirect:/home";
	}
	
	//method for find programmer info by Id
	@PostMapping("/findById")
	public String findById(@RequestParam int pId, Model m) {
		
		//get data from DB according to user input id through the Interface which is ProgrammerRepo and Programmer Model class
		Programmer p = pr.getOne(pId);
		//show data from DB to Thaymleaf page table
		m.addAttribute("programmer", p);
		
		return "ProgrammerInfo.html";
	}
	
	//method for delete programmer info by id
	@GetMapping("/deleteProgrammer")
	public String deleteProgrammer(@RequestParam int pId) {
		
		//delete data from DB by specific programmer id through the Interface which is ProgrammerRepo class
		pr.deleteById(pId);
		
		return "redirect:/home";
	}
	
	//method for update programmer info
	@PostMapping("/updateProgrammer")
	public String updateProgrammer(@RequestParam int pId, Programmer programmer) {
		
		//match input id with DB according to user input id through the Interface which is ProgrammerRepo and Programmer Model class
		Programmer p = pr.getOne(programmer.getpId());
		//update the programmer info
		p.setpName(programmer.getpName());
		p.setpLang(programmer.getpLang());
		
		//update the programmer info
		pr.save(p);
		
		return "ProgrammerInfo.html";
	}
	
	//method for find programmer info by Language
	@PostMapping("/findByLang")
	public String findByLanguage(@RequestParam String pLang, Model m) {
		
		//get data from DB according to user input id through the Interface which is ProgrammerRepo and Programmer Model class
		List<Programmer> p = pr.findBypLang(pLang);
		//show data from DB to Thaymleaf page table
		m.addAttribute("programmers", p);
		
		return "AllProgrammer.html";
	}
	
	//method for find programmer info by Name through the custom Query 
		@PostMapping("/findByName")
		public String findByName(@RequestParam String pName, Model m) {
			
			//get data from DB according to user input id through the Interface which is ProgrammerRepo and Programmer Model class
			List<Programmer> p = pr.findProgrammer(pName);
			//show data from DB to Thaymleaf page table
			m.addAttribute("programmers", p);
			
			return "AllProgrammer.html";
		}


}
