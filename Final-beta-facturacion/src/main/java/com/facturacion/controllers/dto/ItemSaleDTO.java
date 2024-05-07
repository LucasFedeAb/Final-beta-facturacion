package com.facturacion.controllers.dto;

public class ItemSaleDTO {
	
	private int quantity;
    private ProductDTO product;
    
	public ItemSaleDTO() {
		super();
	}
	
	public ItemSaleDTO( int quantity, ProductDTO product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
 
}