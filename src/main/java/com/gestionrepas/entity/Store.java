package com.gestionrepas.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
 @Table(
         name = "stores",
         uniqueConstraints = {@UniqueConstraint(columnNames = "store_name")}
 )
 public class Store {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @NotBlank(message = "The store name is required")
     @Column(name = "store_name", nullable = false, length = 100)
     private String name;

     @Column(columnDefinition = "TEXT")
     private String address;

     @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
     private Set<Product> products = new HashSet<>();

     public Store() {
     }

     public Long getId() {
         return id;
     }

     public Store setId(Long id) {
         this.id = id;
         return this;
     }

     public String getName() {
         return name;
     }

     public Store setName(String name) {
         this.name = name;
         return this;

     }

     public Set<Product> getProducts(){
         return this.products;
     }

     public Store setProducts(Set<Product> products){
         this.products = products;
         return this;
     }
 }