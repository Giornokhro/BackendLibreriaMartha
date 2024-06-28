package com.libreria.martha.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private float price;
    private int quantity;
    private String description;
    private String image;
}