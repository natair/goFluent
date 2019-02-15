package com.shopping.basket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity(name="basket")
public class Basket {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long basketid;
     
    @NotBlank(message = "ItemName is mandatory")
    private String itemname;
     
    //@NotBlank(message = "Quantity is mandatory")
    private int quantity;
    
    //@NotBlank(message = "Price is mandatory")
    private double price;
   
    public Basket() {}

	public long getBasketid() {
		return basketid;
	}

	public void setBasketid(long basketid) {
		this.basketid = basketid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
    
    

	
    
}
