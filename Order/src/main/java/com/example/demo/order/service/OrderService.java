package com.example.demo.order.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.order.dto.OrderDTO;
import com.example.demo.order.dto.OrderItemsDTO;
import com.example.demo.order.entity.Customer;
import com.example.demo.order.entity.Order;
import com.example.demo.order.entity.OrderItems;
import com.example.demo.order.entity.Product;
import com.example.demo.order.repository.CustomerRepository;
import com.example.demo.order.repository.OrderItemsRepository;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.order.repository.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemsRepository orderItemsRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Transactional(rollbackFor = Exception.class)
	public void register(OrderDTO orderDTO) throws ParseException {
		Date currentDate = new Date();

		Order o = new Order();
		o.setId(orderDTO.getId());
		o.setOrderNo(orderDTO.getOrderNo());
		o.setOrderDate(currentDate);
		Optional<Customer> customerOptional = customerRepository.findById(orderDTO.getCustomerDTO().getId());
		o.setCustomer(customerOptional.get());
		orderRepository.save(o);
		if (orderDTO.getOrderItemsDTOs() != null) {
			for (OrderItemsDTO dto : orderDTO.getOrderItemsDTOs()) {
				Optional<Product> productOptional = productRepository.findById(dto.getProductDTO().getId());
				dto.setTotal(dto.getQuantity() * productOptional.get().getUnitPrice());
				OrderItems e = new OrderItems(dto);
				e.setOrder(o);
				orderItemsRepository.save(e);
			}
		}
	}

	public List<OrderDTO> getAll() {
		List<OrderDTO> orderDTOs = new ArrayList<>();
		List<OrderItemsDTO> orderItemsDTOs = new ArrayList<>();
		List<Order> orders = orderRepository.findAll();

		if (orders != null) {
			for (Order o : orders) {
				OrderDTO dto = new OrderDTO(o);
				orderItemsDTOs = orderItemsRepository.findAllById(o.getId());
				dto.setOrderItemsDTOs(orderItemsDTOs);
				orderDTOs.add(dto);
				System.out.println("dto >>> " + dto.toString());
			}
		}
		return orderDTOs;
	}

	@Transactional(rollbackFor = Exception.class)
	public void update(OrderDTO orderDTO) {
		Optional<Order> orderOptional = orderRepository.findById(orderDTO.getId());
		Order o = orderOptional.get();
		o.setId(orderDTO.getId());
		o.setOrderNo(o.getOrderNo());
		Optional<Customer> customerOptional = customerRepository.findById(orderDTO.getCustomerDTO().getId());
		o.setCustomer(customerOptional.get());
		orderRepository.save(o);
		if (orderDTO.getOrderItemsDTOs() != null) {
			for (OrderItemsDTO dto : orderDTO.getOrderItemsDTOs()) {
				orderItemsRepository.deleteById(o.getId());
				Optional<Product> productOptional = productRepository.findById(dto.getProductDTO().getId());
				dto.setTotal(dto.getQuantity() * productOptional.get().getUnitPrice());
				OrderItems e = new OrderItems(dto);
				e.setOrder(o);
				orderItemsRepository.save(e);
			}
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id) {
		orderRepository.deleteById(id);
	}
}
