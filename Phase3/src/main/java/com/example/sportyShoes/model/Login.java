package com.example.sportyShoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Login {
    @Id
    private String emailId;
    private String password;
    private String typeOfUser;


    @OneToMany
    @JoinColumn(name="emailId")	// FK
    private List<Orders> listOfOrders;

   /* @OneToMany(mappedBy = "login")
    private List<Orders> orders;

    */

}
