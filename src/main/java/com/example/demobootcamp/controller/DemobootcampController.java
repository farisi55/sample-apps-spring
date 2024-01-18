package com.example.demobootcamp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demobootcamp.model.Company;



@RestController
@RequestMapping("/api/welcome") 
public class DemobootcampController {
	 
	List<Company> listCompany = new ArrayList<>();

	    @GetMapping
	    public @ResponseBody List<Company> createDemo(){
	         return listCompany;
	         
	        
	    }
	    
	    @PostMapping
	    List<Company> newCompany(@RequestBody List<Company> listCompanyRq) {
	    	listCompany.addAll(listCompanyRq);
	      return listCompanyRq;
	    }
	    
	    @DeleteMapping
	    List<Company> newCompany(@RequestBody Company companyRq) {
	    	
	    	listCompany.removeIf(obj -> obj.getName().equals(companyRq.getName()) && obj.getOccupation().equals(companyRq.getOccupation()));
	    	
	      return listCompany;
	    }

	   
	

}
