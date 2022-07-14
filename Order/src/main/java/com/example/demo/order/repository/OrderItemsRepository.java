/**
 * 
 */
package com.example.demo.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.order.dto.OrderItemsDTO;
import com.example.demo.order.entity.OrderItems;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 14, 2022
 */
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {

	@Query(value = "SELECT i FROM OrderItems i WHERE i.order.id = :id")
	List<OrderItemsDTO> findAllById(@Param("id") Integer id);

}
