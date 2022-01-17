package TestScripts;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseApiClass;
import Generic_Utility.EndPoints;
import POJO_Class.Project_Library;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Create_Get extends BaseApiClass {
@Test
public void createAndget() throws Throwable {
	
	int ranNum = jUtil.getRandomNumber();
	String expProjectName = "World-Champions"+ranNum ;
	
	Project_Library plib = new Project_Library("India", expProjectName, "onGoing", 15);
	Response response = given()
		.contentType(ContentType.JSON)
		.body(plib)
		
	.when()
	.post(EndPoints.ADD_PROJECT);
	response.then()
	.statusCode(201);
	String projid = response.jsonPath().get("projectId");
	System.out.println(projid);
	
	given()
	.pathParam("projectId", projid)
	.when()
	.get(EndPoints.GETSINGLE_PROJECT)
	.then()
	.assertThat()
	.contentType(ContentType.JSON)
	.statusCode(200)
	.log().all();
	
	String respActualProjName = jsonUtil.getJsonValueData(response, "projectName");
	
	String query = "select * from project";
	String dbActualProjName = dbUtil.getAndVerifyTheData(query, 4, expProjectName);

	Assert.assertEquals(respActualProjName, expProjectName);
	Assert.assertEquals(dbActualProjName, expProjectName);
	}
}
