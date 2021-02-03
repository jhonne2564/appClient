package com.nuvu.corenuvu.interceptor;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nuvu.corenuvu.model.SecurityApp;
import com.nuvu.corenuvu.service.UtilsService;

@Configuration
public class SecurityInterceptor  implements WebMvcConfigurer{

	private static final String REQUEST_CLIENT_KEY = "request-client-key";
	private UtilsService utils;
	public SecurityInterceptor(UtilsService utils) {
		super();
		this.utils = utils;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor());
	}
	
	class MyInterceptor implements HandlerInterceptor{
		private final Logger mylogger = LoggerFactory.getLogger(MyInterceptor.class);
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			
			final String path = request.getRequestURI();
			mylogger.debug("########Uri request: {}", path);									
			
			
			boolean isValidKey = false;
			if(request.getHeader(REQUEST_CLIENT_KEY) != null) {
				final SecurityApp security = utils.getClient(request.getHeader(REQUEST_CLIENT_KEY));
				mylogger.debug("########Request Client: {}, {}", request.getHeader(REQUEST_CLIENT_KEY), security);
				if(security != null) {					
					isValidKey = true;
					mylogger.debug("Valid key has been found.");
				}
			}
			
			if(!isValidKey) {
				final String error = "{\"status\": 401, \"error\": \"Unauthorized\", \"message\": " + 
						"\"Authentication failed due to invalid credentials or missing authentication data\"}";
				
				mylogger.error("Response Error: {}, path:{}", error, path);
				
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				response.setContentType("application/json");
				response.getWriter().write(error);
			}
			
			return isValidKey;
		}
		
		
	}
}
