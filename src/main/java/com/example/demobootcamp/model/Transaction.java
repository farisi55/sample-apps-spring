package com.example.demobootcamp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    @Column(name = "status_transaksi")
    private Long status_transaksi;
    
    @Column(name = "id_transaksi_request")
    private Long id_transaksi_request ;
    
    @Column(name = "id_user")
    private Long id_user ;
    
    @Column(name = "id_item")
    private Long id_item ;
    
    @Column(name = "jumlah_item")
    private Long jumlah_item ;
     
    @NotEmpty(message = "Description cannot be empty")
    @Column(name = "description", length = 500)
    private String desc;
    
    @NotEmpty(message = "Description cannot be empty")
    @Column(name = "nama_item", length = 500)
    private String nama_item;
    
    @NotEmpty(message = "Description cannot be empty")
    @Column(name = "creationDateTime")
    private Date creationDateTime;

}
