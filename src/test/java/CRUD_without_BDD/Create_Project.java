package CRUD_without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Create_Project {
	@Test
	public void  create_Project () {
		
		// read all necessary data - prepare request body - precondition
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Niwash");
		jobj.put("projectName", "Asni");
		jobj.put("status", "Completed");
		jobj.put("teamSize", "7");
		
		// provide request body using given
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		request.body(jobj);
		
		// action - create post request
		Response resp = request.post("http://localhost:8084/addProject");
		
		// validation and print the response
		System.out.println(resp.asPrettyString());
		
	}
}
