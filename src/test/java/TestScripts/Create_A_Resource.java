package TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseApiClass;
import Generic_Utility.EndPoints;
import POJO_Class.Project_Library;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Create_A_Resource extends BaseApiClass{
@Test
public void create() throws Throwable {
	
	// create a random number
	int ranNum = jUtil.getRandomNumber();
	String expProjectName = "TCS"+ranNum ;
	
	// pass the request body using pojo library
	Project_Library plib = new Project_Library("Chandhini", expProjectName, "completed", 25);
	Response response = given()
		.contentType(ContentType.JSON)
		.body(plib)
		.when()
		.post(EndPoints.ADD_PROJECT);
	
	// data from response body
	String respActualProjName = jsonUtil.getJsonValueData(response, "projectName");
	response.then()
	.assertThat()
	.contentType(ContentType.JSON)
	.statusCode(201)
	.log().all();
	
	// data base value verification
	String query = "select * from project";
	String dbActualProjName = dbUtil.getAndVerifyTheData(query, 4, expProjectName);
	
	// verifications
	Assert.assertEquals(respActualProjName, expProjectName);
	Assert.assertEquals(dbActualProjName, expProjectName);
	}
}
