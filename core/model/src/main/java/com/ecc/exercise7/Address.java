package com.ecc.exercise7;

public class Address {

	private Long id;
	private String streetNumber;
	private String barangay;
	private String city;
	private Integer zipcode;
	private Employee employee;

	public Address() {}

	public Address(String streetNumber, String barangay, String city, Integer zipcode, Employee employee) {
		this.streetNumber = streetNumber;
		this.barangay = barangay;
		this.city = city;
		this.zipcode = zipcode;
		this.employee = employee;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetNumber() {
		return this.streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getBarangay() {
		return this.barangay;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return String.format("%s,%s,%s,%d", this.streetNumber, this.barangay, this.city, this.zipcode.intValue());
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Address)) {
			return false;
		}

		Address address = (Address) o;

		return address.getStreetNumber().equals(this.streetNumber) &&
			   address.getBarangay().equals(this.barangay) &&
			   address.getCity().equals(this.city) &&
			   address.getZipcode().intValue() == this.zipcode.intValue() &&
			   address.getEmployee().getId().intValue() == this.employee.getId().intValue();
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + this.streetNumber.hashCode();
		result = 31 * result + this.barangay.hashCode();
		result = 31 * result + this.city.hashCode();
		result = 31 * result + this.zipcode.intValue();
		result = 31 * result + this.employee.hashCode();
		return result;
	}
}