package com.facturacion.models.abstractClass;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
	
	@Column(name = "Dni", unique = true)
    private Integer dni;
	
	@Column(name = "Nombre")
    private String firstName;

    @Column(name = "Apellido")
    private String lastName;

    @Column(name = "Email")
    private String email;
    
    
    public Person () {
    	super();
    }    
    
    public Person(Integer dni, String firstName, String lastName, String email) {
		this.dni = dni;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
    
    //Getters y Setters

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

}
