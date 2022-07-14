/**
 * 
 */
package com.example.demo.order.dto;

import java.io.Serializable;

import com.example.demo.order.entity.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 13, 2022
 */
@Getter
@Setter
@ToString
public class ProductDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7275918505492492245L;

	private Integer id;

	private String name;

	private Double unitPrice;

	//private OrderItemsDTO orderItemsDTO;

	public ProductDTO() {
		super();
	}

	public ProductDTO(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.unitPrice = entity.getUnitPrice();
		//this.orderItemsDTO = entity.getOrderItems() == null ? null : new OrderItemsDTO(entity.getOrderItems());
	}

}
