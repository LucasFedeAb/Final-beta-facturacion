package com.facturacion.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Productos")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@Column(name = "Codigo barra", unique = true)
	private Integer code;
	@Column(name = "Categoria")
	private String category;
	@Column(name = "Nombre")
	private String name;
	@Column(name = "Marca")
	private String brand;
	@Column(name = "Descripcion")
	private String description;
	@Column(name = "Precio")
    private double price;
	@Column(name = "Stock")
    private int stock;
	@Column(name = "Oferta")
	private boolean isPromotion;
	
	
	//Constructor
	
	public Product(Integer id, Integer code, String category, String name, String brand, String description,
			double price, int stock, boolean isPromotion) {
		super();
		this.id = id;
		this.code = code;
		this.category = category;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.isPromotion = isPromotion;
	}


	public Product() {
		super();
	}
	


	//Getters y Setters

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCode() {
		return code;
	}


	public void setCode(Integer code) {
		this.code = code;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	public boolean isPromotion() {
		return isPromotion;
	}


	public void setPromotion(boolean isPromotion) {
		this.isPromotion = isPromotion;
	}

}