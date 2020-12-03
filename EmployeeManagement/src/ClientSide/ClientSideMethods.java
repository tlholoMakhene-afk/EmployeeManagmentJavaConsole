package ClientSide;

public  class ClientSideMethods {
	public static void DisplayHeader()
	{
	              
	               System.out.println("\n" + "________________________________");
	               System.out.println("Employee Management System :-: EPIUSE");
	               System.out.println("________________________________");
	               
	}

	public static void DisplayUserMenu()
	{
	    System.out.println("Please select an option " + "\n"
	            +"1. Login User " + "\n"
	            +"2. Register New User " +"\n"
	            +"3. Exit ");
	}
	public static void DisplayTasksMenu()
	{
	    System.out.println("Please select an option " + "\n"
	            +"1. Search for a employee " + "\n"
	            +"2. List the records of all employees that are older" +"\n"
	            +"3. Organisation Structure" +"\n"
	            +"4. Sort Employees" +"\n"
	            +"5. Exit ");
	}
	public static void DisplayAdminMenu()
	{
	    System.out.println("Please select an option " + "\n"
	            +"1. Standard Tasks " + "\n"
	            +"2. Admin Tasks" +"\n"
	            +"3. Exit ");
	}
	public static void DisplayAdminTaskMenu()
	{
	    System.out.println("Please select an option " + "\n"
	            +"1. Display All Employees" + "\n"
	            +"2. Insert New Employee" +"\n"
	            +"3. Fire Employee" +"\n"
	            +"4. Update Employee Role" +"\n"
	            +"6. Update Employee Pay" +"\n"
	            +"5. Exit ");
	}
	
}
