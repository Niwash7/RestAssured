package CRUD_with_BDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProject {
@Test
public void createproject () {
	
	JSONObject jobj = new JSONObject ();
	jobj.put("createdBy", "Test Yantra");
	jobj.put("projectName", "Byjus");
	jobj.put("status", "onGoing");
	jobj.put("teamSize", "17");
	
	 given()
	.contentType(ContentType.JSON)
	.body(jobj)
	
	.when()
	.post("http://localhost:8084/addProject")
	
	.then()
	.assertThat()
	.statusCode(201)
	.log().all();
	}
}
