/**
 * 
 */
package com.example.demo.order.dto;

import java.io.Serializable;

import com.example.demo.order.entity.OrderItems;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 14, 2022
 */
@Getter
@Setter
@ToString
public class OrderItemsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5581110063377704070L;

	private Integer id;

	private int quantity;

	private Double total;

	private OrderDTO orderDTO;

	private ProductDTO productDTO;
	
	public OrderItemsDTO() {
		super();
	}	

	public OrderItemsDTO(OrderItems entity) {
		this.id = entity.getId();
		this.quantity = entity.getQuantity();
		this.total = entity.getTotal();
		this.orderDTO = entity.getOrder() == null ? null : new OrderDTO(entity.getOrder());
		this.productDTO = entity.getProduct() == null ? null : new ProductDTO(entity.getProduct());
	}


}
