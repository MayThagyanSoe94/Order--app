/**
 * 
 */
package com.example.demo.order.dto;

import java.io.Serializable;

import com.example.demo.order.entity.Customer;

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
public class CustomerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6304665084725889118L;

	private Integer id;

	private String name;

	private String email;

	private String phone;

	private String address;

	public CustomerDTO() {
		super();
	}

	public CustomerDTO(Customer entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.phone = entity.getPhone();
		this.address = entity.getAddress();
	}

}
