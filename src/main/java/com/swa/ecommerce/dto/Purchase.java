package com.swa.ecommerce.dto;

import com.swa.ecommerce.entity.Address;
import com.swa.ecommerce.entity.Customer;
import com.swa.ecommerce.entity.Order;
import com.swa.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
