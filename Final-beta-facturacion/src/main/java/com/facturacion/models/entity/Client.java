package com.facturacion.models.entity;

import com.facturacion.models.abstractClass.Person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "clientes")
public class Client extends Person {
		
		@Id
		@Column(unique = true)
		private Integer id;
	  	@Column(name = "Telefono")
	  	private Long phone;
	  	@Column(name = "Direccion")
		private String address;
	  	
		
	  	// Constructor
	  	public Client () {
	    	super();
	    }
	  	
		public Client (Integer dni, String firstName, String lastName, String email, Long phone, String address) {
	    	super(dni, firstName, lastName, email);
	    	this.id = dni;
	        this.phone = phone;
	        this.address = address;
	    }
	    
		// Getters y Setters
	    public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public Long getPhone() {
			return phone;
		}


		public void setPhone(Long phone) {
			this.phone = phone;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}	
}