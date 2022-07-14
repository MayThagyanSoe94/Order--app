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

import com.example.demo.order.api.ProductApiConstant;
import com.example.demo.order.dto.ProductDTO;
import com.example.demo.order.service.ProductService;
import com.example.demo.order.utils.CommonUtil;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 13, 2022
 */
@RestController
public class ProductController implements ProductApiConstant {

	private final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = PRODUCTS, method = RequestMethod.GET)
	public ResponseEntity<?> getProducts() {
		logger.debug("Start get all product.....");
		List<ProductDTO> dtos = productService.getAll();
		logger.debug("End get all product.....");
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@RequestMapping(value = PRODUCT, method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody ProductDTO productDTO) {
		logger.debug("Start register product.....");

		productService.register(productDTO);

		logger.debug("End register product.....");
		return new ResponseEntity<>(CommonUtil.responseSuccessMessage("Register product is success."),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = PRODUCT, method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody ProductDTO productDTO) {
		logger.debug("Start update product.....");

		productService.update(productDTO);

		logger.debug("End update product.....");
		return new ResponseEntity<>(CommonUtil.responseString("Update product is success."), HttpStatus.OK);
	}

	@RequestMapping(value = DELETEPRODUCTBYID, method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProductById(@PathVariable(required = true, name = "id") Integer id) {
		logger.debug("Start delete product.....");
		productService.delete(id);
		logger.debug("End delete product.....");
		return new ResponseEntity<>(CommonUtil.responseString("Delete product is success."), HttpStatus.OK);
	}

}
