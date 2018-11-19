package com.ecc.exercise8;

import java.util.Optional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeService {

 	private EmployeeDAO employeeDAO = new EmployeeDAO();

	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
	}

	public Optional<Employee> getEmployee(Long id) {
		return getEmployee(id, false, false);
	}

	public Optional<Employee> getEmployee(Long id, boolean isContactsInitialized, boolean isRolesInitialized) {
		return employeeDAO.getEmployee(id, isContactsInitialized, isRolesInitialized);
	}

	public List<Employee> getEmployees() {
		return employeeDAO.getEmployees();
	}

	public String getEmployeeDetail(Long id) {
		Optional<Employee> employee = employeeDAO.getEmployee(id, true, true); 

		if (!employee.isPresent()) {
			return null;
		}

		return String.format(
				"ID: %d \n" +
				"Name: %s \n" +
				"Birth Date: %s \n" +
				"Date Hired: %s \n" +
				"GWA: %s \n" +
				"Employement Status: %s \n" +	
				"Address: %s \n" +
				"Contact/s: %s \n" +
				"Role/s: %s\n", 
				employee.get().getId(), 
				employee.get().getName(), 
				employee.get().getBirthDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
				employee.get().getDateHired().format(DateTimeFormatter.ISO_LOCAL_DATE),
				employee.get().getGWA(),
				employee.get().isEmployed() ? "Employed" : "Unemployed",
				employee.get().getAddress(),
				employee.get().getContacts().stream()
										   .map(c -> c.getType() + ": " + c.getValue())
										   .collect(Collectors.joining(", ")),
				employee.get().getRoles().stream()
										.map(r -> r.getId().toString())
										.collect(Collectors.joining(", ")));
	}

	public String getEmployeeDetails() {
		return getEmployees()
			   .stream()
			   .map(employee -> getEmployeeDetail(employee.getId()))
			   .collect(Collectors.joining("\n"));
	} 

	public void updateEmployee(Employee employee) {
		this.employeeDAO.updateEmployee(employee);
	}

	public void removeEmployee(Long id) {
		this.employeeDAO.removeEmployee(id);
	}
}