/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.management.Query;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import DataAccessLayer.DataHandler;


/**
 *
 * @author Tlholo Makhene
 */
public class Employee extends Person  implements Serializable, Comparable<Employee>, IEmployeeDatabaseMethods{


    public enum RoleName
    {
       
        Manager,
        Employee,
        Trainee
        
    }

 public Employee employeesSupervisor;
    private int iEmpNum;
    private float fSalary;
    private RoleName sRoleDesignation;
    public int getSupervisorID() {
		return supervisorID;
	}


	public void setSupervisorID(int supervisorID) {
		this.supervisorID = supervisorID;
	}



	private int supervisorID;
    
    

	//<editor-fold defaultstate="collapsed" desc="Getters&Setters">
    public int getiEmpNum() {
        return iEmpNum;
    }


    public float getfSalary() {
        return fSalary;
    }

    public void setfSalary(float fSalary) {
        this.fSalary = fSalary;
    }

    public RoleName getsRoleDesignation() {
        return sRoleDesignation;
    }

    public void setsRoleDesignation(RoleName sRoleDesignation) {
        this.sRoleDesignation = sRoleDesignation;
    }
   //</editor-fold>

    public Employee(int iEmpNum, float fSalary,int RoleDesignationV, String idNumber, String fName, String lName, int superisorID) {
        super(idNumber, fName, lName);
        this.iEmpNum = iEmpNum;
        this.fSalary = fSalary;
        this.sRoleDesignation = RoleName.values() [RoleDesignationV - 1];
        this.supervisorID = superisorID;
       
      
        
    }
    public Employee(float fSalary,int RoleDesignationV, String idNumber, String fName, String lName, int superisorID) {
        super(idNumber, fName, lName);

        this.fSalary = fSalary;
        this.sRoleDesignation = RoleName.values() [RoleDesignationV - 1];
        this.supervisorID = superisorID;
      
    }
    public Employee(int iEmpNum,float fSalary,int RoleDesignationV, int superisorID) {
    	this.iEmpNum = iEmpNum;
        this.fSalary = fSalary;
        this.sRoleDesignation = RoleName.values() [RoleDesignationV - 1];
        this.supervisorID = superisorID;
     
    }

    public Employee() {
        super();
     
    }
    
    
    @Override
    public String toString() {
        //Trainee: Susan Roe - R 250,000.00
        return this.sRoleDesignation + ": " +  this.getfName() +" "+ this.getlName() + " - R "+ this.fSalary  ; }
   
    
    public String empDetails()
    {
//     name: xxx
//         surname: wwww
//         birth date: 01-01-2000
//         employee number: 0000   
        
        return    "____________________________________________________"+ "\n"
        		+ "Name: " + getfName() + "\n"
                + "Surname: " + this.getlName()  + "\n"
                + "Birth date: " + this.FormateDate()  + "\n"
                + "Employee number: " + this.iEmpNum  + "\n"
                + "Salary: R" + this.getfSalary()  + "\n"
                + "Role Designation: " + this.sRoleDesignation + "\n"
                + "____________________________________________________"
                ;
       
    }
    
    
    
    //<editor-fold defaultstate="collapsed" desc="polymorphism">
    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.iEmpNum;
        hash = 47 * hash + Float.floatToIntBits(this.fSalary);
        hash = 47 * hash + Objects.hashCode(this.sRoleDesignation);
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
        final Employee other = (Employee) obj;
        if (this.iEmpNum != other.iEmpNum) {
            return false;
        }
        if (Float.floatToIntBits(this.fSalary) != Float.floatToIntBits(other.fSalary)) {
            return false;
        }
        if (this.sRoleDesignation != other.sRoleDesignation) {
            return false;
        }
        return true;
    }
    
      //</editor-fold>


   
    
    
    @Override
    public int compareTo(Employee o) {
    if(this.fSalary==o.fSalary & this.sRoleDesignation == o.sRoleDesignation)  
    return 0;  
    else if(fSalary>o.fSalary)  
    return 1;  
    else  
    return -1; 
    }

    private Employee GetSupervisor(int EmpSupID)
    {
    
    for (Employee iterable_element : GetAllEmployees()) {
		if(iterable_element.getiEmpNum() == EmpSupID )
		{
			return iterable_element;
		}
	}
    return null;
    

    	
    }

	@Override
	public List<Employee> GetAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<Employee>();
		try {
			DataHandler dh = new  DataHandler();
	    ResultSet res = dh.GetFullEmployeeDetails();
        while (res.next()) {
             //int iEmpNum, float fSalary,int RoleDesignationV, String idNumber, String fName, String lName, int superisorID
            //String username = res.getString("USERNAME");
           // String password = res.getString("PASSWORD");  
            int empNum = res.getInt("Emp_Num")   ;
            String NationalID = res.getString("IDNumber");
            String firstname = res.getString("FirstName"); 
            String surname = res.getString("LastName");
            int roleID = res.getInt("Role_Designation")   ;
            int reportTo = res.getInt("Reports_To")   ;
          float salary = res.getFloat("Salary");
          Employee temp = new Employee(empNum, salary, roleID, NationalID, firstname, surname, reportTo);
          employees.add(temp);
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
	    


	    return employees;
	 
	}
	

	


	@Override
	public Boolean DeleteEmployee(int ToBeDeletedEmpID) {
		// TODO Auto-generated method stub
		DataHandler dh = new  DataHandler();
		return dh.DeleteData("tblEmployee", ToBeDeletedEmpID);
	}


	@Override
	public Boolean InsertNewEmployee(Employee NewEmployee) {
		// TODO Auto-generated method stub
		DataHandler dh = new  DataHandler();
		return dh.InsertEmp(NewEmployee);
		 
	}
	


	@Override
	public Boolean UpdateEmployeeSalary(int empid, float sal) {
		// TODO Auto-generated method stub
		DataHandler dh = new  DataHandler();
		return dh.UpdateEmp(empid,sal);
	
	}


	@Override
	public Boolean UpdateEmployeeRole(int empid, int roleID) {
		// TODO Auto-generated method stub
		DataHandler dh = new  DataHandler();
		return dh.UpdateEmp(empid,roleID);
	}






}
