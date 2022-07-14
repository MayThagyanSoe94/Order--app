/**
 * 
 */
package com.example.demo.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.order.entity.Product;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 13, 2022
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
	

}
