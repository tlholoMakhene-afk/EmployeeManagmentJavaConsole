package DataAccessLayer;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class AccessMethods {
	 public static void  closeConnection(SQLServerConnection myConnObj) throws SQLServerException    {
	        if(myConnObj.isClosed()  == false) {
	            try {
	              myConnObj.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(DataHandler.class.getName()).
	                        log(Level.WARNING, null, ex);
	                System.out.println("System failed to close connection");
	            }
	        }
	        System.out.println("Successfully Closed");
		      
	 	}
	 
}
	 
