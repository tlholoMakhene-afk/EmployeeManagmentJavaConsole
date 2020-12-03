/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Tlholo Makhene
 */
public interface ISystemMethods  extends Remote{
    
   
    void RenderedInfoFromClientLogger(String clientmsg, LocalDate localDate ) throws RemoteException;
    //rendering informating from the client 
    //in cases of client application usage problems
    //general data capture of system state after certain user methods 
   
    void ServerActiveCheck() throws RemoteException;
    //just checks if server is awake
    ///working with a thread
    
    
    
}
