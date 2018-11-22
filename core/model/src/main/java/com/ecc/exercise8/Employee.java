package com.ecc.exercise8;

import java.util.Set;
import java.util.HashSet;

import java.time.LocalDate;

public class Employee {

	private Long id;	
	private Name name;
	private LocalDate birthDate;
	private LocalDate dateHired;
	private Float gwa;
	private Boolean isEmployed;
	private Address address;
	private Set<Contact> contacts = new HashSet<>();
	private Set<Role> roles = new HashSet<>();

	public Employee() {}

	public Employee(Name name, LocalDate birthDate, LocalDate dateHired, Float gwa, Boolean isEmployed) {
		this.name = name;
		this.birthDate = birthDate;
		this.dateHired = dateHired;
		this.gwa = gwa;
		this.isEmployed = isEmployed;
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

	public Set<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Employee)) {
			return false;
		}

		Employee employee = (Employee) o;

		return employee.getName().equals(this.name) &&
			   employee.getBirthDate().isEqual(this.birthDate) &&
			   employee.getDateHired().isEqual(this.dateHired) &&
			   employee.getGWA().floatValue() == this.gwa.floatValue() &&
			   employee.isEmployed() == this.isEmployed();
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + this.name.hashCode();
		result = 31 * result + this.birthDate.hashCode();
		result = 31 * result + this.dateHired.hashCode();
		result = 31 * result + this.gwa.hashCode();
		result = 31 * result + this.isEmployed.hashCode();
		return result;
	}
}