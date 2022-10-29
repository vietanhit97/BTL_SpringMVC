package com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private Float price ;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "image")
	private String image;
	@Column(name = "status")
	private Boolean status;
	@ManyToOne
	@JoinColumn(name = "categoryId",referencedColumnName = "cid")
	private Category categoryId;
	@OneToMany(mappedBy = "productId")
	private List<Order> orders;
	
	public Product() {
		super();
	}

	public Product(int id, String name, Float price, int quantity, String image, Boolean status, Category category_id,
			List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.status = status;
		this.categoryId = category_id;
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Category getCategory_id() {
		return categoryId;
	}

	public void setCategory_id(Category category_id) {
		this.categoryId = category_id;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
