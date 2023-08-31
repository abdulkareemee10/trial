package com.testing.quizApp.controller;

import Dto.ProductDto;
import Model.CartCost;
import Model.Category;
import Model.Product;
import com.testing.quizApp.service.CategoryService;
import com.testing.quizApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
    @RequestMapping("/product")
    public class ProductController {

        @Autowired
        ProductService productService;
        @Autowired
        CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.OK);
        }
        Category category = optionalCategory.get();
        productService.addProduct(productDto, category);
        return new ResponseEntity<>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }

   @GetMapping()
   public ResponseEntity<List<Product>> getAllProduct() {
       List<Product> body = productService.listProduct();
       return new ResponseEntity<>(body, HttpStatus.OK);
   }

   @PutMapping("/update/{productId}")
   public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") Integer productId, @RequestBody Product product) {
       // Check to see if the category exists.
       if (Objects.nonNull(productService.listProduct())) {
           // If the category exists then update it.
           productService.updateProduct(productId, product);
           return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the category"), HttpStatus.OK);
       }

       // If the category doesn't exist then return a response of unsuccessful.
       return new ResponseEntity<>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
   }

        @DeleteMapping("/delete/{productId}")

    public ResponseEntity<ApiResponse> deleteCarItem(@PathVariable("productId") int id) {

        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product has been removed"), HttpStatus.OK);
    }
    }


