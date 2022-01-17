package CRUD_without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Update_Project {
@Test
public void update_Project () {
	
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "Teddy");
	jobj.put("projectName", "Rest Assured");
	jobj.put("status", "onGoing");
	jobj.put("teamSize", "7");
	
	// provide request body using given
	RequestSpecification request = RestAssured.given();
	request.contentType(ContentType.JSON);
	request.body(jobj);
	
	// action - create post request
		Response resp = request.put("http://localhost:8084/projects/TY_PROJ_802");
		
	// print the response
	System.out.println(resp.statusCode());
	System.out.println(resp.asPrettyString());	
	}
}
