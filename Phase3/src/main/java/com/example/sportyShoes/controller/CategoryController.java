package com.example.sportyShoes.controller;

import com.example.sportyShoes.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {

    @RequestMapping(value = "/addCategoryPage", method = RequestMethod.GET)
    public String addCategoryPage(Model model) {
        model.addAttribute("category", new Category());
        return "addCategoryPage";
    }

    @RequestMapping(value = "/viewCategoryPage", method = RequestMethod.GET)
    public String viewCategoryPage(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("categoryInfo", "there isn'T any category");
        return "viewCategoryPage";
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute Category category, Model model){
        return "index";
    }
}
