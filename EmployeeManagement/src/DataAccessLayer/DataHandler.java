/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.omg.CORBA.INTERNAL;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import BLL.Employee;
import BLL.User;
import DALExceptions.ConnectionNotOpenException;

/**
 *
 * @author Tlholo Makhene
 */
public class DataHandler {
    protected SQLServerConnection myConnObj;
 protected Statement myStatObj;

 

    public DataHandler() {
   //normally we retriving a connection
        try {
               this.myConnObj = SingleConnectionObject.getInstance().getCon();
               //opens the connection
               
               
               if(this.myConnObj.isClosed() == true) {throw new ConnectionNotOpenException("Connection Not Open");}
        }
        catch(ConnectionNotOpenException e) 
        {
            System.out.println(e.toString());
        }
        catch(Exception e) 
        {
            System.out.println(e.toString());
        }
        
    
    }
   
   
   //kinda like c# how we return a dataset
  //here we use resultset
    public ResultSet ReadAnyData(String tblName) throws SQLServerException
   {
      ResultSet myResObj = null;
      
       try  
       {
    	   
           myStatObj = this.myConnObj.createStatement(); 
           myResObj = myStatObj.executeQuery("SELECT * FROM "+tblName);
    
           
       }
       catch(SQLServerException sqle)  
       {
           System.out.println(sqle.toString());
           sqle.printStackTrace();
       }
       catch(SQLException sqle)  
        {
            System.out.println(sqle.toString());
            sqle.printStackTrace();
        }
   
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
       
       
     return  myResObj;
   }

    public ResultSet GetFullEmployeeDetails()
    {
    	
    	ResultSet myResObj = null;
    	String qry = "";
        try  
        {
     	   qry = "SELECT        tblEmployee.*, tblPerson.*\r\n" + 
     	   		"FROM            tblEmployee INNER JOIN\r\n" + 
     	   		"                         tblPerson ON tblEmployee.Emp_NationalID = tblPerson.IDNumber;";
            myStatObj = this.myConnObj.createStatement(); 
            myResObj = myStatObj.executeQuery(qry);
     
            
        }
        catch(SQLServerException sqle)  
        {
            System.out.println(sqle.toString());
            sqle.printStackTrace();
        }
        catch(SQLException sqle)  
         {
             System.out.println(sqle.toString());
             sqle.printStackTrace();
         }

         catch(Exception e)
         {
             System.out.println(e.toString());
         }
        
        
      return  myResObj;
    	

    }
    public Boolean DeleteData(String tblName, int DeleteKey )
    {
        String qry = "Delete From "+ tblName+" Where Emp_Num = ?";

         try  
         {
             PreparedStatement preparedstmt = myConnObj.prepareStatement(qry);
              preparedstmt.setInt(1, DeleteKey);
              if(preparedstmt.execute()) {return true;};
            
         }
         catch(SQLException sqle)  
          {
              System.out.println(sqle.toString());
          }
          catch(Exception e)
          {
              System.out.println(e.toString());
              
          }
         return false;
        
    }



    public Boolean InsertEmp(Employee emp)
    {
    	
    		/*
    		 * qry =
    		 * "INSERT INTO APP."+tblName+" (USERPK, USERNAME, PASSWORD) VALUES (?, ?, ?)";
    		 * 
    		 * }break; case "TBLSTOCK": qry =""; break; }
    		 * 
    		 * try { PreparedStatement preparedstmt = myConnObj.prepareStatement(qry); //
    		 * int idConversion = Integer.parseInt(input.get(0).toString()); // String
    		 * username = input.get(1).toString(); // String password =
    		 * input.get(2).toString(); //the below logic will have to be removed if more
    		 * tables are added
    		 * preparedstmt.setInt(1,Integer.parseInt(input.get(0).toString()) );
    		 * preparedstmt.setString(2, input.get(1).toString()); preparedstmt.setString(3,
    		 * input.get(2).toString()); preparedstmt.execute(); this.myConnObj.close();
    		 */
    	PreparedStatement ps1 = null;
    	PreparedStatement ps2 = null;
    	 boolean state = false;
    	 String qry1, qry2 ;
         try {
        	 qry1 = "INSERT INTO tblPerson" +"(`FirstName`, `LastName`, `IDNumber`) VALUES (?, ?, ?)";
        	 qry2 ="INSERT INTO tblEmployees" + "(`Emp_NationalID`,`Role_Designation`,`Reports_To`,`Salary`) VALUES (?, ?, ?,?)";
        	 ps1.setString(1, emp.getfName());
             ps1.setString(2, emp.getlName());

        	 ps1.setString(3, emp.getIdNumber());
             ps2.setString(4, emp.getIdNumber());
             
             ps2.setInt(5, emp.getsRoleDesignation().ordinal());
             ps2.setInt(6, emp.getSupervisorID());
             ps2.setFloat(7, emp.getfSalary());
             
        	 
             ps1 = this.myConnObj.prepareStatement(qry1);
             ps2 = this.myConnObj.prepareStatement(qry2);
             if (ps1.execute()) {
            	 if( ps2.execute())
                 {state = true;}
             }

         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }

         return state;
    }
    PreparedStatement ps = null;
    public Boolean UpdateEmp(int id, int role)
    {
    	 boolean state = false;
    	 String qry ;
         try {
        	 
        	 qry = "Update tblEmployee "+" set Role_Designation =? where Emp_Num =?";
        	 
             ps = this.myConnObj.prepareStatement(qry);
             ps.setInt(2, id);
             ps.setInt(1, role);
             if (ps.executeUpdate() > 0) {
                 state = true;
             }

         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }

         return state;
    }
    public Boolean UpdateEmp(int id, float fSal)
    {
    	boolean state = false;
    	 String qry ;
        try {
        	
       	 qry = "Update tblEmployee "+" setSalary =? where Emp_Num =?";
       	 
            ps = this.myConnObj.prepareStatement(qry);
            ps.setInt(2, id);
            ps.setFloat(1, fSal);
            if (ps.executeUpdate() > 0) {
                state = true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return state;
    }
    
         
        
    }


 
  
  
    

