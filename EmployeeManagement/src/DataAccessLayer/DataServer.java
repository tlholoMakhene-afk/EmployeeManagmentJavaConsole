/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import HelperLiabrary.GenericClass;
import HelperLiabrary.Json_Formatter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.mysql.jdbc.Connection;

import BLL.Employee;
import sun.net.www.content.text.Generic;

/**
 *
 * @author Tlholo Makhene
 */
public class DataServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//       ConnectionParameters cp = new ConnectionParameters("jdbc:derby://localhost:1527/dbEmployeeManagement", "tlholo", "0000");
////        //to write the connection in the class
////           //Now we can use the json object to store the connection parameters object
////          
//
//  ConnectionParameters params = cp.readJsonString();
//        System.out.println(params.toString() +   params.getPassword());
//
//   
    	//String connectionUrl = "jdbc:sqlserver://<server>:<port>;databaseName=AdventureWorks;user=<user>;password=<password>";

		
    
    	
		
		
		/*
		 * ConnectionParameters cp = new ConnectionParameters(
		 * "jdbc:sqlserver://LAPTOP-FEJDHTB5\\SQLEXPRESS;databaseName=dbEmployeeManagement;integratedSecurity=true"
		 * ,"",""); cp.WriteToJsonObject();
		 */
		  
		/*
		 * SQLServerConnection cn = SingleConnectionObject.getInstance().getCon();
		 * 
		 * System.out.println(cn.toString()) ;
		 */
		/*
		 * DataHandler dh = new DataHandler(); System.out.println(dh.toString()); try {
		 * dh.ReadAnyData("tblUsers"); } catch (SQLServerException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		/*
		 * SProcHandler sh = new SProcHandler(); Employee employee = new
		 * Employee(25000,1,"990816521898","Ben","Ten",0); try { Boolean bInsert =
		 * sh.InsertNewEmployee(employee); } catch (SQLServerException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
    	
    	
    	
    
    }
    
}
