/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import BLL.Employee;
import BLL.Person;
import BLL.SystemMethodsImp;
import BLL.UserMethodsImp;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tlholo Makhene
 */
public class ServerRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         
//        Person tlholo = new Person("9906195216089", "tlholo", "surname");
//       System.out.println(tlholo.toString());
//Employee tlholo = new Employee(2000, 100,1, "8905195468125", "fkkfk", "dmdkd");
//        System.out.println(tlholo.toString());
//        above code used for testing
 try {
              //Create and get reference to rmi registry
              Registry registry = LocateRegistry.createRegistry(3336);

             //Instantiate server object
           IUserMethods stub = new UserMethodsImp();
             registry.rebind("Hellome", stub);
           
           ISystemMethods SysMethodsStub = new SystemMethodsImp();
             registry.rebind("SystemHello", SysMethodsStub);
             System.out.println("Server is working!!!");
             
             
            		 
 		     
               
        }   catch (AccessException ex) {
            Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
        }        catch (RemoteException ex) 
        {
            Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
        }



    }
    
}
