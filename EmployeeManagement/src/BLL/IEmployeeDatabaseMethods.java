package BLL;
import java.util.List;
import BLL.*;

public interface IEmployeeDatabaseMethods {

	List<Employee> GetAllEmployees();
	 Boolean InsertNewEmployee(Employee NewEmployee);
	 Boolean UpdateEmployeeSalary(int empid, float sal );
	 Boolean UpdateEmployeeRole(int empid, int roleID);
	 Boolean DeleteEmployee(int ToBeDeletedEmpID);
	 
	
	
}
