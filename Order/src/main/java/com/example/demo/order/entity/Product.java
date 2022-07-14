/**
 * 
 */
package com.example.demo.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.order.dto.ProductDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 13, 2022
 */
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "unit_price")
	private Double unitPrice;

//	@ManyToOne
//	@JoinColumn(name = "order_items_id", referencedColumnName = "id")
//	private OrderItems orderItems;

	public Product() {
		super();
	}

	public Product(ProductDTO dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.unitPrice = dto.getUnitPrice();
		// this.orderItems = dto.getOrderItemsDTO() == null ? null : new
		// OrderItems(dto.getOrderItemsDTO());
	}

}
