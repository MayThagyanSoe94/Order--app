package com.example.demo.order.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.order.api.OrderApiConstant;
import com.example.demo.order.dto.OrderDTO;
import com.example.demo.order.service.OrderService;
import com.example.demo.order.utils.CommonUtil;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 13, 2022
 */
@RestController
public class OrderController implements OrderApiConstant {

	private final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = ORDERS, method = RequestMethod.GET)
	public ResponseEntity<?> getOrders() {
		logger.debug("Start get all orders.....");
		List<OrderDTO> dtos = orderService.getAll();
		logger.debug("Start get all orders.....");
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@RequestMapping(value = ORDER, method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody OrderDTO orderDTO) throws ParseException {
		System.out.println("OrderDTO >>> "+orderDTO.toString());
		logger.debug("Start register order.....");

		orderService.register(orderDTO);

		logger.debug("End register order.....");
		return new ResponseEntity<>(CommonUtil.responseSuccessMessage("Register order is success."),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = ORDER, method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody OrderDTO orderDTO) {
		logger.debug("Start update order.....");

		orderService.update(orderDTO);

		logger.debug("End update order.....");
		return new ResponseEntity<>(CommonUtil.responseString("Update order is success."), HttpStatus.OK);
	}

	@RequestMapping(value = DELETEORDERBYID, method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteOrderById(@PathVariable(required = true, name = "id") Integer id) {
		logger.debug("Start delete order.....");
		orderService.delete(id);
		logger.debug("End delete order.....");
		return new ResponseEntity<>(CommonUtil.responseString("Delete order is success."), HttpStatus.OK);
	}

}
