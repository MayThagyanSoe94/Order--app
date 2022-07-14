/**
 * 
 */
package com.example.demo.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.order.dto.CustomerDTO;
import com.example.demo.order.entity.Customer;
import com.example.demo.order.repository.CustomerRepository;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 14, 2022
 */
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerDTO> getAll() {
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		List<Customer> customers = customerRepository.findAll();
		if (customers != null) {
			for (Customer c : customers) {
				CustomerDTO dto = new CustomerDTO(c);
				customerDTOs.add(dto);
			}
		}
		return customerDTOs;
	}

	@Transactional(rollbackFor = Exception.class)
	public void register(CustomerDTO customerDTO) {
		Customer c = new Customer();
		c.setName(customerDTO.getName());
		c.setPhone(customerDTO.getPhone());
		c.setEmail(customerDTO.getEmail());
		c.setAddress(customerDTO.getAddress());
		customerRepository.save(c);

	}

	@Transactional(rollbackFor = Exception.class)
	public void update(CustomerDTO customerDTO) {
		Optional<Customer> customerOptional = customerRepository.findById(customerDTO.getId());
		Customer c = customerOptional.get();
		c.setName(customerDTO.getName());
		c.setPhone(customerDTO.getPhone());
		c.setEmail(customerDTO.getEmail());
		c.setAddress(customerDTO.getAddress());
		customerRepository.save(c);
	}

	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id) {
		customerRepository.deleteById(id);
	}

}
