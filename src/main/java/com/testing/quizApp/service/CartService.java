package com.testing.quizApp.service;

import Dto.AddToCartDto;
import Dto.CartDto;
import Model.Cart;
import Model.CartCost;
import Model.Product;
import Repository.CartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

  @Autowired
   private CartRepository cartRepository;

  public CartService(){

  }


    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCart(AddToCartDto addToCartDto, int userId){
        Cart cart = getAddToCartFromDto(addToCartDto, userId);
        cartRepository.save(cart);
    }

    public Cart getAddToCartFromDto(AddToCartDto addToCartDto, int userId){
        Cart cart = new Cart(addToCartDto, userId);
        return cart;
    }
    public CartCost lisCartItems(int user_id){
        List<Cart> cartList = cartRepository.findAllByUserIdOrderByCreatedDateDesc(user_id);
        List<CartDto> cartItems = new ArrayList<>();
        for (Cart cart : cartList){
            CartDto cartDto = getDtoFromCart(cart);
            cartItems.add(cartDto);
        }
        double totalCost = 0;
        for (CartDto cartDto : cartItems) {
            totalCost += (CartDto.getProduct().getPrice() * cartDto.getQuantity());
        }
            CartCost cartCost = new CartCost(cartItems, totalCost);
            return  cartCost;
                 }

        private static CartDto getDtoFromCart(Cart cart) {
        CartDto cartDto = new CartDto(cart);
        return cartDto;
    }
    public void updateCartItem(AddToCartDto cartDto, int userId, Product product){
        Cart cart = getAddToCartFromDto(cartDto, userId);
        cart.setQuantity(cartDto.getQuantity());
        cart.setUserId(cartDto.getUserId());
        cart.setId(cartDto.getId());
        cart.setProductId(cartDto.getProductId());
        cartRepository.save(cart);
    }
    public void deleteCartItem(int id){
        cartRepository.deleteById(id);
    }
}

