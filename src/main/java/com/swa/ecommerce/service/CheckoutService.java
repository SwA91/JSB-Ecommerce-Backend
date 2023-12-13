package com.swa.ecommerce.service;

import com.swa.ecommerce.dto.Purchase;
import com.swa.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
