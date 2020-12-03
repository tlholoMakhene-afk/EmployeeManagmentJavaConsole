/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import BLL.Employee;
import BLL.User;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Tlholo Makhene
 */
public interface IUserMethods extends Remote{
  //we creating the remote interface that will be used by the client side
    //to invoke the methods
    //the reason i used rmi is because the client side cannot create any of our objects 
    //it only invokes methods using the rmi api
    
    
    void DisplayOrganizaionStructure() throws RemoteException;
     List<Employee> GetEmployeesOlderthanDate(String DateEntered) throws RemoteException;
     public Employee GetSearchedEmployee(String empname) throws RemoteException;
     public List<Employee> GetOrderedListBasedOnEarnings() throws RemoteException;
     boolean LoginValidation(String sUserName, String sPassword) throws RemoteException;
     User getUser(String sUserName, String sPassword) throws RemoteException;
}
