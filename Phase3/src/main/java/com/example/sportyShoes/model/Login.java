package com.example.sportyShoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Login {
    @Id
    private String emailid;
    private String password;
    private String typeofuser;
   /* @OneToMany
    @JoinColumn(name="emailid")	// FK
    private List<Orders> listOfOrders;

    */

}
