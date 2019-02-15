package com.shopping.basket.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shopping.basket.entity.Basket;
import com.shopping.basket.repository.ShoppingBasketRepository;

@Controller
public class ShoppingBasketController {
	
	
	private ShoppingBasketRepository repo;
	private double totalAmount = 0.00;
	
	//@Autowired
	//Basket basket;
	
	@Autowired
    public ShoppingBasketController(ShoppingBasketRepository repo) {
        this.repo = repo;
    }
	
	@GetMapping("/shopping")
    public String shoppingList(Model model) {
		model.addAttribute("baskets", repo.findAll());			
		model.addAttribute("totalAmount", getTotalPrice());
        return "shopping-list";
    }
	
	
	 @GetMapping("/addShopping")
    public String showAddForm(Basket basket) {
        return "add-shopping";
    }
	
    @PostMapping("/saveShopping")
    public String saveShopping(@Valid Basket basket, BindingResult result, Model model) {
    	
        if (result.hasErrors()) {
            return "add-shopping";
        }         
 
        repo.save(basket);        
        model.addAttribute("baskets", repo.findAll());
        model.addAttribute("totalAmount", getTotalPrice());
        return "shopping-list";
    }
	
    
    @GetMapping("/edit/{basketid}")
    public String showUpdateForm(@PathVariable("basketid") long basketid, Model model) {       
        Basket basket = repo.findById(basketid)        		
          .orElseThrow(() -> new IllegalArgumentException("Invalid id:" + basketid));         
        model.addAttribute("basket", basket);
        return "update-shopping";
    }
    
    
    @PostMapping("/update/{basketid}")
    public String updateUser(@PathVariable("basketid") long basketid, @Valid Basket basket, 
      BindingResult result, Model model) {
        if (result.hasErrors()) {        	
        	basket.setBasketid(basketid);
            return "update-shopping";
        }
             
        repo.save(basket);
        model.addAttribute("baskets", repo.findAll());
        model.addAttribute("totalAmount", getTotalPrice());
        return "shopping-list";
    }        
    @GetMapping("/delete/{basketid}")
    public String deleteUser(@PathVariable("basketid") long basketid, Model model) {
        Basket basket = repo.findById(basketid)
          .orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + basketid));
        repo.delete(basket);
        model.addAttribute("baskets", repo.findAll());
        model.addAttribute("totalAmount", getTotalPrice());
        return "shopping-list";
    }
    
    public double getTotalPrice() {
    	totalAmount = 0.00;
    	try {
    		totalAmount = repo.getTotalAmount();
    	}catch(Exception e) {
    		
    	}    	    
    	return totalAmount;
    }
}
