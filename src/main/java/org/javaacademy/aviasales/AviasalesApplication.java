package org.javaacademy.aviasales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AviasalesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AviasalesApplication.class, args);
	}

}
