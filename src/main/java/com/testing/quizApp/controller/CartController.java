package com.testing.quizApp.controller;

import Dto.AddToCartDto;
import Model.CartCost;
import Model.Product;
import com.testing.quizApp.service.CartService;
import com.testing.quizApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productServices;


    @PostMapping("/add")

    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, Integer userId) {


        cartService.addToCart(addToCartDto, userId);

        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<CartCost> getCartitems(@RequestBody Integer userId) {

        CartCost cartCost = cartService.lisCartItems(userId);
        return new ResponseEntity<CartCost>(cartCost, HttpStatus.OK);

    }

    @PutMapping("/update/{cartItemId}")

    public ResponseEntity<ApiResponse> updateCartItem(@RequestBody AddToCartDto cartDto, Integer userId, Product product) {

        Product products = productServices.getProductById(cartDto.getProductId());
        cartService.updateCartItem(cartDto, userId, products);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{carItemId}")

    public ResponseEntity<ApiResponse> deleteCarItem(@PathVariable("cartItemId") int itemId) {

        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "item has been removed"), HttpStatus.OK);
    }
}