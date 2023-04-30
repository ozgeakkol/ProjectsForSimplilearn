package com.example.sportyShoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    private String productName;
    private float price;
    private int quantity;
    private Integer categoryId;
    private String productImage;

    @OneToMany
    @JoinColumn(name="productId")		//FK
    private List<Orders> listOfOrders;

    /*@OneToMany(mappedBy = "product")
    private List<Orders> listOfOrders;

     */
}
