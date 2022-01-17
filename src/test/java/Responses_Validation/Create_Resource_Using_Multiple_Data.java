package Responses_Validation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POJO_Class.Project_Library;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Create_Resource_Using_Multiple_Data {
@Test(dataProvider="getData")
public void create (String createdBy, String projectName, String status, int teamSize) {
	
	Project_Library plib = new Project_Library(createdBy, projectName, status, teamSize);
	given()
	.contentType(ContentType.JSON)
	.body(plib)
	
	.when()
	.post("http://localhost:8084/addProject")
	
	.then()
	.assertThat()
	.contentType(ContentType.JSON)
	.statusCode(201)
	.log().all();
	}

	@DataProvider 
	public Object[][] getData() {
		
		Object[][] obj = new Object[2][4];
		
		obj[0][0] = "Saafir";
		obj[0][1] = "Byju's";
		obj[0][2] = "created";
		obj[0][3] = 35;
		
		obj[1][0] = "Irfan";
		obj[1][1] = "IBM";
		obj[1][2] = "onGoing";
		obj[1][3] = 13;
		
		return obj;
		
	}
}
