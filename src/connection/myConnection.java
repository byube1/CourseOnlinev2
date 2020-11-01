package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class myConnection {
	public static Connection makeConnection() {
		Connection cn = null;
		try {
			// nap driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// tao ket noi
			String url = "jdbc:sqlserver://localhost:1433;databaseName=AssignmentJavaWeb";
			cn=DriverManager.getConnection(url,"sa","123456");			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return cn;		
	}
}
