package com.sampleFramework.common.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.sampleFramework.common.config.ServerConfig;
import com.sampleFramework.common.exception.DataFormatException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseController {

	public static final String RESULT_CODE = "RESULT_CODE";
	public static final String RESULT_CODE_MESSAGE = "RESULT_CODE_MESSAGE";
	private static final String RESULT_SUCCESS_MESSAGE = "RESULT_SUCCESS";
	public static final String RESULT_SUCCESS_CODE = "0000";
	public static final String RESULT_ERROR_CODE = "9999";
	
	
	/**
	 * return server mode
	 * 
	 * @return D:개발, S:검증, P:운영
	 */
	public static String getServerMode() {
		return ServerConfig.getInstance().getServerMode();
	}
	
	/**
	 * success response
	 * 
	 * @param String messageStr
	 * @param JsonObject logObj
	 * @param HttpServletRequest request
	 * @return Map<String, String> responseMap
	 */
	public static Map<String, String> successResponse(String messageStr, JsonObject logObj, HttpServletRequest request) {
		Map<String, String> responseMap = new HashMap<String, String>();
		
		responseMap.put(RESULT_CODE, RESULT_SUCCESS_CODE);
		responseMap.put(RESULT_CODE_MESSAGE, RESULT_SUCCESS_MESSAGE);
		
		log.info("=========================== Response ===========================");
		log.info(responseMap.toString());
		
		return responseMap;
	}
	
	/**
	 * error response
	 * 
	 * @param String messageStr
	 * @return Map<String, String> responseMap
	 */
	public static Map<String, String> errorResponse(String exceptionMessage) {
		Map<String, String> responseMap = new HashMap<String, String>();
		
		responseMap.put(RESULT_CODE, RESULT_ERROR_CODE);
		responseMap.put(RESULT_CODE_MESSAGE, exceptionMessage);
		
		log.info("=========================== Response ===========================");
		log.info(responseMap.toString());
		
		return responseMap;
	}
	/**
	 * @param dataFormatException
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler({DataFormatException.class})
	public Map<String, String> dataFormatError(DataFormatException dataFormatException) {
		log.error("Excption["+ dataFormatException.getClass().getName() + "], Exception Message : " +  dataFormatException.getMessage());
		log.error("", dataFormatException);
		return errorResponse(dataFormatException.getMessage());
	}
}
