package com.example.demobootcamp.services;

import java.util.Date;
import java.util.List;
import java.time.Instant;
import java.time.temporal.ChronoUnit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.demobootcamp.model.Transaction;
import com.example.demobootcamp.model.repo.ReportRepo;

@Service
@Transactional
public class ReportService {
	
	@Autowired
	private ReportRepo reportRepo;
	
	Instant now = Instant.now();
	Instant yesterday = now.minus(1, ChronoUnit.DAYS);
	Instant lastWeek = now.minus(7, ChronoUnit.DAYS);
	Instant lastMonth = now.minus(30, ChronoUnit.DAYS);
	  
	  
	   
	 public Iterable<Transaction> findReceivedDaily(){
	        return reportRepo.findReceivedByTime(Date.from(yesterday));
	    }
	 
	 public Iterable<Transaction> findReceivedWeekly(){
	        return reportRepo.findReceivedByTime(Date.from(lastWeek));
	    }
	 
	 public Iterable<Transaction> findReceivedMonthly(){
	        return reportRepo.findReceivedByTime(Date.from(lastMonth));
	    }
	 
	 
	 public Iterable<Transaction> findSendedDaily(){
	        return reportRepo.findSendedByTime(Date.from(yesterday));
	    }
	 
	 public Iterable<Transaction> findSendedWeekly(){
	        return reportRepo.findSendedByTime(Date.from(lastWeek));
	    }
	 
	 public Iterable<Transaction> findSendedMonthly(){
	        return reportRepo.findSendedByTime(Date.from(lastMonth));
	    }
	 public List<Transaction> findStock(){
	        return reportRepo.findStock();
	    }
	 
	 public Iterable<Transaction> FindCountRequested(){
	        return reportRepo.FindCountRequested();
	    }
	 
	 public Iterable<Transaction> FindCountRequester(){
	        return reportRepo.FindCountRequester();
	    }
	 
	 

}
