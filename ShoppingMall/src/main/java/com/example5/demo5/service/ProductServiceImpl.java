package com.example5.demo5.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example5.demo5.Entity.Product;
import com.example5.demo5.repository.ProductRepo;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo prodRepo;

	@Autowired
	ProductRepo productRepo;
	
	@Override
	public Product addProduct(Product prod) {
		prodRepo.save(prod);
		return prod;
	}

	@Override
	public List<Product> getProductDtls()
	{
		return (List<Product>) productRepo.findAll();
	}

	@Override
	public List<Product> findByNameAndCategory(String name, String category) {
		return (List<Product>)productRepo.findByNameAndCategory(name,category);
	}

	@Override
	public Product update(Product product) {
		Optional<Product> productOptional = productRepo.findById(product.getId());
		if (productOptional.isPresent())
		{
			BeanUtils.copyProperties(product, productOptional.get(), "id");
			productRepo.save(productOptional.get());
            return product;
		}
		return null;
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





	



