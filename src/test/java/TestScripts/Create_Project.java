package TestScripts;

import Generic_Utility.BaseApiClass;
import Generic_Utility.EndPoints;
import POJO_Class.Project_Library;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Create_Project extends BaseApiClass{
@Test
public void Create() throws Throwable {
	
	int ranNum = jUtil.getRandomNumber();
	String expProjName = "Prince"+ranNum;
	String expStatus = "onGoing";
	String expSuccessMsg = "Successfully Added";
	
	Project_Library plib = new Project_Library("Asni", expProjName, expStatus, 01);
	Response response = given()
	.contentType(ContentType.JSON)
	.body(plib)
	
	.when()
	.post(EndPoints.ADD_PROJECT);
	
	String respActualProjName = jsonUtil.getJsonValueData(response, "projectName");
	String respActStatus = jsonUtil.getJsonValueData(response, "status");
	String respActSuccessMsg = jsonUtil.getJsonValueData(response, "msg");
	response.then()
	.assertThat()
	.contentType(ContentType.JSON)
	.statusCode(201)
	.log().all();
	
	String query = "select * from project";
	String dbActualProjName = dbUtil.getAndVerifyTheData(query, 4, expProjName);
	String dbActStatus = dbUtil.getAndVerifyTheData(query, 5, expStatus);

	// response validation
	Assert.assertEquals(respActualProjName, expProjName);
	Assert.assertEquals(expStatus, respActStatus);
	Assert.assertEquals(expSuccessMsg, respActSuccessMsg);
	System.out.println(respActSuccessMsg + " is present");
	
	// database validation
	Assert.assertEquals(dbActualProjName, expProjName);
	Assert.assertEquals(dbActStatus, expStatus);
	}
}
