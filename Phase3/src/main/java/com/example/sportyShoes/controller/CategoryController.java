package com.example.sportyShoes.controller;

import com.example.sportyShoes.model.Category;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CategoryController {

    @RequestMapping(value = "/addCategoryPage", method = RequestMethod.GET)
    public String addCategoryPage(Model model){
        model.addAttribute("category", new Category());
        //TODO: addCategoryPage does not loaded!
        return "addCategoryPage";
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addCategory(Category category, Model model){
        return "index";
    }
}
