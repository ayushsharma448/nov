package com.example5.demo5.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;
import com.example5.demo5.Entity.User;

@Repository
public interface UserRepo extends PagingAndSortingRepository<User, Long>
{
	
	
		 
}
