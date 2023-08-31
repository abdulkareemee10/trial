package com.testing.quizApp.service;

import Dto.ProductDto;
import Model.Category;
import Model.Product;
import Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public ProductService(){

    }

    public List<Product> listProduct() {
        return (List<Product>) productRepository.findAll();
    }

    public  Product getProductById(Long productId) throws ProductNotExistException {
        Optional <Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent())
            throw new ProductNotExistException("product id is invalid " + productId);
            return optionalProduct.get();
    }


    public void addProduct(ProductDto productDto, Category category) {

    }

    public void updateProduct(Integer productId, Product newProduct) {
        Product product = productRepository.findById(productId).get();
        product.setName(newProduct.getName());
        product.setDescription(newProduct.getDescription());
        productRepository.save(product);
    }


    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }

}
