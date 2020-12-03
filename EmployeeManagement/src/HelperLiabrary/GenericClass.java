/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperLiabrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author Tlholo
 */
public class GenericClass<T> {
    String fname;
    List<T> data;

    
    //this will be used to write varies objects to textfiles aswell as read
   //when you register the most recent user registered is log you into a textfile
    //we serialize and deserialize a list of employees from a textfile that is supposed to be in synch with db
    
    public GenericClass(String name, List<T> data) {
        this.fname = name;
        this.data = data;
    }
      public GenericClass(String name) {
        this.fname = name;
 
    }
 

    
    public void serialize() throws FileNotFoundException, IOException{
        
        FileOutputStream fos = new FileOutputStream(this.fname);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        System.out.println("Successfully Serialized");
     
  oos.writeObject(this.data);
      
        
        
        oos.flush();
        oos.close();
        fos.close();
    }
    

    public List<T> Deserialize() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis2 = new FileInputStream(fname);
        ObjectInputStream ois2 = new ObjectInputStream(fis2);
       this.data = (List<T>)ois2.readObject();
           System.out.println("Successfully Deserialized");
        ois2.close();
        fis2.close();
    
        return data;
    }
   
     


}
