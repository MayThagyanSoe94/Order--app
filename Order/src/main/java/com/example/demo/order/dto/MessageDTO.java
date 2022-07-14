package com.example.demo.order.dto;

import java.io.Serializable;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 13, 2022
 */
@Data
@JsonInclude(Include.NON_NULL)
public class MessageDTO implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 4725295007720533113L;
	
	boolean error;
	String message;
	HashMap<String, String> fieldErrorMessages;


}
