package com.shopping.basket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopping.basket.entity.Basket;

@Repository
public interface ShoppingBasketRepository extends JpaRepository<Basket, Long>{

	 List<Basket> findByItemname(String itemName);
	 	 
	 @Query("SELECT SUM(price) from basket")
	 double getTotalAmount();
	 
	 
	 //Basket findByBasketid(Long )
}
