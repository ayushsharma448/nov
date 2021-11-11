package com.example5.demo5.repository;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example5.demo5.Entity.Seller;

@Repository
public interface SellerRepo extends PagingAndSortingRepository<Seller, Long>
{

	@Query(value="SELECT * FROM Seller e WHERE e.seller_id = :sid AND e.pid=:pid", nativeQuery=true) //Named parameter  e.sellerId = :sid AND @Param("sid") Long sellerId,
	List<Seller> findAbc(@Param("sid") Long sellerId,@Param("pid") Long pid);
	
		
	  @Transactional	  
	  @Query(value="Update Seller s SET s.s_quantity = s.s_quantity + :sQuant where s.pid=:id AND s.seller_id = :sid", nativeQuery=true)	  
	  @Modifying void updateQantityToSeller(@Param("sQuant") Long sQuant,@Param("sid") Long sellerId,@Param("id") Long id);

	  @Transactional
	  @Query(value="Update Seller s SET s.s_quantity = s.s_quantity - :sQuant where s.pid=:pid AND s.seller_id = :sid", nativeQuery=true)
	  @Modifying void updateQuantitySellerProduct(@Param("pid") Long pid,@Param("sid") Long sid,@Param("sQuant") Long sQuant);
	  
/**
 * @param sQuant
 * @param id
 */

	  
}
