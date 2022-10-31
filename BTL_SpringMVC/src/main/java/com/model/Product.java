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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private int id;
	@Column(name = "name")
	@NotEmpty(message = "Please enter your name")
	private String name;
	@Column(name = "price")
	@NotNull(message = "Please enter your price")
	@Max(value = 1000000000 , message = "Value should be greater then then equal to 1000000000")
	@Min(value = 0 , message = "Value should be greater then then equal to 0")
	private Float price;
	@NotNull(message = "Please enter your quantity")
	@Max(value = 1000 , message = "Value should be greater then then equal to 1000 product")
	@Min(value = 1 , message = "Value should be greater then then equal to 1")
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "image")
	private String image;
	@Column(name = "status")
	@NotNull(message = "Please choose status")
	private Boolean status;
	@ManyToOne
	@JoinColumn(name = "categoryId", referencedColumnName = "cid")
	@NotNull(message = "Please choose categoryId")
	private Category categoryId;
	@OneToMany(mappedBy = "productId")
	private List<Order> orders;

	public Product() {
		super();
	}

	public Product(int id, String name, Float price, int quantity, String image, Boolean status, Category categoryId,
			List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.status = status;
		this.categoryId = categoryId;
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

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
