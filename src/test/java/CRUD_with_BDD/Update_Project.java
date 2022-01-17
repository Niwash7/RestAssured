package CRUD_with_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Update_Project {
@Test
public void update_Project () {
	
	JSONObject jobj = new JSONObject ();
	jobj.put("createdBy", "Test Yantra");
	jobj.put("projectName", "Rest Assured");
	jobj.put("status", "onGoing");
	jobj.put("teamSize", "7");
	
	given()
	.contentType(ContentType.JSON)
	.body(jobj)
	
	.when()
	.put("http://localhost:8084/projects/TY_PROJ_1002")
	
	.then()
	.assertThat()
	.statusCode(200)
	.log().all();
	}
}
