package com.facturacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FinalBetaFacturacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalBetaFacturacionApplication.class, args);
	}
	
	@Bean
	RestTemplate restTample () {
		return new RestTemplate();
	}
}
