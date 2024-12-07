package com.gc.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gc.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
