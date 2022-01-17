package Generic_Utility;

import static io.restassured.RestAssured.*;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Base Api Class used to provide all the repeated actions
 * @author Niwash
 *
 */
public class BaseApiClass {

	public DataBaseUtility dbUtil = new DataBaseUtility();
	public JavaUtility jUtil = new JavaUtility();
	public JsonUtility jsonUtil = new JsonUtility();
	
	@BeforeSuite
	public void BS() throws Throwable {
		
		System.out.println("DB Connection is started");
		dbUtil.connectDB();
		System.out.println("connected to database");
		baseURI = "http://localhost:8084";
	}
	
	@AfterSuite
	public void AS() {
		dbUtil.closeDB();
		System.out.println("database is closed");
	}
}
