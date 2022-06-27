package com.example.buysell.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Data
public class Product {
     private Long id;
     private String title;
     private String description;
     private int price;
     private String city;
     private String author;

}
