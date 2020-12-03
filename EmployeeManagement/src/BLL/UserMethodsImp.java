/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import RMIServer.IUserMethods;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Tlholo Makhene
 */
public class UserMethodsImp extends UnicastRemoteObject implements IUserMethods{
//provides the implementation of our remote interface that will be servicing the client
    
    public UserMethodsImp() throws RemoteException
    {
        super();
        
    }
    
       @Override
    public boolean LoginValidation(String sUserName, String sPassword) throws RemoteException{
    //validation checks conducted in the front end
    User u = new User();
        System.out.println("Log in attempt "+ sUserName + " Date: " + LocalDate.now());
   List<User> userList = u.GetUsersLoginDetails();
   
   for(User use : userList)
   {
       if(use.getUsername().equalsIgnoreCase(sUserName) && use.getPassword().equals(sPassword))
       {System.out.println("User Logged-in "+ sUserName + " Date: " + LocalDate.now());
           return true;}
   }
   System.out.println("Failed - Username entered: " + sUserName + " Password entered: " + sPassword );
   return false;  }
    
      @Override
    public User getUser(String sUserName, String sPassword) throws RemoteException { 
   User u = new User();
   List<User> userList = u.GetUsersLoginDetails();
   
   for(User use : userList)
   {
       if(use.getUsername().equalsIgnoreCase(sUserName) && use.getPassword().equals(sPassword))
       {System.out.println(use.toString());
           return use;
       }
   }
   return null;
    }
    
    @Override
    public void DisplayOrganizaionStructure() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Date date1 = null;
    @Override
    public List<Employee> GetEmployeesOlderthanDate(String DateEntered) throws RemoteException {
    	List<Employee> empList = new ArrayList<Employee>();
    	
    	 try {
			 date1 = new SimpleDateFormat("dd/MM/yyyy").parse(DateEntered);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
         Employee emp = new Employee();
     
         emp.GetAllEmployees().forEach((x)->{
        	 
        	 if(x.getsDOB().compareTo(date1) < 0 )
        	 {
        		 empList.add(x);
        	 }
         });
    	  return empList;
    
    }

    @Override
    public Employee GetSearchedEmployee(String empname) throws RemoteException {
    
    //actually researching on the equalivant of LINQ in java, heard about JOOQ
    //Manager: Jacob Black - R 700000.0
    	  Employee emp = new Employee();
    	     
        for (Employee empElement : emp.GetAllEmployees()) {
			
        	if(empElement.getfName().equalsIgnoreCase(empname)){return empElement;}
		}
        	 
     	  return null;
    }

    @Override
    public List<Employee> GetOrderedListBasedOnEarnings() throws RemoteException {
       Employee employee = new Employee();
       List<Employee> tempList =employee.GetAllEmployees();
       
    		   Collections.sort(tempList);
    		   
return tempList;
    }
    
}
