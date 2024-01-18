package com.example.demobootcamp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demobootcamp.dto.ResponseData;
import com.example.demobootcamp.model.Company;
import com.example.demobootcamp.model.Product;
import com.example.demobootcamp.services.ProductService;

@RestController
@RequestMapping("/api/product") 
public class ProductController {
	
	@Autowired 
	private ProductService productService;
	
	
	
	@PostMapping
	public ResponseEntity<ResponseData<Product>> create (@Valid @RequestBody Product product,Errors errors)
	{
		ResponseData<Product> responseData = new ResponseData<Product>();
		
		if(errors.hasErrors())
		{
			for(ObjectError error: errors.getAllErrors())
			{
				responseData.getMessage().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
			
		}
		responseData.setStatus(true);
		responseData.setPayload(productService.save(product));
		return ResponseEntity.ok(responseData);
	}
	
	@GetMapping
    public Iterable<Product> findAll(){
         return productService.findAll();
            
    }
	
	@GetMapping("/{id}") 
    public Product findOne(@PathVariable("id") Long id){
         return productService.findOne(id);
            
    }
	
	@PutMapping
	public ResponseEntity<ResponseData<Product>> update (@Valid @RequestBody Product product,Errors errors)
	{
		ResponseData<Product> responseData = new ResponseData<Product>();
		
		if(errors.hasErrors())
		{
			for(ObjectError error: errors.getAllErrors())
			{
				responseData.getMessage().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
			
		}
		responseData.setStatus(true);
		responseData.setPayload(productService.save(product));
		return ResponseEntity.ok(responseData);
	}
    
	@DeleteMapping("/{id}") 
    public void removeOne(@PathVariable("id") Long id){
          productService.removeOne(id);
            
    }
    

}
