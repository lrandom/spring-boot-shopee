package com.example.demo.models;

import javafx.scene.chart.CategoryAxis;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "category")
public class Category extends GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "parent_id")
    private Long parentId;

    @OneToOne()
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToOne(mappedBy = "parent")
    private Category child;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "category",
            cascade = {CascadeType.ALL})
    private List<Product> listProduct =
            new ArrayList<>();
}
