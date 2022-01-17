package CRUD_without_BDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_Single_Project {
	@Test
	public void Get_Single_Project () {
		
	int expstatus = 200;
		
	Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_004");
	int actstatus = resp.getStatusCode();
	
	// validation
	Assert.assertEquals(expstatus, actstatus);
	System.out.println(resp.asPrettyString());
	}
}
