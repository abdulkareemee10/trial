package Model;

import Dto.CartDto;

import java.util.List;

public class CartCost {
    private List<CartDto> cartItems;
    private double totalCost;

    public CartCost(List<CartDto> CartDtoList, double totalCost){
        this.cartItems = CartDtoList;
        this.totalCost = totalCost;
    }

    public List<CartDto> getCartItems(){
        return  cartItems;
    }

    public void setCartItems(List<CartDto> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
