package CRUD_without_BDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete_Project {
@Test
public void delete_Project () {
	
	// delete a project
	int expstatus = 204;
	Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_006");
	
	// get status
	int actstatus = resp.getStatusCode();
	
	//validation
	Assert.assertEquals(expstatus, actstatus);
	System.out.println(resp.asPrettyString());
	}
}
