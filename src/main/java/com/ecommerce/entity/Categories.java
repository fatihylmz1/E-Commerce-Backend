package com.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "category" , schema = "public")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "title")
    private String title;
    @Column(name = "img")
    private String img;
    @Column(name = "rating")
    private Long rating;
    @Column(name = "gender")
    private String gender;

    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
    private List<Products> products;

}
