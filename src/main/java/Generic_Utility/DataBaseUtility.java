package Generic_Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/**
 * database utility class
 * @author Niwash
 *
 */
public class DataBaseUtility {

	Connection connection = null ;
	
	// this method will do the connection to database
	
	public void connectDB() throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection(EndPoints.DATABASE_URL,"root","root");	
	}
	
	// close the db connecion
	
	public void closeDB() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// it will return all the data from database
	
	public ResultSet getAllData(String query) {
		ResultSet result = null ;
	try {
		result = connection.createStatement().executeQuery(query);
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return result;
	}
	
	public String getAndVerifyTheData(String query, int columnNumber, String expectedData) throws Throwable {
		ResultSet result = connection.createStatement().executeQuery(query);
		String actualData = null;
		boolean flag = false;
		try {
			while(result.next()) {
				String dbData = result.getString(columnNumber);
				if(dbData.equals(expectedData)) {
					actualData = dbData;
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
				
			}
		if(flag) {
			System.out.println("data is present and verified");
			return actualData;
		} else {
			System.out.println("data is not present in database");
			return actualData;
		}
	}
}
