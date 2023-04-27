package com.example.sportyShoes.controller;

import com.example.sportyShoes.model.Category;
import com.example.sportyShoes.model.Product;
import com.example.sportyShoes.service.CategoryService;
import com.example.sportyShoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/addProductPage", method = RequestMethod.GET)
    public String addProductPage(Model model) {
        List<Category> listOfCategory = categoryService.getAllCategories();
        model.addAttribute("category",listOfCategory);
        model.addAttribute("product", new Product());
        return "addProductPage";
    }

    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    public String addProduct(Model mm,Product product) {
        //TODO: validate before insertion!
        boolean productInserted = productService.insertProduct(product);
        if(productInserted){
            mm.addAttribute("product", product);
            mm.addAttribute("msg", "successfully inserted!");
            List<Category> listOfCategory = categoryService.getAllCategories();
            mm.addAttribute("category",listOfCategory);
            return "addProductPage";
        }

        mm.addAttribute("msg", "something went wrong!");
        return "addProductPage";


    }

}
