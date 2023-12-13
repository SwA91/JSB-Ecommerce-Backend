package com.swa.ecommerce.controller;

import com.swa.ecommerce.dto.Purchase;
import com.swa.ecommerce.dto.PurchaseResponse;
import com.swa.ecommerce.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService _checkoutService) {
        this.checkoutService = _checkoutService;
    }

    @PostMapping(value = "/purchase", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        return checkoutService.placeOrder(purchase);
    }
}
