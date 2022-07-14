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

import com.example.demo.order.dto.CustomerDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 14, 2022
 */
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "address")
	private String address;

	public Customer() {
		super();
	}

	public Customer(CustomerDTO dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.email = dto.getEmail();
		this.phone = dto.getPhone();
		this.address = dto.getAddress();
	}

}
