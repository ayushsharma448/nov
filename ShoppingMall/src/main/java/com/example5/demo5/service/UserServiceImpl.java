package com.example5.demo5.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example5.demo5.Entity.Product;
import com.example5.demo5.Entity.User;
import com.example5.demo5.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public User createUser(User user) {
		userRepo.save(user);
		return user;
	}	
	
	

}
	
	
	
	
	
	
	
	/*
	 * @Override public Employee createUser(Employee emp) {
	 * System.out.println("---------one to one call start");
	 * //System.out.println("emp addr:"+emp.getAddress().getCity()+emp.getAddress().
	 * getStreet()); empRepo.save(emp); return emp; }
	 * 
	 * @Override public List<Employee> getUser() { List<Employee>
	 * le=empRepo.findAbc(1); le.forEach(emp ->{System.out.println(emp);});
	 * 
	 * System.out.println("---------------findXyz() below---------------");
	 * List<Employee> lo = empRepo.findXyz(); lo.forEach(emp
	 * ->{System.out.println(emp);}); //empRepo.addSalutationToName("");
	 * //-------findByNameAndSalary return (List<Employee>)empRepo.findAll(); }
	 */





	



