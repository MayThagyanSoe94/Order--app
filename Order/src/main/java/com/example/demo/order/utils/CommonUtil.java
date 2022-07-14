package com.example.demo.order.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.example.demo.order.dto.MessageDTO;

/**
 * @Author May Thagyan Soe
 * @CreatedAt: Jul 13, 2022
 */
public class CommonUtil {

	/**
	 * Change String to JSON Format String
	 * 
	 * @param message
	 * @return
	 */
	public static String responseString(String message) {
		Map<String, String> responseMap = new HashMap<>();
		responseMap.put("message", message);

		return new JSONObject(responseMap).toString();
	}

	/**
	 * Response success message
	 * 
	 * @param message
	 * @return
	 */
	public static MessageDTO responseSuccessMessage(String message) {
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setMessage(message);
		return messageDTO;
	}
	
	/**
	 * @param dateTime
	 * @param standardDateInputFormat
	 * @return
	 */
	public static String dateToString(Date dateTime, String standardDateInputFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(standardDateInputFormat);
		String retDate = new String();
		if (dateTime != null)
			retDate = sdf.format(dateTime);
		return retDate;
	}
	
	/**
	 * @param date
	 * @param standardDateInputFormat
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateWithoutTimeUsingFormat(Date date, String standardDateInputFormat) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(standardDateInputFormat);
		return formatter.parse(formatter.format(date));
	}

}
