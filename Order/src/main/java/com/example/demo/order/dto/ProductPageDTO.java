/**
 * 
 */
package com.example.demo.order.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 13, 2022
 */
@Data
public class ProductPageDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4864322481426911089L;

	List<ProductDTO> products = new ArrayList<>();
	
	int page;
	int size;
	int numberofElements;
	long totalElements;
	int totalPages;

}
