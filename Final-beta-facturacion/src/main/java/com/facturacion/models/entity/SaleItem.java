package com.facturacion.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SaleItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_item_venta")
	private Integer itemSaleId;
	@Column(name = "Id_producto_vendido")
	private Integer productId;
	@Column(name = "Cantidad vendida")
	private int quantity;
	@Column(name = "Codigo barra")
	private Integer code;
	@Column(name = "Categoria")
	private String category;
	@Column(name = "Nombre")
	private String name;
	@Column(name = "Marca")
	private String brand;
	@Column(name = "Descripcion")
    private String description;
	@Column(name = "Monto total")
    private double salePrice;
	@Column(name = "Stock")
    private int stock;
	@Column(name = "Oferta")
	private boolean isPromotion;
    
    @ManyToOne
    @JoinColumn(name = "sale_id")
    @JsonBackReference 		//!importante para serializacion y no generar bucle infinito
    private Sale sale;

	public SaleItem() {
		super();
	}
	
	//Getters y Setters
	public Integer getItemSaleId() {
		return itemSaleId;
	}

	public void setItemSaleId(Integer itemSaleId) {
		this.itemSaleId = itemSaleId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getCode(Integer code) {
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

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
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

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

}