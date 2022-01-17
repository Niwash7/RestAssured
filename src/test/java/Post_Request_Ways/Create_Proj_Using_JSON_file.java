package Post_Request_Ways;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class Create_Proj_Using_JSON_file {
@Test
public void create_Proj_Using_JSON_file() {
	
	baseURI = "http://localhost";
	port = 8084;
	
	// prepare the request body 
	File file = new File("./data.json");
	
	given()
	.contentType(ContentType.JSON)
	.body(file)
	
	.when()
	.post("/addProject")
	
	.then()
	.log().all();
	}
}
