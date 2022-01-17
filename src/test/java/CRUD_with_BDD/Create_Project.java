package CRUD_with_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Create_Project {
@Test
public void create_Project () {
	
	JSONObject jobj = new JSONObject ();
	jobj.put("createdBy", "TY-22");
	jobj.put("projectName", "Rest");
	jobj.put("status", "onGoing");
	jobj.put("teamSize", "9");
	
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
