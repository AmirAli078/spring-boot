package com.practice.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MyController {
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(org.springframework.ui.Model model) {
		//about.html
		System.out.println("Inside the about handler");
		model.addAttribute("name", "Amir");
		model.addAttribute("currentDate", new Date().toLocaleString());
		return "about";
	}
	
	// create a handler to handle the itteration 
	@GetMapping("/example-loop")
   public String iterateHandler(Model model) {
		// set the values in a array, collection or set 
		List<String> names = List.of("Inam","Amir","Touqeer","Ubaid","waseem");
		model.addAttribute("names", names);
	   return "iterate";
   }
	
	//create a handler for handling the conditions 
	@GetMapping("/condition-example")
	public String conditionHandler(Model model) {
		
		model.addAttribute("isActive", false);
		model.addAttribute("gender", "F");
		
		List<Integer> number = List.of(12,134,124,131);
	     model.addAttribute("numbers", number);
		return "condition";
	}
	
	//handler for including fragments
	
	@GetMapping("/service")
	public String serviceHandler(Model model) {
		//process logic
		model.addAttribute("title", "Mehran University Of Engineering And Technology");
		model.addAttribute("subtitle", new Date().toLocaleString());
    return "service";		
	}
	
	@GetMapping("/aboutnew")
	public String newAbout() {
		return"aboutnew";
	}

}
