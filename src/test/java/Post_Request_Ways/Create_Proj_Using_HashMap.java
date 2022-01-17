package Post_Request_Ways;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class Create_Proj_Using_HashMap {
@Test
public void create_Proj_Using_HashMap () {

	baseURI = "http://localhost";
	port = 8084;
	
	// prepare the request body
	HashMap map = new HashMap();
	map.put("createdBy", "Shanu");
	map.put("projectName", "Shanu7");
	map.put("status", "Created");
	map.put("teamSize", 18);
	
	//preconditions
	given()
	.contentType(ContentType.JSON)
	.body(map)
	
	.when()
	.post("/addProject")
	
	.then()
	.log().all();
}
}
