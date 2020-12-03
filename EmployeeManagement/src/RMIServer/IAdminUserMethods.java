package RMIServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import BLL.Employee;

public interface IAdminUserMethods extends Remote {

	Boolean DeleteEmployee(int id) throws RemoteException;
	Boolean InsertEmployee(Employee emp) throws RemoteException;
	Boolean UpdateEmpRole(Employee emp) throws RemoteException;
	Boolean UpdateEmpSalary(Employee emp) throws RemoteException;
}
