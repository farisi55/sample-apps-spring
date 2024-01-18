package com.example.demobootcamp.model.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demobootcamp.model.Product;



public interface ProductRepo extends CrudRepository<Product, Long>{
	
	List<Product> findByNameContains(String name);

}
