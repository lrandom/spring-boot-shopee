package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "category",
            cascade = {CascadeType.ALL})
    private List<Product> listProduct =
            new ArrayList<>();
}
