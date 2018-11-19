package com.ecc.exercise8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

public class RoleQueryApp {
	RoleService roleService = new RoleService();

	private static final int VIEW_ROLES = 0;
	private static final int ADD_ROLE = 1;
	private static final int UPDATE_ROLE = 2;
	private static final int REMOVE_ROLE = 3;
	private static final int RETURN = 4;

	private static final int COLUMN_CODE = 0;
	private static final int COLUMN_DESCRIPTION = 1;

	public void execute() {
    	boolean isReturn = false;

    	do {
    		System.out.println("[0] View Roles, [1] Add Role, [2] Update Role, [3] Remove Role, [4] Return");

    		int option = InputUtility.nextIntPersistent("Enter option:");

	    	switch (option) {
	    		case VIEW_ROLES:
	    			viewRoles();
	    			break;
                case ADD_ROLE :
                	addRole();
                	viewRoles();
                	break;
                case UPDATE_ROLE:
                	updateRole();
                	viewRoles();
                	break;
                case REMOVE_ROLE:
                	removeRole();
                	viewRoles();
                	break;
    			case RETURN :
    				isReturn = true;
	    	}	

    	} while (!isReturn);    	
    }

    public void viewRoles() {
		System.out.println(this.roleService.getRoleDetails());    	
    }

    public void addRole() {
    	List<Role> existingRoles = this.roleService.getRoles();
    	String[] existingRoleCodes = existingRoles.stream().map(Role::getCode).toArray(String[]::new);

		String code = InputUtility.nextStringPersistent("Enter Code:", existingRoleCodes);
		String description = InputUtility.nextStringPersistent("Enter Description:");

		Role role = new Role(code, description);
		this.roleService.saveRole(role);
    }

    public void updateRole() {
		Optional<Role> role = getRoleByID();

		if (!role.isPresent()) {
			System.out.println("No Role Exists.");
			return;
		}

    	System.out.println("[0] Code, [1] Description");
    	int option = InputUtility.nextIntPersistent("Choose Column to Edit:", 0, 1);

    	switch (option) {
    		case COLUMN_CODE:
    			List<Role> existingRoles = this.roleService.getRoles();
    			String[] existingRoleCodes = existingRoles.stream().map(Role::getCode).toArray(String[]::new);

    			String code = InputUtility.nextStringPersistent("Enter Code:", existingRoleCodes);
    			role.get().setCode(code);
    			break;
			case COLUMN_DESCRIPTION:
				String description = InputUtility.nextStringPersistent("Enter Description:");
				role.get().setDescription(description);
				break;
    	}

    	this.roleService.updateRole(role.get());
    }

    public void removeRole() {
    	Optional<Role> role = getRoleByID();

    	if (!role.isPresent()) {
    		System.out.println("No Role Exists");
    	}

    	this.roleService.removeRole(role.get().getId());
    }

    private Optional<Role> getRoleByID() {
    	List<Role> existingRoles = this.roleService.getRoles();

    	if (existingRoles == null || existingRoles.isEmpty()) {
    		return null;
    	}

    	Optional<Role> role = Optional.empty();    	

    	do {
    		long id = InputUtility.nextLongPersistent("Enter Role ID:");

    		role = this.roleService.getRole(id);

    		if (!role.isPresent()) {
    			System.out.println("Role ID does not exist.");
    		}

    	} while (!role.isPresent());

    	return role;
    }
}