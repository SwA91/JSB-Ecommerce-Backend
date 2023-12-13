package com.swa.ecommerce.dto;

import lombok.Data;

@Data
public class PurchaseResponse {
    // con final lombok nos hace un constructor con esta propiedad
    private final String orderTrackingNumber;
}
