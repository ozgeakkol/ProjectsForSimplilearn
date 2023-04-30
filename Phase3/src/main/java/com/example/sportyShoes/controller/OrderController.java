package com.example.sportyShoes.controller;

import com.example.sportyShoes.model.Orders;
import com.example.sportyShoes.model.Product;
import com.example.sportyShoes.service.CategoryService;
import com.example.sportyShoes.service.OrdersService;
import com.example.sportyShoes.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Controller
public class OrderController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/getOrderPage/{productId}", method = RequestMethod.GET)
    public String getOrderPage(@PathVariable int productId, Model model, HttpSession session) {
        Optional<Product> product = productService.getProduct(productId);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            model.addAttribute("categoryName", categoryService.getCategoryName(product.get().getCategoryId()));
            model.addAttribute("address", new String());
            return "giveOrderPage";
        }
        return "redirect:/customerHome";
    }

    @RequestMapping(value = "/giveOrder/{productId}", method = RequestMethod.POST)
    public String giveOrder(
            @PathVariable int productId, @ModelAttribute("address") String address, Model model, HttpSession session) {
        String emailId = (String) session.getAttribute("emailId");
        Orders order = ordersService.createOrder(productId, emailId, address);
        ordersService.insertOrder(order);
        return "redirect:/customerHome";
    }


}
