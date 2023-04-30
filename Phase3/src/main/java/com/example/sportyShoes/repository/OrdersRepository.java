package com.example.sportyShoes.repository;

import com.example.sportyShoes.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findOrdersByEmailId(String emailId);
}
