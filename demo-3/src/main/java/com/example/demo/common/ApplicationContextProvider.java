package com.example.demo.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {
	
	
	private static ApplicationContext ctx = null;  

	public static ApplicationContext getApplicationContext() {           
		return ctx;      
	}  

	@Override
	public void setApplicationContext(ApplicationContext context) { 
		ctx = context;  // NOSONAR
	}

}
