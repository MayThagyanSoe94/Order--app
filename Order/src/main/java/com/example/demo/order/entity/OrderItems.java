/**
 * 
 */
package com.example.demo.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.order.dto.OrderItemsDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 14, 2022
 */
@Getter
@Setter
@Entity
@Table(name = "order_items")
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "total")
	private Double total;

	@ManyToOne
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;

	public OrderItems() {
		super();
	}

	public OrderItems(OrderItemsDTO dto) {
		this.id = dto.getId();
		this.quantity = dto.getQuantity();
		this.total = dto.getTotal();
		this.order = dto.getOrderDTO() == null ? null : new Order(dto.getOrderDTO());
		this.product = dto.getProductDTO() == null ? null: new Product(dto.getProductDTO());

	}
}
