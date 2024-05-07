package com.facturacion.controllers.dto;

import com.facturacion.models.entity.Product;

public class ProductDTO {
	private Integer id;
	private Integer code;
	private String category;
	private String name;
	private String brand;
	private String description;
    private double price;
    private int stock;
	private boolean isPromotion;

    // Constructor
    
    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.code = product.getCode();
        this.category = product.getCategory();
        this.name = product.getName();
        this.brand = product.getBrand();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.isPromotion = product.isPromotion();
        
     // Registro de producto creado
        System.out.println("Se creó un nuevo ProductoDTO a partir de Producto: " + product.getId());
    }

    // Getters y Setters
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