package com.dxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.beans.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}