package com.dgrh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.dgrh"})
@SpringBootApplication()
public class toolsApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(toolsApplication.class, args);
	}

}
