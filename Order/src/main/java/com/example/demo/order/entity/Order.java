/**
 * 
 */
package com.example.demo.order.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.order.dto.OrderDTO;
import com.example.demo.order.enums.OrderStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 13, 2022
 */
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "order_no")
	private String orderNo;

	@Column(name = "order_date")
	private Date orderDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private OrderStatus status = OrderStatus.DRAFT;

	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true) // default fetch type = LAZY
	private List<OrderItems> orderItems = new ArrayList<>();

	public Order() {
		super();
	}

	public Order(OrderDTO dto) {
		this.id = dto.getId();
		this.orderNo = dto.getOrderNo();
		this.orderDate = dto.getOrderDate();
		this.status = dto.getStatus();
		this.customer = dto.getCustomerDTO() == null ? null : new Customer(dto.getCustomerDTO());
	}

}
