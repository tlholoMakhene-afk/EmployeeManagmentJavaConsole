/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperLiabrary;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tlholo Makhene
 */
public class Json_Formatter {

    public static String ConvertWrite(Object obj, String pathName) {

         Gson gson = new Gson();  
    
        // convert java object to JSON format,  
        // and returned as JSON formatted string  
       String json = gson.toJson(obj);  
    
  try {  
   //write converted json data to a file name 
      FileWriter writer = new FileWriter(pathName);  
    writer.write(json); 
      System.out.println(json);
    writer.close();  
    
  } catch (IOException e) {  
   e.printStackTrace();  
  }  
    
  System.out.println(json);  
    return json;
}
    
    public static BufferedReader ConvertRead(String pathString)
    {
        
 BufferedReader br = null;
        Gson gson1 = new Gson();

        try {
          br =  new BufferedReader( new FileReader(pathString));
            
            //convert the json string back to object  
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Json_Formatter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return br;
   
 
 

    }

    
}