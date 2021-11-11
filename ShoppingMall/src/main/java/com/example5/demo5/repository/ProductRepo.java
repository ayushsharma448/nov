package com.example5.demo5.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example5.demo5.Entity.Product;

@Repository
public interface ProductRepo  extends JpaRepository<Product, Long>
{

	List<Product> findByNameAndCategory(String name, String category);
	
	@Transactional
	  @Query(value="Update Product p SET p.prod_qunatity = p.prod_qunatity - :sQuant where p.pid=:pid", nativeQuery=true)
	  @Modifying void updateQuantityTotalProduct(@Param("pid") Long pid,@Param("sQuant") Long sQuant);
	  
		 
}
