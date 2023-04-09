package com.project.stockmicroservices.controller;

import com.project.stockmicroservices.entity.Product;
import com.project.stockmicroservices.entity.StockResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.stockmicroservices.repository.StockRepository;

import java.util.List;
import java.util.Optional;


/**
 * @author Hung Nguyen
 **/

@RestController
public class StockController {
    @Autowired StockRepository stockRepository;


    @GetMapping("/current-stock")
    public StockResponse getCurrentStock(){
        return new StockResponse(stockRepository.findAll());
    }

    @GetMapping("/stock")
    public ResponseEntity<Product> getProductById(@RequestParam("id") Long id) {
        // return product info in JSON
        Optional<Product> products = stockRepository.findById(id);
        return products.map(product -> new ResponseEntity<>(product, HttpStatus.OK)).
                orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @GetMapping("/stock")
    public ResponseEntity<Product> getProductByName(@RequestParam("name") String name) {
        // return product info in JSON
        Optional<Product> products = stockRepository.findByName(name);
        return products.map(product -> new ResponseEntity<>(product, HttpStatus.OK)).
                orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
