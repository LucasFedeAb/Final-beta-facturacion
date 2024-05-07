package com.facturacion.controllers.dto;

import com.facturacion.models.abstractClass.Person;

public class ClientDTO extends Person {
	private Integer id;
	private Integer dni;
    private String firstName;
    private String lastName;
    private String email;
    private Long phone;
    private String address;
    
    // Constructor
    public ClientDTO() {
    } 

	public ClientDTO(Integer id, Integer dni, String firstName, String lastName, String email, Long phone,
			String address) {
		super();
		this.id = id;
		this.dni = dni;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getDni() {
		return dni;
	}


	public void setDni(Integer dni) {
		this.dni = dni;
	}



	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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