package com.shopping.basket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.shopping.basket.controller"})
@SpringBootApplication
/*
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.shopping.basket"})
@EnableJpaRepositories(basePackages="com.shopping.basket.repository")
@EnableTransactionManagement
@EntityScan(basePackages="com.shopping.basket.entity")
*/

public class ShoppingBasketApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingBasketApplication.class, args);
	}

}

