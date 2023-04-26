import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.*;

public class DatabaseConnectionService {

	//DO NOT EDIT THIS STRING, YOU WILL RECEIVE NO CREDIT FOR THIS TASK IF THIS STRING IS EDITED
	private final String SampleURL = "jdbc:sqlserver://${dbServer};databaseName=${dbName};user=${user};password={${pass}}";

	private Connection connection = null;

	private String databaseName;
	private String serverName;

	public DatabaseConnectionService(String serverName, String databaseName) {
		//DO NOT CHANGE THIS METHOD
		this.serverName = serverName;
		this.databaseName = databaseName;
	}

	public boolean connect(String user, String pass) {
		
		Properties connectionProps = new Properties();
	    connectionProps.put("user", user);
	    connectionProps.put("password", pass);
		
		String url = "jdbc:sqlserver://${dbServer};databaseName=${dbName};user=${user};password={${pass}};";
		
		String fullUrl = url
				.replace("${dbServer}", serverName)
				.replace("${dbName}", databaseName)
				.replace("${user}", user)
				.replace("${pass}", pass);
		fullUrl += "encrypt=true;trustServerCertificate=true;";
		System.out.println(fullUrl);
		
		try {
			connection = DriverManager.getConnection(fullUrl);
			connection.setCatalog(this.databaseName);
			System.out.println("Connected");
			return true;
		} catch (Exception g) {
			g.printStackTrace();
			return false;
		}
	}
	

	public Connection getConnection() {
		return this.connection;
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		}
	}

}
