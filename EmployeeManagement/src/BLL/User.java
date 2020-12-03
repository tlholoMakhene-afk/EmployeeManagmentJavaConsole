/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;


import java.io.Serializable;
import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import DataAccessLayer.DataHandler;

/**
 *
 * @author Tlholo Makhene
 */


public class User extends Person implements Serializable{
     
public enum UserType
{

    Admin,
    Normal
    
}
    private int userID;
    private String username;
    private String password;
 

	public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
    private UserType type;
 
    
    public int getEmpId() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = (username.isEmpty()) ? "None":username ;
    }

    public void setPassword(String password) {
        this.password = (password.isEmpty()) ? "None":password;
    }

  
public User(String idNumber, String fName, String lName, int userID, String username, String password,
			int typeID) {
		super(idNumber, fName, lName);
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.type = UserType.values()[typeID - 1];
	}


public User(String idNumber, String fName, String lName, String username, String password, int typeID) {
	super(idNumber, fName, lName);
	this.username = username;
	this.password = password;
	this.type = UserType.values()[typeID - 1];
	
}


public User(String username, String password, int typeID) {
	super();
	this.username = username;
	this.password = password;
	this.type = UserType.values()[typeID - 1];
	
}

public List<User> GetUsersLoginDetails()
{
	 
		    DataHandler dh = new DataHandler();
		        List<User> userlist = new ArrayList<>();
		    try
		    {
		                ResultSet res = dh.ReadAnyData("TBLUSERS");
		        while (res.next()) {
		             
		              
		                String username = res.getString("USERNAME");
		                String password = res.getString("PASSWORD");
		                int id = res.getInt("TYPE");
		            userlist.add(new User(username,password,id));
		        }
		        
		       
		    }
		    catch(SQLException sqle)
		            {
		                System.out.println(sqle.toString());  
		            }
		    catch(Exception e)
		        {
		            System.out.println(e.toString());
		        }
		    


		    
		        
		    return  userlist;
		    
}
  

  	public User(){
       super();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.userID;
        hash = 29 * hash + Objects.hashCode(this.username);
        hash = 29 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userID != other.userID) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", username=" + username + ", Type = "+  type+'}';
    }

    
    
}
