package com.example.demobootcamp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Column(name = "name", length = 100)
    private String name;

    @NotEmpty(message = "Description cannot be empty")
    @Column(name = "description", length = 500)
    private String desc;

    @Column(name = "price")
    private double price;
    
    @ManyToOne
    private Category category;
    
  
    
    
    @ManyToMany
    @JoinTable(name = "tbl_product_suplier",
    		joinColumns = @JoinColumn(name = "product_id"),
    		inverseJoinColumns = @JoinColumn(name = "suplier_id"))
    private Set<Suplier> suplier;
    
    
}

