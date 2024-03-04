package com.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "card",schema = "public")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "card_no")
    private String cardNo;
    @Column(name = "expire_month")
    private Long expireMonth;
    @Column(name = "expire_year")
    private Long expireYear;
    @Column(name = "name_on_card")
    private String nameOnCard;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
