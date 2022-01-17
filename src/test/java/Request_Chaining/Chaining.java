package Request_Chaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Chaining {
@Test
public void chaining() {

	// get all projects and delete
	
	Response response = when()
	.get("http://localhost:8084/projects");
	String proID = response.jsonPath().get("[0].projectId");
	
	given()
	.pathParam("projectId", proID)
	.when()
	.delete("http://localhost:8084/projects/{projectId}")
	.then()
	.assertThat()
	.statusCode(204)
	.log().all();
	
	}
}
