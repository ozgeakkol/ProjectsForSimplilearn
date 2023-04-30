package com.example.sportyShoes.controller;

import com.example.sportyShoes.constants.Result;
import com.example.sportyShoes.model.Category;
import com.example.sportyShoes.model.Product;
import com.example.sportyShoes.service.CategoryService;
import com.example.sportyShoes.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.example.sportyShoes.constants.Result.NO_PRODUCTS;

@Slf4j
@Controller
public class ProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/addProductPage", method = RequestMethod.GET)
    public String addProductPage(Model model) {
        List<Category> listOfCategory = categoryService.getAllCategories();
        model.addAttribute("category", listOfCategory);
        model.addAttribute("product", new Product());
        return "addProductPage";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(Model mm, Product product) {
        //TODO: validate before insertion!
        Result result = productService.insertProduct(product);
        List<Category> listOfCategory = categoryService.getAllCategories();
        mm.addAttribute("product", product);
        mm.addAttribute("category", listOfCategory);
        mm.addAttribute("msg", result.getResultMessage());
        return "addProductPage";
    }

    @RequestMapping(value = "/viewProductPage", method = RequestMethod.GET)
    public String viewProductPage(Model model, Product product) {
        List<Product> products = productService.getAllProducts();
        if (!products.isEmpty()) {
            log.info("[viewProductPage] products will be shown in page! products={}", products);
            model.addAttribute("products", products);
            return "viewProductPage";
        }
        log.warn("[viewProductPage] there is no products!");
        model.addAttribute("viewProductInfo", NO_PRODUCTS.getResultMessage());
        model.addAttribute("products", Collections.emptyList());

        return "viewProductPage";
    }

    @RequestMapping(value = "/viewProductPageFromCustomer", method = RequestMethod.GET)
    public String viewProductPageFromCustomer(Model model) {
        List<Product> products = productService.getAllAvailableProducts();
        if (!products.isEmpty()) {
            log.info("[viewProductPageFromCustomer] products will be shown in page! products={}", products);
            model.addAttribute("products", products);
            return "viewProductPageFromCustomer";
        }
        log.warn("[viewProductPageFromCustomer] there is no products!");
        model.addAttribute("viewProductInfo", NO_PRODUCTS.getResultMessage());
        model.addAttribute("products", Collections.emptyList());

        return "viewProductPageFromCustomer";
    }
}
