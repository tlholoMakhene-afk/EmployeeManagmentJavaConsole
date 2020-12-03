package BLL;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import RMIServer.IAdminUserMethods;



public class AdminUserMethodsImp extends UnicastRemoteObject implements IAdminUserMethods{

	protected AdminUserMethodsImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	Employee empC = new Employee();

	@Override
	public Boolean DeleteEmployee(int id) throws RemoteException {
		// TODO Auto-generated method stub
	
		if(empC.DeleteEmployee(id))
		{
			System.out.println("Employee Record Deleted");
			return true;
		}
		else
		{
			System.out.println("Failed To Delete");
			return false;
			
		}
		
	} 
	
	@Override
	public Boolean InsertEmployee(Employee emp) throws RemoteException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				
				if(empC.InsertNewEmployee(emp))
				{
					System.out.println("Employee Inserted");
					return true;
				}
				else
				{
					System.out.println("Failed To Insert");
					return false;
					
				}
	}

	@Override
	public Boolean UpdateEmpRole(Employee emp) throws RemoteException {
		// TODO Auto-generated method stub
		if(empC.UpdateEmployeeRole(emp.getiEmpNum(), emp.getsRoleDesignation().ordinal()))
		{
			System.out.println("Employee Updated");
			return true;
		}
		else
		{
			System.out.println("Failed To Update");
			return false;
			
		}
	}

	@Override
	public Boolean UpdateEmpSalary(Employee emp) throws RemoteException {
		// TODO Auto-generated method stub
		if(empC.UpdateEmployeeSalary(emp.getiEmpNum(),emp.getfSalary()))
		{
			System.out.println("Employee Updated");
			return true;
		}
		else
		{
			System.out.println("Failed To Update");
			return false;
			
		}
	}

}
