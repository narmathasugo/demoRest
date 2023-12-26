package com.sigma.demo.model;

import java.math.BigDecimal;
import java.util.Collection;

import flexjson.JSONSerializer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String toJson() {
		return new JSONSerializer().exclude("*.class").serialize(this);
	}
	public static String toJsonArray(Collection<Item> collection) {
		return new JSONSerializer().exclude("*.class").serialize(collection);
	}

}
