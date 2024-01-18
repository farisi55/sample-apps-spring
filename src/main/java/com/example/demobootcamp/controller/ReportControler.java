package com.example.demobootcamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demobootcamp.model.Transaction;

import com.example.demobootcamp.services.ReportService;

@RestController
@RequestMapping("/api/report") 
public class ReportControler {
	
	@Autowired 
	private ReportService reportService;
	
	@GetMapping("/receiveddaily") 
	public Iterable<Transaction> findReceivedDaily(){
         return reportService.findReceivedDaily();
            
    }
	
	@GetMapping("/receivedweekly") 
	public Iterable<Transaction> findReceivedWeekly(){
         return reportService.findReceivedWeekly();
            
    }
	
	@GetMapping("/receivedmonthly") 
	public Iterable<Transaction> findReceivedMonthly(){
         return reportService.findReceivedMonthly();
            
    }
	
	@GetMapping("/sendeddaily") 
	public Iterable<Transaction> findSendedDaily(){
         return reportService.findSendedDaily();
            
    }
	
	@GetMapping("/sendedweekly") 
	public Iterable<Transaction> findSendedWeekly(){
         return reportService.findSendedWeekly();
            
    }
	
	@GetMapping("/sendedmonthly") 
	public Iterable<Transaction> findSendedMonthly(){
         return reportService.findSendedMonthly();
            
    }
	
	@GetMapping("/stock") 
	public List<Transaction> findStock(){
         return reportService.findStock();
            
    }
	
	@GetMapping("/requested") 
	public Iterable<Transaction> FindCountRequested(){
         return reportService.FindCountRequested();
            
    }
	
	@GetMapping("/requester") 
	public Iterable<Transaction> FindCountRequester(){
         return reportService.FindCountRequester();
            
    }
	
	

}
