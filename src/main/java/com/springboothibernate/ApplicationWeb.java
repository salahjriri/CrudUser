package com.springboothibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class ApplicationWeb extends SpringBootServletInitializer{
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(ApplicationWeb.class);
	    }

	public static void main(String args[]){
		SpringApplication.run(ApplicationWeb.class, args);
	}
}
