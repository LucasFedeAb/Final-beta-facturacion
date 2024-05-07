package com.facturacion.controllers.dto;

import java.util.List;

public class SaleDTO {
	
	private Integer id;
	private String dateSale;
    private double totalSaleAmount;
    private ClientDTO client;
    private List<ItemSaleDTO> items;
    
    
	public SaleDTO() {
		super();
	}
	
	public SaleDTO(Integer id, String dateSale, double totalSaleAmount, ClientDTO client, List<ItemSaleDTO> items) {
		super();
		this.id = id;
		this.dateSale = dateSale;
		this.totalSaleAmount = totalSaleAmount;
		this.client = client;
		this.items = items;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDateSale() {
		return dateSale;
	}


	public void setDateSale(String dateSale) {
		this.dateSale = dateSale;
	}


	public double getTotalSaleAmount() {
		return totalSaleAmount;
	}


	public void setTotalSaleAmount(double totalSaleAmount) {
		this.totalSaleAmount = totalSaleAmount;
	}


	public ClientDTO getClient() {
		return client;
	}


	public void setClient(ClientDTO client) {
		this.client = client;
	}


	public List<ItemSaleDTO> getItems() {
		return items;
	}


	public void setItems(List<ItemSaleDTO> items) {
		this.items = items;
	}

}