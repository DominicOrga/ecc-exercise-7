package com.ecc.exercise8;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	private Name name;

	@Column(nullable=false)
	private LocalDate birthDate;

	@Column(nullable=false)
	private LocalDate dateHired;

	@Column(nullable=false)
	private Float gwa;

	@Column(nullable=false)
	private Boolean isEmployed;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;

	public Employee() {}

	public Employee(Name name, LocalDate birthDate, LocalDate dateHired, Float gwa, Boolean isEmployed, Address address) {
		this.name = name;
		this.birthDate = birthDate;
		this.dateHired = dateHired;
		this.gwa = gwa;
		this.isEmployed = isEmployed;
		this.address = address;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Name getName() {
		return this.name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Float getGWA() {
		return this.gwa;
	}

	public void setGWA(Float gwa) {
		this.gwa = gwa;
	}

	public Boolean isEmployed() {
		return this.isEmployed;
	}

	public void setEmployed(Boolean isEmployed) {
		this.isEmployed = isEmployed;
	}

	public LocalDate getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getDateHired() {
		return this.dateHired;
	}

	public void setDateHired(LocalDate dateHired) {
		this.dateHired = dateHired;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}