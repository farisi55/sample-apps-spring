package com.example.demobootcamp.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "tbl_suplier")
public class Suplier {
    private static final long serialVersionUID = 1L;
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Column(name = "name", length = 100)
    private String name;

    @NotEmpty(message = "Address cannot be empty")
    @Column(name = "address", length = 500)
    private String address;

    @NotEmpty(message = "Email cannot be empty")
    @Column(name = "email", length = 500)
    private String email;
    
    @ManyToMany(mappedBy = "suplier")
    private Set<Product> product;
    
}
