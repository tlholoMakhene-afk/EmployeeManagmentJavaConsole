package ClientSide;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import BLL.Employee;
import RMIServer.ISystemMethods;
import RMIServer.IUserMethods;

public class StandardTasks {
public enum task
{
search,FilterBasedOnAge, CompanyDiagram,SortBasedOnPay, exit

}
	
	public static void main(Object[] args) {
		
		try
		{
		Registry registry = LocateRegistry.getRegistry("localhost",3336);
        
        //Lookup server object
        //ICustomer rp =(ICustomer)registry.lookup("Hellome");
         IUserMethods rp = (IUserMethods)registry.lookup("Hellome");
         ISystemMethods smethod = (ISystemMethods)registry.lookup("SystemHello");
		
	
		
		
		Boolean bApp = true;
		CurrentUser TempUser = (CurrentUser) args[0];

		do
		{
			ClientSideMethods.DisplayTasksMenu();
			Scanner myscannerobj = new Scanner(System.in);
			int choice = Integer.parseInt(myscannerobj.nextLine());
			task taskchoice = task.values()[choice-1];
			
			switch (taskchoice) {
			case search:{
				 smethod.RenderedInfoFromClientLogger("User Accessing Search Zone", LocalDate.now());
				System.out.println("--Search Zone--");
				System.out.println(">Type in the name of an employee you would like to search for...the output should then contain a listing of the employee's details:"); 
				//later on make it on any valid entry
				String empStringValue = myscannerobj.nextLine();
				if(rp.GetSearchedEmployee(empStringValue) == null)
				{
					System.out.println("Sorry No Match Found");
					
				}
				else 
				{
					System.out.println("Employee Found ---------");
					System.out.println(rp.GetSearchedEmployee(empStringValue).empDetails());
				}
				
				
			}
				break;
			case FilterBasedOnAge://or date given
			{
				 smethod.RenderedInfoFromClientLogger("User Accessing Age Filter", LocalDate.now());
				System.out.println("___________Filter Based On Age __________");
				System.out.println(">Type in a date (dd/MM/yyyy) to list all employees older than this date...");
				String empStringValue = myscannerobj.nextLine();
				if(!(rp.GetEmployeesOlderthanDate(empStringValue) == null))
				{
					
				
				for (Employee object : rp.GetEmployeesOlderthanDate(empStringValue)) {
					System.out.println(object.toString());
				}
			}
				else
				{
					System.out.println("No employees older than this date..sorry");
					return;
				}
			
				
			}
				break;
			case CompanyDiagram:
			{
				 smethod.RenderedInfoFromClientLogger("User Accessing Tree Diagram", LocalDate.now());
				System.out.println("___________Hierarchy Tree Diagram __________");
				
				
				
				
				
			}
				break;
			case SortBasedOnPay:
			{
				smethod.RenderedInfoFromClientLogger("User Accessing Pay Sort", LocalDate.now());
				System.out.println("___________Sort By Pay Obtain __________");
				if(!(rp.GetOrderedListBasedOnEarnings() == null))
				{
					
				
				for (Employee object : rp.GetOrderedListBasedOnEarnings()) {
					System.out.println(object.toString());
				}
			}
				else
				{
					System.out.println("No employees found");
					return;
				}
				
				
			}
				
				break;
				
			case exit:
			{
				if(TempUser.getType() == "Admin") {LogInRouter.main(new Object[] {TempUser});}
				else {ClientSide.main(new String[] {});}
			}
				
				break;
			default:
				System.out.println("Please select correct option");
				break;
			}
			
			
			
		}while(bApp == true );
		}  catch(NotBoundException | RemoteException ex ){Logger.getLogger(ClientSide.class.getName()).log(Level.SEVERE, null, ex);
	      } 
        catch(Exception  ex ){Logger.getLogger(ClientSide.class.getName()).log(Level.SEVERE, null, ex);
 } 
	}

}
