package com.example.demo.order.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.order.entity.Order;
import com.example.demo.order.enums.OrderStatus;

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
public class OrderDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7864496576526042661L;

	private Integer id;

	private String orderNo;

	private Date orderDate;

	private OrderStatus status = OrderStatus.DRAFT;

	private CustomerDTO customerDTO;

	private List<OrderItemsDTO> orderItemsDTOs = new ArrayList<>();
	

	public OrderDTO() {
		super();
	}
	
	public OrderDTO(Order entity) {
		this.id = entity.getId();
		this.orderNo = entity.getOrderNo();
		this.orderDate = new Date();
		this.status = entity.getStatus();
		this.customerDTO = entity.getCustomer() == null ? null:new CustomerDTO(entity.getCustomer());
	}




}
