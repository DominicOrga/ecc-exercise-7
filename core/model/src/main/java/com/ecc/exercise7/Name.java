package com.ecc.exercise7;

public class Name {

	private String firstName;
	private String middleName;
	private String lastName;

	public Name() {}

	public Name(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.middleName + " " + this.lastName;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Name)) {
			return false;
		}

		Name name = (Name) o;

		return name.getFirstName().equals(this.firstName) &&
			   name.getMiddleName().equals(this.middleName) &&
			   name.getLastName().equals(this.lastName);
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + this.firstName.hashCode();
		result = 31 * result + this.middleName.hashCode();
		result = 31 * result + this.lastName.hashCode();
		return result;
	}
}