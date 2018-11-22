package com.ecc.exercise8;

public class Contact {

	public enum ContactType {
		landline, mobile, email
	}

	private Long id;
	private ContactType type;	
	private String value;	
	private Employee employee;

	public Contact() {}

	public Contact(ContactType type, String value, Employee employee) {
		this.type = type;
		this.value = value;
		this.employee = employee;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ContactType getType() {
		return this.type;
	}

	public void setType(ContactType type) {
		this.type = type;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Contact)) {
			return false;
		}

		Contact contact = (Contact) o;

		return contact.getType().equals(this.type) && 
			   contact.getValue().equals(this.value) &&
			   contact.getEmployee().equals(this.employee);
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + this.type.hashCode();
		result = 31 * result + this.value.hashCode();
		result = 31 * result + this.employee.hashCode();
		
		return result;
	}
}