/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.Date;

import RMIServer.ISystemMethods;


/**
 *
 * @author Tlholo Makhene
 */
public class SystemMethodsImp extends UnicastRemoteObject implements ISystemMethods {

	public SystemMethodsImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void RenderedInfoFromClientLogger(String clientmsg, LocalDate datetime) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Message From Client: " + clientmsg  + " @ " + datetime.toString());
	
	}

	@Override
	public void ServerActiveCheck() throws RemoteException {
		
		// TODO Auto-generated method stub
		System.out.println("Client Side Ping Recieved");
		System.out.println("Server still running");
		
		
	}
    
}
