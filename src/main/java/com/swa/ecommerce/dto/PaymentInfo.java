package com.swa.ecommerce.dto;

import lombok.Data;

/**
 * PaymentInfo
 */
@Data
public class PaymentInfo {

    private int amount;
    private String currency;
}