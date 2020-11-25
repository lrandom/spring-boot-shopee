package com.example.demo.models;

import javafx.scene.chart.CategoryAxis;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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


    @Column(name="parent_id")
    private Long parent_id;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "parent_id",
            insertable = false, updatable = false)
    private Category parent;

    @OneToOne(mappedBy = "parent", cascade = {CascadeType.DETACH})
    private Category child;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "category",
            cascade = {CascadeType.ALL})
    private List<Product> listProduct =
            new ArrayList<>();
}
