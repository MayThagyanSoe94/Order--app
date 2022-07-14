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

import com.example.demo.order.dto.ProductDTO;
import com.example.demo.order.entity.Product;
import com.example.demo.order.repository.ProductRepository;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 13, 2022
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional(rollbackFor = Exception.class)
	public void register(ProductDTO productDTO) {
		Product p = new Product();
		p.setName(productDTO.getName());
		p.setUnitPrice(productDTO.getUnitPrice());
		productRepository.save(p);
	}

	public List<ProductDTO> getAll() {
		List<ProductDTO> productDTOs = new ArrayList<>();
		List<Product> products = productRepository.findAll();
		if (products != null) {
			for (Product p : products) {
				ProductDTO dto = new ProductDTO(p);
				productDTOs.add(dto);
			}
		}
		return productDTOs;
	}

	@Transactional(rollbackFor = Exception.class)
	public void update(ProductDTO productDTO) {
		Optional<Product> productOptional = productRepository.findById(productDTO.getId());
		Product p = productOptional.get();
		p.setName(productDTO.getName());
		p.setUnitPrice(productDTO.getUnitPrice());
		productRepository.save(p);
	}

	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id) {
		productRepository.deleteById(id);
	}

}
