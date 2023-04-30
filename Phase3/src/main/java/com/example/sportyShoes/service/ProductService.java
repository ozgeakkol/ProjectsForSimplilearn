package com.example.sportyShoes.service;

import com.example.sportyShoes.constants.Result;
import com.example.sportyShoes.model.Product;
import com.example.sportyShoes.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> getProduct(Integer pId){
       return productRepository.findById(pId);
    }

    public List<Product> getAllProducts() {
        try {
            log.info("[getAllProducts] started!");
            return productRepository.findAll();
        } catch (Exception e) {
            log.error("[getAllProducts] Exception occurred!", e);
            return Collections.emptyList();
        }
    }

    public List<Product> getAllAvailableProducts() {
        try {
            log.info("[getAllAvailableProducts] started!");
            List<Product> allProducts = productRepository.findAll();
            return allProducts.stream()
                              .filter(product -> product.getQuantity() > 0)
                              .collect(
                                      Collectors.toList());
        } catch (Exception e) {
            log.error("[getAllAvailableProducts] Exception occurred!", e);
            return Collections.emptyList();
        }
    }


    public Result insertProduct(Product product) {
        try {
            log.info("[insertProduct] started! product will be inserted! :: product ={}", product);
            if (!isProductAlreadyExist(product)) {
                productRepository.save(product);
                log.info("[insertProduct] new product inserted! :: product ={}", product);
                return Result.PRODUCT_SUCCESSFULLY_INSERTED;
            }
            return Result.PRODUCT_ALREADY_EXIST;
        } catch (Exception e) {
            log.error("[insertProduct] Exception occurred! Product could not be added!");
        }
        return Result.PRODUCT_ADD_ERROR;
    }

    private boolean isProductAlreadyExist(Product product) {
        try {
            log.info("[isProductAlreadyExist] started! existence will be checked! :: product ={}", product);
            return productRepository.existsByCategoryIdAndProductName(product.getCategoryId(),
                                                                      product.getProductName());
        } catch (DataAccessException dataAccessException) {
            log.error("[isProductAlreadyExist] Exception occurred while getting data from db!", dataAccessException);
        } catch (Exception e) {
            log.error("[isProductAlreadyExist] Exception occurred!", e);
        }
        return true;
    }

    public void decrementQuantity(int pid) {
        log.info("[decrementQuantity] Quantity will be decreased!");
        try {
            Optional<Product> result = productRepository.findById(pid);
            if (result.isPresent()) {
                Product product = result.get();
                product.setQuantity(product.getQuantity() - 1);
                productRepository.saveAndFlush(product);
            }
        } catch (Exception e) {
            log.error("[decrementQuantity] Exception occurred while decreasing the quantity of the product!", e);
        }
    }
}
