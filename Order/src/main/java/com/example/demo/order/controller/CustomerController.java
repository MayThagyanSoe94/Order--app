/**
 * 
 */
package com.example.demo.order.controller;

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

import com.example.demo.order.api.CustomerApiConstant;
import com.example.demo.order.dto.CustomerDTO;
import com.example.demo.order.service.CustomerService;
import com.example.demo.order.utils.CommonUtil;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 14, 2022
 */
@RestController
public class CustomerController implements CustomerApiConstant {

	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = CUSTOMERS, method = RequestMethod.GET)
	public ResponseEntity<?> getCustomers() {
		logger.debug("Start get all customer.....");
		logger.debug("End get all customer.....");
		List<CustomerDTO> dtos = customerService.getAll();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@RequestMapping(value = CUSTOMER, method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody CustomerDTO customerDTO) {
		logger.debug("Start register customer.....");

		customerService.register(customerDTO);

		logger.debug("End register customer.....");
		return new ResponseEntity<>(CommonUtil.responseSuccessMessage("Register customer is success."),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = CUSTOMER, method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody CustomerDTO customerDTO) {
		logger.debug("Start update customer.....");

		customerService.update(customerDTO);

		logger.debug("End update customer.....");
		return new ResponseEntity<>(CommonUtil.responseString("Update customer is success."), HttpStatus.OK);
	}

	@RequestMapping(value = DELETECUSTOMERBYID, method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProductById(@PathVariable(required = true, name = "id") Integer id) {
		logger.debug("Start delete customer.....");
		customerService.delete(id);
		logger.debug("End delete customer.....");
		return new ResponseEntity<>(CommonUtil.responseString("Delete customer is success."), HttpStatus.OK);
	}

}
