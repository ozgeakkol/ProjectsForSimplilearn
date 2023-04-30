package com.example.sportyShoes.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @DateTimeFormat(pattern = "YYYY-mm-dd") // mysql default date format.
    private LocalDate orderDate;

    private Integer productId;		//FK

    private String emailId;

    /*@ManyToOne
    @JoinColumn(name = "pId")
    private Product product;

     */

    /*@ManyToOne
    @JoinColumn(name = "emailId")
    private Login login;*/			//FK

    private String address;
}