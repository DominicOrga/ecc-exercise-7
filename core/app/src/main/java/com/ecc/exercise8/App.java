package com.ecc.exercise8;

public class App 
{
	RoleService roleService = new RoleService();

    public static void main( String[] args )
    {
        // System.out.println()


    }

    public void queryRole() {
    	boolean isReturn = false;

    	do {
    		System.out.println("[0] View Roles, [1] Add Role, [2] Update Role, [3] Delete Role, [4] Return");

    		int option = InputUtility.nextIntPersistent("Enter option:");

	    	switch (option) {
	    		case 0 :
	    			this.roleService.getRoleDetails();
	    			break;
    			case 4 :
    				isReturn = true;
	    	}	

    	} while (!isReturn);    	
    }
}
