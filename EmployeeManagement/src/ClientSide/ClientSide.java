/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientSide;

import RMIServer.ISystemMethods;
import RMIServer.IUserMethods;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import BLL.User;


/**
 *
 * @author Tlholo Makhene
 */
public class ClientSide {

public enum UserMenu
{
    login,
    register,
    exit
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean bDoApp = true;
 
       
           try {
              Registry registry = LocateRegistry.getRegistry("localhost",3336);
             
              //Lookup server object
              //ICustomer rp =(ICustomer)registry.lookup("Hellome");
               IUserMethods rp = (IUserMethods)registry.lookup("Hellome");
               ISystemMethods smethod = (ISystemMethods)registry.lookup("SystemHello");
               
         do
         {
            
             
            //display login and menu
             ClientSideMethods.DisplayHeader();
             Scanner myscannerobj = new Scanner(System.in);
             ClientSideMethods.DisplayUserMenu();
             int menuSelection = Integer.parseInt(myscannerobj.nextLine());
            UserMenu umenu = UserMenu.values()[menuSelection - 1];
            switch(umenu)
            {
                case login:
                {
                
                    boolean bExitLogin = false;
                    int LoginTries = 3;
                    do
                    {
                    System.out.println("Please enter your username");
                    String sEnteredUsername = myscannerobj.nextLine();
                  
                     System.out.println("Please enter your password");
                    String sEnteredPassword = myscannerobj.nextLine();
                     
                     
                    if(!rp.LoginValidation(sEnteredUsername, sEnteredPassword))
                    {
                        System.out.println("False creditials");
                        System.out.println("Invalid Creditials, Please register or enter correct ones!");
                        LoginTries--;
                        System.out.println(LoginTries+ " amount of tries left");
                        if(LoginTries < 1){System.out.println("Amount of tries available exceeded, Please try later"); 
                        Thread t1 = new Thread() {
                        
                        	public void run() {
                        		try { Thread.sleep(500000);} catch(Exception ex) {ex.printStackTrace();};
								
							}
                        	
                        };
                        t1.start();
                        
                        smethod.RenderedInfoFromClientLogger("Suspicious Activity in Application Usage -- Application Paused -- Server Gathering information", LocalDate.now());
                        
                       bExitLogin = true;
                        
                        }
                        
                        
                    }
                    else
                    {
                    	CurrentUser LoggedUser = new CurrentUser(); 
                    	LoggedUser.setsUsername(sEnteredUsername);
                    	LoggedUser.setsPassword(sEnteredPassword);
                    	if(rp.getUser(sEnteredUsername, sEnteredPassword).getType().toString() == "Admin" )
                    	{
                    		LoggedUser.setType("Admin");
                    		//tlholo.makhene@gmail.com Makhene
                    		 smethod.RenderedInfoFromClientLogger("Client Accessing Admin Forms", LocalDate.now());
                             
                    		LogInRouter.main(new Object[] {LoggedUser});
                    		
                    	}
                    	else if(rp.getUser(sEnteredUsername, sEnteredPassword).getType().toString() == "Normal" )
                    	{
                    		//dummy 1999
                    		LoggedUser.setType("Normal");
                    		 smethod.RenderedInfoFromClientLogger("Client Accessing Standard Tasks", LocalDate.now());
                             
                    		LogInRouter.main(new Object[] {LoggedUser});
                    		
                    	}
                    	else
                    	{
                    		System.out.print("Sorry Invalid USER --- No access");
                    	}
                    
                    }
                    
                    }while (bExitLogin == false) ;
                    
                 
                   
                   
                }
                    break;
                case register:
                {
                
               
                Register.main(new String[] {});
                bDoApp = false;
                
                } 
                break;                                                                    
                    case exit:  
                    {
                 bDoApp = false;
                    }
                 break;
            }
            
        }while(bDoApp == true);
         
        }  //end of try
           catch(NotBoundException | RemoteException ex ){Logger.getLogger(ClientSide.class.getName()).log(Level.SEVERE, null, ex);
      } 
             catch(Exception  ex ){Logger.getLogger(ClientSide.class.getName()).log(Level.SEVERE, null, ex);
      } 
           
       
    }
    
}
