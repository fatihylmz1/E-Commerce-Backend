package com.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "address1",schema = "public")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "city")
    private String city;
    @Column(name = "district")
    private String district;
    @Column(name = "neigborhood")
    private String neigborhood;
    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
