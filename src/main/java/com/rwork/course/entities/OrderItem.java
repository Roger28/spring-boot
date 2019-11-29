package com.rwork.course.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rwork.course.entities.pk.OrderItemPK;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{

	public OrderItem() {

	}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		this.id = new OrderItemPK();
		this.id.setOrder(order);
		this.id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	@JsonIgnore
	public Order getOrder() {
		return this.id.getOrder();
	}

	public void setOrder(Order order) {
		this.id.setOrder(order);
	}
	
	public Product getProduct() {
		return this.id.getProduct();
	}

	public void setOrder(Product product) {
		this.id.setProduct(product);
	}
	
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getSubTotal() {
		return this.price * this.quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@EmbeddedId
	private OrderItemPK id;
	private Integer quantity;
	private Double price;
	private static final long serialVersionUID = 1L;

}
