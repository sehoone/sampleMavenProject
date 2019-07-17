package com.sampleFramework.common.interceptor;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("=========================== DefaultInterceptor start ===========================");

		return super.preHandle(request, response, handler);

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
		
		Collection<String> headers = response.getHeaderNames();
		
		Iterator<String> itr = headers.iterator();
				
		while(itr.hasNext()) {
			String headerName = itr.next();
			String value = response.getHeader(headerName);
			log.info("headerName[" + headerName + "] value[" + value + "]");
		}
		log.info("=========================== DefaultInterceptor end ===========================");

	}

}
