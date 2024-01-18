package com.example.demobootcamp.model.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demobootcamp.model.Transaction;

public interface ReportRepo extends CrudRepository<Transaction, Long>{
	
	
	List<Transaction> creationDateTimeBetween(
		      Date creationDateTimeStart,
		      Date creationDateTimeEnd);
	
	 @Query("select t from Transaction t where t.creationDateTime >= :creationDateTime")
	    List<Transaction> findReceivedByTime(
	      @Param("creationDateTime") Date creationDateTime);

	
	 @Query("select t from Transaction t where t.status_transaksi >= 5 AND t.creationDateTime >= :creationDateTime")
	    List<Transaction> findSendedByTime(
	      @Param("creationDateTime") Date creationDateTime);
	 
	 @Query("select t.id_item, t.nama_item, SUM(jumlah_item) from Transaction t where t.status_transaksi = 1 GROUP BY t.id_item,t.nama_item")
	    List<Transaction> findStock();
	 
	 @Query("select t.id_item, t.nama_item, COUNT(*) from Transaction t where t.status_transaksi = 1 GROUP BY t.id_item,t.id_item")
	    List<Transaction> FindCountRequested(
	      );
	 
	 @Query("select t.id_user, COUNT(*) from Transaction t where t.status_transaksi >=2  GROUP BY t.id_user")
	    List<Transaction> FindCountRequester(
	      );

}
