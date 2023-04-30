package com.example.sportyShoes.service;

import com.example.sportyShoes.constants.Result;
import com.example.sportyShoes.model.Category;
import com.example.sportyShoes.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        try{
            log.info("[getAllCategories] started!");
            return categoryRepository.findAll();
        }catch (Exception e){
            log.error("[getAllCategories] Exception occurred!", e);
            return Collections.emptyList();
        }
    }

    public Result insertCategory(Category category){
        try {
            log.info("[insertCategory] started! record will be inserted! :: category ={}", category);
            if(!isCategoryAlreadyExists(category)){
                categoryRepository.save(category);
                log.info("[insertCategory] new category inserted! :: category ={}", category);
                return Result.CATEGORY_INSERTED;
            }
            return Result.CATEGORY_ALREADY_EXIST;
        }catch (Exception e){
            log.error("[insertCategory] Exception occurred! Category could not be added!");
        }
        return Result.CATEGORY_ADD_ERROR;
    }

    public String getCategoryName(Integer cId){
        try{
            log.info("[getAllCategories] started!");
            Optional<Category> categoryOptional = categoryRepository.findById(cId);
            if(categoryOptional.isPresent()){
                return categoryOptional.get().getCategoryName();
            }
        }catch (Exception e){
            log.error("[getAllCategories] Exception occurred!", e);
        }
        return "";
    }

    public boolean isCategoryAlreadyExists(Category category){
        try {
            log.info("[isCategoryAlreadyExists] started! existence will be checked! :: category ={}", category);
            return categoryRepository.existsByCategoryName(category.getCategoryName());
        }catch (DataAccessException dataAccessException){
            log.error("[isCategoryAlreadyExists] Exception occurred while getting data from db!", dataAccessException);
        }catch (Exception e){
            log.error("[isCategoryAlreadyExists] Exception occurred!", e);
        }
        return true;
    }
}
