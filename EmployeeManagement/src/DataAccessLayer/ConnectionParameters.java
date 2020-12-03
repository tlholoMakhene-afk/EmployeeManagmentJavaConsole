/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import HelperLiabrary.Encryption;
import HelperLiabrary.GenericClass;
import HelperLiabrary.HelperClass;
import HelperLiabrary.Json_Formatter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import com.google.gson.Gson;
import java.awt.List;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Tlholo Makhene
 */
public class ConnectionParameters implements Serializable {
  
	private String ConnectionUrlString;
    private String username;
    private String pass;

    //due to the fact i used the same connection string, username, pass for the system
    //we only have read-onlyfields for the object which gets data from the json object
  


 
public String getConnectionUrlString() {
	return ConnectionUrlString;
}




public ConnectionParameters(String connectionUrlString, String username, String pass) {
		super();
		ConnectionUrlString = connectionUrlString;
		this.username = username;
		this.pass = pass;
	}




public String getUsername() {
	return username;
}




public String getPass() {
	return pass;
}

private static String folder = "\\src\\DataAccessLayer\\localfiles\\data\\params.json";

     public String getPath()
     {
         String filePath = Paths.get(HelperClass.currentPath.toString(), folder).toString();
         return filePath;
                  
     }
     
   


	@Override
	public String toString() {
		//String connectionUrl = "jdbc:sqlserver://<server>:<port>;databaseName=AdventureWorks;user=<user>;password=<password>";

		return this.getConnectionUrlString().toString();
	}




	private ConnectionParameters readJsonString()
     {
         Gson gson1 = new Gson();
         BufferedReader brJSON =  Json_Formatter.ConvertRead(getPath());
        ConnectionParameters cparams  = gson1.fromJson(brJSON,  ConnectionParameters.class);
        return cparams;
     }
	public ConnectionParameters GetParams()
	{
		return readJsonString();
		
	}
     
     
	private void WriteToJsonObject()
     {//not iN use due to its writing the connection that we dont want changed
    	 Json_Formatter.ConvertWrite(this, this.getPath());
     }
      
    public ConnectionParameters() {
        
    }


}
