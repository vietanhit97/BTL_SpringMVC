package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
	private int id;
	@Column(name = "total_amount")
	private Float totalAmount;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "role")
	private Boolean role;
	@ManyToOne
	@JoinColumn(name = "productId",referencedColumnName = "pid")
	private Product productId;
	
	public Order() {
		super();
	}

	public Order(int id, Float totalAmount, Integer quantity, Boolean role, Product product_id) {
		super();
		this.id = id;
		this.totalAmount = totalAmount;
		this.quantity = quantity;
		this.role = role;
		this.productId = product_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getRole() {
		return role;
	}

	public void setRole(Boolean role) {
		this.role = role;
	}

	public Product getProduct_id() {
		return productId;
	}

	public void setProduct_id(Product product_id) {
		this.productId = product_id;
	}
	
}
