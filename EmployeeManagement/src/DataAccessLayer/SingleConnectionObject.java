/*
    * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.sql.Connection;
import com.microsoft.sqlserver.jdbc.*;

import DALExceptions.ConnectionNotEstablishedException;
import DALExceptions.ConnectionNotOpenException;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tlholo Makhene
 */
public class SingleConnectionObject {
	private static SingleConnectionObject jdbc;


	   private SingleConnectionObject() {}
	   
    public static SingleConnectionObject getInstance() {
        if (jdbc == null) {
            jdbc = new SingleConnectionObject();
        }
        return jdbc;
    }
	
    public SQLServerConnection conn;
    private final ConnectionParameters cp = new ConnectionParameters();
 
    
    private SQLServerConnection GetSingleConnectionObject(){

    	  //String connectionUrl = "jdbc:sqlserver://<server>:<port>;databaseName=AdventureWorks;integratedSecurity=true";
    	
    			ConnectionParameters ConnectionParameters = cp.GetParams();
        
    
    	 try {
    		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     		
String url = ConnectionParameters.getConnectionUrlString();
String user = ConnectionParameters.getUsername();
String pass =ConnectionParameters.getPass();
           conn = (SQLServerConnection) DriverManager.getConnection(url,user , pass);
             //Custom exception usage
             //  connect = null;
        
             if (conn == null) {
            	 
            	 throw new ConnectionNotEstablishedException("NO CONNECTECTION ESTABLISHED");
                 
             } 

         } catch (ClassNotFoundException | SQLException | ConnectionNotEstablishedException ex) {
             System.out.println(ex.toString());
         }
    	 catch(Exception e) {e.printStackTrace();}
		return conn;
    }
    
    public SQLServerConnection getCon(){
    
        return GetSingleConnectionObject();
    }
  
    
}
