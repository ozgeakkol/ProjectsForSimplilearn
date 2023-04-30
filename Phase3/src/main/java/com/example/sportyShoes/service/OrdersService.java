package com.example.sportyShoes.service;

import com.example.sportyShoes.constants.Result;
import com.example.sportyShoes.model.Orders;
import com.example.sportyShoes.repository.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ProductService productService;

    public Result insertOrder(Orders order) {
        try{
            log.info("[insertOrder] Order will be inserted! :: order={}", order);
            ordersRepository.save(order);
            productService.decrementQuantity(order.getProductId());
            return Result.ORDER_SUCCESSFULLY;
        }catch (Exception e){
            log.error("[insertOrder] Exception occurred!", e);
            return Result.ORDER_ERROR;
        }
    }

    public List<Orders> viewAllOrderDetails() {
        return ordersRepository.findAll();
    }

    public Orders createOrder(int productId, String emailId, String address){
        Orders order = new Orders();
        order.setOrderDate(LocalDate.now());
        order.setProductId(productId);
        order.setEmailId(emailId);
        order.setAddress(address);
        return order;
    }
}
