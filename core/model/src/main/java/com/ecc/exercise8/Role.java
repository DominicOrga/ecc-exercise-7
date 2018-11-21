package com.ecc.exercise8;

import java.util.Set;
import java.util.HashSet;

// @Entity
// @Table(name = RoleContract.TABLE_NAME)
public class Role implements java.io.Serializable {

	// @Id
	// @GeneratedValue
	// @Column(name = RoleContract.COLUMN_ID)
	private Long id;

	// @Column(name = RoleContract.COLUMN_CODE, unique = true)
	// @NotBlank
	private String code;

	// @Column(name = RoleContract.COLUMN_DESCRIPTION)
	// @NotBlank
	private String description;

	// @ManyToMany(mappedBy = "roles")
	private Set<Employee> employees = new HashSet<>();

	public Role() {}

	public Role(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Role)) {
			return false;
		}

		Role role = (Role) o;

		return role.getCode().equals(this.code) && 
			   role.getDescription().equals(this.description);
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + this.code.hashCode();
		result = 31 * result + this.description.hashCode();
		return result;
	}
}