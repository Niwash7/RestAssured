package CRUD_without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Get_All_Projects {
@Test
public void get_All_Projects () {
	
	int expstatus = 200;
	Response resp = RestAssured.get("http://localhost:8084/projects");
	
	int actstatus = resp.getStatusCode();
	
	// validation 
	Assert.assertEquals(expstatus, actstatus);
	
	// print in json format
	System.out.println(resp.asPrettyString());
	}
}
