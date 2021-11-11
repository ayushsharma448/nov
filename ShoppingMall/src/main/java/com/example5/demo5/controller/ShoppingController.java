package com.example5.demo5.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example5.demo5.Entity.ApiResponse;
import com.example5.demo5.Entity.Product;
import com.example5.demo5.Entity.Seller;
import com.example5.demo5.Entity.User;
import com.example5.demo5.repository.ProductRepo;
import com.example5.demo5.repository.SellerRepo;
import com.example5.demo5.service.ProductService;
import com.example5.demo5.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class ShoppingController {

	@Autowired
	ProductService prodService;	
	
	@Autowired
	UserService userService;
	
	@Autowired
	SellerRepo sellerRepo;
	
	@Autowired
	ProductRepo prodRepo;
	
	@PostMapping("/addProduct")
	Product addProduct(@Valid @RequestBody Product addProd)
	{		
		return prodService.addProduct(addProd);
	}
	
	@PostMapping("/createUser")
	User createUser(@Valid @RequestBody User userDtls)
	{		
		return userService.createUser(userDtls);
	}
	
	@GetMapping("/getProduct")
	List<Product> geProductDtls()
	{
		return prodService.getProductDtls();
	}
			
	@GetMapping("/sellers")
    public List<Seller> getAllSellers() {
        return (List<Seller>) sellerRepo.findAll();
    }

    @PostMapping("/mall/{pid}/{sid}/seller")
    public Seller createSeller(@PathVariable (value = "pid") Long pid,
    						   @PathVariable (value = "sid") Long sid,
                                 @Valid @RequestBody Seller seller) {
    	
    	List<Seller> s= sellerRepo.findAbc(sid,pid);    	   	
    	if (s.size()>0)
    	{
    		sellerRepo.updateQantityToSeller(seller.getsQuantity(),sid,pid);
			return 	s.get(0);
    	}   
    	
    	return prodRepo.findById(pid).map(product -> {
        	seller.setProduct(product);
            return sellerRepo.save(seller);
        }).get();
    }
    
    @PutMapping("/productUpdate/{id}")
    public ApiResponse<Product> updateProduct(@RequestBody Product product) {
        return new ApiResponse<>(HttpStatus.OK.value(), 
        		"User updated successfully.",prodService.update(product));
    }
    
    @PostMapping("quantityUpdate/{pid}/{sellerid}")
    public String updateQuantitySellerProduct(@PathVariable (value = "pid") Long pid,
			   @PathVariable (value = "sellerid") Long sellerid,
    		 @RequestParam(value="quantityBooked") Long quantityBooked)
    {
    	prodRepo.updateQuantityTotalProduct(pid,quantityBooked);
    	sellerRepo.updateQuantitySellerProduct(pid,sellerid,quantityBooked);
    	return "success"+pid+sellerid+quantityBooked;
    }
}
