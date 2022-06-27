package com.example.buysell.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@Getter
@Setter
@Data
@NoArgsConstructor
public class Product {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "id")
     private Long id;
     @Column(name = "title")
     private String title;
     @Column(name = "description", columnDefinition = "text")
     private String description;
     @Column(name = "price")
     private int price;
     @Column(name = "city")
     private String city;
     @Column(name = "author")
     private String author;


}
