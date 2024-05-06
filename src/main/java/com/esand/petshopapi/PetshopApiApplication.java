package com.esand.petshopapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@EnableFeignClients

@SpringBootApplication
public class PetshopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetshopApiApplication.class, args);
	}

}
