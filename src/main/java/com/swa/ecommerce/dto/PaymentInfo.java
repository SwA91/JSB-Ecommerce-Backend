package com.swa.ecommerce.dto;

import lombok.Data;

/**
 * PaymentInfo
 */
@Data
public class PaymentInfo {

    private int amount; // representado en centimos
    private String currency;
    private String receiptEmail;
}