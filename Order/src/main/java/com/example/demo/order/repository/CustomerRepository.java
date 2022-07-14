/**
 * 
 */
package com.example.demo.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.order.entity.Customer;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 14, 2022
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
