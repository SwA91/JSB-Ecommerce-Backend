package com.swa.ecommerce.dao;

import com.swa.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Productrepository extends JpaRepository<Product, Long> {
}
