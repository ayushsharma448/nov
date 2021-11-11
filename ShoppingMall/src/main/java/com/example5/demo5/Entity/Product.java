package com.example5.demo5.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pid")
	private long id;
	
	@Column(name="pname")
	private String name;
	
	@Column(name="pCatName")
	private String category;
	
	@Column(name="price")
	private long price;

	@Column(name="model")
	private String model ;
	
	@Column(name="prodQunatity")
	private long prodQuantity;


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", model="
				+ model + ", prodQuantity=" + prodQuantity + "]";
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
		this.price = price;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public long getProdQuantity() {
		return prodQuantity;
	}


	public void setProdQuantity(long prodQuantity) {
		this.prodQuantity = prodQuantity;
	}


	public Product() {
		super();
	}

	
}
